package model;

import java.util.ArrayList;
import java.util.Date;
/**
 * Classe Client
 * @author Groupe4-BanqueEnLigne
 * @version 1.0 
 */

import org.joda.time.DateTime;

import dao.DaoAccount;

public class Client {
	/**
<<<<<<< HEAD
	   * L'identifiant du client
	   */
=======
	 * L'id du client
	 */
>>>>>>> origin/master
	private int clt_id;
	/**
	 * Le login du client
	 */
	private String clt_login;
	/**
<<<<<<< HEAD
	   * Le prénom du client
	   */
=======
	 * Le prenom du client
	 */
>>>>>>> origin/master
	private String clt_fname;
	/**
	 * Le nom du client
	 */
	private String clt_lname;
	/**
	 * La nationalite du client
	 */
	private String clt_nationality;
	/**
	 * Le sexe du client
	 */
	private String clt_gender;
	/**
	 * L'adresse du client
	 */
	private String clt_address;
	/**
	 * Le code postal du client
	 */
	private String clt_postalcode;
	/**
	 * La ville du client
	 */
	private String clt_city;
	/**
<<<<<<< HEAD
	   * Le numéro de téléphone du client
	   */
=======
	 * Le num�ro de t�l�phone du client
	 */
>>>>>>> origin/master
	private String clt_telephonenumber;
	/**
	 * L'email du client
	 */
	private String clt_email;
	/**
	 * Le statut du client
	 */
	private String clt_status;
	/**
	 * Le mot de passe du client
	 */
	private String clt_password;
	/**
	 * La date de naissance du client
	 */
	private DateTime clt_birthday;
	/**
	 * La derniere connexion du client
	 */
	private DateTime clt_lastlogin;
	/**
<<<<<<< HEAD
	   * La date de création du compte courant du client
	   */
=======
	 * La date de cr�ation du compte courant du client
	 */
>>>>>>> origin/master
	private DateTime clt_createdon;

	/**
	 * Compte de courrant
	 */
	private Account currentAccount = null;
	/**
	 * Compte d'epargne
	 */
	private Account savingAccount = null;
	/**
	 * Compte de titre
	 */
	private Account securitiesAccount = null;

	/**
	 * Le constructeur de la classe Client
	 *
	 * @param clt_id
	 *            L'id du client
	 * @param clt_fname
	 *            Le pr�nom du client
	 * @param clt_lname
	 *            Le nom du client
	 * @param clt_nationality
	 *            la nationalit� du client
	 * @param clt_gender
	 *            Le sexe du client
	 * @param clt_address
	 *            l'adresse du client
	 * @param clt_postalcode
	 *            Le code postal du client
	 * @param clt_city
	 *            la ville du client
	 * @param clt_telephonenumber
	 *            le numero du client
	 * @param clt_email
	 *            l'email du client
	 * @param clt_status
	 *            le statut du client
	 * @param clt_password
	 *            le mot de passe du client
	 * @param clt_login
	 *            le login du client
	 * @param clt_birthday
	 *            la date de naissance du client
	 * @param clt_lastlogin
	 *            la date de la derniere connexion du client
	 * @param clt_createdon
	 *            la date de creation du compte courant du client
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
		
		ArrayList<Account> accList = DaoAccount.findAccountByClientId(clt_id);
		for(Account acc : accList){
			switch(acc.getAcc_type()){
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
	

	public Account getCurrentAccount() {
		return currentAccount;
	}

	public void setCurrentAccount(Account currentAccount) {
		this.currentAccount = currentAccount;
	}

	public Account getSavingAccount() {
		return savingAccount;
	}

	public void setSavingAccount(Account savingAccount) {
		this.savingAccount = savingAccount;
	}

	public Account getSecuritiesAccount() {
		return securitiesAccount;
	}

	public void setSecuritiesAccount(Account securitiesAccount) {
		this.securitiesAccount = securitiesAccount;
	}


	/**
<<<<<<< HEAD
	* Permet d'obtenir l'id du client.
	* @return l'id du client.
	* @see #setClt_id(int clt_id)
	*/
=======
	 * Permet d'obtenir l'id du client.
	 * 
	 * @return l'id du client.
	 * @see #setClt_id(String name)
	 */
>>>>>>> origin/master
	public int getClt_id() {
		return clt_id;
	}

	public void setClt_id(int clt_id) {
		this.clt_id = clt_id;
	}

