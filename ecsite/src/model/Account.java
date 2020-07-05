package model;

public class Account {
	private String acc_cd;
	private String login_name;
	private String login_pw;
	private String gender;
	private String fullname;
	private String mail;
	private String tel_no;
	private String zip;
	private String prefecture;
	private String city;
	private String address;
	private String del_flg;
	private String ins_date;
	private String upd_date;

	public Account() {}
	public Account(String acc_cd, String login_name, String login_pw, String gender,
			String fullname, String mail, String tel_no, String zip, String prefecture,
			String city, String address, String del_flg, String ins_date, String upd_date) {
		this.acc_cd = acc_cd;
		this.login_name = login_name;
		this.login_pw = login_pw;
		this.gender = gender;
		this.fullname = fullname;
		this.mail = mail;
		this.tel_no = tel_no;
		this.zip = zip;
		this.prefecture = prefecture;
		this.city = city;
		this.address = address;
		this.del_flg = del_flg;
		this.ins_date = ins_date;
		this.upd_date = upd_date;
	}
	public String getAcc_cd() {
		return acc_cd;
	}
	public void setAcc_cd(String acc_cd) {
		this.acc_cd = acc_cd;
	}
	public String getLogin_name() {
		return login_name;
	}
	public void setLogin_name(String login_name) {
		this.login_name = login_name;
	}
	public String getLogin_pw() {
		return login_pw;
	}
	public void setLogin_pw(String login_pw) {
		this.login_pw = login_pw;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getTel_no() {
		return tel_no;
	}
	public void setTel_no(String tel_no) {
		this.tel_no = tel_no;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getPrefecture() {
		return prefecture;
	}
	public void setPrefecture(String prefecture) {
		this.prefecture = prefecture;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDel_flg() {
		return del_flg;
	}
	public void setDel_flg(String del_flg) {
		this.del_flg = del_flg;
	}
	public String getIns_date() {
		return ins_date;
	}
	public void setIns_date(String ins_date) {
		this.ins_date = ins_date;
	}
	public String getUpd_date() {
		return upd_date;
	}
	public void setUpd_date(String upd_date) {
		this.upd_date = upd_date;
	}


}
