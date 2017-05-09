package model;

import java.math.BigDecimal;

import org.joda.time.DateTime;

/**
 * Data transfer object of stock historical price
 * 
 * @authors BENJILANY Junyang HE
 *
 */
public class StockHistoricalPrice {

	/**
	 * l'identifiant de l'historique du prix de l'action.
	 */
	private int shp_id;

	/**
	 * l'identifiant de l'action dont l'historique du prix.
	 */
	private int shp_stk_id;

	/**
	 * la date de l'historique du prix de l'action
	 */
	private DateTime shp_datetime;

	/**
	 * le prix de l'action de la date
	 */
	private BigDecimal shp_price;

	/**
	 * 
	 * @param id
	 *            id of StockHistoricalPrice
	 * @param stk_id
	 *            stock's id
	 * @param datetime
	 *            date of the price of this stock
	 * @param price
	 *            price of the day of this stock
	 */
	public StockHistoricalPrice(int id, int stk_id, DateTime datetime, BigDecimal price) {
		this.shp_id = id;
		this.shp_stk_id = stk_id;
		this.shp_price = price;
		this.shp_datetime = datetime;
	}

	/**
	 * @return the shp_id
	 */
	public int getShp_id() {
		return shp_id;
	}

	/**
	 * @param shp_id
	 *            the shp_id to set
	 */
	public void setShp_id(int shp_id) {
		this.shp_id = shp_id;
	}

	/**
	 * @return the shp_stk_id
	 */
	public int getShp_stk_id() {
		return shp_stk_id;
	}

	/**
	 * @param shp_stk_id
	 *            the shp_stk_id to set
	 */
	public void setShp_stk_id(int shp_stk_id) {
		this.shp_stk_id = shp_stk_id;
	}

	/**
	 * @return the shp_datetime
	 */
	public DateTime getShp_datetime() {
		return shp_datetime;
	}

	/**
	 * @param shp_datetime
	 *            the shp_datetime to set
	 */
	public void setShp_datetime(DateTime shp_datetime) {
		this.shp_datetime = shp_datetime;
	}

	/**
	 * @return the shp_price
	 */
	public BigDecimal getShp_price() {
		return shp_price;
	}

	/**
	 * @param shp_price
	 *            the shp_price to set
	 */
	public void setShp_price(BigDecimal shp_price) {
		this.shp_price = shp_price;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "StockHistoricalPrice [shp_id=" + shp_id + ", shp_stk_id=" + shp_stk_id + ", shp_datetime="
				+ shp_datetime + ", shp_price=" + shp_price + "]";
	}

}