	/**
<<<<<<< HEAD
	* Permet d'obtenir le prenom du client.
	* @return le prenom du client.
	* @see #setClt_fname(String clt_fname)
	*/
=======
	 * Permet d'obtenir le prenom du client.
	 * 
	 * @return le prenom du client.
	 * @see #setClt_fname(String name)
	 */
>>>>>>> origin/master
	public String getClt_fname() {
		return clt_fname;
	}

	public void setClt_fname(String clt_fname) {
		this.clt_fname = clt_fname;
	}

	/**
<<<<<<< HEAD
	* Permet d'obtenir le nom du client.
	* @return le nom du client.
	* @see #setClt_lastname(String clt_lname)
	*/
=======
	 * Permet d'obtenir le nom du client.
	 * 
	 * @return le nom du client.
	 * @see #setClt_lastname(String name)
	 */
>>>>>>> origin/master
	public String getClt_lname() {
		return clt_lname;
	}

	public void setClt_lname(String clt_lname) {
		this.clt_lname = clt_lname;
	}

	/**
<<<<<<< HEAD
	* Permet d'obtenir la nationalité du client.
	* @return le nationalité du client.
	* @see #setClt_nationality(String clt_nationality)
	*/
=======
	 * Permet d'obtenir l'id du client.
	 * 
	 * @return le nom du client.
	 * @see #setClt_id(String name)
	 */
>>>>>>> origin/master
	public String getClt_nationality() {
		return clt_nationality;
	}

	public void setClt_nationality(String clt_nationality) {
		this.clt_nationality = clt_nationality;
	}

	/**
<<<<<<< HEAD
	* Permet d'obtenir le sexe du client.
	* @return le sexe du client.
	* @see #setClt_gender(String clt_gender)
	*/
=======
	 * Permet d'obtenir l'id du client.
	 * 
	 * @return le nom du client.
	 * @see #setClt_id(String name)
	 */
>>>>>>> origin/master
	public String getClt_gender() {
		return clt_gender;
	}

	public void setClt_gender(String clt_gender) {
		this.clt_gender = clt_gender;
	}

	/**
<<<<<<< HEAD
	* Permet d'obtenir l'adresse du client.
	* @return l'adresse du client.
	* @see #setClt_address(String clt_address)
	*/
=======
	 * Permet d'obtenir l'id du client.
	 * 
	 * @return le nom du client.
	 * @see #setClt_id(String name)
	 */
>>>>>>> origin/master
	public String getClt_address() {
		return clt_address;
	}

	public void setClt_address(String clt_address) {
		this.clt_address = clt_address;
	}

	/**
<<<<<<< HEAD
	* Permet d'obtenir le code postal du client.
	* @return le code postal du client.
	* @see #setClt_postalcode(String clt_postalcode)
	*/
=======
	 * Permet d'obtenir l'id du client.
	 * 
	 * @return le nom du client.
	 * @see #setClt_id(String name)
	 */
>>>>>>> origin/master
	public String getClt_postalcode() {
		return clt_postalcode;
	}

	public void setClt_postalcode(String clt_postalcode) {
		this.clt_postalcode = clt_postalcode;
	}

	/**
<<<<<<< HEAD
	* Permet d'obtenir la ville du client.
	* @return la ville du client.
	* @see #setClt_city(String clt_city)
	*/
=======
	 * Permet d'obtenir l'id du client.
	 * 
	 * @return le nom du client.
	 * @see #setClt_id(String name)
	 */
>>>>>>> origin/master
	public String getClt_city() {
		return clt_city;
	}

	public void setClt_city(String clt_city) {
		this.clt_city = clt_city;
	}

	/**
<<<<<<< HEAD
	* Permet d'obtenir le numéro de téléphone du client.
	* @return le numéro de téléphone du client.
	* @see #setClt_telephonenumber(String clt_telephonenumber)
	*/
=======
	 * Permet d'obtenir l'id du client.
	 * 
	 * @return le nom du client.
	 * @see #setClt_id(String name)
	 */
>>>>>>> origin/master
	public String getClt_telephonenumber() {
		return clt_telephonenumber;
	}

	public void setClt_telephonenumber(String clt_telephonenumber) {
		this.clt_telephonenumber = clt_telephonenumber;
	}

	/**
<<<<<<< HEAD
	* Permet d'obtenir l'email du client.
	* @return l'email du client.
	* @see #setClt_email(String clt_email)
	*/
=======
	 * Permet d'obtenir l'id du client.
	 * 
	 * @return le nom du client.
	 * @see #setClt_id(String name)
	 */
>>>>>>> origin/master
	public String getClt_email() {
		return clt_email;
	}

