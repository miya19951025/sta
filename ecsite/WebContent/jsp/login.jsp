<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//リクエストスコープに保存さたエラーメッセージを習得
String errorMsg = (String) request.getAttribute("errorMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Emazon｜本,ファッション,家電から食品まで|</title>
</head>
<body>
<h1>ログイン</h1>
<% if(errorMsg != null) {%>
<p><%= errorMsg  %></p>
<% } %>
<form action="/ecsite/LoginServlet" method="post">
<table>
	<tr>
		<td>ログインID</td>
		<td><input type="text" name="acc_cd"></td>
	</tr>
	<tr>
		<td>パスワード</td>
		<td><input type="password" name="login_pw"></td>
	</tr>
	<tr>
		<td><input type="submit" value="ログイン"></td>
		<td></td>
	</tr>
</table>
</form>
<form action="/ecsite/CreateAccountServlet" method="get">
<table>
	<tr>
		<td><input type="submit" value="新規作成"></td>
		<td>　　　　　</td>
	</tr>
</table>
</form>
</body>
</html>