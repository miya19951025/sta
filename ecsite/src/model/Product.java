package model;

public class Product {
	private int product_id;
	private int category_id;
	private String product_name;
	private int product_price;
	private String product_img;
	private String product_detail;
	private String del_flg;
	private String ins_date;
	private String upd_date;

	public Product(int product_id, int category_id, String product_name, int product_price, String product_img, String product_detail, String del_flg, String ins_date, String upd_date) {
		this.product_id = product_id;
		this.category_id = category_id;
		this.product_name = product_name;
		this.product_price = product_price;
		this.product_detail = product_detail;
		this.product_img = product_img;
		this.del_flg = del_flg;
		this.ins_date = ins_date;
		this.upd_date = upd_date;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public int getProduct_price() {
		return product_price;
	}

	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}

	public String getProduct_img() {
		return product_img;
	}

	public void setProduct_img(String product_img) {
		this.product_img = product_img;
	}

	public String getProduct_detail() {
		return product_detail;
	}

	public void setProduct_detail(String product_detail) {
		this.product_detail = product_detail;
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
