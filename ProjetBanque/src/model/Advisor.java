package model;

import java.io.Serializable;

/**
 * Data transfer object of Advisor
 * 
 * @author Junyang HE
 *
 */
public class Advisor implements Serializable{
	/**
	 * generated serialVersionUID
	 */
	private static final long serialVersionUID = -8886234657997605636L;
	private int avs_id;
	private String avs_name;
	private String avs_login;
	private String avs_password;

	/**
	 * 
	 * @param avs_id
	 *            id of advisor
	 * @param avs_name
	 *            name of advisor
	 * @param avs_login
	 *            login of advisor
	 * @param avs_password
	 *            password hashed of advisor
	 */
	public Advisor(int avs_id, String avs_name, String avs_login, String avs_password) {
		this.avs_id = avs_id;
		this.avs_name = avs_name;
		this.avs_login = avs_login;
		this.avs_password = avs_password;
	}

	/**
	 * @return the avs_id
	 */
	public int getAvs_id() {
		return avs_id;
	}

	/**
	 * @param avs_id
	 *            the avs_id to set
	 */
	public void setAvs_id(int avs_id) {
		this.avs_id = avs_id;
	}

	/**
	 * @return the avs_name
	 */
	public String getAvs_name() {
		return avs_name;
	}

	/**
	 * @param avs_name
	 *            the avs_name to set
	 */
	public void setAvs_name(String avs_name) {
		this.avs_name = avs_name;
	}

	/**
	 * @return the avs_login
	 */
	public String getAvs_login() {
		return avs_login;
	}

	/**
	 * @param avs_login
	 *            the avs_login to set
	 */
	public void setAvs_login(String avs_login) {
		this.avs_login = avs_login;
	}

	/**
	 * @return the avs_password
	 */
	public String getAvs_password() {
		return avs_password;
	}

	/**
	 * @param avs_password
	 *            the avs_password to set
	 */
	public void setAvs_password(String avs_password) {
		this.avs_password = avs_password;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Advisor [avs_id=" + avs_id + ", avs_name=" + avs_name + ", avs_login=" + avs_login + ", avs_password="
				+ avs_password + "]";
	}

}
