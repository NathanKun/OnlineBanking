package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;

import dao.DaoHoldingShare;
import dao.DaoAccount;
import dao.DaoTransactionHistory;

/**
 * Data transfer object of Account
 * 
 * @author BENJILANY - Junyang HE
 *
 */
public class Account implements Serializable{

	/**
	 * generated serialVersionUID
	 */
	private static final long serialVersionUID = -2423945948890528730L;

	/**
	 * the account id
	 */
	private int acc_id;

	/**
	 * the account number
	 */
	private String acc_number;

	/**
	 * the account IBAN
	 */
	private String acc_iban;

	/**
	 * the client id 
	 */
	private int acc_clt_id;

	/**
	 * the account balance
	 */
	private BigDecimal acc_balance;

	/**
	 * the account interest
	 */
	private BigDecimal acc_interest;

	/**
	 * the account type
	 */
	private String acc_type;

	/**
	 * @param id
	 *            id of account
	 * @param number
	 *            number of account
	 * @param iban
	 * 			  iban of account
	 * @param clt_id
	 *            client who own the account
	 * @param balance
	 *            balance of account
	 * @param interest
	 *            interest of account
	 * @param type
	 *            type of account
	 */
	public Account(int id, String number, String iban, int clt_id, BigDecimal balance, BigDecimal interest, int type) {
		this.acc_id = id;
		this.acc_number = number;
		this.acc_iban = iban;
		this.acc_clt_id = clt_id;
		this.acc_balance = balance;
		this.acc_interest = interest;

		/**
		 *  set String of account's type by (int)type
		 */
		switch (type) {
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
	 * Pull Account from database to cover it sell
	 */
	public void pull(){
		Account acc = DaoAccount.getAccount(this.acc_id);
		this.acc_id = acc.acc_id;
		this.acc_number = acc.acc_number;
		this.acc_clt_id = acc.acc_clt_id;
		this.acc_balance = acc.acc_balance;
		this.acc_interest = acc.acc_interest;
	}
	
	/**
	 * Push modification to database.
	 */
	public void push(){
		DaoAccount.updateAccount(this);
	}

	
	/**
	 * Get the Transaction history list of this account
	 * 
	 * @return List of TransactionHistory
	 */
	public ArrayList<TransactionHistory> getTransactionHistory() {
		return DaoTransactionHistory.findTshByAccNumber(acc_number);
	}

	/**
	 * Get the Holding Share list of this account
	 * 
	 * @return List of HoldingShare
	 */
	public ArrayList<HoldingShare> getHoldingShare() {
		return DaoHoldingShare.findHdsByAccId(acc_id);
	}

	/**
	 * @return the acc_id
	 */
	public int getAcc_id() {
		return acc_id;
	}

	/**
	 * @param acc_id
	 *            the acc_id to set
	 */
	public void setAcc_id(int acc_id) {
		this.acc_id = acc_id;
	}

	/**
	 * @return the acc_number
	 */
	public String getAcc_number() {
		return acc_number;
	}

	/**
	 * @param acc_number
	 *            the acc_number to set
	 */
	public void setAcc_number(String acc_number) {
		this.acc_number = acc_number;
	}

	/**
	 * @return the acc_clt_id
	 */
	public int getAcc_clt_id() {
		return acc_clt_id;
	}

	/**
	 * @param acc_clt_id
	 *            the acc_clt_id to set
	 */
	public void setAcc_clt_id(int acc_clt_id) {
		this.acc_clt_id = acc_clt_id;
	}

	/**
	 * @return the acc_balance
	 */
	public BigDecimal getAcc_balance() {
		return acc_balance;
	}

	/**
	 * @param acc_balance
	 *            the acc_balance to set
	 */
	public void setAcc_balance(BigDecimal acc_balance) {
		this.acc_balance = acc_balance;
	}

	/**
	 * @return the acc_interest
	 */
	public BigDecimal getAcc_interest() {
		return acc_interest;
	}

	/**
	 * @param acc_interest
	 *            the acc_interest to set
	 */
	public void setAcc_interest(BigDecimal acc_interest) {
		this.acc_interest = acc_interest;
	}

	/**
	 * @return the acc_type
	 */
	public String getAcc_type() {
		return acc_type;
	}

	/**
	 * @param acc_type
	 *            the acc_type to set
	 */
	public void setAcc_type(String acc_type) {
		this.acc_type = acc_type;
	}

	/**
	 * @return the acc_iban
	 */
	public String getAcc_iban() {
		return acc_iban;
	}

	/**
	 * @param acc_iban the acc_iban to set
	 */
	public void setAcc_iban(String acc_iban) {
		this.acc_iban = acc_iban;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Account [acc_id=" + acc_id + ", acc_number=" + acc_number + ", acc_iban=" + acc_iban + ", acc_clt_id="
				+ acc_clt_id + ", acc_balance=" + acc_balance + ", acc_interest=" + acc_interest + ", acc_type="
				+ acc_type + "]";
	}

}