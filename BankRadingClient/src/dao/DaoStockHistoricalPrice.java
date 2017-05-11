package dao;

import java.util.ArrayList;

import model.StockHistoricalPrice;

/**
 * Data access object of Stock Historical Price.
 * Connecting class StockHistoricalPrice and table stockhistoricalprice_shp
 * 
 * @author Junyang HE
 *
 */
public class DaoStockHistoricalPrice extends Dao {
	/**
	 * return a specific StockHistoricalPrice by it's id.
	 * 
	 * @param id
	 *            id of the StockHistoricalPrice
	 * @return shp - the StockHistoricalPrice
	 */
	public static StockHistoricalPrice getStockHistoricalPrice(int id) {
		String sql = "SELECT * FROM StockHistoricalPrice_shp WHERE shp_id = ?";
		StockHistoricalPrice shp = (StockHistoricalPrice) getOne("StockHistoricalPrice", sql, id);
		return shp;
	}

	/**
	 * allow to have the full list of StockHistoricalPrice in the data base.
	 * 
	 * @return the list of all the StockHistoricalPrices in the data base
	 */
	@SuppressWarnings("unchecked")
	public static ArrayList<StockHistoricalPrice> getStockHistoricalPriceList() {
		String sql = "SELECT * FROM StockHistoricalPrice_shp";
		return (ArrayList<StockHistoricalPrice>) Dao.getList("StockHistoricalPrice", sql);
	}

	/**
	 * add StockHistoricalPrice in the date base.
	 * 
	 * @param shp
	 *            - StockHistoricalPrice to add
	 * @return the number of line add in the StockHistoricalPrice list
	 */
	public static int addStockHistoricalPrice(StockHistoricalPrice shp) {
		return Dao.addRow("StockHistoricalPrice", shp);
	}

	/**
	 * delete a StockHistoricalPrice in the data base StockHistoricalPrice table.
	 * 
	 * @param id
	 *            contain the id of the StockHistoricalPrice we want to delete
	 * @return the number of line delete
	 */
	public static int deleteStockHistoricalPrice(int id) {
		return Dao.deleteLine("StockHistoricalPrice", id);
	}

	/**
	 * update a StockHistoricalPrice.
	 * ONLY Price and Date are modifiable.
	 * @param shp
	 *            the StockHistoricalPrice for update
	 * @return numbers of line updated
	 */
	public static int updateStockHistoricalPrice(StockHistoricalPrice shp) {
		return Dao.updateLine("StockHistoricalPrice", shp);
	}

	/**
	 * Get list of HoldingShare for a client
	 * 
	 * @param stkId	client's ID
	 * @return	list of HoldingShare for this client
	 */
	@SuppressWarnings("unchecked")
	// TODO: NOT TESTED
	public static ArrayList<StockHistoricalPrice> findShpByStkId(int stkId) {
		String sql = "SELECT * FROM stockhistoricalprice_shp "
				+ "WHERE shp_stk_id = " + String.valueOf(stkId);
		
		ArrayList<StockHistoricalPrice> shpList = (ArrayList<StockHistoricalPrice>)Dao.getList("FindShpByStkId", sql);
		return shpList;
	}

	/**
	 * Main for testing
	 * 
	 * @param args Arguments
	 */
	public static void main(String[] args) {
		// insert test
//		StockHistoricalPrice shp = new StockHistoricalPrice(0, 42, new DateTime(), new BigDecimal(233));
//		DaoStockHistoricalPrice.addStockHistoricalPrice(shp);

		// get one test
//		System.out.println(DaoStockHistoricalPrice.getStockHistoricalPrice(16).toString());

		// get all test
		
//		for (StockHistoricalPrice shp : DaoStockHistoricalPrice.getStockHistoricalPriceList()){
//			System.out.println(shp); 
//		}
		

		// delete test
//		DaoStockHistoricalPrice.deleteStockHistoricalPrice(7203);

		// Update test
//		StockHistoricalPrice shp = DaoStockHistoricalPrice.getStockHistoricalPrice(7202);
//		shp.setShp_price(new BigDecimal(10000));;
//		shp.setShp_datetime(new DateTime(2016, 1, 1, 1, 1, 1));
//		DaoStockHistoricalPrice.updateStockHistoricalPrice(shp);
//		System.out.println(DaoStockHistoricalPrice.getStockHistoricalPrice(7202).toString());
	}
}
