package model;

import java.io.Serializable;
import java.math.BigDecimal;

import org.joda.time.DateTime;

/**
 * Data transfer object of Transaction History
 * 
 * @author BENJILANY, Junyang HE
 *
 */
public class TransactionHistory implements Serializable {

	/**
	 * generated serialVersionUID
	 */
	private static final long serialVersionUID = 4997773902150564873L;

	/**
	 * the TransactionHistory id
	 */
	private int tsh_id;

	/**
	 * the account number for the TransactionHistory
	 */
	private String tsh_acc_number;

	/**
	 * the TransactionHistory description
	 */
	private String tsh_description;

	/**
	 * the TransactionHistory date
	 */
	private DateTime tsh_transactionOn;

	/**
	 * the TransactionHistory amount
	 */
	private BigDecimal tsh_amount;

	/**
	 * Constructor
	 * 
	 * @param id
	 *            id of TransactionHistory
	 * @param accNb
	 *            account number
	 * @param description
	 *            description of TransactionHistory
	 * @param time
	 *            date of Transaction
	 * @param amount
	 *            amount of TransactionHistory
	 */
	public TransactionHistory(int id, String accNb, String description, DateTime time, BigDecimal amount) {
		this.tsh_id = id;
		this.tsh_acc_number = accNb;
		this.tsh_description = description;
		this.tsh_transactionOn = time;
		this.tsh_amount = amount;
	}

	/**
	 * @return the tsh_id
	 */
	public int getTsh_id() {
		return tsh_id;
	}

	/**
	 * @param tsh_id
	 *            the tsh_id to set
	 */
	public void setTsh_id(int tsh_id) {
		this.tsh_id = tsh_id;
	}

	/**
	 * @return the tsh_acc_number
	 */
	public String getTsh_acc_number() {
		return tsh_acc_number;
	}

	/**
	 * @param tsh_acc_number
	 *            the tsh_acc_number to set
	 */
	public void setTsh_acc_number(String tsh_acc_number) {
		this.tsh_acc_number = tsh_acc_number;
	}

	/**
	 * @return the tsh_description
	 */
	public String getTsh_description() {
		return tsh_description;
	}

	/**
	 * @param tsh_description
	 *            the tsh_description to set
	 */
	public void setTsh_description(String tsh_description) {
		this.tsh_description = tsh_description;
	}

	/**
	 * @return the tsh_transactionOn
	 */
	public DateTime getTsh_transactionOn() {
		return tsh_transactionOn;
	}

	/**
	 * @param tsh_transactionOn
	 *            the tsh_transactionOn to set
	 */
	public void setTsh_transactionOn(DateTime tsh_transactionOn) {
		this.tsh_transactionOn = tsh_transactionOn;
	}

	/**
	 * @return the tsh_amount
	 */
	public BigDecimal getTsh_amount() {
		return tsh_amount;
	}

	/**
	 * @param tsh_amount
	 *            the tsh_amount to set
	 */
	public void setTsh_amount(BigDecimal tsh_amount) {
		this.tsh_amount = tsh_amount;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TransactionHistory [tsh_id=" + tsh_id + ", tsh_acc_number=" + tsh_acc_number + ", tsh_description="
				+ tsh_description + ", tsh_transactionOn=" + tsh_transactionOn + ", tsh_amount=" + tsh_amount + "]";
	}

}