package model;

import java.math.BigDecimal;

import org.joda.time.DateTime;

public class TransactionHistory {
	
	/**
	 * l'identifiant de l'historique des transactions
	 */
	private int tsh_id;
	
	/**
	 * le num�ro de compte dont l'historique des transactions
	 */
	private String tsh_acc_number;
	
	/**
	 * la description de l'historique des transactions
	 */
	private String tsh_description;
	
	/**
	 * 
	 */
	private DateTime tsh_transactionOn;
	
	/**
	 * 
	 */
	private BigDecimal tsh_amount;
	
	public TransactionHistory(int id, String accNb, String description, DateTime time, BigDecimal amount) {
		this.tsh_id = id;
		this.tsh_acc_number = accNb;
		this.tsh_description = description;
		this.tsh_transactionOn = time;
		this.tsh_amount = amount;
	}

	/**
	* Permet d'obtenir l'identifiant de l'historique des transactions.
	* @return l'identifiant de l'historique des transactions.
	* @see #setTsh_id(int tsh_id)
	*/
	public int getTsh_id() {
		return tsh_id;
	}
	public void setTsh_id(int tsh_id) {
		this.tsh_id = tsh_id;
	}
	
	/**
	* Permet d'obtenir le num�ro de compte dont l'historique des transactions.
	* @return le num�ro de compte dont l'historique des transactions.
	* @see #setTsh_acc_number(String tsh_acc_number)
	*/
	public String getTsh_acc_number() {
		return tsh_acc_number;
	}
	public void setTsh_acc_number(String tsh_acc_number) {
		this.tsh_acc_number = tsh_acc_number;
	}

	/**
	* Permet d'obtenir 
	* @return 
	* @see #setTsh_transactionOn(DateTime tsh_transactionOn)
	*/
	public DateTime getTsh_transactionOn() {
		return tsh_transactionOn;
	}
	public void setTsh_transactionOn(DateTime tsh_transactionOn) {
		this.tsh_transactionOn = tsh_transactionOn;
	}

	/**
	* Permet 
	* @return 
	* @see #setTsh_amount(BigDecimal tsh_amount)
	*/
	public BigDecimal getTsh_amount() {
		return tsh_amount;
	}
	public void setTsh_amount(BigDecimal tsh_amount) {
		this.tsh_amount = tsh_amount;
	}

	/**
	* Permet d'obtenir la description de l'historique des transactions.
	* @return la description de l'historique des transactions.
	* @see #setTsh_description(String tsh_description)
	*/
	public String getTsh_description() {
		return tsh_description;
	}
	public void setTsh_description(String tsh_description) {
		this.tsh_description = tsh_description;
	}

	@Override
	public String toString() {
		return "TransactionHistory [tsh_id=" + tsh_id + ", tsh_acc_number=" + tsh_acc_number + ", tsh_description="
				+ tsh_description + ", tsh_transactionOn=" + tsh_transactionOn + ", tsh_amount=" + tsh_amount + "]";
	}
}
