package model;

public class Login {
	private String acc_cd;
	private String login_pw;

	public Login(String acc_cd, String login_pw) {
		this.acc_cd = acc_cd;
		this.login_pw = login_pw;
	}

	public String getAcc_cd() {
		return acc_cd;
	}

	public void setAcc_cd(String acc_cd) {
		this.acc_cd = acc_cd;
	}

	public String getLogin_pw() {
		return login_pw;
	}

	public void setLogin_pw(String login_pw) {
		this.login_pw = login_pw;
	}



}
