package dao;

import java.util.ArrayList;

import model.Advisor;


/**
 * Data access object of Advisor.
 * Connecting class Advisor and table advisor_avs
 * 
 * @author Junyang HE
 *
 */
public class DaoAdvisor extends Dao{


	/**
	 * return a specific Advisor by his id.
	 * 
	 * @param id
	 *            id of the Advisor
	 * @return avs - the Advisor
	 */
	public static Advisor getAdvisor(int id){
		String sql = "SELECT * FROM advisor_avs WHERE avs_id = ?";
		Advisor avs = (Advisor) getOne("Advisor", sql, id);
		return avs;
	}
	
	/**
	 * allow to have the full list of Advisor in the data base.
	 * 
	 * @return the list of all the Advisors in the data base
	 */
	@SuppressWarnings("unchecked")
	public static ArrayList<Advisor> getAdvisorList() {
		String sql = "SELECT * FROM advisor_avs";
		return (ArrayList<Advisor>) Dao.getList("Advisor", sql);
	}
	
	/**
	 * add Advisor in the date base.
	 * 
	 * @param avs
	 *            - Advisor to add
	 * @return the number of line add in the Advisor list
	 */
	public static int addAdvisor(Advisor avs) {
		return Dao.addRow("Advisor", avs);
	}
	
	/**
	 * delete a Advisor in the data base Advisor table.
	 * 
	 * @param id
	 *            contain the id of the Advisor we want to delete
	 * @return the number of line delete
	 */
	public static int deleteAdvisor(int id) {
		return Dao.deleteLine("Advisor", id);
	}

	/**
	 * update a Advisor.
	 * 
	 * @param avs
	 *            the Advisor for update
	 * @return numbers of line updated
	 */
	public static int updateAdvisor(Advisor avs) {
		return Dao.updateLine("Advisor", avs);
	}
	
	
	public static Advisor findAdvisorByLogin(String login) {
		String sql = "SELECT * FROM advisor_avs WHERE avs_login=?";
		Advisor avs = (Advisor) getOne("FindAdvisorByLogin", sql, login);
		return avs;
	}


	/**
	 * Main for testing
	 * 
	 * @param args Arguments
	 */
	public static void main(String args[]){
		// insert test
//		Advisor avs = new Advisor(0, "addtestName", "login3", "pw");
//		System.out.println(DaoAdvisor.addAdvisor(avs));
//		
		// get one test
//		System.out.println(DaoAdvisor.getAdvisor(3));
		
		// get all test
//		for (Advisor avs : DaoAdvisor.getAdvisorList()){
//			System.out.println(avs);
//		}
		
		// delete test
//		DaoAdvisor.deleteAdvisor(7);
		
//		// Update test
//		Advisor avs = DaoAdvisor.getAdvisor(9);
//		avs.setAvs_login("112233");
//		avs.setAvs_password("updatedPw");
//		avs.setAvs_name("updatedName");
//		DaoAdvisor.updateAdvisor(avs);
//		System.out.println(DaoAdvisor.getAdvisor(9).toString());
		
		// find avdisor by login test
//		System.out.println(findAdvisorByLogin("b"));
		
	}
}
