package dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.ServletConfig;

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
	@SuppressWarnings("unchecked")
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
					retour = new Client(rs.getInt("clt_id"), rs.getString("clt_fname"), rs.getString("clt_lname"),
							rs.getString("clt_nationality"), rs.getString("clt_gender"), rs.getString("clt_address"),
							rs.getString("clt_postalcode"), rs.getString("clt_city"), rs.getString("clt_telephonenumber"), 
							rs.getString("clt_email"), rs.getString("clt_status"),rs.getString("clt_password"), 
							rs.getString("clt_login"), new DateTime(rs.getTimestamp("clt_birthday")), 
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
}
