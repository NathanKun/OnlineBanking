package gui;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.format.DateTimeFormat;

import model.Account;
import model.Client;
import model.TransactionHistory;
import server.DbClient;
import server.DbServer;

/**
 * Gui of main page of the system
 * 
 * @author Junyang HE
 *
 */
public class GuiMain extends JFrame implements ActionListener {
	/**
	 * generate serialVersionUID
	 */
	private static final long serialVersionUID = -2854311114820163820L;
	/**
	 * full client list
	 */
	private ArrayList<Client> clientList;
	/**
	 * label shows: Liste des clients
	 */
	private final JLabel lbClientList = new JLabel("Liste des clients :");
	/**
	 * label shows: Liste des compte :
	 */
	private final JLabel lbAccountList = new JLabel("Liste des comptes :");
	/**
	 * label shows: Informations de client :
	 */
	private final JLabel lbInfo = new JLabel("Informations de client :");
	/**
	 * text field for search a client
	 */
	private JTextField tfSearch = new JTextField();
	/**
	 * model for jlistClient
	 */
	private DefaultListModel<Client> modelJListClient = new DefaultListModel<Client>();
	/**
	 * jlist conatins clients
	 */
	private JList<Client> jlistClient = new JList<Client>(modelJListClient);
	/**
	 * model for jtableClientInfo
	 */
	private DefaultTableModel modelJTableClientInfo = new DefaultTableModel();
	/**
	 * jtable contains information of selected client
	 */
	private JTable jtableClientInfo = new JTable(modelJTableClientInfo);
	/**
	 * model for jlistAccount
	 */
	private DefaultListModel<Account> modelJListAccount = new DefaultListModel<Account>();
	/**
	 * jlist contains all account of selected client
	 */
	private JList<Account> jlistAccount = new JList<Account>(modelJListAccount);
	/**
	 * scroll pane for client list
	 */
	private final JScrollPane jspClientList = new JScrollPane();
	/**
	 * model for jtableTransactionHistory
	 */
	private DefaultTableModel modelJTableTSH = new DefaultTableModel();
	/**
	 * jtable contains list of transaction history of selected account
	 */
	private JTable jtableTransactionHistory = new JTable(modelJTableTSH);
	/**
	 * jlabel : Les historiques de transaction :"
	 */
	JLabel lbTableTitle = new JLabel("Les historiques de transaction :");
	/**
	 * jlabel: client name
	 */
	JLabel lbClientInfo = new JLabel("Client infos");
	/**
	 * jlabel: acc number, acc type
	 */
	private final JLabel lbAccountInfo = new JLabel("Account infos");
	/**
	 * scroll pane for jtableTransactionHistory
	 */
	private final JScrollPane jspTSHTable = new JScrollPane();;
	/**
	 * main menu bar
	 */
	private JMenuBar menuBar = new JMenuBar();
	/**
	 * menu in menu bar
	 */
	private JMenu menuMain = new JMenu("Menu");
	/**
	 * menu2 in menu bar
	 */
	private JMenu menuAbout = new JMenu("About");
	/**
	 * main content pane of frame
	 */
	private JPanel contentPane = (JPanel) this.getContentPane();
	/**
	 * content panel of client list
	 */
	private JPanel jpCltList = new JPanel();
	/**
	 * content panel of client info
	 */
	private JPanel jpCltInfo = new JPanel();
	/**
	 * content panel of acount list
	 */
	private JPanel jpCltAccList = new JPanel();
	/**
	 * content panel of tsh list
	 */
	private JPanel jpTshList = new JPanel();
	/**
	 * button to select a client
	 */
	private JButton jbSelectClient = new JButton("Sélectionner");
	/**
	 * menu item to logout
	 */
	private JMenuItem menuItemLogout = new JMenuItem("Déconnexion");
	/**
	 * menu item to go to start page
	 */
	private JMenuItem menuItemMainPage = new JMenuItem("Acceuil");
	/**
	 * menu item to show about this application
	 */
	private JMenuItem menuItemAbout = new JMenuItem("About");
	/**
	 * button to return to client list
	 */
	private final JButton jbReturnClientList = new JButton("Retourner");
	/**
	 * button to show list of accounts of the client
	 */
	private final JButton jbShowAccList = new JButton("Voir liste des compte");
	/**
	 * button to return to client info page
	 */
	private final JButton jbReturnClientInfo = new JButton("Retourner");
	/**
	 * button to show tsh of the account
	 */
	private final JButton jbShowTsh = new JButton("Voir historique des transactions");
	/**
	 * button to return to account list page
	 */
	private final JButton jbReturnAccList = new JButton("Retourner");
	/**
	 * the db server
	 */
	private final DbServer dbServer;

