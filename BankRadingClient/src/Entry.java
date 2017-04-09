import gui.GuiLogin;
import util.SetTheme;

/**
 * Launcher of BankRadingClient
 * 
 * @author Junyang HE
 *
 */
public class Entry {

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	SetTheme.setNimbus();
                new GuiLogin();
            }
        });
    }
}
