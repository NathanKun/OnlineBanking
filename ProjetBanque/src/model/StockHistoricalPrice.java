package model;

import java.math.BigDecimal;

import org.joda.time.DateTime;

public class StockHistoricalPrice {
	
	private int shp_id;
	
	private int shp_stk_id;
	
	private DateTime shp_datetime;
	
	private BigDecimal shp_price;

	public StockHistoricalPrice(int id, int stk_id, DateTime datetime, BigDecimal price) {
		this.shp_id = id;
		this.shp_stk_id = stk_id;
		this.shp_price = price;
		this.shp_datetime = datetime;
	}
	
	public int getShp_id() {
		return shp_id;
	}

	public void setShp_id(int shp_id) {
		this.shp_id = shp_id;
	}

	public int getShp_stk_id() {
		return shp_stk_id;
	}

	public void setShp_stk_id(int shp_stk_id) {
		this.shp_stk_id = shp_stk_id;
	}

	public DateTime getShp_datetime() {
		return shp_datetime;
	}

	public void setShp_datetime(DateTime shp_datetime) {
		this.shp_datetime = shp_datetime;
	}

	public BigDecimal getShp_price() {
		return shp_price;
	}

	public void setShp_price(BigDecimal shp_price) {
		this.shp_price = shp_price;
	}
}
