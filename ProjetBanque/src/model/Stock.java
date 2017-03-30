package model;

import java.math.BigDecimal;
import java.util.ArrayList;

import dao.DaoStockHistoricalPrice;

public class Stock {

	/**
	 * l'identifiant de l'action
	 */
	private int stk_id;
	
	/**
	 * le nom de l'action
	private String stk_name;
	
	/**
	 * la description de l'action
	 */
	private String stk_description;
	
	/**
	 * le prix de l'action
	 */
	private BigDecimal stk_price;
	
	
	
	public Stock(int id, String name, String description, BigDecimal price) {
		this.stk_id = id;
		this.stk_name = name;
		this.stk_description = description;
		this.stk_price = price;
	}
	
	/**
	 * Get the historical price list of this stock
	 * @return List of StockHistoricalPrice
	 */
	public ArrayList<StockHistoricalPrice> getHistoricalPrice() {
		return DaoStockHistoricalPrice.findShpByStkId(stk_id);
	}

	/**
	* Permet d'obtenir l'identifiant de l'action.
	* @return l'identifiant de l'action.
	* @see #setStk_id(int stk_id)
	*/
	public int getStk_id() {
		return stk_id;
	}
	public void setStk_id(int stk_id) {
		this.stk_id = stk_id;
	}

	/**
	* Permet d'obtenir le nom de l'action.
	* @return le nom de l'action.
	* @see #setStk_name(String stk_name)
	*/
	public String getStk_name() {
		return stk_name;
	}
	public void setStk_name(String stk_name) {
		this.stk_name = stk_name;
	}

	/**
	* Permet d'obtenir la description de l'action.
	* @return la description de l'action.
	* @see #setStk_description(String stk_description)
	*/
	public String getStk_description() {
		return stk_description;
	}
	public void setStk_description(String stk_description) {
		this.stk_description = stk_description;
	}

	/**
	* Permet d'obtenir le prix de l'action.
	* @return le prix de l'action.
	* @see #setStk_price(BigDecimal stk_price)
	*/
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
