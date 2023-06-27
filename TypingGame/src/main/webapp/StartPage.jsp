<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP Start Button</title>
</head>
<body>


    <%-- アクションの処理 --%>
    <% 
    String action = request.getParameter("action");
    if (action != null && action.equals("start")) {
        // スタートボタンが押された場合の処理
        // ここで表示内容の分岐や他のアクションを実行することができます
        
        // 分岐例：メッセージの表示
        out.println("<h1>処理中...</h1>");
    }else{
    %>
        <form method="post" action="">
        <input type="submit" name="action" value="start">
    </form>
    <%} %>
</body>
</html>
