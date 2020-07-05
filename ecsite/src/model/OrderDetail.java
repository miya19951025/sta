package model;

public class OrderDetail {
	private int order_id;
	private int detail_id;
	private int product_id;
	private int whole_amount;
	private int money_amount;
	private int tax;
	private String del_flg;
	private String ins_date;
	private String upd_date;

	public OrderDetail(int order_id,int detail_id,int product_id,int whole_amount,int money_amount, int tax, String del_flg, String ins_date, String upd_date) {
		this.order_id = order_id;
		this.detail_id = detail_id;
		this.product_id = product_id;
		this.whole_amount = whole_amount;
		this.money_amount = money_amount;
		this.tax = tax;
		this.del_flg = del_flg;
		this.ins_date = ins_date;
		this.upd_date = upd_date;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getDetail_id() {
		return detail_id;
	}

	public void setDetail_id(int detail_id) {
		this.detail_id = detail_id;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public int getWhole_amount() {
		return whole_amount;
	}

	public void setWhole_amount(int whole_amount) {
		this.whole_amount = whole_amount;
	}

	public int getMoney_amount() {
		return money_amount;
	}

	public void setMoney_amount(int money_amount) {
		this.money_amount = money_amount;
	}

	public int getTax() {
		return tax;
	}

	public void setTax(int tax) {
		this.tax = tax;
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
