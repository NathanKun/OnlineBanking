package model;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * Classe Client
 * @author Groupe4-BanqueEnLigne
 * @version 1.0 
 */

import org.joda.time.DateTime;

import dao.DaoAccount;
import dao.DaoClient;
import dao.DaoHoldingShare;

/**
 * Data transfer object of Client
 * 
 * @author Benjilany, Junyang HE
 */
public class Client implements Serializable{
	/**
	 * generated serialVersionUID
	 */
	private static final long serialVersionUID = 1423389198819788270L;
	
	/**
	 * the client id
	 */
	private int clt_id;
	
	/**
	 * the client login
	 */
	private String clt_login;
	
	/**
	 * the client first name
	 */
	private String clt_fname;
	
	/**
	 * the client last name
	 */
	private String clt_lname;
	/**
	 * 
	 * the client nationality
	 */
	private String clt_nationality;
	
	/**
	 * the client gender
	 */
	private String clt_gender;
	
	/**
	 * the client address
	 */
	private String clt_address;
	
	/**
	 * the client postal code
	 */
	private String clt_postalcode;
	
	/**
	 * the client city
	 */
	private String clt_city;
	
	/**
	 * the client telephone number
	 */
	private String clt_telephonenumber;
	
	/**
	 * the client email
	 */
	private String clt_email;
	
	/**
	 * the client status
	 */
	private String clt_status;
	
	/**
	 * the client password
	 */
	private String clt_password;
	
	/**
	 * the client birthday date
	 */
	private DateTime clt_birthday;
	
	/**
	 * the client last login date
	 */
	private DateTime clt_lastlogin;
	
	/**
	 * the date where the client create the account
	 */
	private DateTime clt_createdon;

	/**
	 * current account
	 */
	private Account currentAccount = null;
	/**
	 * saving account
	 */
	private Account savingAccount = null;
	/**
	 * securities account
	 */
	private Account securitiesAccount = null;

	/**
	 * Constructor
	 *
	 * @param clt_id
	 *            client id
	 * @param clt_fname
	 *            client first name
	 * @param clt_lname
	 *            client last name
	 * @param clt_nationality
	 *            client nationality
	 * @param clt_gender
	 *            client gender
	 * @param clt_address
	 *            client address
	 * @param clt_postalcode
	 *            client postal code 
	 * @param clt_city
	 *            client city
	 * @param clt_telephonenumber
	 *            client phone number
	 * @param clt_email
	 *            client email
	 * @param clt_status
	 *            client status
	 * @param clt_password
	 *            client password
	 * @param clt_login
	 *            client login
	 * @param clt_birthday
	 *            client birthday date
	 * @param clt_lastlogin
	 *            client last login date
	 * @param clt_createdon
	 *            the date where the client create the account
	 */
	public Client(int clt_id, String clt_login, String clt_password, String clt_fname, String clt_lname,
			DateTime clt_birthday, String clt_nationality, String clt_gender, String clt_address, String clt_postalcode,
			String clt_city, String clt_telephonenumber, String clt_email, String clt_status, DateTime clt_lastlogin,
			DateTime clt_createdon) {
		this.clt_id = clt_id;
		this.clt_fname = clt_fname;
		this.clt_lname = clt_lname;
		this.clt_nationality = clt_nationality;
		this.clt_gender = clt_gender;
		this.clt_address = clt_address;
		this.clt_postalcode = clt_postalcode;
		this.clt_city = clt_city;
		this.clt_telephonenumber = clt_telephonenumber;
		this.clt_email = clt_email;
		this.clt_status = clt_status;
		this.clt_password = clt_password;
		this.clt_login = clt_login;
		this.clt_birthday = clt_birthday;
		this.clt_lastlogin = clt_lastlogin;
		this.clt_createdon = clt_createdon;
		this.currentAccount = null;
		this.savingAccount = null;
		this.securitiesAccount = null;

		/**
		 *  set accounts
		 */
		ArrayList<Account> accList = DaoAccount.findAccountByClientId(clt_id);
		for (Account acc : accList) {
			switch (acc.getAcc_type()) {
			case "Compte de courant":
				this.currentAccount = acc;
				break;
			case "Compte d'epargne":
				this.savingAccount = acc;
				break;
			case "Compte de titre":
				this.securitiesAccount = acc;
				break;
			default:
				break;
			}
		}
	}
	
	
	/**
	 * Pull Client from database to cover it sell
	 */
	public void pull(){
		Client clt = DaoClient.getClient(this.clt_id);

		this.clt_id = clt.clt_id;
		this.clt_fname = clt.clt_fname;
		this.clt_lname = clt.clt_lname;
		this.clt_nationality = clt.clt_nationality;
		this.clt_gender = clt.clt_gender;
		this.clt_address = clt.clt_address;
		this.clt_postalcode = clt.clt_postalcode;
		this.clt_city = clt.clt_city;
		this.clt_telephonenumber = clt.clt_telephonenumber;
		this.clt_email = clt.clt_email;
		this.clt_status = clt.clt_status;
		this.clt_password = clt.clt_password;
		this.clt_login = clt.clt_login;
		this.clt_birthday = clt.clt_birthday;
		this.clt_lastlogin = clt.clt_lastlogin;
		this.clt_createdon = clt.clt_createdon;
		this.currentAccount = null;
		this.savingAccount = null;
		this.securitiesAccount = null;

		/**
		 *  set accounts
		 */
		ArrayList<Account> accList = DaoAccount.findAccountByClientId(clt_id);
		for (Account acc : accList) {
			switch (acc.getAcc_type()) {
			case "Compte de courant":
				this.currentAccount = acc;
				break;
			case "Compte d'epargne":
				this.savingAccount = acc;
				break;
			case "Compte de titre":
				this.securitiesAccount = acc;
				break;
			default:
				break;
			}
		}
	}
	
