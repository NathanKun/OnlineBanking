package server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import dao.DaoAdvisor;
import dao.DaoClient;
import model.Advisor;
import model.Client;

/**
 * Ref: http://blog.csdn.net/ns_code/article/details/14105457
 * 
 * @author 兰亭风雨
 *
 */
public class DbServerThread implements Runnable {
	private Socket socket = null;

	public DbServerThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			// 获取Socket的输出流，用来向客户端发送数据
			ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
			// 获取Socket的输入流，用来接收从客户端发送过来的数据
			BufferedReader buf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			boolean flag = true;
			while (flag) {
				// 接收从客户端发送过来的数据
				String str = buf.readLine();
				if (str == null || "".equals(str)) {
					flag = false;
				} else {
					switch (str) {
					case "bye":
						flag = false;
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

					default:
						System.out.println("String type error");
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
