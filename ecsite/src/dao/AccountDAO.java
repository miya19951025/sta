package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Account;
import model.Login;

public class AccountDAO {
	// データベース接続に使用する情報
	private String url = "jdbc:mysql://localhost/gwec";
	private String id = "root";
	private String pass ="1qaz2wSX?";
	PreparedStatement pStmt;
	Connection conn;

	public boolean create(Account account) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url,id,pass);
		String sql = "INSERT INTO Account(acc_cd,login_name,login_pw,gender,fullname,mail,tel_no,zip,prefecture,city,address,del_flg,ins_date,upd_date) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		pStmt = conn.prepareStatement(sql);
		//INSERT文中「？」に使用する値を設定しSQLを完成
		//
		pStmt.setString(1,account.getAcc_cd());
		pStmt.setString(2,account.getLogin_name());
		pStmt.setString(3,account.getLogin_pw());
		pStmt.setString(4,account.getGender());
		pStmt.setString(5,account.getFullname());
		pStmt.setString(6,account.getMail());
		pStmt.setString(7,account.getTel_no());
		pStmt.setString(8,account.getZip());
		pStmt.setString(9,account.getPrefecture());
		pStmt.setString(10,account.getCity());
		pStmt.setString(11,account.getAddress());
		pStmt.setString(12,account.getDel_flg());
		pStmt.setString(13,account.getIns_date());
		pStmt.setString(14,account.getUpd_date());



		//INSERT文を実行
		pStmt.executeUpdate();

		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if(pStmt !=null) pStmt.close();
				if(conn != null) conn.close();
				return true;
			} catch (Exception ex) {}
		}
		return true;
	}

	public Account findBylogin(Login login) { //ログイン時のアカウントサーチ
		Account account = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url,id,pass);
			String sql = "SELECT * FROM Account WHERE acc_cd = ? AND login_pw = ?";
			//SERECT準備
			pStmt = conn.prepareStatement(sql);
			pStmt.setString(1,login.getAcc_cd());
			pStmt.setString(2,login.getLogin_pw());

			//SELECT文を実行し結果表を作成
			ResultSet rs = pStmt.executeQuery();
			//一致したユーザーがいた場合Accountインスタンスを生成
			if(rs.next()) {
				String acc_cd = rs.getString("acc_cd"); //ログインidのこと
				String login_name = rs.getString("login_name");
				String login_pw = rs.getString("login_pw");
				String gender = rs.getString("gender");
				String fullname = rs.getString("fullname");
				String mail = rs.getString("mail");
				String tel_no = rs.getString("tel_no");
				String zip = rs.getString("zip");
				String prefecture = rs.getString("prefecture");
				String city = rs.getString("city");
				String address = rs.getString("address");
				String del_flg = rs.getString("del_flg");
				String ins_date= rs.getString("ins_date");
				String upd_date = rs.getString("upd_date");

				account = new Account(acc_cd,login_name,login_pw,gender,fullname,mail,tel_no,zip,prefecture,city,address,del_flg,ins_date,upd_date);
			}
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if(pStmt !=null) pStmt.close();
				if(conn != null) conn.close();
				return account;
			} catch (Exception ex) {}
		}

		return account;
	}


}
