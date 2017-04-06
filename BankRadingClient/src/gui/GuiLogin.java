package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

import util.SetTheme;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;

/**
 * Login GUI
 * 
 * @author Junyang HE
 *
 */
public class GuiLogin extends JFrame implements ActionListener {
	


	/**
	 * default serial version UID
	 */
	private static final long serialVersionUID = 1L;
	private JTextField tfId;
	private JPasswordField tfPw;
	private JLabel lbId = new JLabel("Identifiant : ");
	private JLabel lbPw = new JLabel("Mot de passe : ");
	private JLabel lbTitle = new JLabel("RadBanking");
	private JLabel lbSubTitle = new JLabel("Front office advisor system");
	private JButton btnLogin = new JButton("Login");
	
	public GuiLogin() {
		setSize(300, 250);
		setTitle("Login");
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		initComponents();
		
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

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnLogin){
			System.out.println("Clicked");
		}
	}
	public static void main(String[] args) {
		
		SetTheme.setNimbus();
		
        JFrame frame = new JFrame("SwingApplication");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GuiLogin app = new GuiLogin();

	}
}
