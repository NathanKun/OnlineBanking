package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// here is a little indication
		
		// emetteur and beneficiare send in will be one of these: courant, epargne, titre
		String emetteur = request.getParameter("emetteur");
		String montant= request.getParameter("");
		String typeCarte = request.getParameter("type");
		String numCarte= request.getParameter("numcarte");
		String mois= request.getParameter("mois");
		String annee= request.getParameter("annee");
		String crypto= request.getParameter("crypto");
		
	
		
		// check if emetteur account has enough money, if no reponse "No enough money"
		response.getWriter().print("No enough money");
		
		// if has enough money, transfer money, and reponse "ok"
	}

}
