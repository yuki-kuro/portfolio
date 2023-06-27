<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="servlet.BlackjackServlet"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>ブラックジャック</title>
<link rel="stylesheet" type="text/css" href="卒業制作/css/kyoutuu.css">
<link rel="stylesheet" type="text/css" href="css/blackjack.css">
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
					onclick="window.location.href='卒業制作/index.html'">TOP</li>
				<li class="menu-list"
					onclick="window.location.href='http://localhost:8080/JankenServletGame/JankenServlet'">制作物1</li>
				<li class="menu-list"
					onclick="window.location.href='http://localhost:8080/BJServletRensyu2/BlackjackServlet'">制作物2</li>
				<li class="menu-list"
					onclick="window.location.href='http://localhost:8080/TypingGame/TypingGameServlet'">制作物3</li>
				<li class="menu-list"
					onclick="window.location.href='卒業制作/furikaeri.html'">訓練振り返り</li>
			</ul>
		</nav>
		<div class="wrapper">
			<br> <br>
			<h1 class="gametitle">ブラックジャック</h1>
			<br>
			<div class="gamebody">
				<p>
					<strong>あなた :</strong>
					<%if((int)request.getSession().getAttribute("playerPoint")>21) {%>
					バースト
					<%}else if((int)request.getSession().getAttribute("playerPoint")==21){ %>
					ブラックジャック!
					<%}else{ %>
					<%= session.getAttribute("playerPoint")%>点
					<%} %>
				</p>
				<table border="1"  class="myTable">
					<% 
        List<Integer> player = (List<Integer>) request.getSession().getAttribute("player");
        
    %>
					<tr>
						<%for (int i =0;i<player.size();i++) { %>
						<td><%=i+1 %>枚目</td>

						<%} %>
					</tr>
					<tr>
						<%for (int i =0;i<player.size();i++) { %>

						<td><%= servlet.BlackjackServlet.toCardString(player.get(i))%></td>
						<%} %>
					</tr>

				</table>




				<% String result = (String) request.getAttribute("result");
       if (result != null) { %>
				<p>
					<strong>PC :</strong>
					<%if((int)request.getSession().getAttribute("dealerPoint")>21) {%>
					バースト
					<%}else if((int)request.getSession().getAttribute("dealerPoint")==21){ %>
					ブラックジャック!
					<%}else{ %>
					<%= session.getAttribute("dealerPoint")%>点
					<%} %>
				</p>

				<table border="1" class="myTable">
					<% 
        List<Integer> dealer = (List<Integer>) request.getSession().getAttribute("dealer");
        
    %>
					<tr>
						<%for (int i =0;i<dealer.size();i++) { %>
						<td><%=i+1 %>枚目</td>

						<%} %>
					</tr>
					<tr>
						<%for (int i =0;i<dealer.size();i++) { %>
						<td><%=servlet.BlackjackServlet.toCardString(dealer.get(i)) %></td>
						<%} %>
					</tr>
				</table>

				<br><h2>
					結果:
					<%= result %></h2>

				<form action="/BJServletRensyu2/BlackjackServlet" method="post">
					<input type="hidden" name="action" value="reset"> <input
						type="submit" value="初めから" class="hajimekara">
				</form>
				<% } %>

				<% if (result == null) { %>
				<% 
        List<Integer> dealer = (List<Integer>) request.getSession().getAttribute("dealer");
    int firstCard = 0;
    if (!dealer.isEmpty()) {
        firstCard = dealer.get(0);
    }
    %>
				<p>
					<strong>PC :</strong>
					<%=servlet.BlackjackServlet.toNumber(firstCard) %>
					+ ?点
				</p>
				<table border="1" class="myTable">

					<tr>
						<%for (int i =0;i<2;i++) { %>
						<td><%=i+1 %>枚目</td>

						<%} %>
					
					<tr>
					<tr>
						<td><%=servlet.BlackjackServlet.toCardString(firstCard) %></td>
						<td>秘密</td>
					</tr>
				</table>
				<br>
<div class="button-container">
				<form action="/BJServletRensyu2/BlackjackServlet" method="post">
					<input type="hidden" name="action" value="hit"> 
					<button type="submit" class="bjbtn"><span>一枚引く</span></button>
					
				</form>

				<form action="/BJServletRensyu2/BlackjackServlet" method="post">
					<input type="hidden" name="action" value="stand"> 
					<button type="submit" class="bjbtn"><span>勝負する</span></button>
					
				</form>
</div>
				<% } %>
			</div>
		</div>
	</div>
	<footer>
		<p>2023 ALL RIGHT RESERVED.</p>
	</footer>
</body>
</html>
