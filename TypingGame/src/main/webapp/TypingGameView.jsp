<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String randomWordJapanese = (String) session.getAttribute("randomWordJapanese");
String randomWordRomaji = (String) session.getAttribute("randomWordRomaji");
String previousRandomWordRomaji = (String) session.getAttribute("previousRandomWordRomaji");
String userInput = request.getParameter("userInput");
Boolean isCorrect = (Boolean) session.getAttribute("isCorrect");
int score = (int) session.getAttribute("score");
int mondaisuu = 3;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css"
	href="../BJServletRensyu2/卒業制作/css/kyoutuu.css">
<link rel="stylesheet" type="text/css" href="css/Typing.css">
<title>タイピング</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
	crossorigin="anonymous"></script>
<script src="js/hamb.js"></script>

</head>
<body>
	<div class="content">
		<button type="button" class="btn js-btn">
			<span class="btn-line"></span>
		</button>
		<nav>
			<ul class="menu">
				<li class="menu-list"
					onclick="window.location.href='../BJServletRensyu2/卒業制作/index.html'">TOP</li>
				<li class="menu-list"
					onclick="window.location.href='http://localhost:8080/JankenServletGame/JankenServlet'">制作物1</li>
				<li class="menu-list"
					onclick="window.location.href='http://localhost:8080/BJServletRensyu2/BlackjackServlet'">制作物2</li>
				<li class="menu-list"
					onclick="window.location.href='http://localhost:8080/TypingGame/TypingGameServlet'">制作物3</li>
				<li class="menu-list"
					onclick="window.location.href='../BJServletRensyu2/卒業制作/furikaeri.html'">訓練振り返り</li>
			</ul>
		</nav>
		<div class="wrapper">

			<br> <br>

			<h1 class="gametitle">タイピング</h1>
			<br>
			<br>
			<%
			if (score >= mondaisuu) {
			%>
			<div class="clear">
				<strong>ゲームクリア!</strong><br>
				<p>遊んでくれてありがとう!</p>
				<br>
				<br>
				<%
				// セッションを無効化して初期化
				session.invalidate();
				session = request.getSession(true);
				session.setAttribute("score", 0);
				%>
				<form action="TypingGameServlet" method="POST">
					<input type="hidden" name="action" value="reset"> <input
						type="submit" value="初めから" class="hajimekara">
				</form>

			</div>
			<%
			} else {
			%>
			<div class="nyuuryoku">
				<p>
					<strong><%=randomWordJapanese%></strong>
				</p>
				<p>
					<%=randomWordRomaji%>
				</p>
				<form action="TypingGameServlet" method="POST">
					<input type="text" name="userInput" autofocus autocomplete="off"
						class="nyuuryokuform">
				</form>
				<br>
			</div>

			<%
			if (isCorrect != null) {
			%>
			<div class="hantei">
				<p>
					正解:
					<%=previousRandomWordRomaji%></p>
				<p>
					入力:
					<%=userInput%></p>
				<p>
					判定:
					<%
				if (isCorrect) {
				%>
					○
					<%
				} else {
				%>
					☓
					<%
				}
				%>
				</p>
				<p><%=score%>/<%=mondaisuu%>正解!
				</p>
				<%
				}
				%>
				<%
				}
				%>
			</div>
		</div>
	</div>
	<footer>
		<p>2023 ALL RIGHT RESERVED.</p>
	</footer>
</body>
</html>
