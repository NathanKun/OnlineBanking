﻿package model;

import java.util.ArrayList;
/**
 * Classe Client
 * @author Groupe4-BanqueEnLigne
 * @version 1.0 
 */

import org.joda.time.DateTime;

import dao.DaoAccount;
import dao.DaoHoldingShare;

public class Client {
	/**
	 * L'identifiant du client
	 */
	private int clt_id;
	/**
	 * Le login du client
	 */
	private String clt_login;
	/**
	 * Le prénom du client
	 */
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
	 * Le numéro de téléphone du client
	 */
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
	 * La date de création du compte courant du client
	 */
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

		// set accounts
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
	 * Get the Holding Share list of this client
	 * @return List of HoldingShare
	 */
	public ArrayList<HoldingShare> getHoldingShare() {
		return DaoHoldingShare.findHdsByCltId(clt_id);
	}

	/**
	 * Permet d'obtenir l'id du client.
	 * 
	 * @return l'id du client.
	 * @see #setClt_id(int clt_id)
	 */
	public int getClt_id() {
		return clt_id;
	}

	public void setClt_id(int clt_id) {
		this.clt_id = clt_id;
	}

	/**
	 * Permet d'obtenir le prenom du client.
	 * 
	 * @return le prenom du client.
	 * @see #setClt_fname(String clt_fname)
	 */
	public String getClt_fname() {
		return clt_fname;
	}

	public void setClt_fname(String clt_fname) {
		this.clt_fname = clt_fname;
	}

	/**
	 * Permet d'obtenir le nom du client.
	 * 
	 * @return le nom du client.
	 * @see #setClt_lastname(String clt_lname)
	 */
	public String getClt_lname() {
		return clt_lname;
	}

	public void setClt_lname(String clt_lname) {
		this.clt_lname = clt_lname;
	}

	/**
	 * Permet d'obtenir la nationalité du client.
	 * 
	 * @return le nationalité du client.
	 * @see #setClt_nationality(String clt_nationality)
	 */
	public String getClt_nationality() {
		return clt_nationality;
	}

	public void setClt_nationality(String clt_nationality) {
		this.clt_nationality = clt_nationality;
	}

	/**
	 * Permet d'obtenir le sexe du client.
	 * 
	 * @return le sexe du client.
	 * @see #setClt_gender(String clt_gender)
	 */
	public String getClt_gender() {
		return clt_gender;
	}

	public void setClt_gender(String clt_gender) {
		this.clt_gender = clt_gender;
	}

	/**
	 * Permet d'obtenir l'adresse du client.
	 * 
	 * @return l'adresse du client.
	 * @see #setClt_address(String clt_address)
	 */
	public String getClt_address() {
		return clt_address;
	}

	public void setClt_address(String clt_address) {
		this.clt_address = clt_address;
	}

	/**
	 * Permet d'obtenir le code postal du client.
	 * 
	 * @return le code postal du client.
	 * @see #setClt_postalcode(String clt_postalcode)
	 */
	public String getClt_postalcode() {
		return clt_postalcode;
	}

	public void setClt_postalcode(String clt_postalcode) {
		this.clt_postalcode = clt_postalcode;
	}

	/**
	 * Permet d'obtenir la ville du client.
	 * 
	 * @return la ville du client.
	 * @see #setClt_city(String clt_city)
	 */
	public String getClt_city() {
		return clt_city;
	}

	public void setClt_city(String clt_city) {
		this.clt_city = clt_city;
	}

	/**
	 * Permet d'obtenir le numéro de téléphone du client.
	 * 
	 * @return le numéro de téléphone du client.
	 * @see #setClt_telephonenumber(String clt_telephonenumber)
	 */
	public String getClt_telephonenumber() {
		return clt_telephonenumber;
	}

	public void setClt_telephonenumber(String clt_telephonenumber) {
		this.clt_telephonenumber = clt_telephonenumber;
	}

	/**
	 * Permet d'obtenir l'email du client.
	 * 
	 * @return l'email du client.
	 * @see #setClt_email(String clt_email)
	 */
	public String getClt_email() {
		return clt_email;
	}

	public void setClt_email(String clt_email) {
		this.clt_email = clt_email;
	}

	/**
	 * Permet d'obtenir le statut du client.
	 * 
	 * @return le statut client.
	 * @see #setClt_status(String clt_status)
	 */
	public String getClt_status() {
		return clt_status;
	}

	public void setClt_status(String clt_status) {
		this.clt_status = clt_status;
	}

	/**
	 * Permet d'obtenir le mot de passe du client.
	 * 
	 * @return le mot de passe du client.
	 * @see #setClt_password(String clt_password)
	 */
	public String getClt_password() {
		return clt_password;
	}

	public void setClt_password(String clt_password) {
		this.clt_password = clt_password;
	}

	/**
	 * Permet d'obtenir le login du client.
	 * 
	 * @return le login du client.
	 * @see #setClt_login(String clt_login)
	 */
	public String getClt_login() {
		return clt_login;
	}

	public void setClt_login(String clt_login) {
		this.clt_login = clt_login;
	}

	/**
	 * Permet d'obtenir la date de naissance du client.
	 * 
	 * @return la date de naissance du client.
	 * @see #setClt_birthday(DateTime clt_birthday)
	 */
	public DateTime getClt_birthday() {
		return clt_birthday;
	}

	public void setClt_birthday(DateTime clt_birthday) {
		this.clt_birthday = clt_birthday;
	}

	/**
	 * Permet d'obtenir La derniere connexion du client.
	 * 
	 * @return La derniere connexion du client
	 * @see #setClt_lastlogin(DateTime clt_lastlogin)
	 */
	public DateTime getClt_lastlogin() {
		return clt_lastlogin;
	}

	public void setClt_lastlogin(DateTime clt_lastlogin) {
		this.clt_lastlogin = clt_lastlogin;
	}

	/**
	 * Permet d'obtenir la date de création du compte du client.
	 * 
	 * @return la date de création du compte du client.
	 * @see #setClt_createdon(DateTime clt_createdon)
	 */
	public DateTime getClt_createdon() {
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
