package model;

import java.math.BigDecimal;

import org.joda.time.DateTime;

public class HoldingShare {

	private int hds_id;
	
	private int hds_stk_id;
	
	private int hds_acc_id;
	
	private int hds_numberOfShares;
	
	private DateTime hds_boughtOn;
	
	private BigDecimal hds_total;
	
	public HoldingShare(int id, int stk_id, int acc_id, int nb, 
			DateTime boughtOn, BigDecimal total) {
		this.hds_id = id;
		this.hds_stk_id = stk_id;
		this.hds_acc_id = acc_id;
		this.hds_numberOfShares = nb;
		this.hds_boughtOn = boughtOn;
		this.hds_total = total;
	}

	public int getHds_id() {
		return hds_id;
	}

	public void setHds_id(int hds_id) {
		this.hds_id = hds_id;
	}

	public int getHds_stk_id() {
		return hds_stk_id;
	}

	public void setHds_stk_id(int hds_stk_id) {
		this.hds_stk_id = hds_stk_id;
	}

	public int getHds_acc_id() {
		return hds_acc_id;
	}

	public void setHds_acc_id(int hds_acc_id) {
		this.hds_acc_id = hds_acc_id;
	}

	public int getHds_numberOfShares() {
		return hds_numberOfShares;
	}

	public void setHds_numberOfShares(int hds_numberOfShares) {
		this.hds_numberOfShares = hds_numberOfShares;
	}

	public DateTime getHds_boughtOn() {
		return hds_boughtOn;
	}

	public void setHds_boughtOn(DateTime hds_boughtOn) {
		this.hds_boughtOn = hds_boughtOn;
	}

	public BigDecimal getHds_total() {
		return hds_total;
	}

	public void setHds_total(BigDecimal hds_total) {
		this.hds_total = hds_total;
	}
	
	
}
