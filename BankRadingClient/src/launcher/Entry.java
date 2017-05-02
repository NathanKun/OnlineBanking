package launcher;
import gui.GuiLogin;
import server.DbServer;
import util.SetTheme;

/**
 * Launcher of BankRadingClient
 * 
 * @author Junyang HE
 *
 */
public class Entry {

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
    	
    	// start application
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	SetTheme.setNimbus();
                new GuiLogin(dbServer);
            }
        });
    }
}
