package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletConfig;

public class Dao {

	
	
	public  void init(ServletConfig config) throws SQLException {
		
		   String url = config.getInitParameter("jdbc:mysql://localhost/onlinebank?autoReconnect=true&useSSL=false") ;
		   String login = config.getInitParameter("root") ;
		   String passwd = config.getInitParameter("root") ;
			
		   Connection con = DriverManager.getConnection(url, login, passwd) ;
		   
	}
}
