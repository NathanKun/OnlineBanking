package server;

import java.net.ServerSocket;  
import java.net.Socket;  
 
/**
 * ref: http://blog.csdn.net/ns_code/article/details/14105457
 * @author 兰亭风雨
 *
 */
public class DbServer {  
    public static void main(String[] args) throws Exception{  
        // server listen to 20006 and wait for connection
        ServerSocket server = new ServerSocket(20006);
        System.out.println("DB server started");  
        Socket socket = null;  
        boolean b = true;  
        while(b){  
            // keep waiting if no connection
            socket = server.accept();  
            System.out.println("Connected with client");  
            // open a new thread for every connection
            new Thread(new DbServerThread(socket)).start();  
        }  
        server.close();
        System.out.println("DB server ended");
    }  
}  