	/**
	 * Constructor of jframe
	 * 
	 * @param dbServer
	 *            the intermediate server
	 */
	public GuiMain(DbServer dbServer) {
		this.dbServer = dbServer;
		// connect to server to get client list
		try {
			clientList = DbClient.getClientList();
		} catch (IOException e) {
			clientList = new ArrayList<Client>();
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		setFont(new Font("Arial", Font.PLAIN, 15));
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(800, 600);
		setTitle("Front Office Advisor System");
		setResizable(false);
		setLocationRelativeTo(null);

		initMenuBar();

		initPanels();

		switchJpCltList();
		// exit_on_close event, stop server when close windows
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dbServer.stopServer();
				e.getWindow().dispose();
			}
		});

		setVisible(true);
	}

	/**
	 * switch to list of clients page
	 */
	private void switchJpCltList() {
		switchPanel(jpCltList);
	}

	/**
	 * switch to info of the client page
	 */
	private void switchJpCltInfo() {
		switchPanel(jpCltInfo);
	}

	/**
	 * switch to list of account of the client page
	 */
	private void switchJpCltAccList() {
		switchPanel(jpCltAccList);
	}

	/**
	 * switch to tsh list of account page
	 */
	private void switchJpTshList(Account acc, String fullname) {
		updateJpTshList(acc, fullname);
		switchPanel(jpTshList);
	}

	/**
	 * method to switch to a given page
	 * 
	 * @param panel
	 *            the panel of page
	 */
	private void switchPanel(JPanel panel) {
		contentPane.removeAll();
		contentPane.add(panel);
		contentPane.revalidate();
		contentPane.repaint();
	}

	/**
	 * initial client list panel
	 */
	private void initJpClientList() {
		lbClientList.setFont(new Font("Arial", Font.PLAIN, 15));
		lbClientList.setBounds(10, 10, 219, 21);
		jpCltList.add(lbClientList);

		jbSelectClient.addActionListener(this);
		jbSelectClient.setFont(new Font("Arial", Font.PLAIN, 15));
		jbSelectClient.setBounds(648, 9, 136, 23);
		jpCltList.add(jbSelectClient);

		// textfield for search client
		tfSearch.setFont(new Font("Arial Unicode MS", Font.PLAIN, 15));
		tfSearch.setBounds(10, 41, 774, 30);
		tfSearch.setColumns(10);
		// add text on change listener
		tfSearch.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void changedUpdate(DocumentEvent arg0) {
				updateJListClient();
			}

			@Override
			public void insertUpdate(DocumentEvent arg0) {
				updateJListClient();
			}

			@Override
			public void removeUpdate(DocumentEvent arg0) {
				updateJListClient();
			}

		});
		jpCltList.add(tfSearch);

		jlistClient.setFont(new Font("Arial", Font.PLAIN, 15));
		// set a custom renderer to jlist which show client's full name when it
		// contains a list of Client objects
		jlistClient.setCellRenderer(new DefaultListCellRenderer() {

			/**
			 * serialVersionUID
			 */
			private static final long serialVersionUID = -1766659322866433816L;

			/**
			 * Custom renderer baesd on the Default ListCellRenderer
			 */
			@Override
			public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
					boolean cellHasFocus) {
				Component renderer = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
				if (renderer instanceof JLabel && value instanceof Client) {
					((JLabel) renderer).setText(((Client) value).getFullName());
				}
				return renderer;
			}
		});

		// add clients in jlist
		for (Client clt : clientList) {
			modelJListClient.addElement(clt);
		}

		jspClientList.setBounds(10, 81, 774, 459);
		jspClientList.setViewportView(jlistClient);
		jpCltList.add(jspClientList);
	}

	/**
	 * initial client info panel
	 */
	private void initJpCltInfo() {
		jbReturnClientList.addActionListener(this);
		jbReturnClientList.setFont(new Font("Arial", Font.PLAIN, 15));
		jbReturnClientList.setBounds(648, 25, 137, 23);
		jpCltInfo.add(jbReturnClientList);

		lbInfo.setFont(new Font("Arial", Font.PLAIN, 15));
		lbInfo.setBounds(10, 27, 341, 18);
		jpCltInfo.add(lbInfo);

		jtableClientInfo.setSize(775, 354);
		jtableClientInfo.setLocation(10, 74);
		jtableClientInfo.setRowHeight(25);
		jtableClientInfo.setFont(new Font("Arial Unicode MS", Font.PLAIN, 15));
		jpCltInfo.add(jtableClientInfo);

		// add columns and show keys for jtableClientInfo
		String[] keysClientInfo = { "Prénom", "Nom", "Sexe", "Login", "Date de naissance", "Nationalité", "Adresse",
				"Code postale", "Ville", "Numéro de téléphone", "Mail", "Statut", "Date de création de compte",
				"Dernière connexion" };
		modelJTableClientInfo.addColumn("Key", keysClientInfo);
		modelJTableClientInfo.addColumn("Value");

		jbShowAccList.addActionListener(this);

		jbShowAccList.setFont(new Font("Arial", Font.PLAIN, 15));
		jbShowAccList.setBounds(494, 438, 275, 35);
		jpCltInfo.add(jbShowAccList);
	}

	/**
	 * initial account list panel
	 */
	private void initJpCltAccList() {

		lbAccountList.setFont(new Font("Arial", Font.PLAIN, 15));
		lbAccountList.setBounds(10, 115, 341, 18);
		jpCltAccList.add(lbAccountList);

		// jtable of client's info
		jlistAccount.setFont(new Font("Arial", Font.PLAIN, 15));
		jlistAccount.setBounds(10, 177, 775, 161);
		// set a custom renderer to jlist account which will show account number
		// when it contains a list of Account objects
		jlistAccount.setCellRenderer(new DefaultListCellRenderer() {
			/**
			 * default serialVersionUID
			 */
			private static final long serialVersionUID = 1L;

			/**
			 * Custom renderer baesd on the Default ListCellRenderer
			 */
			@Override
			public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
					boolean cellHasFocus) {
				Component renderer = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
				if (renderer instanceof JLabel && value instanceof Account) {
					((JLabel) renderer).setText(
							((Account) value).getAcc_number() + "    Solde : " + ((Account) value).getAcc_balance());
				}
				return renderer;
			}
		});
		jpCltAccList.add(jlistAccount);

		jbReturnClientInfo.addActionListener(this);
		jbReturnClientInfo.setFont(new Font("Arial", Font.PLAIN, 15));
		jbReturnClientInfo.setBounds(671, 113, 114, 23);

		jpCltAccList.add(jbReturnClientInfo);

		jbShowTsh.addActionListener(this);
		jbShowTsh.setFont(new Font("Arial", Font.PLAIN, 15));
		jbShowTsh.setBounds(423, 364, 362, 35);
		jpCltAccList.add(jbShowTsh);
	}

	/**
	 * initial tsh list panel
	 */
	private void initJpTshList() throws ClassNotFoundException, IOException {

		lbClientInfo.setFont(new Font("Arial", Font.PLAIN, 15));
		lbClientInfo.setBounds(10, 10, 648, 24);
		jpTshList.add(lbClientInfo);

		lbAccountInfo.setFont(new Font("Arial", Font.PLAIN, 15));
		lbAccountInfo.setBounds(10, 44, 648, 24);
		jpTshList.add(lbAccountInfo);

		lbTableTitle.setFont(new Font("Arial", Font.PLAIN, 15));
		lbTableTitle.setBounds(10, 74, 341, 24);
		jpTshList.add(lbTableTitle);

		jtableTransactionHistory.setFont(new Font("Arial", Font.PLAIN, 15));
		jspTSHTable.setBounds(10, 102, 774, 438);
		jspTSHTable.setViewportView(jtableTransactionHistory);
		jpTshList.add(jspTSHTable);

		// add columns and show keys for jtableTransactionHistory
		modelJTableTSH.addColumn("Date");
		modelJTableTSH.addColumn("Description");
		modelJTableTSH.addColumn("Somme");

		jbReturnAccList.addActionListener(this);
		jbReturnAccList.setFont(new Font("Arial", Font.PLAIN, 15));
		jbReturnAccList.setBounds(668, 11, 116, 23);
		jpTshList.add(jbReturnAccList);
	}

	/**
	 * update tsh list panel
	 * 
	 * @param acc
	 *            the account
	 * @param fullname
	 *            the full name of the client
	 */
	private void updateJpTshList(Account acc, String fullname) {
		lbClientInfo.setText("Client : " + fullname);
		lbAccountInfo.setText(acc.getAcc_type() + " : " + acc.getAcc_number());
		clearJTableTSH();
		try {
			initJTableTSH(acc);
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * initial all panels
	 */
	private void initPanels() {
		jpCltList.setLayout(null);
		jpCltInfo.setLayout(null);
		jpCltAccList.setLayout(null);
		jpTshList.setLayout(null);

		initJpClientList();
		initJpCltInfo();
		initJpCltAccList();
		try {
			initJpTshList();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * initial menu bar
	 */
	private void initMenuBar() {

		menuMain.setFont(new Font("Arial", Font.PLAIN, 15));
		menuMain.getAccessibleContext().setAccessibleDescription("Main menu of application");
		menuBar.add(menuMain);

		menuItemMainPage.setFont(new Font("Arial", Font.PLAIN, 15));
		menuMain.getAccessibleContext().setAccessibleDescription("Return to main page");
		menuItemMainPage.addActionListener(this);
		menuMain.add(menuItemMainPage);

		menuItemLogout.setFont(new Font("Arial", Font.PLAIN, 15));
		menuMain.getAccessibleContext().setAccessibleDescription("Logout");
		menuItemLogout.addActionListener(this);
		menuMain.add(menuItemLogout);

		menuAbout.setFont(new Font("Arial", Font.PLAIN, 15));
		menuAbout.getAccessibleContext().setAccessibleDescription("About this application");
		menuBar.add(menuAbout);

		menuItemAbout.setFont(new Font("Arial", Font.PLAIN, 15));
		menuItemAbout.getAccessibleContext().setAccessibleDescription("About");
		menuItemAbout.addActionListener(this);
		menuAbout.add(menuItemAbout);

		setJMenuBar(menuBar);
	}

	/**
	 * clear all rows in jtableTransactionHistory
	 */
	private void clearJTableTSH() {
		for (int i = modelJTableTSH.getRowCount() - 1; i >= 0; i--) {
			modelJTableTSH.removeRow(i);
		}
	}

	/**
	 * search client which name contains the input text, and update jlist
	 */
	private void updateJListClient() {
		modelJListClient.removeAllElements();
		for (Client clt : clientList) {
			if (StringUtils.containsIgnoreCase(clt.getFullName(), tfSearch.getText())) {
				modelJListClient.addElement(clt);
			}
		}
	}

	/**
	 * update JList of account when select a client
	 */
	private void updateJListAccount() {
		if (!jlistClient.isSelectionEmpty()) { // avoid event generate by reset
												// client list
			modelJListAccount.removeAllElements();
			Client clt = jlistClient.getSelectedValue();
			if (clt.getCurrentAccount() != null) {
				modelJListAccount.addElement(clt.getCurrentAccount());
			}
			if (clt.getSavingAccount() != null) {
				modelJListAccount.addElement(clt.getSavingAccount());
			}
			if (clt.getSecuritiesAccount() != null) {
				modelJListAccount.addElement(clt.getSecuritiesAccount());
			}
		}
	}

	/**
	 * update client's data in jtable when select client change
	 */
	private void updateJTableClientInfo() {
		Client clt = jlistClient.getSelectedValue();
		for (int i = modelJTableClientInfo.getRowCount() - 1; i >= 0; i--) {
			modelJTableClientInfo.removeRow(i);
		}
		modelJTableClientInfo.addRow(new Object[] { "Prénom", clt.getClt_fname() });
		modelJTableClientInfo.addRow(new Object[] { "Nom", clt.getClt_lname() });
		modelJTableClientInfo.addRow(new Object[] { "Sexe", clt.getClt_gender() });
		modelJTableClientInfo.addRow(new Object[] { "Login", clt.getClt_login() });
		modelJTableClientInfo.addRow(new Object[] { "Date de naissance",
				clt.getClt_birthday().toString(DateTimeFormat.forPattern("dd/MM/yyyy")) });
		modelJTableClientInfo.addRow(new Object[] { "Nationalité", clt.getClt_nationality() });
		modelJTableClientInfo.addRow(new Object[] { "Adresse", clt.getClt_address() });
		modelJTableClientInfo.addRow(new Object[] { "Code postale", clt.getClt_postalcode() });
		modelJTableClientInfo.addRow(new Object[] { "Ville", clt.getClt_city() });
		modelJTableClientInfo.addRow(new Object[] { "Numéro de téléphone", clt.getClt_telephonenumber() });
		modelJTableClientInfo.addRow(new Object[] { "Mail", clt.getClt_email() });
		modelJTableClientInfo.addRow(new Object[] { "Statut", clt.getClt_status() });
		modelJTableClientInfo.addRow(new Object[] { "Date de création de compte",
				clt.getClt_createdon().toString(DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss")) });
		modelJTableClientInfo.addRow(new Object[] { "Dernière connexion",
				clt.getClt_lastlogin().toString(DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss")) });
		resizeColumnWidth(jtableClientInfo);
	}

	/**
	 * Resize table to fit content
	 * 
	 * @param table
	 *            the table to resize column width
	 */
	public void resizeColumnWidth(JTable table) {
		final TableColumnModel columnModel = table.getColumnModel();
		for (int column = 0; column < table.getColumnCount(); column++) {
			int width = 5; // Min width
			for (int row = 0; row < table.getRowCount(); row++) {
				TableCellRenderer renderer = table.getCellRenderer(row, column);
				Component comp = table.prepareRenderer(renderer, row, column);
				width = Math.max(comp.getPreferredSize().width + 1, width);
			}
			if (width > 700)
				width = 300;
			columnModel.getColumn(column).setPreferredWidth(width);
		}
	}

	/**
	 * update jtableTransactionHistory when select an account
	 * 
	 * @param acc
	 *            the account
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	private void initJTableTSH(Account acc) throws ClassNotFoundException, IOException {
		if (acc != null) {
			ArrayList<TransactionHistory> tshList = DbClient.findTshByAccNumber(acc.getAcc_number());

			for (TransactionHistory tsh : tshList) {
				modelJTableTSH.addRow(
						new Object[] { tsh.getTsh_transactionOn().toString(DateTimeFormat.forPattern("yyyy/MM/dd")),
								tsh.getTsh_description(), tsh.getTsh_amount() });
			}
			resizeColumnWidth(jtableTransactionHistory);
		}
	}

	/**
	 * action performed
	 * 
	 * @param e
	 *            event
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == menuItemAbout) {
			JOptionPane.showMessageDialog(this,
					"ESIGELEC Projet S8 - Banque en ligne\n" + "Groupe 4\n" + "Author: HE Junyang\n", "About",
					JOptionPane.PLAIN_MESSAGE);
		} else if (e.getSource() == menuItemMainPage) {
			this.switchJpCltList();
		} else if (e.getSource() == menuItemLogout) {
			this.dispose();
			new GuiLogin(dbServer);
		} else if (e.getSource() == jbSelectClient) {
			if (!jlistClient.isSelectionEmpty()) { // avoid event generate by
													// reset
				// client list
				updateJTableClientInfo();
				updateJListAccount();
				clearJTableTSH();
				switchJpCltInfo();
			}
		} else if (e.getSource() == jbReturnClientList) {
			switchJpCltList();
		} else if (e.getSource() == jbShowAccList) {
			switchJpCltAccList();
		} else if (e.getSource() == jbReturnClientInfo) {
			switchJpCltInfo();
		} else if (e.getSource() == jbShowTsh) {
			if (jlistAccount.getSelectedValue() != null) {
				switchJpTshList(jlistAccount.getSelectedValue(), jlistClient.getSelectedValue().getFullName());
			}
		} else if (e.getSource() == jbReturnAccList) {
			switchJpCltAccList();
		}
	}

	/**
	 * Main for testing
	 * 
	 * @param args
	 *            inputs arguments
	 */
	public static void main(String[] args) {
		DbServer dbServer = new DbServer();
		Thread server = new Thread(dbServer);
		server.start();

		new GuiMain(dbServer);
	}
}