	/**
	 * Push modification to database.
	 */
	public void push(){
		DaoClient.updateClient(this);
	}

	/**
	 * Get the full name of the client
	 * 
	 * @return the full name of the client
	 */
	public String getFullName() {
		return clt_lname + " " + clt_fname;
	}

	/**
	 * Get the Holding Share list of this client
	 * 
	 * @return List of HoldingShare
	 */
	public ArrayList<HoldingShare> getHoldingShare() {
		return DaoHoldingShare.findHdsByCltId(clt_id);
	}

	/**
	 * @return the clt_id
	 */
	public int getClt_id() {
		return clt_id;
	}

	/**
	 * @param clt_id
	 *            the clt_id to set
	 */
	public void setClt_id(int clt_id) {
		this.clt_id = clt_id;
	}

	/**
	 * @return the clt_login
	 */
	public String getClt_login() {
		return clt_login;
	}

	/**
	 * @param clt_login
	 *            the clt_login to set
	 */
	public void setClt_login(String clt_login) {
		this.clt_login = clt_login;
	}

	/**
	 * @return the clt_fname
	 */
	public String getClt_fname() {
		return clt_fname;
	}

	/**
	 * @param clt_fname
	 *            the clt_fname to set
	 */
	public void setClt_fname(String clt_fname) {
		this.clt_fname = clt_fname;
	}

	/**
	 * @return the clt_lname
	 */
	public String getClt_lname() {
		return clt_lname;
	}

	/**
	 * @param clt_lname
	 *            the clt_lname to set
	 */
	public void setClt_lname(String clt_lname) {
		this.clt_lname = clt_lname;
	}

	/**
	 * @return the clt_nationality
	 */
	public String getClt_nationality() {
		return clt_nationality;
	}

	/**
	 * @param clt_nationality
	 *            the clt_nationality to set
	 */
	public void setClt_nationality(String clt_nationality) {
		this.clt_nationality = clt_nationality;
	}

	/**
	 * @return the clt_gender
	 */
	public String getClt_gender() {
		return clt_gender;
	}

	/**
	 * @param clt_gender
	 *            the clt_gender to set
	 */
	public void setClt_gender(String clt_gender) {
		this.clt_gender = clt_gender;
	}

	/**
	 * @return the clt_address
	 */
	public String getClt_address() {
		return clt_address;
	}

	/**
	 * @param clt_address
	 *            the clt_address to set
	 */
	public void setClt_address(String clt_address) {
		this.clt_address = clt_address;
	}

	/**
	 * @return the clt_postalcode
	 */
	public String getClt_postalcode() {
		return clt_postalcode;
	}

	/**
	 * @param clt_postalcode
	 *            the clt_postalcode to set
	 */
	public void setClt_postalcode(String clt_postalcode) {
		this.clt_postalcode = clt_postalcode;
	}

