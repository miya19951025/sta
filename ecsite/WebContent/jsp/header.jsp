<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Account,java.util.Date,java.text.SimpleDateFormat" %>
<%
Date date = new Date();
SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
String loginday = sdf.format(date);
String login_name = (String) session.getAttribute("login_name");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Emazon｜本,ファッション,家電から食品まで|</title>
</head>
<body>
<table>
	<tr>
		<td><%=login_name%>さんログイン中</td>
		<td><%=loginday%></td>
		<td><form action="/ecsite/LogoutServlet" method="get"><input type="submit" value="ログアウト"></form></td>
	</tr>
</table>

</body>
</html>