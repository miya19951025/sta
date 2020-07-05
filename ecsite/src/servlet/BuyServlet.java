package servlet;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BuyDAO;
import dao.ProductDAO;
import model.Order;
import model.OrderDetail;
import model.ProductInCart;

@WebServlet({"/BuyServlet"})
public class BuyServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}

	  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    HttpSession session = request.getSession();
	    List<ProductInCart> cartList = (List<ProductInCart>)session.getAttribute("cartList");
	    int totalMoney = Integer.parseInt(request.getParameter("whole_amount"));
	    Random random = new Random();
	    int order_id = random.nextInt(1000000000) + 1;
	    LocalDateTime date1 = LocalDateTime.now();
	    DateTimeFormatter dtformat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    String order_date = dtformat.format(date1);
	    Period p1 = Period.ofDays(14);
	    LocalDateTime date2 = LocalDateTime.now();
	    String limit_date = dtformat.format(date2.plus(p1));
	    String confirm_date = null;
	    String order_status = "0";
	    String del_flg = "0";
	    String ins_date = order_date;
	    String upd_date = order_date;
	    Order order = new Order(order_id, totalMoney, order_date, limit_date, confirm_date, order_status, del_flg, ins_date, upd_date);
	    ProductDAO productDAO = new ProductDAO();
	    List<OrderDetail> orderDetailList=new ArrayList<>();
		boolean detail_id_flg = false;
		boolean sqlCheck = false;
		int detail_id=0;
		while(sqlCheck == false) {
			for(ProductInCart p : cartList) {
				// order_idは作成済み
				// 明細フラグがfalseならidを取得
				if(detail_id_flg == false) {
				detail_id = random.nextInt(1000000000)+1;
				detail_id_flg = true;
				}
				//商品idをリストから順にDAOで取得プロダクトネームからidを取得
				int product_id = Integer.parseInt(productDAO.getProductId(p));
				//商品の個数を取得
				int whole_amount = p.getQuantity();
				//商品すべての値段を取得
				int money_amount = p.getProduct_price()*whole_amount;
				//商品の税を取得
				int tax = (int)(money_amount * 1.1);

				OrderDetail orderDetail = new OrderDetail(order_id,detail_id,product_id,whole_amount,money_amount,tax,del_flg,ins_date,upd_date);
				orderDetailList.add(orderDetail);
			}


			BuyDAO buyDAO = new BuyDAO();
			try {
				buyDAO.buy(order,orderDetailList);
				sqlCheck = true;
			} catch (Exception e) {
				sqlCheck = false;
			}

		}

	    cartList.clear();
	    RequestDispatcher dispatcher = request.getRequestDispatcher(
	        "/jsp/decideToBuy.jsp");
	    dispatcher.forward((ServletRequest)request, (ServletResponse)response);
	  }
}
