package model;

import java.math.BigDecimal;

public class Account {

	private int acc_id;

	private String acc_number;

	private int acc_clt_id;

	private BigDecimal acc_balance;

	private BigDecimal acc_interest;

	private String acc_type;

	public Account (int id, String number, int clt_id, 
			BigDecimal balance, BigDecimal interest, int type) {
		this.acc_id = id;
		this.acc_number = number;
		this.acc_clt_id = clt_id;
		this.acc_balance = balance;
		this.acc_interest = interest;
		
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

	public int getAcc_id() {
		return acc_id;
	}

	public void setAcc_id(int acc_id) {
		this.acc_id = acc_id;
	}

	public String getAcc_number() {
		return acc_number;
	}

	public void setAcc_number(String acc_number) {
		this.acc_number = acc_number;
	}

	public int getAcc_clt_id() {
		return acc_clt_id;
	}

	public void setAcc_clt_id(int acc_clt_id) {
		this.acc_clt_id = acc_clt_id;
	}

	public BigDecimal getAcc_balance() {
		return acc_balance;
	}

	public void setAcc_balance(BigDecimal acc_balance) {
		this.acc_balance = acc_balance;
	}

	public BigDecimal getAcc_interest() {
		return acc_interest;
	}

	public void setAcc_interest(BigDecimal acc_interest) {
		this.acc_interest = acc_interest;
	}

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