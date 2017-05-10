package servlet;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joda.time.DateTime;

import dao.DaoAccount;
import dao.DaoTransactionHistory;
import model.Account;
import model.Client;
import model.TransactionHistory;

/**
 * Servlet implementation class TransferMoney
 * 
 * @author HE Junyang,DJAMEN Yann,BENJILANY Boubeker, Ndjamo Ursula
 */
@WebServlet("/TransferMoney")
public class TransferMoney extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("./zoneclient.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		/**
		 * Here we get the parameters
		 */
		String emetteur = request.getParameter("emetteur");
		String beneficiaire = request.getParameter("beneficiaire");
		String montant = request.getParameter("montant");
		String motif = request.getParameter("motif");
		String iban = request.getParameter("iban");
		String accnumber1 = "";
		String accnumber2 = "";
		

		/**
		 *  We save  the client in an object c
		 */
		Client c = (Client) request.getSession(true).getAttribute("client");

		/**
		 *  We check  which is the debit account
		 */
		switch (emetteur)
		{
		 /**
		  * if the debit account is the current account
		  */
		 case "courant":   
			 /**
			  * We get the current account in an object
			  */
			  Account a1 = c.getCurrentAccount();
			 
			 /**
			  * We get the account number
			  */
				accnumber1 = a1.getAcc_number();
			
			 /**
			  * We check if the debit account has enough money
			  * if the account balance is less than the amount to debit
			  */
				if (a1.getAcc_balance().compareTo(new BigDecimal(montant)) == -1) {
					response.getWriter().print("No enough money");
					montant = "0";
				} 
				
				/**
				 * if the account balance is more than the amount to debit,
				 * we debit that amount from the debit account
				 */
				else {
					a1.setAcc_balance(a1.getAcc_balance().subtract(new BigDecimal(montant)));
					a1.push();
				}
				break; 
				
		  /**
		   * if the debit account is the saving account
		   */
		  case "epargne":
			/**
			 * We get the saving account in an object
			 */
			  Account a = c.getSavingAccount();
			  
			/**
			 * We get the account number
			 */
			  accnumber1 = a.getAcc_number();
			  	
		    /**
		     * We check if the debit account has enough money
		     */
				
		    /**
		     * if the account balance is less than the amount to debit
		     */
				if (a.getAcc_balance().compareTo(new BigDecimal(montant)) == -1) {
					response.getWriter().print("No enough money");
					montant = "0";
				} 
			/**
			 * if the account balance is more than the amount to debit,
			 * we debit that amount from the debit account
			 */	
				else {
					a.setAcc_balance(a.getAcc_balance().subtract(new BigDecimal(montant)));
					a.push();
				}
		    break; 

		}
		
		/**
		 *  We check  which is the account to be credited
		 */
		switch(beneficiaire)
		{
		/**
		 * if the account to be credited is the current account
		 */
		case "courant":
			/**
			 * We get the current account in an object
			 */
			Account a = c.getCurrentAccount();
			/**
			 * We get the account number	
			 */
			accnumber2 = a.getAcc_number();
			/**
			 * We change the value of the account balance
			 */
			a.setAcc_balance(a.getAcc_balance().add(new BigDecimal(montant)));
			a.push();
		break;
		
		/**
		 * if the account to be credited is the saving account
		 */
		case"epargne":
			/**
			 * We get the current account in an object
			 */
			Account ae = c.getSavingAccount();
			/**
			 * We get the account number	
			 */
			accnumber2 = ae.getAcc_number();
			/**
			 * We change the value of the account balance
			 */
			ae.setAcc_balance(ae.getAcc_balance().add(new BigDecimal(montant)));
			ae.push();	
		break;
		
		/**
		 * if the account to be credited is an external account
		 */
		case"external":
			/**
			 * We find the account in the database by its iban and get it in an object
			 */
			Account aex = DaoAccount.findAccountByIban(iban);
			
			/**
			 * if there's no account found in the database(then it's an acount from another bank)
			 */
			if(aex==null)
			{
				accnumber2 = "Compte externe Iban" + iban;
			}
			/**
			 * if there's is a match with an account in the database
			 */
			else {
			/**
			 * We get the account number	
			 */
			accnumber2 = aex.getAcc_number();
			/**
			 * We change the value of the account balance
			 */
			aex.setAcc_balance(aex.getAcc_balance().add(new BigDecimal(montant)));
			aex.push();}
		break;
		}

		/**
		 *  Here we add notes to the transaction history of each account
		 */
		if((new BigDecimal (montant)).compareTo(BigDecimal.ZERO) != 0) {
			String description1 = "virement emis vers le compte " + accnumber2 + "le motif: " + motif;
			TransactionHistory t1 = new TransactionHistory(0, accnumber1, description1, new DateTime().toDateTimeISO(),
					new BigDecimal(montant).multiply(new BigDecimal(-1)));
			String description2 = " virement recu du compte " + accnumber1 + " le motif: " + motif;
			TransactionHistory t2 = new TransactionHistory(0, accnumber2, description2, new DateTime().toDateTimeISO(),
					new BigDecimal(montant));
			DaoTransactionHistory.addTransactionHistory(t1);
			DaoTransactionHistory.addTransactionHistory(t2);
		}

	}

}
