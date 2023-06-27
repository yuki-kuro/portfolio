<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.Result"%>

<%
String userHand = (String) request.getAttribute("userHand");
userHand = userHand == null ? "" : userHand;
String pcHand = (String) request.getAttribute("pcHand");
pcHand = pcHand == null ? "" : pcHand;
String result = (String) request.getAttribute("result");
result = result == null ? "" : result;

Result r = (Result) session.getAttribute("r");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css"
	href="../BJServletRensyu2/卒業制作/css/kyoutuu.css">
<link rel="stylesheet" type="text/css" href="css/janken.css">
<title>じゃんけんゲーム</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
	crossorigin="anonymous"></script>
<script src="js/hamb.js"></script>
<script>
	function selectHand(handValue) {
		document.getElementById('selected-hand').value = handValue;
		document.getElementById('jankenForm').submit();
	}

	setTimeout(
			function() {
				document.getElementById("jann").style.display = "inline";
				setTimeout(
						function() {
							document.getElementById("kenn").style.display = "inline";
							setTimeout(
									function() {
										document.getElementById("ponn").style.display = "inline";
										document
												.getElementById("result-container").style.display = "block";
									}, 700);
						}, 700);
			}, 0);
</script>
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
				<li class="menu-list" onclick="window.location.href='http://localhost:8080/JankenServletGame/JankenServlet'">制作物1</li>
				<li class="menu-list" onclick="window.location.href='http://localhost:8080/BJServletRensyu2/BlackjackServlet'">制作物2</li>
				<li class="menu-list" onclick="window.location.href='http://localhost:8080/TypingGame/TypingGameServlet'">制作物3</li>
				<li class="menu-list"
					onclick="window.location.href='../BJServletRensyu2/卒業制作/furikaeri.html'">訓練振り返り</li>
			</ul>
		</nav>
		<div class="wrapper">
			<br>
			<br>
			<h1 class="gametitle">じゃんけんゲーム</h1>
			<br>
			<div class="wrapper-content">
			<form id="jankenForm" action="/JankenServletGame/JankenServlet"
				method="post">
				手を選んでね<br> <br><input type="hidden" id="selected-hand" name="hand"
					value="<%=userHand%>">
			</form>

			<div class="image-container">
				<button class="janbutton" onclick="selectHand('0')">グー</button>
				<button class="janbutton" onclick="selectHand('1')">チョキ</button>
				<button class="janbutton" onclick="selectHand('2')">パー</button>
			</div>

			<%
			if (result.length() > 0) {
			%>
<br>
			<p id="jann" style="display: none;">じゃん</p>
			<p id="kenn" style="display: none;">けん</p>
			<p id="ponn" style="display: none;">ぽん!</p><br>
			<div id="result-container" style="display: none;">
				<div class ="image-container2">
					<div class="hand">
						<b>あなた</b><br>
						<%
						if (userHand.equals("グー")) {
						%>
						<img src="images/gu.png" alt="グー">
						<%
						} else if (userHand.equals("チョキ")) {
						%>
						<img src="images/choki.png" alt="チョキ">
						<%
						} else if (userHand.equals("パー")) {
						%>
						<img src="images/pa.png" alt="パー">
						<%
						}
						%>
					</div>
					<div class="hand">
						<b>PC</b><br>
						<%
						if (pcHand.equals("グー")) {
						%>
						<img src="images/gu.png" alt="グー">
						<%
						} else if (pcHand.equals("チョキ")) {
						%>
						<img src="images/choki.png" alt="チョキ">
						<%
						} else if (pcHand.equals("パー")) {
						%>
						<img src="images/pa.png" alt="パー">
						<%
						}
						%>
					</div>
				</div><br>

				<p><%=result%></p>
				<p>
					勝:<%=r.getWin()%>
					負:<%=r.getLose()%>
					分:<%=r.getDraw()%>
				</p>

				<form action="/JankenServletGame/JankenServlet" method="post">
					<input type="hidden" name="action" value="reset"> 
					<input
						type="submit" value="初めから" class="hajimekara">
				</form>

				<%
				}
				session.removeAttribute("r");
				%>
				</div>
			</div>
		</div>
	</div>

	<footer>
		<p>2023 ALL RIGHT RESERVED.</p>
	</footer>
</body>
</html>