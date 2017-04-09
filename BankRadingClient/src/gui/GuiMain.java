package gui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import dao.DaoClient;
import model.Account;
import model.Client;
import model.TransactionHistory;

import javax.swing.JTextPane;

/**
 * Gui of main page of the system
 * 
 * @author Junyang HE
 *
 */
public class GuiMain extends JFrame {
	
	/**
	 * full client list
	 */
	private final ArrayList<Client> clientList = DaoClient.getClientList();
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
	 * label shows: Les historiques de trransaction : :
	 */
	private final JLabel lbTransactionHistory = new JLabel("Les historiques de trransaction :");
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
	 * model for jtableTransactionHistory
	 */
	private DefaultTableModel modelJTableTSH = new DefaultTableModel();
	/**
	 * jtable contains list of transaction history of selected account
	 */
	private JTable jtableTransactionHistory = new JTable(modelJTableTSH);
	/**
	 * model for jlistAccount
	 */
	private DefaultListModel<Account> modelJListAccount = new DefaultListModel<Account>();
	/**
	 * jlist contains all account of selected client
	 */
	private JList<Account> jlistAccount = new JList<Account>(modelJListAccount);
	
	/**
	 * Constructor of jframe
	 */
	public GuiMain() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1024, 768);
		setTitle("Front Office Advisor System");
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		initComponents();

		setVisible(true);
	}

	/**
	 * initiate components
	 */
	private void initComponents() {
		// labels
		lbClientList.setBounds(6, 15, 219, 21);
		getContentPane().add(lbClientList);
		
		lbAccountList.setBounds(237, 271, 341, 18);
		getContentPane().add(lbAccountList);
		
		lbInfo.setBounds(237, 16, 341, 18);
		getContentPane().add(lbInfo);
		
		lbTransactionHistory.setBounds(237, 355, 341, 18);
		getContentPane().add(lbTransactionHistory);
		
		
		
		// JList of client
		jlistClient.setBounds(6, 68, 219, 654);
		getContentPane().add(jlistClient);
		// set a custom renderer to jlist which show client's full name when it contains a list of Client objects
		jlistClient.setCellRenderer(new DefaultListCellRenderer() {
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
				if(renderer instanceof JLabel && value instanceof Client) {
					((JLabel) renderer).setText(((Client) value).getFullName());
				}
				return renderer;
			}
		});
		// Add jlist select cell change listener
		jlistClient.addListSelectionListener(new ListSelectionListener(){

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				updateJTable();
				updateJListAccount();
				clearJTableTSH();
			}
			
		});

		// textfield for search client
		tfSearch.setBounds(6, 35, 219, 30);
		getContentPane().add(tfSearch);
		tfSearch.setColumns(10);
		// add text on change listener
		tfSearch.getDocument().addDocumentListener(new DocumentListener(){

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
		
		// jtable of client's info
		jtableClientInfo.setSize(775, 224);
		jtableClientInfo.setLocation(237, 35);
		getContentPane().add(jtableClientInfo);
		
		// jlist of account
		jlistAccount.setBounds(237, 290, 775, 59);
		getContentPane().add(jlistAccount);
		// set a custom renderer to jlist account which will show account number when it contains a list of Account objects
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
				if(renderer instanceof JLabel && value instanceof Account) {
					((JLabel) renderer).setText(((Account) value).getAcc_number());
				}
				return renderer;
			}
		});
		// add select account change listener
		jlistAccount.addListSelectionListener(new ListSelectionListener(){

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				updateJTableTSH();
			}
			
		});
		
		// jtable of transaction history
		jtableTransactionHistory.setBounds(237, 385, 775, 337);
		getContentPane().add(jtableTransactionHistory);

		// add clients in jlist
		for(Client clt : clientList){
			modelJListClient.addElement(clt);
		}
		
		// add columns and show keys for jtableClientInfo
		String[] keysClientInfo = {"Pr¨¦nom", "Nom", "Sexe", "Login", "Date de naissance", "Nationalit¨¦", 
				"Adresse", "Code postale", "Ville", "Num¨¦ro de t¨¦l¨¦phone", "Mail", "Statut",
				"Date de cr¨¦ation de compte", "Derni¨¨re connexion"};
		modelJTableClientInfo.addColumn("Key", keysClientInfo);
		modelJTableClientInfo.addColumn("Value");
		
		// add columns and show keys for jtableTransactionHistory
		modelJTableTSH.addColumn("Date");
		modelJTableTSH.addColumn("Description");
		modelJTableTSH.addColumn("Somme");
	}
	
	/**
	 * clear all rows in jtableTransactionHistory
	 */
	private void clearJTableTSH(){
		for (int i = modelJTableTSH.getRowCount() - 1; i >= 0; i--) {
			modelJTableTSH.removeRow(i);
		}
	}
	
	/**
	 * update jtableTransactionHistory when select an account
	 */
	private void updateJTableTSH() {
		if(!jlistAccount.isSelectionEmpty()){ // avoid event generate by reset account list
			Account acc = jlistAccount.getSelectedValue();
			ArrayList<TransactionHistory> tshList = acc.getTransactionHistory();
			clearJTableTSH();
			
			for(TransactionHistory tsh : tshList){
				modelJTableTSH.addRow(new Object[]{tsh.getTsh_transactionOn().toString(DateTimeFormat.forPattern("yyyy/MM/dd")),
						tsh.getTsh_description(), tsh.getTsh_amount()});
			}
		}
	}
	
	/**
	 * search client which name contains the input text, and update jlist
	 */
	private void updateJListClient() {
		modelJListClient.removeAllElements();
		for(Client clt : clientList) {
			if(StringUtils.containsIgnoreCase(clt.getFullName(), tfSearch.getText())){
				modelJListClient.addElement(clt);
			}
		}
	}
	
	/**
	 * update jlist of account when select a client
	 */
	private void updateJListAccount() {
		if(!jlistClient.isSelectionEmpty()){ // avoid event generate by reset client list
			modelJListAccount.removeAllElements();
			Client clt = jlistClient.getSelectedValue();
			if(clt.getCurrentAccount() != null){
				modelJListAccount.addElement(clt.getCurrentAccount());
			}
			if(clt.getSavingAccount() != null){
				modelJListAccount.addElement(clt.getSavingAccount());
			}
			if(clt.getSecuritiesAccount() != null){
				modelJListAccount.addElement(clt.getSecuritiesAccount());
			}
		}
	}
	
	/**
	 * update client's data in jtable when select client change
	 */
	private void updateJTable() {
		if(!jlistClient.isSelectionEmpty()){ // avoid event generate by reset client list
			Client clt = jlistClient.getSelectedValue();
			for (int i = modelJTableClientInfo.getRowCount() - 1; i >= 0; i--) {
				modelJTableClientInfo.removeRow(i);
			}
			modelJTableClientInfo.addRow(new Object[] { "Pr¨¦nom", clt.getClt_fname() });
			modelJTableClientInfo.addRow(new Object[] { "Nom", clt.getClt_lname() });
			modelJTableClientInfo.addRow(new Object[] { "Sexe", clt.getClt_gender() });
			modelJTableClientInfo.addRow(new Object[] { "Login", clt.getClt_login() });
			modelJTableClientInfo.addRow(new Object[] { "Date de naissance",
					clt.getClt_birthday().toString(DateTimeFormat.forPattern("dd/MM/yyyy")) });
			modelJTableClientInfo.addRow(new Object[] { "Nationalit¨¦", clt.getClt_nationality() });
			modelJTableClientInfo.addRow(new Object[] { "Adresse", clt.getClt_address() });
			modelJTableClientInfo.addRow(new Object[] { "Code postale", clt.getClt_postalcode() });
			modelJTableClientInfo.addRow(new Object[] { "Ville", clt.getClt_city() });
			modelJTableClientInfo.addRow(new Object[] { "Num¨¦ro de t¨¦l¨¦phone", clt.getClt_telephonenumber() });
			modelJTableClientInfo.addRow(new Object[] { "Mail", clt.getClt_email() });
			modelJTableClientInfo.addRow(new Object[] { "Statut", clt.getClt_status() });
			modelJTableClientInfo.addRow(new Object[] { "Date de cr¨¦ation de compte",
					clt.getClt_createdon().toString(DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss")) });
			modelJTableClientInfo.addRow(new Object[] { "Derni¨¨re connexion",
					clt.getClt_lastlogin().toString(DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss")) });
		}
	}

	/**
	 * Main for testing
	 * @param args
	 */
	public static void main(String[] args) {
		new GuiMain();
	}
}
