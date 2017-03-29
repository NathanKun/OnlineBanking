package dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Statement;


import org.joda.time.DateTime;
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

			default:
				ps.setLong(1, (Long) item);
				break;
			}
			rs = ps.executeQuery();
			if (rs.next()) {
				switch (type) {
				case "Client":
					retour = new Client(rs.getInt("clt_id"), rs.getString("clt_login"), rs.getString("clt_password"), 
							rs.getString("clt_fname"), rs.getString("clt_lname"), new DateTime(rs.getTimestamp("clt_birthday")), 
							rs.getString("clt_nationality"), rs.getString("clt_gender"), rs.getString("clt_address"),
							rs.getString("clt_postalcode"), rs.getString("clt_city"), rs.getString("clt_telephonenumber"), 
							rs.getString("clt_email"), rs.getString("clt_status"), 
							new DateTime(rs.getTimestamp("clt_lastlogin")), new DateTime(rs.getTimestamp("clt_createdon")));
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
			default:
				System.out.println("String type error!");
				break;
			}

			// excecution of the requiere
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

}
