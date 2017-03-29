package model;

import java.util.Date;

import org.joda.time.DateTime;

public class Client {

	private int clt_id;
	private String clt_fname,clt_lname,clt_nationality,clt_gender,clt_address,clt_postalcode,clt_city,clt_telephonenumber,clt_email,clt_status,clt_password,clt_login; 
	private DateTime clt_birthday,clt_lastlogin,clt_createdon;
	
	public Client(int clt_id, String clt_fname, String clt_lname, String clt_nationality, String clt_gender,
			String clt_address, String clt_postalcode, String clt_city, String clt_telephonenumber, String clt_email,
			String clt_status, String clt_password, String clt_login, DateTime clt_birthday, DateTime clt_lastlogin,
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
	}

	public int getClt_id() {
		return clt_id;
	}

	public void setClt_id(int clt_id) {
		this.clt_id = clt_id;
	}

	public String getClt_fname() {
		return clt_fname;
	}

	public void setClt_fname(String clt_fname) {
		this.clt_fname = clt_fname;
	}

	public String getClt_lname() {
		return clt_lname;
	}

	public void setClt_lname(String clt_lname) {
		this.clt_lname = clt_lname;
	}

	public String getClt_nationality() {
		return clt_nationality;
	}

	public void setClt_nationality(String clt_nationality) {
		this.clt_nationality = clt_nationality;
	}

	public String getClt_gender() {
		return clt_gender;
	}

	public void setClt_gender(String clt_gender) {
		this.clt_gender = clt_gender;
	}

	public String getClt_address() {
		return clt_address;
	}

	public void setClt_address(String clt_address) {
		this.clt_address = clt_address;
	}

	public String getClt_postalcode() {
		return clt_postalcode;
	}

	public void setClt_postalcode(String clt_postalcode) {
		this.clt_postalcode = clt_postalcode;
	}

	public String getClt_city() {
		return clt_city;
	}

	public void setClt_city(String clt_city) {
		this.clt_city = clt_city;
	}

	public String getClt_telephonenumber() {
		return clt_telephonenumber;
	}

	public void setClt_telephonenumber(String clt_telephonenumber) {
		this.clt_telephonenumber = clt_telephonenumber;
	}

	public String getClt_email() {
		return clt_email;
	}

	public void setClt_email(String clt_email) {
		this.clt_email = clt_email;
	}

	public String getClt_status() {
		return clt_status;
	}

	public void setClt_status(String clt_status) {
		this.clt_status = clt_status;
	}

	public String getClt_password() {
		return clt_password;
	}

	public void setClt_password(String clt_password) {
		this.clt_password = clt_password;
	}

	public String getClt_login() {
		return clt_login;
	}

	public void setClt_login(String clt_login) {
		this.clt_login = clt_login;
	}

	public DateTime getClt_birthday() {
		return clt_birthday;
	}

	public void setClt_birthday(DateTime clt_birthday) {
		this.clt_birthday = clt_birthday;
	}

	public DateTime getClt_lastlogin() {
		return clt_lastlogin;
	}

	public void setClt_lastlogin(DateTime clt_lastlogin) {
		this.clt_lastlogin = clt_lastlogin;
	}

	public DateTime getClt_createdon() {
		return clt_createdon;
	}

	public void setClt_createdon(DateTime clt_createdon) {
		this.clt_createdon = clt_createdon;
	}

	@Override
	public String toString() {
		return "Client [clt_id=" + clt_id + ", clt_fname=" + clt_fname + ", clt_lname=" + clt_lname
				+ ", clt_nationality=" + clt_nationality + ", clt_gender=" + clt_gender + ", clt_address=" + clt_address
				+ ", clt_postalcode=" + clt_postalcode + ", clt_city=" + clt_city + ", clt_telephonenumber="
				+ clt_telephonenumber + ", clt_email=" + clt_email + ", clt_status=" + clt_status + ", clt_password="
				+ clt_password + ", clt_login=" + clt_login + ", clt_birthday=" + clt_birthday + ", clt_lastlogin="
				+ clt_lastlogin + ", clt_createdon=" + clt_createdon + "]";
	}

	

}
