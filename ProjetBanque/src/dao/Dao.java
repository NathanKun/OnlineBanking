package dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import org.joda.time.DateTime;

import model.Account;
import model.Client;

abstract public class Dao {

	static String URL = "jdbc:mysql://localhost/onlinebank?autoReconnect=true&useSSL=false";
	static String LOGIN = "root";
	static String PASS = "root";

	public Dao() {
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
			case "Client":
				ps.setInt(1, (int) item);
				break;
				
			case "Account":
				ps.setInt(1, (int) item);
				break;

			default:
				ps.setInt(1, (int) item);
				break;
			}
			rs = ps.executeQuery();
			if (rs.next()) {
				switch (type) {
				case "Client":
					retour = new Client(rs.getInt("clt_id"), rs.getString("clt_login"), rs.getString("clt_password"),
							rs.getString("clt_fname"), rs.getString("clt_lname"),
							new DateTime(rs.getTimestamp("clt_birthday")), rs.getString("clt_nationality"),
							rs.getString("clt_gender"), rs.getString("clt_address"), rs.getString("clt_postalcode"),
							rs.getString("clt_city"), rs.getString("clt_telephonenumber"), rs.getString("clt_email"),
							rs.getString("clt_status"), new DateTime(rs.getTimestamp("clt_lastlogin")),
							new DateTime(rs.getTimestamp("clt_createdon")));
					break;
					
				case "Account":
					retour = new Account(rs.getInt("acc_id"), rs.getString("acc_number"), rs.getInt("acc_clt_id"), 
							rs.getBigDecimal("acc_balance"), rs.getBigDecimal("acc_interest"), rs.getInt("acc_type"));
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
			case "Client":
				while (rs.next()) {
					returnList.add(new Client(rs.getInt("clt_id"), rs.getString("clt_login"), rs.getString("clt_password"),
							rs.getString("clt_fname"), rs.getString("clt_lname"),
							new DateTime(rs.getTimestamp("clt_birthday")), rs.getString("clt_nationality"),
							rs.getString("clt_gender"), rs.getString("clt_address"), rs.getString("clt_postalcode"),
							rs.getString("clt_city"), rs.getString("clt_telephonenumber"), rs.getString("clt_email"),
							rs.getString("clt_status"), new DateTime(rs.getTimestamp("clt_lastlogin")),
							new DateTime(rs.getTimestamp("clt_createdon"))));
				}
				break;
				
			case "Account":
				while (rs.next()) {
					returnList.add(new Account(rs.getInt("acc_id"), rs.getString("acc_number"), rs.getInt("acc_clt_id"), 
							rs.getBigDecimal("acc_balance"), rs.getBigDecimal("acc_interest"), rs.getInt("acc_type")));
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
		ResultSet rs = null;
		int retour = 0;
		// connection to date base
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);

			switch (type) {
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
				Account acc = (Account)item;
				ps = con.prepareStatement(
						"INSERT INTO account_acc VALUES(null, ?, ?, ?, ?, ?)");
				ps.setString(1, acc.getAcc_number());
				ps.setInt(2, acc.getAcc_clt_id());
				ps.setBigDecimal(3, acc.getAcc_balance());
				ps.setBigDecimal(4, acc.getAcc_interest());
				
				switch (acc.getAcc_type()){
				case "Compte de courant":
					ps.setInt(5, 1);
					break;
				case "Compte d'epargne":
					ps.setInt(5, 2);
					break;
				case "Compte de titre":
					ps.setInt(5, 3);
					break;
				default:
					ps.setInt(5, 0);
					break;
				}
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
			
			switch (type) {
			case "Client":
				ps = con.prepareStatement("DELETE FROM client_clt WHERE clt_id=?");
				ps.setInt(1, (int) item);
				break;

			case "Account":
				ps = con.prepareStatement("DELETE FROM account_acc WHERE acc_id=?");
				ps.setInt(1, (int) item);
				break;
				
			default:
				System.out.println("String type error!!!");
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
			case "Client":
				Client clt = (Client) item;
				ps = con.prepareStatement("UPDATE client_clt SET "
						+ "clt_password=?, clt_fname=?, clt_lname=?, clt_birthday=?,"
						+ "clt_nationality=?, clt_gender=?, clt_address=?, clt_postalcode=?, "
						+ "clt_city=?, clt_telephonenumber=?, clt_email=?, clt_status=?"
						+ "WHERE clt_id=?");
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
				Account acc = (Account)item;
				ps = con.prepareStatement("UPDATE account_acc SET"
						+ "acc_balance=?, acc_interest=? WHERE acc_id=?");
				ps.setBigDecimal(1, acc.getAcc_balance());
				ps.setBigDecimal(2, acc.getAcc_interest());
				ps.setInt(3, acc.getAcc_id());
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

}
