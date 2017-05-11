package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ref: http://blog.csdn.net/ns_code/article/details/14105457
 * 
 * @author Junyang HE, 兰亭风雨
 *
 */
public class DbServer implements Runnable {
	ServerSocket server;
	boolean flag;

	/**
	 * stop server. Set flag to false, and make a connection sending only a
	 * 'bye' then close connection.
	 */
	public void stopServer() {
		flag = false;
		try {
			DbClient.bye();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Action when run the thread
	 */
	@Override
	public void run() {
		// server listen to 20006 and wait for connection
		try {
			server = new ServerSocket(20006);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Server: DB server started");
		Socket socket = null;
		flag = true;
		while (flag) {
			// keep waiting if no connection
			try {
				socket = server.accept();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("Server: Connected with client");
			// open a new thread for every connection
			new Thread(new DbServerThread(socket)).start();
		}
		try {
			server.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Server: DB server ended");
	}
	


	/**
	 * Main entry of application
	 * @param args	for main
	 */
    public static void main(String[] args) {
    	// intermediate server to connect to database
    	DbServer dbServer = new DbServer();
    	// new thread for server
    	Thread server = new Thread(dbServer);
    	// start server
    	server.start();
    }
}
