package model;

public class Order {
	private int order_id;
	private int whole_amount ;
	private String order_date;
	private String limit_date;
	private String confirm_date;
	private String order_status;
	private String del_flg;
	private String ins_date;
	private String upd_date;

	public Order(int order_id,int whole_amount,String order_date,String limit_date,String confirm_date,String order_status,String del_flg,String ins_date,String upd_date) {
		this.order_id = order_id;
		this.whole_amount = whole_amount;
		this.order_date = order_date;
		this.limit_date = limit_date;
		this.confirm_date = confirm_date;
		this.order_status = order_status;
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

	public int getWhole_amount() {
		return whole_amount;
	}

	public void setWhole_amount(int whole_amount) {
		this.whole_amount = whole_amount;
	}

	public String getOrder_date() {
		return order_date;
	}

	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}

	public String getLimit_date() {
		return limit_date;
	}

	public void setLimit_date(String limit_date) {
		this.limit_date = limit_date;
	}

	public String getConfirm_date() {
		return confirm_date;
	}

	public void setConfirm_date(String confirm_date) {
		this.confirm_date = confirm_date;
	}

	public String getOrder_status() {
		return order_status;
	}

	public void setOrder_status(String order_status) {
		this.order_status = order_status;
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
