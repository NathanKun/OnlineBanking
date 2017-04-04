package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Random;

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
		response.getWriter().append("Served at: ").append(request.getContextPath());
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
		String naissance = request.getParameter("naissance");
		

		PrintWriter out = response.getWriter();
		String login = DaoClient.getNextClientLogin();
		String acc_number = DaoAccount.getNextAccountNumber();

		PasswordAuthentication pa = new PasswordAuthentication();
		password = pa.hash(password.toCharArray());
		
		out.println("Espace cree");

		out.println("Votre login est "+ login);
		out.println(naissance);
		/*Client c = new Client(0,login,password,prenom,nom, new DateTime(naissance),
				nationalite,sexe,adresse,codepostal,ville,tel,email,statut,null, 
				new DateTime());
		//On ajoute les infos du client dans la base de donn�es
		DaoClient.addClient(c);
	
		c = DaoClient.findClientByLogin(login);
<<<<<<< HEAD:ProjetBanque/src/servlet/Inscription.java
		//On cree un compte courant pour le nouveau client
		Account acc=new Account(0,acc_number,c.getClt_id(),BigDecimal.ZERO,BigDecimal.ZERO,1);
=======
		//On créé un compte courant pour le nouveau client
		Account acc = new Account(0, acc_number, c.getClt_id(), BigDecimal.ZERO, BigDecimal.ZERO, 1);
>>>>>>> 014e01296e7bbdd00892fee5b4c0c3352debca0f:ProjetBanque/src/servlet/Subscribe.java
		DaoAccount.addAccount(acc);
		out.println("Votre numero de compte est  "+ acc_number );


		if(request.getParameter("epargneCheckBox") == "on"){
			// create saving account
			acc = new Account(0, DaoAccount.getNextAccountNumber(), c.getClt_id(), new BigDecimal(1.5), BigDecimal.ZERO, 2);
			DaoAccount.addAccount(acc);
		}
		if(request.getParameter("titreCheckBox") == "on"){
			// create securities account
			acc = new Account(0, DaoAccount.getNextAccountNumber(), c.getClt_id(), BigDecimal.ZERO, BigDecimal.ZERO, 3);
			DaoAccount.addAccount(acc);
		}*/
		
	}
}
