package model;

public class Advisor {
	private int avs_id;
	private String avs_name;
	private String avs_login;
	private String avs_password;

	public Advisor(int avs_id, String avs_name, String avs_login, String avs_password) {
		this.avs_id = avs_id;
		this.avs_name = avs_name;
		this.avs_login = avs_login;
		this.avs_password = avs_password;
	}

	public int getAvs_id() {
		return avs_id;
	}

	public void setAvs_id(int avs_id) {
		this.avs_id = avs_id;
	}

	public String getAvs_name() {
		return avs_name;
	}

	public void setAvs_name(String avs_name) {
		this.avs_name = avs_name;
	}

	public String getAvs_login() {
		return avs_login;
	}

	public void setAvs_login(String avs_login) {
		this.avs_login = avs_login;
	}

	public String getAvs_password() {
		return avs_password;
	}

	public void setAvs_password(String avs_password) {
		this.avs_password = avs_password;
	}

	@Override
	public String toString() {
		return "Advisor [avs_id=" + avs_id + ", avs_name=" + avs_name + ", avs_login=" + avs_login + ", avs_password="
				+ avs_password + "]";
	}

}
