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
		// here is a little indication
		
		// emetteur and beneficiare send in will be one of these: courant, epargne, titre
		String recepteur = request.getParameter("recepteur");
		String montant= request.getParameter("montant");
		String accnumber="";
		String description = "Credité de " + montant + " euros dans l'espace client.";
		
		/*
		String typeCarte = request.getParameter("type");
		String titulaire= request.getParameter("titulaire");
		String numCarte= request.getParameter("numcarte");
		String mois= request.getParameter("mois");
		String annee= request.getParameter("annee");
		String crypto= request.getParameter("crypto");
		*/
		
		Client c= (Client)request.getSession(true).getAttribute("client");
		
		if(recepteur.equals("courant"))
		{
			Account a= c.getCurrentAccount();
			accnumber=a.getAcc_number();
			a.setAcc_balance(a.getAcc_balance().add(new BigDecimal(montant)));
			a.push();
		}
		
		if ( recepteur.equals("epargne"))
		{
			Account a= c.getSavingAccount();
			accnumber=a.getAcc_number();
			a.setAcc_balance(a.getAcc_balance().add(new BigDecimal(montant)));
			a.push();
		}
		
		if ( recepteur.equals("titre"))
		{
			Account a= c.getSecuritiesAccount();
			accnumber= a.getAcc_number();
			a.setAcc_balance(a.getAcc_balance().add(new BigDecimal(montant)));
			a.push();
		}
		
		
		// check if emetteur account has enough money, if no reponse "No enough money"
		//response.getWriter().print("No enough money");
	

	TransactionHistory t = new TransactionHistory(0,accnumber,description,new DateTime().toDateTimeISO() ,new BigDecimal(montant));
	DaoTransactionHistory.addTransactionHistory(t);
	response.sendRedirect("./zoneclient.jsp");
	}
	
}
