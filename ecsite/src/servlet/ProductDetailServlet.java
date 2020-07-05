package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import model.DetailProduct;

@WebServlet({"/ProductDetailServlet"})
public class ProductDetailServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    String product_name = request.getParameter("product_name");
    ProductDAO dao = new ProductDAO();
    DetailProduct detailProduct = dao.getProductDetail(product_name);
    request.setAttribute("detailProduct", detailProduct);
    RequestDispatcher dispatcher = request.getRequestDispatcher(
        "/jsp/details.jsp");
    dispatcher.forward((ServletRequest)request, (ServletResponse)response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}
}
