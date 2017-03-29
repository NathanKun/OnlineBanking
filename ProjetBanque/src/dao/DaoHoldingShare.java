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
