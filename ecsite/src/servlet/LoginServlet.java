package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AccountDAO;
import model.Account;
import model.Login;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		request.setCharacterEncoding("UTF-8");

		String create = request.getParameter("create");
		if(create != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/accountCreation.jsp");
			dispatcher.forward(request, response);

		} else {

		String acc_cd = request.getParameter("acc_cd");
		String login_pw = request.getParameter("login_pw");

		Login login = new Login(acc_cd,login_pw);
		AccountDAO dao = new AccountDAO();
		Account result = dao.findBylogin(login);
		try {
			if(acc_cd.equals(result.getAcc_cd()) && login_pw.equals(result.getLogin_pw()) ) {
				//ログイン成功。アカウントのログイン名を保存し商品検索画面へ
				HttpSession session = request.getSession();
				session.setAttribute("login_name",result.getLogin_name());

				//商品検索画面にフォワード

				RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/search.jsp");
				dispatcher.forward(request,response);
			}
		} catch (Exception e) {
			//ログイン失敗時エラーメッセージを習得
			request.setAttribute("errorMsg", "ログイン失敗");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/login.jsp");
			dispatcher.forward(request, response);
		}
		}

	}

}
