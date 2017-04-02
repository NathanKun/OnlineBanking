package model;

public class ContactForm {
	
	/**
	 * id of the contact form
	 */
	private int ctf_id;
	/**
	 * name of who filled this form
	 */
	private String ctf_name;
	/**
	 * email of who filled this form
	 */
	private String ctf_email;
	/**
	 * phone number of who filled this form
	 */
	private String ctf_tel;
	/**
	 * The message leaved
	 */
	private String cff_message;
	
	
	public ContactForm (int id, String name, String email, String tel, String msg) {
		this.ctf_id = id;
		this.ctf_name = name;
		this.ctf_email = email;
		this.ctf_tel = tel;
		this.cff_message = msg;
	}


	public int getCtf_id() {
		return ctf_id;
	}


	public void setCtf_id(int ctf_id) {
		this.ctf_id = ctf_id;
	}


	public String getCtf_name() {
		return ctf_name;
	}


	public void setCtf_name(String ctf_name) {
		this.ctf_name = ctf_name;
	}


	public String getCtf_email() {
		return ctf_email;
	}


	public void setCtf_email(String ctf_email) {
		this.ctf_email = ctf_email;
	}


	public String getCtf_tel() {
		return ctf_tel;
	}


	public void setCtf_tel(String ctf_tel) {
		this.ctf_tel = ctf_tel;
	}


	public String getCff_message() {
		return cff_message;
	}


	public void setCff_message(String cff_message) {
		this.cff_message = cff_message;
	}


	@Override
	public String toString() {
		return "ContactForm [ctf_id=" + ctf_id + ", ctf_name=" + ctf_name + ", ctf_email=" + ctf_email + ", ctf_tel="
				+ ctf_tel + ", cff_message=" + cff_message + "]";
	}
}
