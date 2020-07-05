<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.ProductInCart,java.util.List" %>
<%
List<ProductInCart> cartList = (List<ProductInCart>) session.getAttribute("cartList");
int whole_amount=0;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Emazon｜本,ファッション,家電から食品まで|</title>
</head>
<body>
<jsp:include page = "/jsp/header.jsp" /><br>
<h1>本当に購入しますか？</h1>
<% if(cartList != null && cartList.size() !=0) { %>
<table border="1" style="border-collapse: collapse">
  <tr>
    <th>商品名</th><th>単価</th><th>数量</th>
  </tr>
  <% for(ProductInCart p : cartList) {%>
  <tr>
  	<td><%=p.getProduct_name() %></td><td>￥<%=p.getProduct_price() %></td><td><%=p.getQuantity()%></td>
  </tr>
  <% whole_amount += p.getProduct_price(); %>
  <% } %>
  <%-- 商品名をカートに入れた分だけ表示 --%>
  <tr>
  	<td colspan="2">消費税</td><td>￥<%=(int) whole_amount /10 %></td>
  </tr>
  <tr>
  	<td colspan="2">合計金額</td><td>￥<%=(int) whole_amount + whole_amount /10%></td>
  </tr>
</table>
<%} else { %>
<p>カートは空です</p>
<%} %>
<div style="display:inline-flex">
<form action="/ecsite/jsp/search.jsp" method="post">

<input type="submit" value="いいえ">
</form>
<% if(cartList != null && cartList.size() !=0) { %>
<form action="/ecsite/BuyServlet" method="post">
<input type="hidden" name="whole_amount" value="<%=whole_amount %>">
<input type="submit" value="はい">
</form>
<%} %>
</div>
</body>
</html>