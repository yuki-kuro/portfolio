package servlet;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Result;

@WebServlet("/JankenServlet")
public class JankenServlet extends HttpServlet {
	Result r = new Result();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/main.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action != null && action.equals("reset")) {
			// Resultオブジェクトをリセット
			HttpSession session = request.getSession();
			r.setWin(0);
			r.setLose(0);
			r.setDraw(0);
			session.setAttribute("r", r);

		} else {
			String[] hands = { "グー", "チョキ", "パー" };

			request.setCharacterEncoding("utf-8");
			String handStr = request.getParameter("hand");
			int userHand = Integer.parseInt(handStr);
			int pcHand = new Random().nextInt(hands.length);
			String result;
			int diff = (userHand + 3 - pcHand) % 3;
			if (diff == 0) {
				result = "あいこです";
				r.setDraw(r.getDraw() + 1);
			} else if (diff == 2) {
				result = "あなたの勝ち";
				r.setWin(r.getWin() + 1);
			} else {
				result = "あなたの負け";
				r.setLose(r.getLose() + 1);
			}
			HttpSession session = request.getSession();
			session.setAttribute("r", r);
			request.setAttribute("userHand", hands[userHand]);
			request.setAttribute("pcHand", hands[pcHand]);
			request.setAttribute("result", result);

		}
		doGet(request, response);
	}
}