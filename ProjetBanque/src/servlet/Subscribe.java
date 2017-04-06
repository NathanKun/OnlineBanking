package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joda.time.DateTime;

import dao.DaoAccount;
import dao.DaoClient;
import model.Account;
import model.Client;
import util.PasswordAuthentication;

/**
 * Servlet implementation class Inscription
 */
@WebServlet("/Subscribe")
public class Subscribe extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("./subscribe.jsp");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// On recupere les parametres entr�s dans le formulaire HTML
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String nationalite = request.getParameter("nationalite");
		String sexe = request.getParameter("sexe");
		String adresse = request.getParameter("adresse");
		String codepostal = request.getParameter("codepostal");
		String ville = request.getParameter("ville");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String statut = request.getParameter("statut");
		String tel = request.getParameter("tel");
        String jour = request.getParameter("jour");
        String mois = request.getParameter("mois");
        String annee = request.getParameter("annee");
        int j= Integer.parseInt(jour);
        int m= Integer.parseInt(mois);
        int a= Integer.parseInt(annee);
        

		String login = DaoClient.getNextClientLogin();
		
		PasswordAuthentication pa = new PasswordAuthentication();
		password = pa.hash(password.toCharArray());
		
		Client c = new Client(0,login,password,prenom,nom, new DateTime(a,m,j,0,0,0,0),
                nationalite,sexe,adresse,codepostal,ville,tel,email,statut,null, 
                new DateTime().toDateTimeISO());
		
		//On ajoute les infos du client dans la base de donnees
		DaoClient.addClient(c);
		c = DaoClient.findClientByLogin(login);

		//On cree un compte courant pour le nouveau client
		Account acc=new Account(0,DaoAccount.getNextAccountNumber(),c.getClt_id(),BigDecimal.ZERO,BigDecimal.ZERO,1);
		DaoAccount.addAccount(acc);

		String epargneCB = "";
		String titreCB = "";
		if(request.getParameter("epargneCheckBox") != null)
			epargneCB = request.getParameter("epargneCheckBox");
		if(request.getParameter("titreCheckBox") != null)
			titreCB = request.getParameter("titreCheckBox");

		if(epargneCB.equals("on")){
			// create saving account
			acc = new Account(0, DaoAccount.getNextAccountNumber(), c.getClt_id(), BigDecimal.ZERO, new BigDecimal(1.5), 2);
			DaoAccount.addAccount(acc);
		}
		if(titreCB.equals("on")){
			// create securities account
			acc = new Account(0, DaoAccount.getNextAccountNumber(), c.getClt_id(), BigDecimal.ZERO, BigDecimal.ZERO, 3);
			DaoAccount.addAccount(acc);
		} 
		// redirection
		request.getSession(true).setAttribute("client", DaoClient.findClientByLogin(login));
		response.sendRedirect("./zoneclient.jsp");
	}
}
