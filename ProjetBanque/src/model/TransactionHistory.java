package model;

import java.math.BigDecimal;

import org.joda.time.DateTime;

public class TransactionHistory {

	private int tsh_id;
	
	private String tsh_acc_number;
	
	private String tsh_description;
	
	private DateTime tsh_transactionOn;
	
	private BigDecimal tsh_amount;
	
	public TransactionHistory(int id, String accNb, String description, DateTime time, BigDecimal amount) {
		this.tsh_id = id;
		this.tsh_acc_number = accNb;
		this.tsh_description = description;
		this.tsh_transactionOn = time;
		this.tsh_amount = amount;
	}

	public int getTsh_id() {
		return tsh_id;
	}

	public void setTsh_id(int tsh_id) {
		this.tsh_id = tsh_id;
	}

	public String getTsh_acc_number() {
		return tsh_acc_number;
	}

	public void setTsh_acc_number(String tsh_acc_number) {
		this.tsh_acc_number = tsh_acc_number;
	}

	public DateTime getTsh_transactionOn() {
		return tsh_transactionOn;
	}

	public void setTsh_transactionOn(DateTime tsh_transactionOn) {
		this.tsh_transactionOn = tsh_transactionOn;
	}

	public BigDecimal getTsh_amount() {
		return tsh_amount;
	}

	public void setTsh_amount(BigDecimal tsh_amount) {
		this.tsh_amount = tsh_amount;
	}

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
