package dao;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.joda.time.DateTime;

import model.HoldingShare;

public class DaoHoldingShare extends Dao {
	/**
	 * return a specific HoldingShare by it's id.
	 * 
	 * @param id
	 *            id of the HoldingShare
	 * @return hds - the HoldingShare
	 */
	public static HoldingShare getHoldingShare(int id) {
		String sql = "SELECT * FROM HoldingShare_hds WHERE hds_id = ?";
		HoldingShare hds = (HoldingShare) getOne("HoldingShare", sql, id);
		return hds;
	}

	/**
	 * allow to have the full list of HoldingShare in the data base.
	 * 
	 * @return the list of all the HoldingShares in the data base
	 */
	@SuppressWarnings("unchecked")
	public static ArrayList<HoldingShare> getHoldingShareList() {
		String sql = "SELECT * FROM HoldingShare_hds";
		return (ArrayList<HoldingShare>) Dao.getList("HoldingShare", sql);
	}

	/**
	 * add HoldingShare in the date base.
	 * 
	 * @param HoldingShare
	 *            - HoldingShare to add
	 * @return the number of line add in the HoldingShare list
	 */
	public static int addHoldingShare(HoldingShare hds) {
		return Dao.addRow("HoldingShare", hds);
	}

	/**
	 * delete a HoldingShare in the data base HoldingShare table.
	 * 
	 * @param id
	 *            contain the id of the HoldingShare we want to delete
	 * @return the number of line delete
	 */
	public static int deleteHoldingShare(int id) {
		return Dao.deleteLine("HoldingShare", id);
	}

	/**
	 * update a HoldingShare.
	 * ONLY Balance and Interest are modifiable.
	 * HoldingShare Number and HoldingShare type NOT MODIFIABLE
	 * @param HoldingShare
	 *            the HoldingShare for update
	 * @return numbers of line updated
	 */
	public static int updateHoldingShare(HoldingShare hds) {
		return Dao.updateLine("HoldingShare", hds);
	}

	/**
	 * Get list of HoldingShare for a client
	 * 
	 * @param cltId	client's ID
	 * @return	list of HoldingShare for this client
	 */
	// TODO : NOT TESTED
	public static ArrayList<HoldingShare> findHdsByCltId(int cltId) {
		String sql = "SELECT * FROM holdingshare_hds "
				+ "INNER JOINT account_acc ON hds_acc_id = acc_id "
				+ "INNER JOINT client_clt ON acc_clt_id = clt_id "
				+ "WHERE clt_id = " + String.valueOf(cltId);
		ArrayList<HoldingShare> hdsList = (ArrayList<HoldingShare>)Dao.getList("FindHdsByCltId", sql);
		return hdsList;
	}

	/**
	 * Get list of HoldingShare for a account
	 * 
	 * @param accId	account's ID
	 * @return	list of HoldingShare for this account
	 */
	// TODO : NOT TESTED
	public static ArrayList<HoldingShare> findHdsByAccId(int accId) {
		String sql = "SELECT * FROM holdingshare_hds "
				+ "INNER JOINT account_acc ON hds_acc_id = acc_id "
				+ "WHERE acc_id = " + String.valueOf(accId);
		// same as FindHdsByCltId
		ArrayList<HoldingShare> hdsList = (ArrayList<HoldingShare>)Dao.getList("FindHdsByCltId", sql);
		return hdsList;
	}
	

	/**
	 * Main for testing
	 * 
	 * @param args Arguments
	 */
	public static void main(String[] args) {
		// insert test
//		HoldingShare hds = new HoldingShare(0, 1, 2, 200, new DateTime());
//		DaoHoldingShare.addHoldingShare(hds);

		// get one test
//		System.out.println(DaoHoldingShare.getHoldingShare(1).toString());

		// get all test
		
		/*for (HoldingShare hds : DaoHoldingShare.getHoldingShareList()){
			System.out.println(hds); 
		}*/
		

		// delete test
		//DaoHoldingShare.deleteHoldingShare(1);

		// Update test
//		HoldingShare hds = DaoHoldingShare.getHoldingShare(3);
//		hds.setHds_numberOfShares(3333);
//		DaoHoldingShare.updateHoldingShare(hds);
//		System.out.println(DaoHoldingShare.getHoldingShare(2).toString());
		
	}
}
