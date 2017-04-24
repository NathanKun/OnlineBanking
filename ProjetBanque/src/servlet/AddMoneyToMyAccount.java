package servlet;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Account;
import model.Client;

/**
 * Servlet implementation class AddMoneyToMyAccount
 */
@WebServlet("/AddMoneyToMyAccount")
public class AddMoneyToMyAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AddMoneyToMyAccount() {
        // TODO Auto-generated constructor stub
    }

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
		String typeCarte = request.getParameter("type");
		String titulaire= request.getParameter("titulaire");
		String numCarte= request.getParameter("numcarte");
		String mois= request.getParameter("mois");
		String annee= request.getParameter("annee");
		String crypto= request.getParameter("crypto");
		
		Client c= (Client)request.getSession(true).getAttribute("client");
		
		if(recepteur.equals("1"))
		{
			Account a= c.getCurrentAccount();
			a.setAcc_balance(a.getAcc_balance().add(new BigDecimal(montant)));
			a.push();
			response.sendRedirect("./zoneclient.jsp");
		}
		
		if ( recepteur.equals("2"))
		{
			Account a= c.getSavingAccount();
			a.setAcc_balance(a.getAcc_balance().add(new BigDecimal(montant)));
			a.push();
			response.sendRedirect("./zoneclient.jsp");
		}
		
		if ( recepteur.equals("3"))
		{
			Account a= c.getSecuritiesAccount();
			a.setAcc_balance(a.getAcc_balance().add(new BigDecimal(montant)));
			a.push();
			response.sendRedirect("./zoneclient.jsp");
		}
		
		
		// check if emetteur account has enough money, if no reponse "No enough money"
		response.getWriter().print("No enough money");
		
		// if has enough money, transfer money, and reponse "ok"
	}

}
