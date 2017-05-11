package dao;

import java.util.ArrayList;

import model.Stock;

/**
 * Data access object of Stock.
 * Connecting class StockHistoricalPrice and table stock_stk
 * 
 * @author Junyang HE
 *
 */
public class DaoStock extends Dao {
	/**
	 * return a specific Stock by it's id.
	 * 
	 * @param ticker
	 *            ticker of the Stock
	 * @return stk - the Stock
	 */
	public static Stock getStock(String ticker) {
		String sql = "SELECT * FROM Stock_stk WHERE stk_ticker = ?";
		Stock stk = (Stock) getOne("Stock", sql, ticker);
		return stk;
	}

	/**
	 * allow to have the full list of Stock in the data base.
	 * 
	 * @return the list of all the Stocks in the data base
	 */
	@SuppressWarnings("unchecked")
	public static ArrayList<Stock> getStockList() {
		String sql = "SELECT * FROM Stock_stk";
		return (ArrayList<Stock>) Dao.getList("Stock", sql);
	}

	/**
	 * add Stock in the date base.
	 * 
	 * @param stk
	 *            - Stock to add
	 * @return the number of line add in the Stock list
	 */
	public static int addStock(Stock stk) {
		return Dao.addRow("Stock", stk);
	}

	/**
	 * delete a Stock in the data base Stock table.
	 * 
	 * @param ticker
	 *            contain the id of the Stock we want to delete
	 * @return the number of line delete
	 */
	public static int deleteStock(String ticker) {
		return Dao.deleteLine("Stock", ticker);
	}

	/**
	 * update a Stock.
	 * ONLY Name, Description and Price are modifiable.
	 * @param stk
	 *            the Stock for update
	 * @return numbers of line updated
	 */
	public static int updateStock(Stock stk) {
		return Dao.updateLine("Stock", stk);
	}


	/**
	 * Main for testing
	 * 
	 * @param args Arguments
	 */
	public static void main(String[] args) {
		// insert test
//		Stock stk = new Stock(0, "stk1", "first stock", new BigDecimal(200));
//		DaoStock.addStock(stk);

		// get one test
		//System.out.println(DaoStock.getStock(1).toString());

		// get all test
		
//		for (Stock stk : DaoStock.getStockList()){
//			System.out.println(stk); 
//		}
		

		// delete test
//		DaoStock.deleteStock(46);

		// Update test
//		Stock stk = DaoStock.getStock(45);
//		stk.setStk_name("updated");
//		stk.setStk_description("des updated");
//		stk.setStk_price(new BigDecimal(2333));
//		DaoStock.updateStock(stk);
//		System.out.println(DaoStock.getStock(45).toString());
	}
}
