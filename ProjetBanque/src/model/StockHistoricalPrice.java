package model;

import java.math.BigDecimal;

import org.joda.time.DateTime;

public class StockHistoricalPrice {
	
	/**
	 *l'identifiant de l'historique du prix de l'action.
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
	 * le prix de l'action à la datetime
	 */
	private BigDecimal shp_price;

	
	public StockHistoricalPrice(int id, int stk_id, DateTime datetime, BigDecimal price) {
		this.shp_id = id;
		this.shp_stk_id = stk_id;
		this.shp_price = price;
		this.shp_datetime = datetime;
	}
	
	/**
	* Permet d'obtenir l'identifiant de l'historique du prix de l'action.
	* @return l'identifiant de l'historique du prix de l'action.
	* @see #ssetShp_id(int shp_id)
	*/
	public int getShp_id() {
		return shp_id;
	}
	public void setShp_id(int shp_id) {
		this.shp_id = shp_id;
	}

	/**
	* Permet d'obtenir l'identifiant de l'action dont l'historique du prix.
	* @return l'identifiant de l'action dont l'historique du prix.
	* @see #setShp_stk_id(int shp_stk_id)
	*/
	public int getShp_stk_id() {
		return shp_stk_id;
	}
	public void setShp_stk_id(int shp_stk_id) {
		this.shp_stk_id = shp_stk_id;
	}

	/**
	* Permet d'obtenir la date de l'historique du prix de l'action.
	* @return la date de l'historique du prix de l'action.
	* @see #setShp_datetime(DateTime shp_datetime)
	*/
	public DateTime getShp_datetime() {
		return shp_datetime;
	}
	public void setShp_datetime(DateTime shp_datetime) {
		this.shp_datetime = shp_datetime;
	}

	/**
	* Permet d'obtenir le prix de l'action à la datetime.
	* @return le prix de l'action à la datetime.
	* @see #setShp_price(BigDecimal shp_price)
	*/
	public BigDecimal getShp_price() {
		return shp_price;
	}
	public void setShp_price(BigDecimal shp_price) {
		this.shp_price = shp_price;
	}

	@Override
	public String toString() {
		return "StockHistoricalPrice [shp_id=" + shp_id + ", shp_stk_id=" + shp_stk_id + ", shp_datetime="
				+ shp_datetime + ", shp_price=" + shp_price + "]";
	}
}