	/**
	 * @return the clt_city
	 */
	public String getClt_city() {
		return clt_city;
	}

	/**
	 * @param clt_city
	 *            the clt_city to set
	 */
	public void setClt_city(String clt_city) {
		this.clt_city = clt_city;
	}

	/**
	 * @return the clt_telephonenumber
	 */
	public String getClt_telephonenumber() {
		return clt_telephonenumber;
	}

	/**
	 * @param clt_telephonenumber
	 *            the clt_telephonenumber to set
	 */
	public void setClt_telephonenumber(String clt_telephonenumber) {
		this.clt_telephonenumber = clt_telephonenumber;
	}

	/**
	 * @return the clt_email
	 */
	public String getClt_email() {
		return clt_email;
	}

	/**
	 * @param clt_email
	 *            the clt_email to set
	 */
	public void setClt_email(String clt_email) {
		this.clt_email = clt_email;
	}

	/**
	 * @return the clt_status
	 */
	public String getClt_status() {
		return clt_status;
	}

	/**
	 * @param clt_status
	 *            the clt_status to set
	 */
	public void setClt_status(String clt_status) {
		this.clt_status = clt_status;
	}

	/**
	 * @return the clt_password
	 */
	public String getClt_password() {
		return clt_password;
	}

	/**
	 * @param clt_password
	 *            the clt_password to set
	 */
	public void setClt_password(String clt_password) {
		this.clt_password = clt_password;
	}

	/**
	 * @return the clt_birthday
	 */
	public DateTime getClt_birthday() {
		return clt_birthday;
	}

	/**
	 * @param clt_birthday
	 *            the clt_birthday to set
	 */
	public void setClt_birthday(DateTime clt_birthday) {
		this.clt_birthday = clt_birthday;
	}

	/**
	 * @return the clt_lastlogin
	 */
	public DateTime getClt_lastlogin() {
		return clt_lastlogin;
	}

	/**
	 * @param clt_lastlogin
	 *            the clt_lastlogin to set
	 */
	public void setClt_lastlogin(DateTime clt_lastlogin) {
		this.clt_lastlogin = clt_lastlogin;
	}

	/**
	 * @return the clt_createdon
	 */
	public DateTime getClt_createdon() {
		return clt_createdon;
	}

	/**
	 * @param clt_createdon
	 *            the clt_createdon to set
	 */
	public void setClt_createdon(DateTime clt_createdon) {
		this.clt_createdon = clt_createdon;
	}

	/**
	 * @return the currentAccount
	 */
	public Account getCurrentAccount() {
		return currentAccount;
	}

	/**
	 * @param currentAccount
	 *            the currentAccount to set
	 */
	public void setCurrentAccount(Account currentAccount) {
		this.currentAccount = currentAccount;
	}

	/**
	 * @return the savingAccount
	 */
	public Account getSavingAccount() {
		return savingAccount;
	}

	/**
	 * @param savingAccount
	 *            the savingAccount to set
	 */
	public void setSavingAccount(Account savingAccount) {
		this.savingAccount = savingAccount;
	}

	/**
	 * @return the securitiesAccount
	 */
	public Account getSecuritiesAccount() {
		return securitiesAccount;
	}

	/**
	 * @param securitiesAccount
	 *            the securitiesAccount to set
	 */
	public void setSecuritiesAccount(Account securitiesAccount) {
		this.securitiesAccount = securitiesAccount;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Client [clt_id=" + clt_id + ", clt_login=" + clt_login + ", clt_fname=" + clt_fname + ", clt_lname="
				+ clt_lname + ", clt_nationality=" + clt_nationality + ", clt_gender=" + clt_gender + ", clt_address="
				+ clt_address + ", clt_postalcode=" + clt_postalcode + ", clt_city=" + clt_city
				+ ", clt_telephonenumber=" + clt_telephonenumber + ", clt_email=" + clt_email + ", clt_status="
				+ clt_status + ", clt_password=" + clt_password + ", clt_birthday=" + clt_birthday + ", clt_lastlogin="
				+ clt_lastlogin + ", clt_createdon=" + clt_createdon + ", currentAccount=" + currentAccount
				+ ", savingAccount=" + savingAccount + ", securitiesAccount=" + securitiesAccount + "]";
	}
	

}
