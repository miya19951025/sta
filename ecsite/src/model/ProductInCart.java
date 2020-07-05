package model;

public class ProductInCart {
	private String product_name;
	private int product_price;
	private int quantity;

	public ProductInCart(String name,int price,int quantity ) {
		this.product_name = name;
		this.product_price = price;
		this.quantity = quantity;
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


}
