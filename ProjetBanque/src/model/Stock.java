package model;

import dao.DaoStock;

/**
 * Data transfer object of stock
 * 
 * @author Junyang HE
 *
 */
public class Stock {

	/**
	 * ticker symbol de l'action
	 */
	private String stk_ticker;

	/**
	 * le nom de l'action
	 */
	private String stk_name;

	/**
	 * la description de l'action
	 */
	private String stk_description;
	
	/**
	 * 
	 * @param ticker
	 *            ticker symbol of the stock
	 * @param name
	 *            name of the stock
	 * @param description
	 *            description of the stock
	 */
	public Stock(String ticker, String name, String description) {
		this.stk_ticker = ticker;
		this.stk_name = name;
		this.stk_description = description;
	}

	/**
	 * Pull stock from database to cover it sell
	 */
	public void pull(){
		Stock stk = DaoStock.getStock(this.stk_ticker);
		this.stk_ticker = stk.stk_ticker;
		this.stk_name = stk.stk_name;
		this.stk_description = stk.stk_description;
	}
	
	/**
	 * Push modification to database.
	 */
	public void push(){
		DaoStock.updateStock(this);
	}

	/**
	 * @return the stk_ticker
	 */
	public String getStk_ticker() {
		return stk_ticker;
	}

	/**
	 * @param stk_ticker the stk_ticker to set
	 */
	public void setStk_ticker(String stk_ticker) {
		this.stk_ticker = stk_ticker;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Stock [stk_ticker=" + stk_ticker + ", stk_name=" + stk_name + ", stk_description=" + stk_description + "]";
	}

}
