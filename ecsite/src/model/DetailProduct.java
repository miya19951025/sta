package model;

public class DetailProduct {
	private String product_name;
	private int product_price;
	private String category_name;
	private int stock;
	private String product_detail;
	private String product_img;

	public DetailProduct(String product_name,int product_price,String category_name,int stock,String product_detail,String product_img) {
		this.product_name = product_name;
		this.product_price = product_price;
		this.category_name = category_name;
		this.stock = stock;
		this.product_detail = product_detail;
		this.product_img = product_img;
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

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getProduct_detail() {
		return product_detail;
	}

	public void setProduct_detail(String product_detail) {
		this.product_detail = product_detail;
	}

	public String getProduct_img() {
		return product_img;
	}

	public void setProduct_img(String product_img) {
		this.product_img = product_img;
	}


}
