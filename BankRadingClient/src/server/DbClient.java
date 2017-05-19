package server;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;

import model.Advisor;
import model.Client;
import model.TransactionHistory;

/**
 * Client of DbServer
 * 
 * @author Junyang HE
 *
 */
public class DbClient {

	/**
	 * Only send a bye to server.
	 * 
	 * @throws IOException	IOException
	 */
	public static void bye() throws IOException {
		// TCP connection
		Socket s = new Socket("catprogrammer.com", 20006);
		s.setSoTimeout(10000);
		// get socket output stream, str out put stream
		PrintStream out = new PrintStream(s.getOutputStream());
		// send action type
		out.println("bye");
		if (s != null) {
			// if connection established
			s.close();
		}
	}

	/**
	 * Tell server to dao to find advisor by login
	 * 
	 * @param login
	 *            login of advisor
	 * @return advisor found
	 * @throws IOException IOException
	 * @throws ClassNotFoundException ClassNotFoundException
	 */
	public static Advisor findAdvisorByLogin(String login) throws IOException, ClassNotFoundException {
		Advisor rt = null;

		// TCP connection
		Socket s = new Socket("catprogrammer.com", 20006);
		s.setSoTimeout(10000);

		// out: String; in: Object

		// get socket input stream, object input stream
		ObjectInputStream input = new ObjectInputStream(new BufferedInputStream(s.getInputStream()));
		// get socket output stream, str out put stream
		PrintStream out = new PrintStream(s.getOutputStream());

		System.out.print("Client: findAdvisorByLogin started");

		// send action type
		out.println("DaoAdvisor.findAdvisorByLogin");
		// send login
		out.println(login);
		// get return object
		try {
			rt = (Advisor) input.readObject();
		} catch (SocketTimeoutException e) {
			System.out.println("Time out, No response");
		}

		// send ending str
		out.println("bye");

		input.close();
		if (s != null) {
			// if connection established
			s.close();
		}
		System.out.print("Client: findAdvisorByLogin ended");

		return rt;
	}

	/**
	 * Tell server to return the list of client
	 * 
	 * @return the list of client
	 * @throws IOException IOException
	 * @throws ClassNotFoundException ClassNotFoundException
	 */
	@SuppressWarnings("unchecked")
	public static ArrayList<Client> getClientList() throws IOException, ClassNotFoundException {
		ArrayList<Client> rt = null;

		// TCP connection
		Socket s = new Socket("catprogrammer.com", 20006);
		s.setSoTimeout(10000);

		// out: String; in: Object

		// get socket input stream, object input stream
		ObjectInputStream input = new ObjectInputStream(new BufferedInputStream(s.getInputStream()));
		// get socket output stream, str out put stream
		PrintStream out = new PrintStream(s.getOutputStream());

		System.out.print("Client: getClientList started");

		// send action type
		out.println("DaoClient.getClientList");

		// get return object
		try {
			rt = (ArrayList<Client>) input.readObject();
		} catch (SocketTimeoutException e) {
			System.out.println("Time out, No response");
		}

		// send ending str
		out.println("bye");

		input.close();
		if (s != null) {
			// if connection established
			s.close();
		}
		System.out.print("Client: getClientList ended");

		return rt;
	}

	/**
	 * Tell server to find the list of transaction history of an account by it's
	 * number
	 * 
	 * @param accNumber	account's number
	 * @return	the list of transaction history of the account
	 * @throws IOException IOException
	 * @throws ClassNotFoundException ClassNotFoundException
	 */
	@SuppressWarnings("unchecked")
	public static ArrayList<TransactionHistory> findTshByAccNumber(String accNumber)
			throws IOException, ClassNotFoundException {
		ArrayList<TransactionHistory> rt = null;

		// TCP connection
		Socket s = new Socket("catprogrammer.com", 20006);
		s.setSoTimeout(10000);

		// out: String; in: Object

		// get socket input stream, object input stream
		ObjectInputStream input = new ObjectInputStream(new BufferedInputStream(s.getInputStream()));
		// get socket output stream, str out put stream
		PrintStream out = new PrintStream(s.getOutputStream());

		System.out.print("Client: findTshByAccNumber started");

		// send action type
		out.println("DaoTransactionHistory.findTshByAccNumber");
		// send account number

		out.println(accNumber);
		// get return object
		try {
			rt = (ArrayList<TransactionHistory>) input.readObject();
		} catch (SocketTimeoutException e) {
			System.out.println("Time out, No response");
		}

		// send ending str
		out.println("bye");

		input.close();
		if (s != null) {
			// if connection established
			s.close();
		}
		System.out.print("Client: findTshByAccNumber ended");

		return rt;

	}

	/**
	 * Main method for testing
	 * @param args	for main
	 */
	public static void main(String[] args) {
		try {
			// System.out.println(findAdvisorByLogin("a"));
			System.out.println(findTshByAccNumber("2222333322220001"));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
