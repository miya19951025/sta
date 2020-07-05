<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// リクエストスコープに保存されたエラーメッセージを習得
String errorMsg = (String) request.getAttribute("errorMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Emazon｜本,ファッション,家電から食品まで|</title>
</head>
<body>
<h1>アカウント作成</h1>
<% if(errorMsg != null) { %>
<p><%=errorMsg %></p>
<% }%>
<form action="/ecsite/CreateAccountServlet" method="post">
	<table>
		<tr>
			<td>ログイン名(30文字まで)</td>
			<td><input type="text" name="login_name"></td>
			<td>ログインID(30文字まで)</td>
			<td><input type="text" name="acc_cd"></td>
		</tr>
		<tr>
			<td>氏名</td>
			<td><input type="text" name="fullname"></td>
			<td>性別</td>
			<td><select name="gender">
				<option value="M" selected="selected">男</option><option value="F">女</option>
				</select></td>
		</tr>
		<tr>
			<td>メールアドレス</td>
			<td><input type="text" name="mail"></td>
			<td>電話番号（11桁）</td>
			<td><input type="text" name="tel_no"></td>
		</tr>
		<tr>
			<td>郵便番号（7桁）</td>
			<td><input type="text" name="zip"></td>
			<td>都道府県</td>
			<td><input type="text" name="prefecture"></td>
		</tr>
		<tr>
			<td>市区町村（20文字まで）</td>
			<td><input type="text" name="address"></td>
			<td>番地（20文字まで）</td>
			<td><input type="text" name="city"></td>
		</tr>
		<tr>
			<td>パスワード（5文字以上20文字まで）</td>
			<td><input type="text" name ="login_pw"><td>
			<td><input type="submit" value="作成"></td>
		</tr>
</table>


</form>
</body>
</html>