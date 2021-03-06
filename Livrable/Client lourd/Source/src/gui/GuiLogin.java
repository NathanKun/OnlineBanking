package gui;

import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import model.Advisor;
import server.DbClient;
import server.DbServer;
import util.PasswordAuthentication;
import util.SetTheme;

/**
 * Login GUI
 * 
 * @author Junyang HE
 *
 */
public class GuiLogin extends JFrame implements ActionListener {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 8275872523267694997L;
	/**
	 * text field for input id
	 */
	private JTextField tfId;
	/**
	 * password field for input password
	 */
	private JPasswordField tfPw;
	/**
	 * label shows: Identifiant : 
	 */
	private JLabel lbId = new JLabel("Identifiant : ");
	/**
	 * label shows: Mot de passe : 
	 */
	private JLabel lbPw = new JLabel("Mot de passe : ");
	/**
	 * label shows: BankRading
	 */
	private JLabel lbTitle = new JLabel("BankRading");
	/**
	 * label shows: Front office advisor system
	 */
	private JLabel lbSubTitle = new JLabel("Front office advisor system");
	/**
	 * button for login action
	 */
	private JButton btnLogin = new JButton("Login");
	/**
	 * server for connecting to database
	 */
	private DbServer dbServer = null;
	
	/**
	 * constructor of JFrame
	 * 
	 * @param	dbServer the intermediate server
	 */
	public GuiLogin() {
		// exit on close
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// size
		setSize(300, 250);
		//title
		setTitle("Login");
		// not resizable
		setResizable(false);
		// center window to screen
		setLocationRelativeTo(null);
		// absolute layout
		getContentPane().setLayout(null);
		// initiate components
		initComponents();
		
		// show window
		setVisible(true);
	}
	
	/**
	 * constructor of JFrame
	 * 
	 * @param	dbServer the intermediate server
	 */
	public GuiLogin(DbServer dbServer) {
		// exit on close
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		// size
		setSize(300, 250);
		//title
		setTitle("Login");
		// not resizable
		setResizable(false);
		// center window to screen
		setLocationRelativeTo(null);
		// absolute layout
		getContentPane().setLayout(null);
		// initiate components
		initComponents();
		this.dbServer = dbServer;
		
		// exit_on_close event, stop server when close windows
		addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
            	dbServer.stopServer();
                e.getWindow().dispose();
            }
        });
		
		// show window
		setVisible(true);
	}

	/**
	 * Initiate components for the frame
	 */
	private void initComponents() {
		lbId.setBounds(38, 91, 101, 18);
		getContentPane().add(lbId);
		
		lbPw.setBounds(38, 133, 101, 18);
		getContentPane().add(lbPw);
		
		tfId = new JTextField();
		tfId.setBounds(135, 85, 122, 30);
		getContentPane().add(tfId);
		tfId.setColumns(10);
		
		tfPw = new JPasswordField();
		tfPw.setColumns(10);
		tfPw.setBounds(135, 127, 122, 30);
		getContentPane().add(tfPw);
		
		lbTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lbTitle.setFont(new Font("Arial", Font.PLAIN, 20));
		lbTitle.setBounds(38, 21, 219, 30);
		getContentPane().add(lbTitle);
		
		lbSubTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lbSubTitle.setFont(new Font("Arial", Font.PLAIN, 14));
		lbSubTitle.setBounds(38, 57, 219, 18);
		getContentPane().add(lbSubTitle);
		
		btnLogin.setBounds(100, 170, 100, 30);
		btnLogin.addActionListener(this);
		getContentPane().add(btnLogin);
		
		getRootPane().setDefaultButton(btnLogin);
	}

	/**
	 * Event that user click on login
	 */
	public void loginOnclick(){
		if(!tfId.getText().isEmpty() && tfPw.getPassword().length != 0){
			//Advisor avs = DaoAdvisor.findAdvisorByLogin(tfId.getText());
			Advisor avs = null;
			// connect to server to get advisor
			try {
				avs = DbClient.findAdvisorByLogin(tfId.getText());
			} catch (ClassNotFoundException | IOException e) {
				e.printStackTrace();
				showMessageDialog(this, "Cannot connect to server");
			}
			if(avs != null) {
				PasswordAuthentication pa = new PasswordAuthentication();
				if(pa.authenticate(tfPw.getPassword(), avs.getAvs_password())){
					dispose();
					if(dbServer == null) {
						new GuiMain();
					} else {
						new GuiMain(dbServer);
					}
				} else{
					showMessageDialog(this, "L'identifiant ou le mot de passe est incorrect.");
				}
			} else {
				showMessageDialog(this, "L'identifiant ou le mot de passe est incorrect.");
			}
			
		} else {
			showMessageDialog(this, "Veillez entrer l'identifiant et le mot de passe.");
		}
		
	}
	
	/**
	 * action perform
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnLogin){
			loginOnclick();
		}
	}
	
	/**
	 * Main method for testing
	 * @param args input arguments
	 */
	public static void main(String[] args) {
    	DbServer dbServer = new DbServer();
    	Thread server = new Thread(dbServer);
    	server.start();
    	
		SetTheme.setNimbus();

        new GuiLogin(dbServer);

	}
}
