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
 * @author 
 */
@WebServlet("/TransferMoney")
public class TransferMoney extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// here is a little indication
		
		// emetteur and beneficiare send in will be one of these: courant, epargne, titre
		String emetteur = request.getParameter("emetteur");
		String beneficiaire = request.getParameter("beneficiaire");
		String montant = request.getParameter("montant");
		String  motif = request.getParameter("motif");
		String iban = request.getParameter("iban");
		String accnumber1="";
		String accnumber2="";
		
		Client c= (Client)request.getSession(true).getAttribute("client");
		
		if (emetteur.equals("courant"))
		{
			
			Account a= c.getCurrentAccount();
			accnumber1=a.getAcc_number();
			// check if emetteur account has enough money, if no reponse "No enough money"
	
			if (a.getAcc_balance().compareTo(new BigDecimal(montant))== -1)
			{response.getWriter().print("No enough money");
			montant="0";}
				else{
			a.setAcc_balance(a.getAcc_balance().subtract(new BigDecimal(montant)));
				a.push();
				 
				}
		}
		
		if (emetteur.equals("epargne"))
		{
			Account a= c.getSavingAccount();
			accnumber1=a.getAcc_number();
				if (a.getAcc_balance().compareTo(new BigDecimal(montant))== -1)
				{response.getWriter().print("No enough money");
				montant="0";}
				else{
			a.setAcc_balance(a.getAcc_balance().subtract(new BigDecimal(montant)));
				a.push();
				 
				}
		}
		
		if (emetteur.equals("titre"))
		{
			Account a= c.getSecuritiesAccount();
			accnumber1=a.getAcc_number();
				if (a.getAcc_balance().compareTo(new BigDecimal(montant))== -1)
				{response.getWriter().print("No enough money");
				montant="0";}
				else{
			a.setAcc_balance(a.getAcc_balance().subtract(new BigDecimal(montant)));
				a.push();
				 
				}
		}
		
		
		
		if(beneficiaire.equals("courant"))
		{
			Account a= c.getCurrentAccount();
			accnumber2=a.getAcc_number();
			a.setAcc_balance(a.getAcc_balance().add(new BigDecimal(montant)));
			a.push();
			 
		}
		
		if ( beneficiaire.equals("epargne"))
		{
			Account a= c.getSavingAccount();
			accnumber2=a.getAcc_number();
			a.setAcc_balance(a.getAcc_balance().add(new BigDecimal(montant)));
			a.push();
			 
		}
		
		if ( beneficiaire.equals("titre"))
		{
			Account a= c.getSecuritiesAccount();
			accnumber2=a.getAcc_number();
			a.setAcc_balance(a.getAcc_balance().add(new BigDecimal(montant)));
			a.push();
			 
		}
		
		if ( beneficiaire.equals("external"))
		{
			Account a= DaoAccount.findAccountByIban(iban);
			accnumber2=a.getAcc_number();
			a.setAcc_balance(a.getAcc_balance().add(new BigDecimal(montant)));
			a.push();
			 
		}
		String description1= "vous avez effectue un virement au compte "+ accnumber2 + "le motif: " + motif;
		TransactionHistory t1 = new TransactionHistory(0,accnumber1,description1,new DateTime().toDateTimeISO() ,new BigDecimal(montant));
		String description2= "vous avez recu un virement du compte "+ accnumber1 + " le motif: " + motif;
		TransactionHistory t2 = new TransactionHistory(0,accnumber2,description2,new DateTime().toDateTimeISO() ,new BigDecimal(montant));
		DaoTransactionHistory.addTransactionHistory(t1);
		DaoTransactionHistory.addTransactionHistory(t2);
		// if has enough money, transfer money, and reponse "ok"
	}

}
