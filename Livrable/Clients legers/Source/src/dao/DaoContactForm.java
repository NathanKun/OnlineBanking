package dao;

import java.util.ArrayList;

import model.ContactForm;


/**
 * Data access object of ContactForm.
 * Connecting class ContactForm and table contactform_ctf
 * 
 * @author Junyang HE
 *
 */
public class DaoContactForm extends Dao {

	/**
	 * return a specific ContactForm by his id.
	 * 
	 * @param id
	 *            identifiant of the ContactForm
	 * @return ctf - the ContactForm
	 */
	public static ContactForm getContactForm(int id){
		String sql = "SELECT * FROM ContactForm_ctf WHERE ctf_id = ?";
		ContactForm ctf = (ContactForm) getOne("ContactForm", sql, id);
		return ctf;
	}
	
	/**
	 * allow to have the full list of ContactForm in the data base.
	 * 
	 * @return the list of all the ContactForms in the data base
	 */
	@SuppressWarnings("unchecked")
	public static ArrayList<ContactForm> getContactFormList() {
		String sql = "SELECT * FROM ContactForm_ctf";
		return (ArrayList<ContactForm>) Dao.getList("ContactForm", sql);
	}
	
	/**
	 * add ContactForm in the date base.
	 * 
	 * @param ctf
	 *            - ContactForm to add
	 * @return the number of line add in the ContactForm list
	 */
	public static int addContactForm(ContactForm ctf) {
		return Dao.addRow("ContactForm", ctf);
	}
	
	/**
	 * delete a ContactForm in the data base ContactForm table.
	 * 
	 * @param id
	 *            contain the id of the ContactForm we want to delete
	 * @return the number of line delete
	 */
	public static int deleteContactForm(int id) {
		return Dao.deleteLine("ContactForm", id);
	}

	/**
	 * update a ContactForm.
	 * 
	 * @param ctf
	 *            the ContactForm for update
	 * @return numbers of line updated
	 */
	public static int updateContactForm(ContactForm ctf) {
		return Dao.updateLine("ContactForm", ctf);
	}


	/**
	 * Main for testing
	 * 
	 * @param args Arguments
	 */
	public static void main(String args[]){
		// insert test
		ContactForm ctf = new ContactForm(0, "Name2", "e@mai.il2", "phonenb2", "msgmsgmsgmsgmsgmsgmsg2");
		System.out.println(DaoContactForm.addContactForm(ctf));

		// get one test
//		System.out.println(DaoContactForm.getContactForm(4));
		
		// get all test
		
//		for (ContactForm ctf : DaoContactForm.getContactFormList()) {
//			System.out.println(ctf);
//		}
		
		// delete test
//		DaoContactForm.deleteContactForm(2);
	}
}
