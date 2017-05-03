package servlet;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joda.time.DateTime;

import dao.DaoTransactionHistory;
import model.Account;
import model.Client;
import model.TransactionHistory;

/**
 * Servlet implementation class AddMoneyToMyAccount
 */
@WebServlet("/AddMoneyToMyAccount")
public class AddMoneyToMyAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("./zoneclient.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Here we get the parameters
		String recepteur = request.getParameter("recepteur");
		String montant= request.getParameter("montant");
		String accnumber="";
		String typeCarte = request.getParameter("type");
		String titulaire= request.getParameter("titulaire");
		String numCarte= request.getParameter("numcarte");
		String mois= request.getParameter("mois");
		String annee= request.getParameter("annee");
		String crypto= request.getParameter("crypto");
		String description = "" + montant + " euros ajoutés via une carte de type " + typeCarte;
		
		Client c= (Client)request.getSession(true).getAttribute("client");
		switch(recepteur){
			//if the account to be credited is the current account
			case "courant":
			//We get the current account in an object
			Account a= c.getCurrentAccount();
			//We get the account number
			accnumber=a.getAcc_number();
			//We change the value of the account balance
			a.setAcc_balance(a.getAcc_balance().add(new BigDecimal(montant)));
			a.push();
		    break;
		
			//if the account to be credited is the saving account
			case "epargne":
			//We get the saving account in an object
			Account ae= c.getSavingAccount();
			//We get the account number
			accnumber=ae.getAcc_number();
			//We change the value of the account balance
			ae.setAcc_balance(ae.getAcc_balance().add(new BigDecimal(montant)));
			ae.push();
			break;
		}
		// Here we add notes to the transaction history of the account to be credited
		if((new BigDecimal (montant)).compareTo(BigDecimal.ZERO) != 0) {	
	TransactionHistory t = new TransactionHistory(0,accnumber,description,new DateTime().toDateTimeISO() ,new BigDecimal(montant));
	DaoTransactionHistory.addTransactionHistory(t);
	response.sendRedirect("./zoneclient.jsp");
	}
		}
	
}
