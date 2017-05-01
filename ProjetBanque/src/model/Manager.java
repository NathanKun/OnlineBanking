package model;

/**
 * Data transfer object of manager
 * 
 * @author Boubeker BENJILANY
 *
 */
public class Manager {
	private int mng_id;
	private String mng_name;
	private String mng_login;
	private String mng_password;

	/**
	 * 
	 * @param mng_id
	 *            id of manager
	 * @param mng_name
	 *            name of manager
	 * @param mng_login
	 *            login of manager
	 * @param mng_password
	 *            password hashed of manager
	 *            
	 */

	public Manager(int mng_id, String mng_name, String mng_login, String mng_password) {
		this.mng_id = mng_id;
		this.mng_name = mng_name;
		this.mng_login = mng_login;
		this.mng_password = mng_password;
	}

	/**
	 * @return the mng_id
	 */
	public int getmng_id() {
		return mng_id;
	}

	/**
	 * @param mng_id
	 *            the mng_id to set
	 */
	public void setmng_id(int mng_id) {
		this.mng_id = mng_id;
	}

	/**
	 * @return the mng_name
	 */
	public String getmng_name() {
		return mng_name;
	}

	/**
	 * @param mng_name
	 *            the mng_name to set
	 */
	public void setmng_name(String mng_name) {
		this.mng_name = mng_name;
	}

	/**
	 * @return the mng_login
	 */
	public String getmng_login() {
		return mng_login;
	}

	/**
	 * @param mng_login
	 *            the mng_login to set
	 */
	public void setmng_login(String mng_login) {
		this.mng_login = mng_login;
	}

	/**
	 * @return the mng_password
	 */
	public String getmng_password() {
		return mng_password;
	}

	/**
	 * @param mng_password
	 *            the mng_password to set
	 */
	public void setmng_password(String mng_password) {
		this.mng_password = mng_password;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Manager [mng_id=" + mng_id + ", mng_name=" + mng_name + ", mng_login=" + mng_login + ", mng_password="
				+ mng_password + "]";
	}

}

