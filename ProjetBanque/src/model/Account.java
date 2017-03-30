package model;

import java.math.BigDecimal;
import java.util.ArrayList;

import dao.DaoHoldingShare;
import dao.DaoStockHistoricalPrice;
import dao.DaoTransactionHistory;

public class Account {

	private int acc_id;
/**
 * l'id du compte
 */
	
	private String acc_number;
/**
 * le num�ro du compte
 */
	
	private int acc_clt_id;
/**
 * l'id du client poss�dant le compte
 */

	private BigDecimal acc_balance;
/**
 * le solde du compte
 */
	
	private BigDecimal acc_interest;
/**
 * les int�rets du compte
 */
	
	private String acc_type;
/**
 * le type du compte
 */
	
	/**
 * @param id
 * @param number
 * @param clt_id
 * @param balance
 * @param interest
 * @param type
 */
	public Account (int id, String number, int clt_id, 
			BigDecimal balance, BigDecimal interest, int type) {
		this.acc_id = id;
		this.acc_number = number;
		this.acc_clt_id = clt_id;
		this.acc_balance = balance;
		this.acc_interest = interest;
		
		// set String of account's type by (int)type
		switch (type){
		case 1:
			this.acc_type = "Compte de courant";
			break;
		case 2:
			this.acc_type = "Compte d'epargne";
			break;
		case 3:
			this.acc_type = "Compte de titre";
			break;
		default:
			this.acc_type = "error";
			break;
		}
	}
	
	/**
	 * Get the Transaction history list of this account
	 * @return List of TransactionHistory
	 */
	public ArrayList<TransactionHistory> getTransactionHistory() {
		return DaoTransactionHistory.findTshByAccId(acc_id);
	}
	
	/**
	 * Get the Holding Share list of this account
	 * @return List of HoldingShare
	 */
	public ArrayList<HoldingShare> getHoldingShare() {
		return DaoHoldingShare.findHdsByAccId(acc_id);
	}
	
	
	/**
	* Permet d'obtenir l'identifiant du compte.
	* @return l'identifiant du compte.
	* @see #setAcc_id(int acc_id)
	*/
	public int getAcc_id() {
		return acc_id;
	}

	public void setAcc_id(int acc_id) {
		this.acc_id = acc_id;
	}
	
	/**
	* Permet d'obtenir le num�ro du compte.
	* @return le num�ro du compte.
	* @see #setAcc_number(String acc_number)
	*/

	public String getAcc_number() {
		return acc_number;
	}

	public void setAcc_number(String acc_number) {
		this.acc_number = acc_number;
	}
	
	/**
	* Permet d'obtenir l'identifiant du client poss�dant le compte.
	* @return l'identifiant du client poss�dant le compte.
	* @see #setAcc_clt_id(String acc_clt_id)
	*/

	public int getAcc_clt_id() {
		return acc_clt_id;
	}

	public void setAcc_clt_id(int acc_clt_id) {
		this.acc_clt_id = acc_clt_id;
	}

	/**
	* Permet d'obtenir le solde du compte.
	* @return le solde du compte.
	* @see #setAcc_balance(BigDecimal acc_balance)
	*/
	
	public BigDecimal getAcc_balance() {
		return acc_balance;
	}

	public void setAcc_balance(BigDecimal acc_balance) {
		this.acc_balance = acc_balance;
	}
	
	/**
	* Permet d'obtenir les int�rets du compte.
	* @return les int�rets du compte.
	* @see #setAcc_interest(BigDecimal acc_interest)
	*/
	public BigDecimal getAcc_interest() {
		return acc_interest;
	}

	public void setAcc_interest(BigDecimal acc_interest) {
		this.acc_interest = acc_interest;
	}

	/**
	* Permet d'obtenir le type du compte.
	* @return le type du compte.
	* @see #setAcc_type(String acc_type)
	*/
	public String getAcc_type() {
		return acc_type;
	}

	public void setAcc_type(String acc_type) {
		this.acc_type = acc_type;
	}

	@Override
	public String toString() {
		return "Account [acc_id=" + acc_id + ", acc_number=" + acc_number + ", acc_clt_id=" + acc_clt_id
				+ ", acc_balance=" + acc_balance + ", acc_interest=" + acc_interest + ", acc_type=" + acc_type + "]";
	}
}