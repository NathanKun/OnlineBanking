package dao;

import java.util.ArrayList;

import model.Manager;


/**
 * Data access object of Manager.
 * Connecting class Manager and table manager
 * 
 * @author Amghar zakaria
 *
 */
public class DaoManager extends Dao{


	/**
	 * return a specific Manager by his id.
	 * 
	 * @param id
	 *            id of the Manager
	 * @return mng - the Manager
	 */
	public static Manager getManager(int id){
		String sql = "SELECT * FROM manager_mng WHERE mng_id = ?";
		Manager mng = (Manager) getOne("Manager", sql, id);
		return mng;
	}
	
	public static Manager findManagerByLogin(String login){
		String sql = "SELECT * FROM manager_mng WHERE mng_login = ?";
		Manager mng = (Manager) getOne("findManagerByLogin", sql, login);
		return mng;
	}
	
	/**
	 * allow to have the full list of Manager in the data base.
	 * 
	 * @return the list of all the Manager in the data base
	 */
	@SuppressWarnings("unchecked")
	public static ArrayList<Manager> getManagerList() {
		String sql = "SELECT * FROM manager_mng";
		return (ArrayList<Manager>) Dao.getList("Manager", sql);
	}
	
	/**
	 * add Manager in the date base.
	 * 
	 * @param mng
	 *            - Manager to add
	 * @return the number of line add in the Manager list
	 */
	public static int addManager(Manager mng) {
		return Dao.addRow("Manager", mng);
	}
	
	/**
	 * delete a Manager in the data base Manager table.
	 * 
	 * @param id
	 *            contain the id of the Manager we want to delete
	 * @return the number of line delete
	 */
	public static int deleteManager(int id) {
		return Dao.deleteLine("Manager", id);
	}

	/**
	 * update a Manager.
	 * 
	 * @param mng
	 *            the Manager for update
	 * @return numbers of line updated
	 */
	public static int updateManager(Manager mng) {
		return Dao.updateLine("Manager", mng);
	}


	/**
	 * Main for testing
	 * 
	 * @param args Arguments
	 */
	public static void main(String args[]){
		// insert test
//		Manager mng = new Manager(0, "addtestName2", "login2", "pw2");
//		System.out.println(DaoManager.addManager(mng));

		// get one test
//		System.out.println(DaoManager.getManager(2));
		
		// get all test
//		for (Manager mng : DaoManager.getManagerList()){
//			System.out.println(mng);
//		}
		
		// delete test
//		DaoManager.deleteManager(1);
		
//		// Update test
//		Manager mng = DaoManager.getManager(2);
//		mng.setmng_login("112233");
//		mng.setmng_password("updatedPw");
//		mng.setmng_name("updatedName");
//		DaoManager.updateManager(mng);
//		System.out.println(DaoManager.getManager(2).toString());
		
		// test findManagerByLogin
		System.out.println(findManagerByLogin("a"));
		
	}
}
