package model;

import java.math.BigDecimal;

public class Stock {

	private int stk_id;
	
	private String stk_name;
	
	private String stk_description;
	
	private BigDecimal stk_price;
	
	public Stock(int id, String name, String description, BigDecimal price) {
		this.stk_id = id;
		this.stk_name = name;
		this.stk_description = description;
		this.stk_price = price;
	}

	public int getStk_id() {
		return stk_id;
	}

	public void setStk_id(int stk_id) {
		this.stk_id = stk_id;
	}

	public String getStk_name() {
		return stk_name;
	}

	public void setStk_name(String stk_name) {
		this.stk_name = stk_name;
	}

	public String getStk_description() {
		return stk_description;
	}

	public void setStk_description(String stk_description) {
		this.stk_description = stk_description;
	}

	public BigDecimal getStk_price() {
		return stk_price;
	}

	public void setStk_price(BigDecimal stk_price) {
		this.stk_price = stk_price;
	}

	@Override
	public String toString() {
		return "Stock [stk_id=" + stk_id + ", stk_name=" + stk_name + ", stk_description=" + stk_description
				+ ", stk_price=" + stk_price + "]";
	}
}
