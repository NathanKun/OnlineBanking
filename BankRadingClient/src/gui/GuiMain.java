package gui;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.format.DateTimeFormat;

import model.Account;
import model.Client;
import server.DbClient;
import server.DbServer;

/**
 * Gui of main page of the system
 * 
 * @author Junyang HE
 *
 */
public class GuiMain extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -248822875737254279L;
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
	 * model for jtableTransactionHistory
	 */
	private DefaultTableModel modelJTableTSH = new DefaultTableModel();
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
	 * Constructor of jframe
	 * 
	 * @param dbServer  the intermediate server
	 */
	public GuiMain(DbServer dbServer) {
		// connect to server to get client list
		try {
			clientList = DbClient.getClientList();
		} catch (IOException e) {
			clientList = new ArrayList<Client> ();
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		setFont(new Font("Arial", Font.PLAIN, 15));
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(1024, 566);
		setTitle("Front Office Advisor System");
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		initComponents();
		
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

		setVisible(true);
	}

	/**
	 * initiate components
	 */
	private void initComponents() {
		lbClientList.setFont(new Font("Arial", Font.PLAIN, 15));
		// labels
		lbClientList.setBounds(6, 15, 219, 21);
		getContentPane().add(lbClientList);
		lbAccountList.setFont(new Font("Arial", Font.PLAIN, 15));
		
		lbAccountList.setBounds(237, 399, 341, 18);
		getContentPane().add(lbAccountList);
		lbInfo.setFont(new Font("Arial", Font.PLAIN, 15));
		
		lbInfo.setBounds(237, 16, 341, 18);
		getContentPane().add(lbInfo);
		jspClientList.setBounds(6, 68, 219, 460);
		
		getContentPane().add(jspClientList);
		jlistClient.setFont(new Font("Arial", Font.PLAIN, 15));
		jspClientList.setViewportView(jlistClient);
		// set a custom renderer to jlist which show client's full name when it contains a list of Client objects
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
				updateJTableClientInfo();
				updateJListAccount();
				clearJTableTSH();
			}
			
		});
		tfSearch.setFont(new Font("Arial Unicode MS", Font.PLAIN, 15));

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
		jtableClientInfo.setSize(775, 354);
		jtableClientInfo.setLocation(237, 35);
		getContentPane().add(jtableClientInfo);
		jlistAccount.setFont(new Font("Arial", Font.PLAIN, 15));
		jtableClientInfo.setRowHeight(25);
		
		// jlist of account
		jtableClientInfo.setFont(new Font("Arial Unicode MS", Font.PLAIN, 15));
		jlistAccount.setBounds(237, 427, 775, 101);
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
					((JLabel) renderer).setText(
							((Account) value).getAcc_number()
							+ "    Solde : "
							+ ((Account) value).getAcc_balance());
				}
				return renderer;
			}
		});
		// add select account change listener
		jlistAccount.addListSelectionListener(new ListSelectionListener(){

			@Override
			public void valueChanged(ListSelectionEvent ev) {
				//updateJTableTSH();
				if (!ev.getValueIsAdjusting()) {//This line prevents double events
					if(jlistAccount.getSelectedValue() != null){
						new GuiTransactionHistory(jlistAccount.getSelectedValue(), jlistClient.getSelectedValue().getFullName());
					}
			    }
			}
			
		});

		// add clients in jlist
		for(Client clt : clientList){
			modelJListClient.addElement(clt);
		}
		
		// add columns and show keys for jtableClientInfo
		String[] keysClientInfo = {"Prénom", "Nom", "Sexe", "Login", "Date de naissance", "Nationalité", 
				"Adresse", "Code postale", "Ville", "Numéro de téléphone", "Mail", "Statut",
				"Date de création de compte", "Dernière connexion"};
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
	 * update JList of account when select a client
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
	private void updateJTableClientInfo() {
		if(!jlistClient.isSelectionEmpty()){ // avoid event generate by reset client list
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
	}
	
	/**
	 * Resize table to fit content
	 * @param table	the table to resize column width
	 */
	public void resizeColumnWidth(JTable table) {
	    final TableColumnModel columnModel = table.getColumnModel();
	    for (int column = 0; column < table.getColumnCount(); column++) {
	        int width = 5; // Min width
	        for (int row = 0; row < table.getRowCount(); row++) {
	            TableCellRenderer renderer = table.getCellRenderer(row, column);
	            Component comp = table.prepareRenderer(renderer, row, column);
	            width = Math.max(comp.getPreferredSize().width +1 , width);
	        }
	        if(width > 700)
	            width=300;
	        columnModel.getColumn(column).setPreferredWidth(width);
	    }
	}

	/**
	 * Main for testing
	 * @param args inputs arguments
	 */
	public static void main(String[] args) {
    	DbServer dbServer = new DbServer();
    	Thread server = new Thread(dbServer);
    	server.start();
    	
		new GuiMain(dbServer);
	}
}