	public void setClt_email(String clt_email) {
		this.clt_email = clt_email;
	}

	/**
<<<<<<< HEAD
	* Permet d'obtenir le statut du client.
	* @return le statut client.
	* @see #setClt_status(String clt_status)
	*/
=======
	 * Permet d'obtenir l'id du client.
	 * 
	 * @return le nom du client.
	 * @see #setClt_id(String name)
	 */
>>>>>>> origin/master
	public String getClt_status() {
		return clt_status;
	}

	public void setClt_status(String clt_status) {
		this.clt_status = clt_status;
	}

	/**
<<<<<<< HEAD
	* Permet d'obtenir le mot de passe du client.
	* @return le mot de passe du client.
	* @see #setClt_password(String clt_password)
	*/
=======
	 * Permet d'obtenir l'id du client.
	 * 
	 * @return le nom du client.
	 * @see #setClt_id(String name)
	 */
>>>>>>> origin/master
	public String getClt_password() {
		return clt_password;
	}

	public void setClt_password(String clt_password) {
		this.clt_password = clt_password;
	}

	/**
<<<<<<< HEAD
	* Permet d'obtenir le login du client.
	* @return le login du client.
	* @see #setClt_login(String clt_login)
	*/
=======
	 * Permet d'obtenir l'id du client.
	 * 
	 * @return le nom du client.
	 * @see #setClt_id(String name)
	 */
>>>>>>> origin/master
	public String getClt_login() {
		return clt_login;
	}

	public void setClt_login(String clt_login) {
		this.clt_login = clt_login;
	}

	public DateTime getClt_birthday() {
<<<<<<< HEAD
	/**
	* Permet d'obtenir la date de naissance du client.
	* @return la date de naissance du client.
	* @see #setClt_birthday(DateTime clt_birthday)
	*/
=======
		/**
		 * Permet d'obtenir l'id du client.
		 * 
		 * @return le nom du client.
		 * @see #setClt_id(String name)
		 */
>>>>>>> origin/master
		return clt_birthday;
	}

	public void setClt_birthday(DateTime clt_birthday) {
		this.clt_birthday = clt_birthday;
	}

	public DateTime getClt_lastlogin() {
<<<<<<< HEAD
	/**
	* Permet d'obtenir La derniere connexion du client.
	* @return La derniere connexion du client
	* @see #setClt_lastlogin(DateTime clt_lastlogin)
	*/
=======
		/**
		 * Permet d'obtenir l'id du client.
		 * 
		 * @return le nom du client.
		 * @see #setClt_id(String name)
		 */
>>>>>>> origin/master
		return clt_lastlogin;
	}

	public void setClt_lastlogin(DateTime clt_lastlogin) {
		this.clt_lastlogin = clt_lastlogin;
	}

	public DateTime getClt_createdon() {
<<<<<<< HEAD
	/**
	* Permet d'obtenir la date de création du compte du client.
	* @return la date de création du compte du client.
	* @see #setClt_createdon(DateTime clt_createdon)
	*/
=======
		/**
		 * Permet d'obtenir l'id du client.
		 * 
		 * @return le nom du client.
		 * @see #setClt_id(String name)
		 */
>>>>>>> origin/master
		return clt_createdon;
	}

	public void setClt_createdon(DateTime clt_createdon) {
		this.clt_createdon = clt_createdon;
	}

	@Override
	public String toString() {
		return "Client [clt_id=" + clt_id + ", clt_login=" + clt_login + ", clt_fname=" + clt_fname + ", clt_lname="
				+ clt_lname + ", clt_nationality=" + clt_nationality + ", clt_gender=" + clt_gender + ", clt_address="
				+ clt_address + ", clt_postalcode=" + clt_postalcode + ", clt_city=" + clt_city
				+ ", clt_telephonenumber=" + clt_telephonenumber + ", clt_email=" + clt_email + ", clt_status="
				+ clt_status + ", clt_password=" + clt_password + ", clt_birthday=" + clt_birthday + ", clt_lastlogin="
				+ clt_lastlogin + ", clt_createdon=" + clt_createdon + "\n    currentAccount=" + currentAccount
				+ "\n    savingAccount=" + savingAccount + "\n    securitiesAccount=" + securitiesAccount + "]";
	}


}
