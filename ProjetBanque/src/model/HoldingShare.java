package model;

import org.joda.time.DateTime;

public class HoldingShare {

	/**
	 *l'identifiant du HoldingShare 	
	 */
	private int hds_id;

	/**
     * 	l'identifiant de l'action achet�e
     */
	private int hds_stk_id;
	
	/**
	 * l'identifiant du compte du HoldingShare
	 */
	private int hds_acc_id;
	
	/**
	 * le nombre d'actions achet�es
	 */
	private int hds_numberOfShares;
	
	/**
	 * la date de l'achat
	 */
	private DateTime hds_boughtOn;
	
	
	public HoldingShare(int id, int stk_id, int acc_id, int nb, 
			DateTime boughtOn) {
		this.hds_id = id;
		this.hds_stk_id = stk_id;
		this.hds_acc_id = acc_id;
		this.hds_numberOfShares = nb;
		this.hds_boughtOn = boughtOn;
	}

	/**
	* Permet d'obtenir l'identifiant du HoldingShare.
	* @return l'identifiant du HoldingShare.
	* @see #setHds_id(int hds_id)
	*/
	public int getHds_id() {
		return hds_id;
	}

	public void setHds_id(int hds_id) {
		this.hds_id = hds_id;
	}

	/**
	* Permet d'obtenir l'identifiant de l'action du HoldingShare.
	* @return l'identifiant de l'action du HoldingShare.
	* @see #setHds_stk_idd(int hds_stk_id)
	*/
	public int getHds_stk_id() {
		return hds_stk_id;
	}

	public void setHds_stk_id(int hds_stk_id) {
		this.hds_stk_id = hds_stk_id;
	}

	/**
	* Permet d'obtenir l'identifiant du compte du HoldingShare.
	* @return l'identifiant du compte du HoldingShare.
	* @see #setHds_acc_id(int hds_acc_id)
	*/
	public int getHds_acc_id() {
		return hds_acc_id;
	}

	public void setHds_acc_id(int hds_acc_id) {
		this.hds_acc_id = hds_acc_id;
	}

	/**
	* Permet d'obtenir le nombre d'actions achet�es.
	* @return le nombre d'actions achet�es.
	* @see #setHds_numberOfShares(int hds_numberOfShares)
	*/
	public int getHds_numberOfShares() {
		return hds_numberOfShares;
	}

	public void setHds_numberOfShares(int hds_numberOfShares) {
		this.hds_numberOfShares = hds_numberOfShares;
	}

	/**
	* Permet d'obtenir le nombre d'actions achet�es.
	* @return le nombre d'actions achet�es.
	* @see # setHds_boughtOn(DateTime hds_boughtOn).
	*/
	public DateTime getHds_boughtOn() {
		return hds_boughtOn;
	}

	public void setHds_boughtOn(DateTime hds_boughtOn) {
		this.hds_boughtOn = hds_boughtOn;
	}

	@Override
	public String toString() {
		return "HoldingShare [hds_id=" + hds_id + ", hds_stk_id=" + hds_stk_id + ", hds_acc_id=" + hds_acc_id
				+ ", hds_numberOfShares=" + hds_numberOfShares + ", hds_boughtOn=" + hds_boughtOn + "]";
	}
	
	
}
