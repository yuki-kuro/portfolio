package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BlackjackServlet")
public class BlackjackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Integer> deck;
	private List<Integer> player;
	private List<Integer> dealer;
	private int deckCount;
	private int playerHands;
	private int playerPoint;
	private int dealerPoint;

	@Override
	public void init() throws ServletException {
		super.init();
		// 初期化時に山札を作成しシャッフルする
		deck = new ArrayList<>(52);
		shuffleDeck(deck);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ゲーム開始時の処理
		initializeGame();
		init();
		// プレイヤーとディーラーの最初のカードを引く
		player.add(deck.get(deckCount++));
		dealer.add(deck.get(deckCount++));
		player.add(deck.get(deckCount++));
		dealer.add(deck.get(deckCount++));
		playerPoint = sumPoint(player);
		dealerPoint = sumPoint(dealer);
		// ゲームの状態をセッションに保存
		request.getSession().setAttribute("player", player);
		request.getSession().setAttribute("dealer", dealer);
		request.getSession().setAttribute("playerHands", playerHands);
		request.getSession().setAttribute("playerPoint", playerPoint);
		request.getSession().setAttribute("dealerPoint", dealerPoint);
		// ゲーム画面にリダイレクト
		response.sendRedirect("game.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action != null) {
			if (action.equals("hit")) {
				// プレイヤーがカードを引く場合
				player.add(deck.get(deckCount++));
				playerHands++;
				playerPoint = sumPoint(player);
				if (isBusted(playerPoint)) {
					// バーストした場合の処理
					request.setAttribute("result", "lose");
				}
			} else if (action.equals("stand")) {
				// プレイヤーがカードを引かずにターンを終了する場合
				while (dealerPoint < 17) {
					dealer.add(deck.get(deckCount++));
					dealerPoint = sumPoint(dealer);
					if (isBusted(dealerPoint)) {
						// ディーラーがバーストした場合の処理
						request.setAttribute("result", "win");
						break;
					}
				}
				if (request.getAttribute("result") == null) {
					// プレイヤーとディーラーのポイントを比較して勝敗を判定
					if (playerPoint == dealerPoint) {
						request.setAttribute("result", "draw");
					} else if (playerPoint > dealerPoint) {
						request.setAttribute("result", "win");
					} else {
						request.setAttribute("result", "lose");
					}
				}
			} else if (action.equals("reset")) {
				request.getSession().invalidate();
				// doGet() メソッドを呼び出す
				doGet(request, response);
				return;
			}
		}
		// ゲームの状態をセッションに保存
		request.getSession().setAttribute("player", player);
		request.getSession().setAttribute("dealer", dealer);
		request.getSession().setAttribute("playerHands", playerHands);
		request.getSession().setAttribute("playerPoint", playerPoint);
		request.getSession().setAttribute("dealerPoint", dealerPoint);

		// ゲーム画面にフォワード
		request.getRequestDispatcher("game.jsp").forward(request, response);
	}

	private void initializeGame() {
		player = new ArrayList<>();
		dealer = new ArrayList<>();
		deckCount = 0;
		playerHands = 2;
		playerPoint = 0;
		dealerPoint = 0;
	}

	private void shuffleDeck(List<Integer> deck) {
		for (int i = 1; i <= 52; i++) {
			deck.add(i);
		}
		Collections.shuffle(deck);
	}

	private boolean isBusted(int point) {
		return point > 21;
	}

	private int sumPoint(List<Integer> list) {
		int sum = 0;
		for (int i = 0; i < list.size(); i++) {
			sum += toPoint(toNumber(list.get(i)));
		}
		return sum;
	}

	private int toPoint(int num) {
		if (num >= 10) {
			return 10;
		}
		return num;
	}

	//山札の数を（スート）の（ランク）の文字列に置き換えるメソッド
	public static String toCardString(int cardNumber) {
		String rank = toRank(toNumber(cardNumber));
		String suit = toSuit(cardNumber);

		return suit + rank;
	}

	//山札の数をカードの数に置き換えるメソッド
	public static int toNumber(int cardNumber) {
		int number = cardNumber % 13;
		if (number == 0) {
			number = 13;
		}

		return number;
	}

	//カード番号をランク（AやJ,Q,K）に変換するメソッド
	private static String toRank(int number) {
		switch (number) {
		case 1:
			return "A";
		case 11:
			return "J";
		case 12:
			return "Q";
		case 13:
			return "K";
		default:
			String str = String.valueOf(number);
			return str;
		}
	}

	//山札の数をスート（ハートやスペードなどのマーク）に置き換えるメソッド
	private static String toSuit(int cardNumber) {
		switch ((cardNumber - 1) / 13) {
		case 0:
			return "♣";
		case 1:
			return "♦";
		case 2:
			return "♥";
		case 3:
			return "♠";
		default:
			return "例外です";
		}
	}
}
