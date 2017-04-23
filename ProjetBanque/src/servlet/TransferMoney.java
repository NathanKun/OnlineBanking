package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TransferMoney
 * @author 
 */
@WebServlet("/TransferMoney")
public class TransferMoney extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// here is a little indication
		
		// emetteur and beneficiare send in will be one of these: courant, epargne, titre
		String emetteur = request.getParameter("emetteur");
		String beneficiare = request.getParameter("beneficiaire");
		String montant = request.getParameter("montant");
		String  motif = request.getParameter("motif");
		
		// check if emetteur account has enough money, if no reponse "No enough money"
		response.getWriter().print("No enough money");
		
		// if has enough money, transfer money, and reponse "ok"
	}

}
