<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="model.DetailProduct,model.ProductInCart,java.util.List" %>
<%
//リクエストスコープに変更すべき
DetailProduct detailProduct = (DetailProduct) request.getAttribute("detailProduct");
List<ProductInCart> cartList = (List<ProductInCart>) session.getAttribute("cartList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Emazon｜本,ファッション,家電から食品まで|</title>
</head>
<body>
<jsp:include page = "/jsp/header.jsp" /><br>
<h1>商品紹介</h1>

<br>
<table>
	<table border="1" style="border-collapse: collapse">
		<tr>
			<td><img src="images/<%=detailProduct.getProduct_img()%>.png"></td>
			<td><table border="1" style="border-collapse: collapse">
  <tr>
    <td>商品名</td>
    <td><%=detailProduct.getProduct_name() %></td>
  </tr>
  <tr>
    <td>カテゴリ</td>
    <td><%=detailProduct.getCategory_name() %></td>
  </tr>
  <tr>
    <td>価格</td>
    <td><%=detailProduct.getProduct_price() %></td>
  </tr>
  <tr>
    <td>在庫</td>
    <td><%=detailProduct.getStock() %></td>
  </tr>
  <tr>
    <td>商品紹介</td>
    <td><%=detailProduct.getProduct_detail()%></td>
  </tr>
</table></td></table>

<form action="/ecsite/CartServlet" method="get" >
個数<select name="quantity">
<%if(detailProduct.getStock()==0) { %>
<option value=“0”>sold out</option>
<%} else { %>
<% for(int i = 1; i <= detailProduct.getStock(); i++) {  %>
<option value="<%=i %>" <%if(i==1){%>selected="selected"<%} %>><%=i%></option>
<%if(i >=10) { break;} %>
<% } %>
<%} %>
</select>
<%if(detailProduct.getStock() !=0) { %>
<input type="hidden" name="product_name" value="<%=detailProduct.getProduct_name() %>">
<input type="hidden" name="product_price" value="<%=detailProduct.getProduct_price() %>">
<input type="submit" value="カートへ">
<%} %>
</form>
<form>
<input type="button" value="戻る" onClick="history.go(-1)">
</form>
</div>
</body>
</html>