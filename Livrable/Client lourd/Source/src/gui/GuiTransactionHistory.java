package gui;

import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.Component;
import java.awt.Font;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import org.joda.time.format.DateTimeFormat;

import model.Account;
import model.TransactionHistory;
import server.DbClient;

/**
 * JFrame to show transaction history of an account
 * 
 * @author Junyang HE
 *
 */
public class GuiTransactionHistory extends JFrame {

	/**
	 * default serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
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
	 * scrol pane for jtableTransactionHistory
	 */
	private final JScrollPane jspTSHTable = new JScrollPane();
	
	/**
	 * Constructor of jframe
	 * 
	 * @param	acc the account to show transaction history
	 * @param	fullname the full name of the client
	 */
	public GuiTransactionHistory(Account acc, String fullname) {
		setFont(new Font("Arial", Font.PLAIN, 15));
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(800, 600);
		setTitle("Transaction History");
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		
		// connect to server to get tsh list
		try {
			initComponents(acc, fullname);
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
			showMessageDialog(this, "Cannot connect to server");
		}

		setVisible(true);
	}
	
	/**
	 * initiate components
	 * @param acc	account to show transaction history
	 * @param fullname fullname of the client who own the account
	 * @throws IOException 	IOException
	 * @throws ClassNotFoundException	ClassNotFoundException 
	 */
	private void initComponents(Account acc, String fullname) throws ClassNotFoundException, IOException {
		lbClientInfo.setText("Client : " + fullname);
		lbAccountInfo.setText(acc.getAcc_type() + " : " + acc.getAcc_number());
		
		lbTableTitle.setFont(new Font("Arial", Font.PLAIN, 15));
		lbTableTitle.setBounds(10, 74, 341, 24);
		getContentPane().add(lbTableTitle);
		jspTSHTable.setBounds(10, 102, 774, 459);
		
		getContentPane().add(jspTSHTable);
		jspTSHTable.setViewportView(jtableTransactionHistory);
		jtableTransactionHistory.setFont(new Font("Arial", Font.PLAIN, 15));
		
		lbClientInfo.setFont(new Font("Arial", Font.PLAIN, 15));
		lbClientInfo.setBounds(10, 10, 648, 24);
		getContentPane().add(lbClientInfo);
		lbAccountInfo.setFont(new Font("Arial", Font.PLAIN, 15));
		lbAccountInfo.setBounds(10, 44, 648, 24);
		
		getContentPane().add(lbAccountInfo);
		
		// add columns and show keys for jtableTransactionHistory
		modelJTableTSH.addColumn("Date");
		modelJTableTSH.addColumn("Description");
		modelJTableTSH.addColumn("Somme");
		
		initJTableTSH(acc);
	}
	/**
	 * update jtableTransactionHistory when select an account
	 * 
	 * @param acc account to show transaction history
	 * @throws IOException	IOException 
	 * @throws ClassNotFoundException	ClassNotFoundException 
	 */
	private void initJTableTSH(Account acc) throws ClassNotFoundException, IOException {
		if(acc != null){
			ArrayList<TransactionHistory> tshList = DbClient.findTshByAccNumber(acc.getAcc_number());
			
			for(TransactionHistory tsh : tshList){
				modelJTableTSH.addRow(new Object[]{tsh.getTsh_transactionOn().toString(DateTimeFormat.forPattern("yyyy/MM/dd")),
						tsh.getTsh_description(), tsh.getTsh_amount()});
			}
			resizeColumnWidth(jtableTransactionHistory);
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
}
