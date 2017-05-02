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

/**
 * Client of DbServer
 * 
 * @author Junyang HE
 *
 */
public class DbClient {
	public static Advisor findAdvisorByLogin(String login) throws IOException, ClassNotFoundException {
		Advisor rt = null;

		// TCP connection
		Socket s = new Socket("127.0.0.1", 20006);
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

		input.close();
		if (s != null) {
			// if connection established
			s.close();
		}
		System.out.print("Client: findAdvisorByLogin ended");

		return rt;
	}
	
	@SuppressWarnings("unchecked")
	public static ArrayList<model.Client> getClientList() throws IOException{
		ArrayList<Client> rt = null;

		// TCP connection
		Socket s = new Socket("127.0.0.1", 20006);
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
			rt = (ArrayList<model.Client>) input.readObject();
		} catch (SocketTimeoutException e) {
			System.out.println("Time out, No response");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}

		input.close();
		if (s != null) {
			// if connection established
			s.close();
		}
		System.out.print("Client: getClientList ended");

		return rt;
	}
	
	public static void main(String[] args){
		try {
			//System.out.println(findAdvisorByLogin("a"));
			System.out.println(getClientList());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
