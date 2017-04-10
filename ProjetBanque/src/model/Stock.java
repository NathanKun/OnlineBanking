package model;

import java.math.BigDecimal;
import java.util.ArrayList;

import dao.DaoStockHistoricalPrice;

/**
 * Data transfer object of stock
 * 
 * @author Junyang HE
 *
 */
public class Stock {

	/**
	 * l'identifiant de l'action
	 */
	private int stk_id;

	/**
	 * le nom de l'action
	 */
	private String stk_name;

	/**
	 * la description de l'action
	 */
	private String stk_description;

	/**
	 * le prix de l'action
	 */
	private BigDecimal stk_price;

	/**
	 * 
	 * @param id
	 *            id of the stock
	 * @param name
	 *            name of the stock
	 * @param description
	 *            description of the stock
	 * @param price
	 *            price of the stock
	 */
	public Stock(int id, String name, String description, BigDecimal price) {
		this.stk_id = id;
		this.stk_name = name;
		this.stk_description = description;
		this.stk_price = price;
	}

	/**
	 * Get the historical price list of this stock
	 * 
	 * @return List of StockHistoricalPrice
	 */
	public ArrayList<StockHistoricalPrice> getHistoricalPrice() {
		return DaoStockHistoricalPrice.findShpByStkId(stk_id);
	}

	/**
	 * @return the stk_id
	 */
	public int getStk_id() {
		return stk_id;
	}

	/**
	 * @param stk_id
	 *            the stk_id to set
	 */
	public void setStk_id(int stk_id) {
		this.stk_id = stk_id;
	}

	/**
	 * @return the stk_name
	 */
	public String getStk_name() {
		return stk_name;
	}

	/**
	 * @param stk_name
	 *            the stk_name to set
	 */
	public void setStk_name(String stk_name) {
		this.stk_name = stk_name;
	}

	/**
	 * @return the stk_description
	 */
	public String getStk_description() {
		return stk_description;
	}

	/**
	 * @param stk_description
	 *            the stk_description to set
	 */
	public void setStk_description(String stk_description) {
		this.stk_description = stk_description;
	}

	/**
	 * @return the stk_price
	 */
	public BigDecimal getStk_price() {
		return stk_price;
	}

	/**
	 * @param stk_price
	 *            the stk_price to set
	 */
	public void setStk_price(BigDecimal stk_price) {
		this.stk_price = stk_price;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Stock [stk_id=" + stk_id + ", stk_name=" + stk_name + ", stk_description=" + stk_description
				+ ", stk_price=" + stk_price + "]";
	}

}
