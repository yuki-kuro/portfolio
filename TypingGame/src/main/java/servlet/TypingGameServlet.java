package servlet;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/TypingGameServlet")
public class TypingGameServlet extends HttpServlet {
	// words 配列に単語を格納する
	String[][] words = {
			{ "サーブレットクラス", "sa-burettokurasu" },
			{ "アノテーション", "anote-syonn" },
			{ "リクエストスコープ", "rikuesutosuko-pu" },
			{ "セッションスコープ", "sessyonsuko-pu" },
			{ "アプリケーションスコープ", "apurike-syonsuko-pu" },
			{ "ガベージコレクション","gabe-jikorekusyonn"},
			{ "フォワード","fowa-do"},
			{ "プロパティ","puropathi"}
	};

	// 現在の単語を除いたランダムな単語を選ぶメソッド
	private String[] getRandomWordWithoutCurrent(String[][] wordPairs, String[] currentWordPair) {
		String[] randomWordPair = currentWordPair;
		while (Arrays.equals(randomWordPair, currentWordPair)) {
			int randomIndex = (int) (Math.random() * wordPairs.length);
			randomWordPair = wordPairs[randomIndex];
		}
		return randomWordPair;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("score", 0); // 初期スコアをセッションに保存
		showRandomWord(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String action = request.getParameter("action");

		if (action != null && action.equals("reset")) {

			// doGet() メソッドを呼び出す
			doGet(request, response);
			return;
		} else {
			// ユーザーの入力を取得
			String userInput = request.getParameter("userInput");

			// 正解の単語をセッションから取得
			HttpSession session = request.getSession();
			String randomWordJapanese = (String) session.getAttribute("randomWordJapanese");
			String randomWordRomaji = (String) session.getAttribute("randomWordRomaji");
			String[] randomWordPair = { randomWordJapanese, randomWordRomaji };

			// 正誤を判定（大文字と小文字を区別）
			boolean isCorrect = userInput.equals(randomWordRomaji);

			// スコアを取得し、1増やす
			int score = (int) session.getAttribute("score");
			if (isCorrect) {
				score++;
				session.setAttribute("score", score); // スコアを更新
			}

			// 10単語正解時に終了
			if (score >= 3) {
				request.getRequestDispatcher("TypingGameView.jsp").forward(request, response);
			} else {

				// 判定結果をセッションに保存
				session.setAttribute("isCorrect", isCorrect);

				// 次の問題を選ぶ（同じ問題が出ないようにする）
				String[] nextRandomWordPair = getRandomWordWithoutCurrent(words, randomWordPair);

				// 次の問題をセッションに保存
				String nextRandomWordJapanese = nextRandomWordPair[0];
				String nextRandomWordRomaji = nextRandomWordPair[1];

				session.setAttribute("randomWordJapanese", nextRandomWordJapanese);
				session.setAttribute("randomWordRomaji", nextRandomWordRomaji);
				session.setAttribute("previousRandomWordRomaji", randomWordRomaji);

				// TypingGameView.jspにフォワード
				request.getRequestDispatcher("TypingGameView.jsp").forward(request, response);
			}
		}

	}

	private void showRandomWord(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// words 配列の要素数を取得し、ランダムなインデックスを生成します
		int randomIndex = (int) (Math.random() * words.length);

		// ランダムなインデックスに対応する words 配列の要素を取得し、ランダムな単語を選択します
		String[] randomWordPair = words[randomIndex];
		String randomWordJapanese = randomWordPair[0];
		String randomWordRomaji = randomWordPair[1];

		// 選択されたランダムな単語をセッションに保存します。
		request.getSession().setAttribute("randomWordJapanese", randomWordJapanese);
		request.getSession().setAttribute("randomWordRomaji", randomWordRomaji);

		request.getRequestDispatcher("TypingGameView.jsp").forward(request, response);
	}
}
