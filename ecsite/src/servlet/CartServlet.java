package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ProductInCart;


@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String product_name = request.getParameter("product_name");
		int product_price = Integer.parseInt(request.getParameter("product_price"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		HttpSession session = request.getSession();
		List<ProductInCart> cartList = (List<ProductInCart>) session.getAttribute("cartList");
		ProductInCart p = new ProductInCart(product_name,product_price,quantity);
		if(cartList == null || cartList.size() ==0 ) {
			cartList = new ArrayList<ProductInCart>();
		}
		cartList.add(p);
		session = request.getSession();
		session.setAttribute("cartList",cartList);

		//フォワード
		 RequestDispatcher dispatcher = request.getRequestDispatcher(
				 "/jsp/cartPage.jsp");
		 dispatcher.forward(request,response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
