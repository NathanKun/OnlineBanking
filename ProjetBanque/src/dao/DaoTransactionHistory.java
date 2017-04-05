package dao;

import java.util.ArrayList;

import model.TransactionHistory;

public class DaoTransactionHistory extends Dao {
	/**
	 * return a specific TransactionHistory by it's id.
	 * 
	 * @param id
	 *            id of the TransactionHistory
	 * @return tsh - the TransactionHistory
	 */
	public static TransactionHistory getTransactionHistory(int id) {
		String sql = "SELECT * FROM TransactionHistory_tsh WHERE tsh_id = ?";
		TransactionHistory tsh = (TransactionHistory) getOne("TransactionHistory", sql, id);
		return tsh;
	}

	/**
	 * allow to have the full list of TransactionHistory in the data base.
	 * 
	 * @return the list of all the TransactionHistorys in the data base
	 */
	@SuppressWarnings("unchecked")
	public static ArrayList<TransactionHistory> getTransactionHistoryList() {
		String sql = "SELECT * FROM TransactionHistory_tsh";
		return (ArrayList<TransactionHistory>) Dao.getList("TransactionHistory", sql);
	}

	/**
	 * add TransactionHistory in the date base.
	 * 
	 * @param TransactionHistory
	 *            - TransactionHistory to add
	 * @return the number of line add in the TransactionHistory list
	 */
	public static int addTransactionHistory(TransactionHistory tsh) {
		return Dao.addRow("TransactionHistory", tsh);
	}

	/**
	 * delete a TransactionHistory in the data base TransactionHistory table.
	 * 
	 * @param id
	 *            contain the id of the TransactionHistory we want to delete
	 * @return the number of line delete
	 */
	public static int deleteTransactionHistory(int id) {
		return Dao.deleteLine("TransactionHistory", id);
	}

	/**
	 * update a TransactionHistory.
	 * ONLY Description is modifiable.
	 * Amount, Date and AccountNumber are NOT MODIFIABLE
	 * @param TransactionHistory
	 *            the TransactionHistory for update
	 * @return numbers of line updated
	 */
	public static int updateTransactionHistory(TransactionHistory tsh) {
		return Dao.updateLine("TransactionHistory", tsh);
	}
	
	
	/**
	 * return a list of TransactionHistory of a specified account's number.
	 * 
	 * @param number
	 *            number of the account
	 * @return tsh - the list of TransactionHistory
	 */
	@SuppressWarnings("unchecked")
	public static ArrayList<TransactionHistory> findTshByAccNumber(String number) {
		String sql = "SELECT * FROM transactionhistory_tsh WHERE tsh_acc_number = " + number;
		ArrayList<TransactionHistory> tshList = (ArrayList<TransactionHistory>) getList("FindTshByAccId", sql);
		return tshList;
	}

	/**
	 * Main for testing
	 * 
	 * @param args Arguments
	 */
	public static void main(String[] args) {
		// insert test
//		TransactionHistory tsh = new TransactionHistory(0, "4444555566660003", "test3", new DateTime(), new BigDecimal(333));
//		DaoTransactionHistory.addTransactionHistory(tsh);

		// get one test
//		System.out.println(DaoTransactionHistory.getTransactionHistory(3).toString());

		// get all test
		
//		for (TransactionHistory tsh : DaoTransactionHistory.getTransactionHistoryList()){
//			System.out.println(tsh); 
//		}
		

		// delete test
//		DaoTransactionHistory.deleteTransactionHistory(1);

		// Update test
//		TransactionHistory tsh = DaoTransactionHistory.getTransactionHistory(3);
//		tsh.setTsh_description("Updated");
//		DaoTransactionHistory.updateTransactionHistory(tsh);
//		System.out.println(DaoTransactionHistory.getTransactionHistory(3).toString());
	}
}
