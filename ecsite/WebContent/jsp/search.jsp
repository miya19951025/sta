<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Product,java.util.List" %>

<%
//リクエストスコープに保存された商品検索リストを取得
List<Product> productListResult = (List<Product>) request.getAttribute("productListResult");
//リクエストスコープに保存されたsearchItemNameを習得
String searchItemName = (String) request.getAttribute("searchItemName");
//セッションスコープに保存された商品検索数を取得
String searchResults = (String) session.getAttribute("searchResults");
//リクエストスコープに保存された10の倍数
String searchPartResult = (String)request.getAttribute("searchPartResults");
//リクエストスコープに保存されたページ番号を取得
String pageNo = (String) request.getAttribute("pageNo");
//リクエストスコープに保存された検索結果０の場合のメッセージを取得
String errorMsg = (String) request.getAttribute("errorMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Emazon｜本,ファッション,家電から食品まで|</title>
</head>
<body>
<jsp:include page = "/jsp/header.jsp" /><br>
<form action="/ecsite/ProductSearchServlet" method="post">
<input type="text" name="searchItemName"><br>
<input type="submit" value="検索">
</form>
<% if(errorMsg != null)  {%>
<p><%= errorMsg %></p>
<% } %>
<% if(productListResult != null && productListResult.size() != 0) { %>
<table border="1" style="border-collapse: collapse">
  <tr>
    <th>商品名</th><th>価格</th><th>詳細</th>
  </tr>
  <% 	for(int i =0 ; i < productListResult.size() ; i++) {%>
  <tr>
  	<td><%= productListResult.get(i).getProduct_name()%></td>
  	<td><%= productListResult.get(i).getProduct_price() %></td>
  	<td><form action="/ecsite/ProductDetailServlet" method="get">
  	<input type="hidden" name="product_name" value="<%=productListResult.get(i).getProduct_name() %>">
  	<input type="submit" value="詳細">
  	</form></td>
  </tr>
<% 		} %>
<table border="0" style="border-collapse: collapse">
	<tr>
	<%	if (Integer.parseInt(pageNo) -1 > 0 )  {%>
		<td><form name ="decrease" action="/ecsite/ProductSearchServlet" method="get">
			<input type="hidden" name="action" value="decrease">
			<input type="hidden" name="pageNo" value="<%=pageNo %>">
			<input type="hidden" name="searchPartResults" value="<%=searchPartResult %>">
			<input type="hidden" name="searchItemName" value="<%=searchItemName %>">
			</form><a href="javascript:decrease.submit()">前へ </a> </td>
	<%	} %>
	<%	if (Integer.parseInt(pageNo)*10 < Integer.parseInt(searchResults))  {%>
	<td><form name="increase" action="/ecsite/ProductSearchServlet" method="get">
		<input type="hidden" name="action" value="increase">
		<input type="hidden" name="pageNo" value="<%=pageNo %>">
		<input type="hidden" name="searchPartResults" value="<%=searchPartResult %>">
		<input type="hidden" name="searchItemName" value="<%=searchItemName %>">
		</form><a href="javascript:increase.submit()">次へ </a> </td>
	<%	} %>
	</tr>
</table>
<% } %>
</table>
</body>
</html>