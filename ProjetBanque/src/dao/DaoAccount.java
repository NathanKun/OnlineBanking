package dao;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.joda.time.DateTime;

import model.Account;
import model.Account;

public class DaoAccount extends Dao {

	/**
	 * return a specific Account by it's id.
	 * 
	 * @param id
	 *            id of the Account
	 * @return acc - the Account
	 */
	public static Account getAccount(int id) {
		String sql = "SELECT * FROM Account_acc WHERE acc_id = ?";
		Account acc = (Account) getOne("Account", sql, id);
		return acc;
	}

	/**
	 * allow to have the full list of Account in the data base.
	 * 
	 * @return the list of all the Accounts in the data base
	 */
	@SuppressWarnings("unchecked")
	public static ArrayList<Account> getAccountList() {
		String sql = "SELECT * FROM Account_acc";
		return (ArrayList<Account>) Dao.getList("Account", sql);
	}

	/**
	 * add Account in the date base.
	 * 
	 * @param Account
	 *            - Account to add
	 * @return the number of line add in the Account list
	 */
	public static int addAccount(Account acc) {
		return Dao.addRow("Account", acc);
	}

	/**
	 * delete a Account in the data base Account table.
	 * 
	 * @param id
	 *            contain the id of the Account we want to delete
	 * @return the number of line delete
	 */
	public static int deleteAccount(int id) {
		return Dao.deleteLine("Account", id);
	}

	/**
	 * update a Account.
	 * ONLY Balance and Interest are modifiable.
	 * Account Number and Account type NOT MODIFIABLE
	 * @param Account
	 *            the Account for update
	 * @return numbers of line updated
	 */
	public static int updateAccount(Account acc) {
		return Dao.updateLine("Account", acc);
	}

	public static void main(String[] args) {
		// insert test
		/*Account acc = new Account(0, "0000111122223333", 1, new BigDecimal(123.45), new BigDecimal(0.12), 2);
		DaoAccount.addAccount(acc);*/

		// get one test
		//System.out.println(DaoAccount.getAccount(7).toString());

		// get all test
		/*
		for (Account acc : DaoAccount.getAccountList()){
			System.out.println(acc); 
		}*/
		

		// delete test
		//DaoAccount.deleteAccount(9);

		// Update test
		Account acc = DaoAccount.getAccount(1);
		acc.setAcc_balance(new BigDecimal(3366.99));
		acc.setAcc_interest(new BigDecimal(5.64));
		DaoAccount.updateAccount(acc);
		System.out.println(DaoAccount.getAccount(1).toString());
		
	}

}
