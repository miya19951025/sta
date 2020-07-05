package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProductDAO;
import model.Product;
import model.SearchProduct;


@WebServlet("/ProductSearchServlet")
public class ProductSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		String pageNo = request.getParameter("pageNo");
		String searchPartResults = request.getParameter("searchPartResults");
		String searchItemName = request.getParameter("searchItemName");
		int intTypePageNo; //pageNo格納用

		if(pageNo == null) {
			pageNo = "1";
		}

		intTypePageNo = Integer.parseInt(pageNo);

		if(action != null && action.equals("increase")) {
			intTypePageNo++;


		} else if (action != null && action.equals("decrease")) {
			intTypePageNo--;
		}

		ProductDAO dao = new ProductDAO();
		SearchProduct searchProduct = new SearchProduct(searchItemName);
		//searchAccountのsearchItemNameを含むproductインスタンスが格納されているlistを作成
		List<Product> productListResult = dao.searchByproduct(searchProduct,intTypePageNo);
		if(productListResult != null) {
			 request.setAttribute("productListResult", productListResult);
			 request.setAttribute("searchItemName",searchItemName );
			 HttpSession session = request.getSession();
			 session.setAttribute("searchResults", dao.getSearchResults());
			 request.setAttribute("searchPartResults", dao.getSearchPartResults());
			 request.setAttribute("pageNo", dao.getPageNo());
		 }

		 //フォワード
		 RequestDispatcher dispatcher = request.getRequestDispatcher(
				 "/jsp/search.jsp");
		 dispatcher.forward(request,response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメータの習得
		 request.setCharacterEncoding("UTF-8");
		 String searchItemName = request.getParameter("searchItemName");
		 SearchProduct searchProduct = new SearchProduct(searchItemName);
		 ProductDAO dao = new ProductDAO();

		 //searchAccountのsearchItemNameを含むproductインスタンスが格納されているlistを作成
		 List<Product> productListResult = dao.searchByproduct(searchProduct);

		 if(productListResult != null && searchItemName.length() != 0) {
			 request.setAttribute("productListResult", productListResult);
			 request.setAttribute("searchItemName",searchItemName );
			 HttpSession session = request.getSession();
			 session.setAttribute("searchResults", dao.getSearchResults());
			 request.setAttribute("searchPartResults", dao.getSearchPartResults());
			 request.setAttribute("pageNo", dao.getPageNo());
		 } else {
			 //検索結果がなければエラーメッセージを習得
			 request.setAttribute("errorMsg", "検索結果がありません");

		 }

		 //フォワード
		 RequestDispatcher dispatcher = request.getRequestDispatcher(
				 "/jsp/search.jsp");
		 dispatcher.forward(request,response);



	}

}
