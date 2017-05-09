package model;

import org.joda.time.DateTime;

import dao.DaoStock;

/**
 * Data transfer object of Holding share
 * 
 * @author Junyang HE
 *
 */
public class HoldingShare {

	/**
	 * l'identifiant du HoldingShare
	 */
	private int hds_id;

	/**
	 * ticker symbole de l'action achetée
	 */
	private String hds_stk_ticker;

	/**
	 * l'identifiant du compte du HoldingShare
	 */
	private int hds_acc_id;

	/**
	 * le nombre d'actions achetées
	 */
	private int hds_numberOfShares;

	/**
	 * la date de l'achat
	 */
	private DateTime hds_boughtOn;

	/**
	 * 
	 * @param id
	 *            id of HoldingShare
	 * @param stk_ticker
	 *            stock ticker of HoldingShare
	 * @param acc_id
	 *            account id that hold the share
	 * @param nb
	 *            number of shares holding
	 * @param boughtOn
	 *            date of buying the stock
	 */
	public HoldingShare(int id, String stk_ticker, int acc_id, int nb, DateTime boughtOn) {
		this.hds_id = id;
		this.hds_stk_ticker = stk_ticker;
		this.hds_acc_id = acc_id;
		this.hds_numberOfShares = nb;
		this.hds_boughtOn = boughtOn;
	}
	
	public Stock getStock(){
		return DaoStock.getStock(this.hds_stk_ticker);
	}

	/**
	 * @return the hds_id
	 */
	public int getHds_id() {
		return hds_id;
	}

	/**
	 * @param hds_id
	 *            the hds_id to set
	 */
	public void setHds_id(int hds_id) {
		this.hds_id = hds_id;
	}

	/**
	 * @return the hds_stk_ticker
	 */
	public String getHds_stk_ticker() {
		return hds_stk_ticker;
	}

	/**
	 * @param hds_stk_ticker
	 *            the hds_stk_ticker to set
	 */
	public void setHds_stk_ticker(String hds_stk_ticker) {
		this.hds_stk_ticker = hds_stk_ticker;
	}

	/**
	 * @return the hds_acc_id
	 */
	public int getHds_acc_id() {
		return hds_acc_id;
	}

	/**
	 * @param hds_acc_id
	 *            the hds_acc_id to set
	 */
	public void setHds_acc_id(int hds_acc_id) {
		this.hds_acc_id = hds_acc_id;
	}

	/**
	 * @return the hds_numberOfShares
	 */
	public int getHds_numberOfShares() {
		return hds_numberOfShares;
	}

	/**
	 * @param hds_numberOfShares
	 *            the hds_numberOfShares to set
	 */
	public void setHds_numberOfShares(int hds_numberOfShares) {
		this.hds_numberOfShares = hds_numberOfShares;
	}

	/**
	 * @return the hds_boughtOn
	 */
	public DateTime getHds_boughtOn() {
		return hds_boughtOn;
	}

	/**
	 * @param hds_boughtOn
	 *            the hds_boughtOn to set
	 */
	public void setHds_boughtOn(DateTime hds_boughtOn) {
		this.hds_boughtOn = hds_boughtOn;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "HoldingShare [hds_id=" + hds_id + ", hds_stk_ticker=" + hds_stk_ticker + ", hds_acc_id=" + hds_acc_id
				+ ", hds_numberOfShares=" + hds_numberOfShares + ", hds_boughtOn=" + hds_boughtOn + "]";
	}

}
