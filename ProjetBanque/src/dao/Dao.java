package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.joda.time.DateTime;

import model.Account;
import model.Advisor;
import model.Client;
import model.ContactForm;
import model.HoldingShare;
import model.Manager;
import model.News;
import model.Stock;
import model.StockHistoricalPrice;
import model.TransactionHistory;

/**
 * Parent class of all Daos.
 * 
 * @author Junyang HE
 *
 */
abstract public class Dao {

	static String URL = "jdbc:mysql://localhost/onlinebank?autoReconnect=true&useSSL=false";
	static String LOGIN = "root";
	static String PASS = "root";

	/**
	 * load jdbc driver
	 */
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Dirver not found");
		}
		System.out.println("Done");
	}

	/**
	 * get an object from the data base.
	 * 
	 * @param type
	 *            the type of object
	 * @param sql
	 *            the SQL code
	 * @param item
	 *            the parameter
	 * @return the object got from data base
	 */
	protected static Object getOne(String type, String sql, Object item) {
		Object retour = null;

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		// connection to the data base
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement(sql);
			switch (type) {
			case "Manager":
			case "Advisor":
			case "Client":
			case "Account":
			case "HoldingShare":
			case "TransactionHistory":
			case "StockHistoricalPrice":
			case "ContactForm":
			case "News":
				ps.setInt(1, (int) item);
				break;
				
			case "findManagerByLogin":
			case "FindAccountByIban":
			case "FindAdvisorByLogin":
			case "FindClientByLogin":
			case "Stock":
				ps.setString(1, (String) item);
				break;

			default:
				System.out.println("String type error!");
				ps.setInt(1, (int) item);
				break;
			}
			rs = ps.executeQuery();
			if (rs.next()) {
				switch (type) {
				case "findManagerByLogin":
				case "Manager":
					retour = new Manager(rs.getInt("mng_id"), rs.getString("mng_name"), rs.getString("mng_login"), 
							rs.getString("mng_password"));
					break;
					
				case "News":
					retour = new News(rs.getInt("nws_id"), rs.getString("nws_title"), rs.getString("nws_text"), 
							rs.getString("nws_image"), rs.getString("nws_type"), new DateTime(rs.getTimestamp("nws_date")));
					break;

				case "FindAdvisorByLogin":
				case "Advisor":
					retour = new Advisor(rs.getInt("avs_id"), rs.getString("avs_name"), rs.getString("avs_login"),
							rs.getString("avs_password"));
					break;

				case "FindClientByLogin":
				case "Client":
					retour = new Client(rs.getInt("clt_id"), rs.getString("clt_login"), rs.getString("clt_password"),
							rs.getString("clt_fname"), rs.getString("clt_lname"),
							new DateTime(rs.getTimestamp("clt_birthday")), rs.getString("clt_nationality"),
							rs.getString("clt_gender"), rs.getString("clt_address"), rs.getString("clt_postalcode"),
							rs.getString("clt_city"), rs.getString("clt_telephonenumber"), rs.getString("clt_email"),
							rs.getString("clt_status"), new DateTime(rs.getTimestamp("clt_lastlogin")),
							new DateTime(rs.getTimestamp("clt_createdon")));
					break;

				case "FindAccountByIban":
				case "Account":
					retour = new Account(rs.getInt("acc_id"), rs.getString("acc_number"), rs.getString("acc_iban"),
							rs.getInt("acc_clt_id"), rs.getBigDecimal("acc_balance"), rs.getBigDecimal("acc_interest"),
							rs.getInt("acc_type"));
					break;

				case "HoldingShare":
					retour = new HoldingShare(rs.getInt("hds_id"), rs.getString("hds_stk_ticker"),
							rs.getInt("hds_acc_id"), rs.getInt("hds_numberofshares"),
							new DateTime(rs.getDate("hds_boughton")));
					break;

				case "Stock":
					retour = new Stock(rs.getString("stk_ticker"), rs.getString("stk_name"),
							rs.getString("stk_description"));
					break;

				case "StockHistoricalPrice":
					retour = new StockHistoricalPrice(rs.getInt("shp_id"), rs.getInt("shp_stk_id"),
							new DateTime(rs.getDate("shp_datetime")), rs.getBigDecimal("shp_price"));
					break;

				case "TransactionHistory":
					retour = new TransactionHistory(rs.getInt("tsh_id"), rs.getString("tsh_acc_number"),
							rs.getString("tsh_description"), new DateTime(rs.getDate("tsh_transactionOn")),
							rs.getBigDecimal("tsh_amount"));
					break;

				case "ContactForm":
					retour = new ContactForm(rs.getInt("ctf_id"), rs.getString("ctf_tel"), rs.getString("ctf_email"),
							rs.getString("ctf_tel"), rs.getString("ctf_message"));
					break;

				default:
					System.out.println("String type error");
					break;
				}
			}
		} catch (Exception ee) {
			ee.printStackTrace();
		} finally {
			// closing of ResultSet, PreparedStatement and connection
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (Exception ee) {
				System.out.println("closing problem");
			}
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (Exception ee) {
				System.out.println("closing problem");
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (Exception ee) {
				System.out.println("closing problem");
			}
		}

		return retour;
	}

	/**
	 * get the list of object.
	 * 
	 * @param type
	 *            the type of object
	 * @param sql
	 *            SQL code
	 * @param parameterNumber
	 *            numbers of parameter
	 * @param id
	 *            the parameter
	 * @return A list of object
	 */
	protected static Object getList(String type, String sql) {
		ArrayList<Object> returnList = new ArrayList<Object>();

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		// connection to the data base
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement(sql);

			// requet execution
			rs = ps.executeQuery();

			// we crosse all the line of the results
			switch (type) {
			case "Manager":
				while (rs.next()) {
					returnList.add(new Manager(rs.getInt("mng_id"), rs.getString("mng_name"), rs.getString("mng_login"), 
							rs.getString("mng_password")));
				}
				break;
			
			case "find3BankNews":
			case "find3OtherNews":
			case "findAllBankNews":
			case "findAllOtherNews":
			case "News":
				while (rs.next()) {
					returnList.add(new News(rs.getInt("nws_id"), rs.getString("nws_title"), rs.getString("nws_text"), 
							rs.getString("nws_image"), rs.getString("nws_type"), new DateTime(rs.getDate("nws_date"))));
				}
				break;

			case "Advisor":
				while (rs.next()) {
					returnList.add(new Advisor(rs.getInt("avs_id"), rs.getString("avs_name"), rs.getString("avs_login"),
							rs.getString("avs_password")));
				}
				break;

			case "Client":
				while (rs.next()) {
					returnList.add(new Client(rs.getInt("clt_id"), rs.getString("clt_login"),
							rs.getString("clt_password"), rs.getString("clt_fname"), rs.getString("clt_lname"),
							new DateTime(rs.getTimestamp("clt_birthday")), rs.getString("clt_nationality"),
							rs.getString("clt_gender"), rs.getString("clt_address"), rs.getString("clt_postalcode"),
							rs.getString("clt_city"), rs.getString("clt_telephonenumber"), rs.getString("clt_email"),
							rs.getString("clt_status"), new DateTime(rs.getTimestamp("clt_lastlogin")),
							new DateTime(rs.getTimestamp("clt_createdon"))));
				}
				break;

			case "FindAccountByClientId":
			case "Account":
				while (rs.next()) {
					returnList.add(new Account(rs.getInt("acc_id"), rs.getString("acc_number"),
							rs.getString("acc_iban"), rs.getInt("acc_clt_id"), rs.getBigDecimal("acc_balance"),
							rs.getBigDecimal("acc_interest"), rs.getInt("acc_type")));
				}
				break;

			case "FindHdsByCltId":
			case "HoldingShare":
				while (rs.next()) {
					returnList.add(new HoldingShare(rs.getInt("hds_id"), rs.getString("hds_stk_ticker"),
							rs.getInt("hds_acc_id"), rs.getInt("hds_numberofshares"),
							new DateTime(rs.getDate("hds_boughton"))));
				}
				break;

			case "Stock":
				while (rs.next()) {
					returnList.add(new Stock(rs.getString("stk_ticker"), rs.getString("stk_name"),
							rs.getString("stk_description")));
				}
				break;


			case "FindShpByStkId":
			case "StockHistoricalPrice":
				while (rs.next()) {
					returnList.add(new StockHistoricalPrice(rs.getInt("shp_id"), rs.getInt("shp_stk_id"),
							new DateTime(rs.getDate("shp_datetime")), rs.getBigDecimal("shp_price")));
				}
				break;


			case "TransactionHistory":
			case "findTshByAccNumber":
				while (rs.next()) {
					returnList.add(new TransactionHistory(rs.getInt("tsh_id"), rs.getString("tsh_acc_number"),
							rs.getString("tsh_description"), new DateTime(rs.getDate("tsh_transactionOn")),
							rs.getBigDecimal("tsh_amount")));
				}
				break;

			case "ContactForm":
				while (rs.next()) {
					returnList.add(new ContactForm(rs.getInt("ctf_id"), rs.getString("ctf_tel"),
							rs.getString("ctf_email"), rs.getString("ctf_tel"), rs.getString("ctf_message")));
				}
				break;
			default:
				System.out.println("String type not correct!");
				break;
			}
		} catch (Exception ee) {
			ee.printStackTrace();
		} finally {
			// closing rs, PreparedStatement and connection
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (Exception ignore) {
				System.out.println("closing problem");
			}
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (Exception ignore) {
				System.out.println("closing problem");
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (Exception ignore) {
				System.out.println("closing problem");
			}
		}

		return returnList;
	}

	/**
	 * Add a line in data base.
	 * 
	 * @param type
	 *            type of object
	 * @param item
	 *            the object
	 * @return numbers of line added.
	 */
	protected static int addRow(String type, Object item) {
		Connection con = null;
		PreparedStatement ps = null;
		int retour = 0;
		// connection to date base
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);

			switch (type) {
			case "Manager":
				Manager mng = (Manager) item;
				ps = con.prepareStatement("INSERT INTO manager_mng VALUES(null, ?, ?, ?)");
				ps.setString(1, mng.getmng_name());
				ps.setString(2, mng.getmng_login());
				ps.setString(3, mng.getmng_password());
				break;
			
			case "News":
				News nws = (News) item;
				ps = con.prepareStatement("INSERT INTO news_nws VALUES(null, ?, ?, ?, ?, NOW())");
				ps.setString(1, nws.getNws_title());
				ps.setString(2, nws.getNws_text());
				ps.setString(3, nws.getNws_image());
				ps.setString(4, nws.getNws_type());
				break;

			case "Advisor":
				Advisor advisor = (Advisor) item;
				ps = con.prepareStatement("INSERT INTO advisor_avs VALUES(null, ?, ?, ?)");
				ps.setString(1, advisor.getAvs_name());
				ps.setString(2, advisor.getAvs_login());
				ps.setString(3, advisor.getAvs_password());
				break;

			case "Client":
				Client client = (Client) item;
				ps = con.prepareStatement(
						"INSERT INTO client_clt VALUES(null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, null, ?)");
				ps.setString(1, client.getClt_login());
				ps.setString(2, client.getClt_password());
				ps.setString(3, client.getClt_fname());
				ps.setString(4, client.getClt_lname());
				ps.setDate(5, new java.sql.Date(client.getClt_birthday().getMillis()));
				ps.setString(6, client.getClt_nationality());
				ps.setString(7, client.getClt_gender());
				ps.setString(8, client.getClt_address());
				ps.setString(9, client.getClt_postalcode());
				ps.setString(10, client.getClt_city());
				ps.setString(11, client.getClt_telephonenumber());
				ps.setString(12, client.getClt_email());
				ps.setString(13, client.getClt_status());
				ps.setDate(14, new java.sql.Date(client.getClt_createdon().getMillis()));
				break;

			case "Account":
				Account acc = (Account) item;
				ps = con.prepareStatement("INSERT INTO account_acc VALUES(null, ?, ?, ?, ?, ?, ?)");
				ps.setString(1, acc.getAcc_number());
				ps.setString(2, acc.getAcc_iban());
				ps.setInt(3, acc.getAcc_clt_id());
				ps.setBigDecimal(4, acc.getAcc_balance());
				ps.setBigDecimal(5, acc.getAcc_interest());

				switch (acc.getAcc_type()) {
				case "Compte de courant":
					ps.setInt(6, 1);
					break;
				case "Compte d'epargne":
					ps.setInt(6, 2);
					break;
				case "Compte de titre":
					ps.setInt(6, 3);
					break;
				default:
					ps.setInt(6, 0);
					break;
				}
				break;

			case "HoldingShare":
				HoldingShare hds = (HoldingShare) item;
				ps = con.prepareStatement("INSERT INTO holdingshare_hds VALUES(null, ?, ?, ?, ?)");
				ps.setString(1, hds.getHds_stk_ticker());
				ps.setInt(2, hds.getHds_acc_id());
				ps.setInt(3, hds.getHds_numberOfShares());
				ps.setDate(4, new java.sql.Date(hds.getHds_boughtOn().getMillis()));
				break;

			case "Stock":
				Stock stk = (Stock) item;
				ps = con.prepareStatement("INSERT INTO stock_stk VALUES(?, ?, ?)");
				ps.setString(1, stk.getStk_ticker());
				ps.setString(2, stk.getStk_name());
				ps.setString(3, stk.getStk_description());
				break;

			case "StockHistoricalPrice":
				StockHistoricalPrice shp = (StockHistoricalPrice) item;
				ps = con.prepareStatement("INSERT INTO stockhistoricalprice_shp VALUES(null, ?, ?, ?)");
				ps.setInt(1, shp.getShp_stk_id());
				ps.setDate(2, new Date(shp.getShp_datetime().getMillis()));
				ps.setBigDecimal(3, shp.getShp_price());
				break;

			case "TransactionHistory":
				TransactionHistory tsh = (TransactionHistory) item;
				ps = con.prepareStatement("INSERT INTO transactionhistory_tsh VALUES(null, ?, ?, ?, ?)");
				ps.setString(1, tsh.getTsh_description());
				ps.setString(2, tsh.getTsh_acc_number());
				ps.setDate(3, new Date(tsh.getTsh_transactionOn().getMillis()));
				ps.setBigDecimal(4, tsh.getTsh_amount());
				break;

			case "ContactForm":
				ContactForm ctf = (ContactForm) item;
				ps = con.prepareStatement("INSERT INTO contactform_ctf VALUES(null, ?, ?, ?, ?)");
				ps.setString(1, ctf.getCtf_name());
				ps.setString(2, ctf.getCtf_email());
				ps.setString(3, ctf.getCtf_tel());
				ps.setString(4, ctf.getCff_message());
				break;

			default:
				System.out.println("String type error!");
				break;
			}

			// Execution of the require
			retour = ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			// close preparedStatement and connexion
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (Exception ex) {
				System.out.println("closing problem");
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (Exception ex) {
				System.out.println("closing problem");
			}
		}
		return retour;
	}

	/**
	 * Delete a line in database.
	 * 
	 * @param type
	 *            type of object
	 * @param item
	 *            the object
	 * @return numbers of line deleted
	 */
	protected static int deleteLine(String type, Object item) {

		Connection con = null;
		PreparedStatement ps = null;
		int retour = 0;
		// connection to date base
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			boolean isStringTypeCorrect = true;

			switch (type) {
			case "Manager":
				ps = con.prepareStatement("DELETE FROM manager_mng WHERE mng_id=?");
				break;
			
			case "News":
				ps = con.prepareStatement("DELETE FROM news_nws WHERE nws_id=?");
				break;

			case "Advisor":
				ps = con.prepareStatement("DELETE FROM advisor_avs WHERE avs_id=?");
				break;

			case "Client":
				ps = con.prepareStatement("DELETE FROM client_clt WHERE clt_id=?");
				break;

			case "Account":
				ps = con.prepareStatement("DELETE FROM account_acc WHERE acc_id=?");
				break;

			case "HoldingShare":
				ps = con.prepareStatement("DELETE FROM holdingshare_hds WHERE hds_id=?");
				break;

			case "Stock":
				ps = con.prepareStatement("DELETE FROM stock_stk WHERE stk_id=?");
				break;

			case "StockHistoricalPrice":
				ps = con.prepareStatement("DELETE FROM stockhistoricalprice_shp WHERE shp_id=?");
				break;

			case "TransactionHistory":
				ps = con.prepareStatement("DELETE FROM transactionhistory_tsh WHERE tsh_id=?");
				break;

			case "ContactForm":
				ps = con.prepareStatement("DELETE FROM contactform_ctf WHERE ctf_id=?");
				break;

			default:
				isStringTypeCorrect = false;
				System.out.println("String type error!!!");
				break;
			}

			if (isStringTypeCorrect) {
				if (type.equals("Stock")) {
					ps.setString(1, (String) item);
				} else {
					ps.setInt(1, (int) item);
				}
				// Execution of the require
				retour = ps.executeUpdate();
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			// close preparedStatement and connexion
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (Exception ignore) {
				System.out.println("closing problem");
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (Exception ignore) {
				System.out.println("closing problem");
			}
		}
		return retour;
	}

	/**
	 * Update a line in database.
	 * 
	 * @param type
	 *            type of object
	 * @param item
	 *            the object
	 * @return numbers of line updated
	 */
	protected static int updateLine(String type, Object item) {

		Connection con = null;
		PreparedStatement ps = null;
		int retour = 0;
		// connection to date base
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);

			switch (type) {
			case "Manager":
				Manager mng = (Manager) item;
				ps = con.prepareStatement(
						"UPDATE manager_mng SET mng_login=?, mng_password=?, mng_name=? WHERE mng_id=?");
				ps.setString(1, mng.getmng_login());
				ps.setString(2, mng.getmng_password());
				ps.setString(3, mng.getmng_name());
				ps.setInt(4, mng.getmng_id());
				break;
				
			case "Advisor":
				Advisor advisor = (Advisor) item;
				ps = con.prepareStatement(
						"UPDATE advisor_avs SET avs_name=?, avs_login=?, avs_password=? WHERE avs_id=?");
				ps.setString(1, advisor.getAvs_name());
				ps.setString(2, advisor.getAvs_login());
				ps.setString(3, advisor.getAvs_password());
				ps.setInt(4, advisor.getAvs_id());
				break;

			case "Client":
				Client clt = (Client) item;
				ps = con.prepareStatement(
						"UPDATE client_clt SET " + "clt_password=?, clt_fname=?, clt_lname=?, clt_birthday=?,"
								+ "clt_nationality=?, clt_gender=?, clt_address=?, clt_postalcode=?, "
								+ "clt_city=?, clt_telephonenumber=?, clt_email=?, clt_status=?" + "WHERE clt_id=?");
				ps.setString(1, clt.getClt_password());
				ps.setString(2, clt.getClt_fname());
				ps.setString(3, clt.getClt_lname());
				ps.setDate(4, new java.sql.Date(clt.getClt_birthday().getMillis()));
				ps.setString(5, clt.getClt_nationality());
				ps.setString(6, clt.getClt_gender());
				ps.setString(7, clt.getClt_address());
				ps.setString(8, clt.getClt_postalcode());
				ps.setString(9, clt.getClt_city());
				ps.setString(10, clt.getClt_telephonenumber());
				ps.setString(11, clt.getClt_email());
				ps.setString(12, clt.getClt_status());
				ps.setInt(13, clt.getClt_id());
				break;

			case "Account":
				Account acc = (Account) item;
				ps = con.prepareStatement("UPDATE account_acc SET acc_balance=?, acc_interest=? WHERE acc_id=?");
				ps.setBigDecimal(1, acc.getAcc_balance());
				ps.setBigDecimal(2, acc.getAcc_interest());
				ps.setInt(3, acc.getAcc_id());
				break;

			case "HoldingShare":
				HoldingShare hds = (HoldingShare) item;
				ps = con.prepareStatement("UPDATE holdingshare_hds SET hds_numberofshares=? WHERE hds_id=?");
				ps.setInt(1, hds.getHds_numberOfShares());
				ps.setInt(2, hds.getHds_id());
				break;

			case "Stock":
				Stock stk = (Stock) item;
				ps = con.prepareStatement("UPDATE stock_stk SET " + "stk_name=?, stk_description=? WHERE stk_ticker=?");
				ps.setString(1, stk.getStk_name());
				ps.setString(2, stk.getStk_description());
				ps.setString(3, stk.getStk_ticker());
				break;

			case "StockHistoricalPrice":
				StockHistoricalPrice shp = (StockHistoricalPrice) item;
				ps = con.prepareStatement(
						"UPDATE stockhistoricalprice_shp SET " + "shp_datetime=?, shp_price=? WHERE shp_id=?");
				ps.setDate(1, new Date(shp.getShp_datetime().getMillis()));
				ps.setBigDecimal(2, shp.getShp_price());
				ps.setInt(3, shp.getShp_id());
				break;

			case "TransactionHistory":
				TransactionHistory tsh = (TransactionHistory) item;
				ps = con.prepareStatement("UPDATE transactionhistory_tsh SET tsh_description=? WHERE tsh_id=?");
				ps.setString(1, tsh.getTsh_description());
				ps.setInt(2, tsh.getTsh_id());
				break;

			default:
				System.out.println("String type error!");
				break;
			}

			// Execution of the require
			retour = ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			// close preparedStatement and connection
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (Exception ex) {
				System.out.println("closing problem");
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (Exception ex) {
				System.out.println("closing problem");
			}
		}
		return retour;
	}

	/**
	 * get next auto-increment item from a table of database
	 * 
	 * @param type
	 *            String that contains the type of item
	 * @param sql
	 *            SQL request
	 * @return the next auto-increment item
	 */
	public static String getNextItem(String type, String sql) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String retour = "";
		// connection to date base
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			if (rs.next()) {
				switch (type) {
				case "clt_login":
					retour = rs.getString("clt_login");
					break;
				case "acc_number":
					retour = rs.getString("acc_number");
					break;
				default:
					System.out.println("String type error!");
					break;
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			// close preparedStatement and connection
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (Exception ex) {
				System.out.println("closing problem");
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (Exception ex) {
				System.out.println("closing problem");
			}
		}
		return retour;
	}

}
