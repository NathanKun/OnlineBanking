package model;

import java.util.Date;
/**
 * Classe Client
 * @author Groupe4-BanqueEnLigne
 * @version 1.0 
 */

public class Client {
	/**
	   * L'id du client
	   */
	private int clt_id;
	/**
	   * Le prénom du client
	   */
	private String clt_fname;
	/**
	   * Le nom du client
	   */
	private String clt_lname;
	/**
	   * La nationalité du client
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
	   * Le login du client
	   */
	private String clt_login;
	/**
	   * La date de naissance du client
	   */
	private Date clt_birthday;
	/**
	   * La derniere connexion du client
	   */
	private Date clt_lastlogin;
	/**
	   * La date de création du compte courant du client
	   */
	private Date clt_createdon;
	
	 /**
	   * Le constructeur de la classe Client
	   *
	   * @param clt_id L'id du client
	   * @param clt_fname Le prénom du client
	   * @param clt_lname Le nom du client
	   * @param clt_nationality la nationalité du client
	   * @param clt_gender Le sexe du client
	   * @param clt_address l'adresse du client
	   * @param clt_postalcode Le code postal du client
	   * @param clt_city la ville du client
	   * @param clt_telephonenumber le numero du client
	   * @param clt_email l'email du client
	   * @param clt_status le statut du client
	   * @param clt_password le mot de passe du client
	   * @param clt_login le login du client
	   * @param clt_birthday la date de naissance du client	
	   * @param clt_lastlogin la date de la derniere connexion du client
	   * @param clt_createdon la date de creation du compte courant du client
	   */
	public Client(int clt_id, String clt_fname, String clt_lname, String clt_nationality, String clt_gender,
			String clt_address, String clt_postalcode, String clt_city, String clt_telephonenumber, String clt_email,
			String clt_status, String clt_password, String clt_login, Date clt_birthday, Date clt_lastlogin,
			Date clt_createdon) {
		super();
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
	}
	/**
	* Permet d'obtenir l'id du client.
	* @return l'id du client.
	* @see #setClt_id(String name)
	*/
	public int getClt_id() {
		return clt_id;
	}

	public void setClt_id(int clt_id) {
		this.clt_id = clt_id;
	}
	/**
	* Permet d'obtenir le prenom du client.
	* @return le prenom du client.
	* @see #setClt_fname(String name)
	*/
	public String getClt_fname() {
		return clt_fname;
	}

	public void setClt_fname(String clt_fname) {
		this.clt_fname = clt_fname;
	}
	/**
	* Permet d'obtenir le nom du client.
	* @return le nom du client.
	* @see #setClt_lastname(String name)
	*/
	public String getClt_lname() {
		return clt_lname;
	}

	public void setClt_lname(String clt_lname) {
		this.clt_lname = clt_lname;
	}
	/**
	* Permet d'obtenir l'id du client.
	* @return le nom du client.
	* @see #setClt_id(String name)
	*/
	public String getClt_nationality() {
		return clt_nationality;
	}

	public void setClt_nationality(String clt_nationality) {
		this.clt_nationality = clt_nationality;
	}
	/**
	* Permet d'obtenir l'id du client.
	* @return le nom du client.
	* @see #setClt_id(String name)
	*/
	public String getClt_gender() {
		return clt_gender;
	}

	public void setClt_gender(String clt_gender) {
		this.clt_gender = clt_gender;
	}
	/**
	* Permet d'obtenir l'id du client.
	* @return le nom du client.
	* @see #setClt_id(String name)
	*/
	public String getClt_address() {
		return clt_address;
	}

	public void setClt_address(String clt_address) {
		this.clt_address = clt_address;
	}
	/**
	* Permet d'obtenir l'id du client.
	* @return le nom du client.
	* @see #setClt_id(String name)
	*/
	public String getClt_postalcode() {
		return clt_postalcode;
	}

	public void setClt_postalcode(String clt_postalcode) {
		this.clt_postalcode = clt_postalcode;
	}
	/**
	* Permet d'obtenir l'id du client.
	* @return le nom du client.
	* @see #setClt_id(String name)
	*/
	public String getClt_city() {
		return clt_city;
	}

	public void setClt_city(String clt_city) {
		this.clt_city = clt_city;
	}
	/**
	* Permet d'obtenir l'id du client.
	* @return le nom du client.
	* @see #setClt_id(String name)
	*/
	public String getClt_telephonenumber() {
		return clt_telephonenumber;
	}

	public void setClt_telephonenumber(String clt_telephonenumber) {
		this.clt_telephonenumber = clt_telephonenumber;
	}
	/**
	* Permet d'obtenir l'id du client.
	* @return le nom du client.
	* @see #setClt_id(String name)
	*/
	public String getClt_email() {
		return clt_email;
	}

	public void setClt_email(String clt_email) {
		this.clt_email = clt_email;
	}
	/**
	* Permet d'obtenir l'id du client.
	* @return le nom du client.
	* @see #setClt_id(String name)
	*/
	public String getClt_status() {
		return clt_status;
	}

	public void setClt_status(String clt_status) {
		this.clt_status = clt_status;
	}
	/**
	* Permet d'obtenir l'id du client.
	* @return le nom du client.
	* @see #setClt_id(String name)
	*/
	public String getClt_password() {
		return clt_password;
	}

	public void setClt_password(String clt_password) {
		this.clt_password = clt_password;
	}
	/**
	* Permet d'obtenir l'id du client.
	* @return le nom du client.
	* @see #setClt_id(String name)
	*/
	public String getClt_login() {
		return clt_login;
	}

	public void setClt_login(String clt_login) {
		this.clt_login = clt_login;
	}
	/**
	* Permet d'obtenir l'id du client.
	* @return le nom du client.
	* @see #setClt_id(String name)
	*/
	public Date getClt_birthday() {
		return clt_birthday;
	}

	public void setClt_birthday(Date clt_birthday) {
		this.clt_birthday = clt_birthday;
	}
	/**
	* Permet d'obtenir l'id du client.
	* @return le nom du client.
	* @see #setClt_id(String name)
	*/
	public Date getClt_lastlogin() {
		return clt_lastlogin;
	}

	public void setClt_lastlogin(Date clt_lastlogin) {
		this.clt_lastlogin = clt_lastlogin;
	}
	/**
	* Permet d'obtenir l'id du client.
	* @return le nom du client.
	* @see #setClt_id(String name)
	*/
	public Date getClt_createdon() {
		return clt_createdon;
	}

	public void setClt_createdon(Date clt_createdon) {
		this.clt_createdon = clt_createdon;
	}

	

}
