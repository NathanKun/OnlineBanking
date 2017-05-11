package server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;

import dao.DaoAdvisor;
import dao.DaoClient;
import dao.DaoTransactionHistory;
import model.Advisor;
import model.Client;
import model.TransactionHistory;

/**
 * A thread create when a client connect to server
 * Ref: http://blog.csdn.net/ns_code/article/details/14105457
 * 
 * @author Junyang HE
 *
 */
public class DbServerThread implements Runnable {
	/**
	 * socket of connection
	 */
	private Socket socket = null;

	/**
	 * Constructor of thread
	 * @param socket socket of connection
	 */
	public DbServerThread(Socket socket) {
		this.socket = socket;
	}

	/**
	 * action when run the thread
	 */
	@Override
	public void run() {
		try {
			// Server out: object; Server in: String
			
			// get output stream from socket in order to sent object to client
			ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
			// get output stream from socket in order to receive string from client
			BufferedReader buf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			boolean flag = true;
			while (flag) {
				// receive string from client
				String str = null;
				try {
					str = buf.readLine();
				} catch (SocketException e){
				}
				if (str == null || "".equals(str)) {
					flag = false;
				} else {
					switch (str) {
					case "bye":
						flag = false;
						System.out.println("Server: bye");
						break;

					// use dao to get object, and sent to client
					case "DaoAdvisor.findAdvisorByLogin":
						System.out.println("Server: findAdvisorByLogin started");
						String login = buf.readLine();
						Advisor avs = DaoAdvisor.findAdvisorByLogin(login);
						out.writeObject(avs);
						System.out.println("Server: findAdvisorByLogin ended");
						break;

					case "DaoClient.getClientList":
						System.out.println("Server: findAdvisorByLogin started");
						ArrayList<Client> cltList = DaoClient.getClientList();
						out.writeObject(cltList);
						System.out.println("Server: findAdvisorByLogin ended");
						break;

					case "DaoTransactionHistory.findTshByAccNumber":
						System.out.println("Server: findTshByAccNumber started");
						String accNumber = buf.readLine();
						ArrayList<TransactionHistory> tshList = DaoTransactionHistory.findTshByAccNumber(accNumber);
						out.writeObject(tshList);
						System.out.println("Server: findTshByAccNumber ended");
						break;

					default:
						System.out.println("Server: String type error");
					}
				}
			}
			out.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
