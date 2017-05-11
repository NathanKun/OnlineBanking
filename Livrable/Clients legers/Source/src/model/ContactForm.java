package model;

/**
 * Data transfer object of Contact form
 * 
 * @author Benjilany Junyang HE
 *
 */
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

	/**
	 * 
	 * @param id
	 *            id of ContactForm
	 * @param name
	 *            name of visitor who left the ContactForm
	 * @param email
	 *            email of visitor who left the ContactForm
	 * @param tel
	 *            phone number of visitor who left the ContactForm
	 * @param msg
	 *            message that visitor left
	 */
	public ContactForm(int id, String name, String email, String tel, String msg) {
		this.ctf_id = id;
		this.ctf_name = name;
		this.ctf_email = email;
		this.ctf_tel = tel;
		this.cff_message = msg;
	}

	/**
	 * @return the ctf_id
	 */
	public int getCtf_id() {
		return ctf_id;
	}

	/**
	 * @param ctf_id
	 *            the ctf_id to set
	 */
	public void setCtf_id(int ctf_id) {
		this.ctf_id = ctf_id;
	}

	/**
	 * @return the ctf_name
	 */
	public String getCtf_name() {
		return ctf_name;
	}

	/**
	 * @param ctf_name
	 *            the ctf_name to set
	 */
	public void setCtf_name(String ctf_name) {
		this.ctf_name = ctf_name;
	}

	/**
	 * @return the ctf_email
	 */
	public String getCtf_email() {
		return ctf_email;
	}

	/**
	 * @param ctf_email
	 *            the ctf_email to set
	 */
	public void setCtf_email(String ctf_email) {
		this.ctf_email = ctf_email;
	}

	/**
	 * @return the ctf_tel
	 */
	public String getCtf_tel() {
		return ctf_tel;
	}

	/**
	 * @param ctf_tel
	 *            the ctf_tel to set
	 */
	public void setCtf_tel(String ctf_tel) {
		this.ctf_tel = ctf_tel;
	}

	/**
	 * @return the cff_message
	 */
	public String getCff_message() {
		return cff_message;
	}

	/**
	 * @param cff_message
	 *            the cff_message to set
	 */
	public void setCff_message(String cff_message) {
		this.cff_message = cff_message;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ContactForm [ctf_id=" + ctf_id + ", ctf_name=" + ctf_name + ", ctf_email=" + ctf_email + ", ctf_tel="
				+ ctf_tel + ", cff_message=" + cff_message + "]";
	}

}
