<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Emazon｜本,ファッション,家電から食品まで|</title>
</head>
<body>
<jsp:include page = "/jsp/header.jsp" /><br>
<h1>お買い上げありがとうございました</h1><br>
<div style="display:inline-flex">
<form action="/ecsite//jsp/search.jsp">
<input type="submit" value="買い物を続ける">
</form>
<form action="/ecsite/LogoutServlet" method="get">
<input type="submit" value="ログアウト">
</form>
</div>
</body>
</html>