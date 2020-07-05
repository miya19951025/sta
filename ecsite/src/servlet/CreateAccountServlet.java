package servlet;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AccountDAO;
import model.Account;


@WebServlet("/CreateAccountServlet")
public class CreateAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//アカウント作成画面にフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/accountCreation.jsp");
		dispatcher.forward(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//現在日時を取得

		//DateTimeFormatterクラスのオブジェクトを生成する
    	DateTimeFormatter dtf =
            DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    	//LocalDateTimeクラスを使用して日付を設定する
    	LocalDateTime ld =LocalDateTime.now();
    	String strnow = ld.format(dtf).toString();


		//リクエストパラメータの習得

		request.setCharacterEncoding("UTF-8");
		String acc_cd = request.getParameter("acc_cd");
		String login_name = request.getParameter("login_name");
		String login_pw = request.getParameter("login_pw");
		String gender = request.getParameter("gender");
		String fullname = request.getParameter("fullname");
		String mail = request.getParameter("mail");
		String tel_no = request.getParameter("tel_no");
		String zip =  request.getParameter("zip");
		String prefecture = request.getParameter("prefecture");
		String city = request.getParameter("city");
		String address = request.getParameter("address");
		String del_flg = "0";
		String ins_date = strnow;
		String upd_date = strnow;

		//入力値チェック。適切ならパラメータを習得しアカウント登録。不適切ならアカウント作成画面に戻る
		if(acc_cd != null && acc_cd.length()!= 0 && acc_cd.length() <=30 &&
		   login_name != null && login_name.length()!= 5 && login_name.length() <=30 &&
		   login_pw!= null && login_pw.length()!= 0 && login_pw.length() <=20 &&
		   fullname != null && fullname.length()!= 0 && fullname.length() <=20 &&
		   mail != null && mail.length()!= 0 && mail.length() <=256 &&
		   tel_no.matches("[0-9]{11}") &&
		   zip.matches("[0-9]{7}") &&
		   prefecture != null && prefecture.length()!= 0 && prefecture.length() <=4 &&
		   city != null && city.length()!= 0 && city.length() <=20 &&
		   address != null && address.length()!= 0 && address.length() <=20) {

			// 登録するユーザー情報の設定

			Account account = new Account(acc_cd,login_name,login_pw,gender,fullname,mail,tel_no,zip,prefecture,city,address,del_flg,ins_date,upd_date);

			//DBにユーザー登録
			AccountDAO dao = new AccountDAO();
			dao.create(account);

			//ログイン画面にフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/login.jsp");
			dispatcher.forward(request,response);

		 } else {
			 //エラーメッセージをアカウント作成画面に
			 request.setAttribute("errorMsg", "不正な入力値があります");
			 RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/accountCreation.jsp");
				dispatcher.forward(request,response);
		 }



	}

}
