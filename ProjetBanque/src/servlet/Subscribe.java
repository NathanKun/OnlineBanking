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
import dao.DaoClient;
import model.Account;
import model.Client;
import util.IbanUtil;
import util.PasswordAuthentication;

/**
 * Servlet implementation class Inscription
 * 
 * @author DJAMEN Yann, HE Junyang, BENJILANY Boubeker
 */
@WebServlet("/Subscribe")
public class Subscribe extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("./subscribe.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (((String) (request.getSession().getAttribute("code"))).equals("ok")) {

			/**
			 * Here we get the parameters entered in the HTML form
			 */
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
			int j = Integer.parseInt(jour);
			int m = Integer.parseInt(mois);
			int a = Integer.parseInt(annee);

			/**
			 * We give automatically a login for the new client
			 */
			String login = DaoClient.getNextClientLogin();

			/**
			 * We give a password for the new client
			 */
			PasswordAuthentication pa = new PasswordAuthentication();
			password = pa.hash(password.toCharArray());

			Client c = new Client(0, login, password, prenom, nom, new DateTime(a, m, j, 0, 0, 0, 0), nationalite, sexe,
					adresse, codepostal, ville, tel, email, statut, null, new DateTime().toDateTimeISO());

			/**
			 * We add the client to the DataBase
			 */
			DaoClient.addClient(c);
			c = DaoClient.findClientByLogin(login);

			/**
			 * We create a current account for the new client
			 */
			Account acc = new Account(0, DaoAccount.getNextAccountNumber(), IbanUtil.generateIban(c.getClt_login(), 1),
					c.getClt_id(), BigDecimal.ZERO, BigDecimal.ZERO, 1);
			DaoAccount.addAccount(acc);

			/**
			 * We create a saving or/and securities accounts for the new client
			 * if he asks for
			 */
			String epargneCB = "";
			String titreCB = "";
			if (request.getParameter("epargneCheckBox") != null)
				epargneCB = request.getParameter("epargneCheckBox");
			if (request.getParameter("titreCheckBox") != null)
				titreCB = request.getParameter("titreCheckBox");

			if (epargneCB.equals("on")) {
				/**
				 * create saving account
				 */
				acc = new Account(0, DaoAccount.getNextAccountNumber(), IbanUtil.generateIban(c.getClt_login(), 2),
						c.getClt_id(), BigDecimal.ZERO, new BigDecimal(1.5), 2);
				DaoAccount.addAccount(acc);
			}
			if (titreCB.equals("on")) {
				/**
				 * create securities account
				 */
				acc = new Account(0, DaoAccount.getNextAccountNumber(), IbanUtil.generateIban(c.getClt_login(), 3),
						c.getClt_id(), BigDecimal.ZERO, BigDecimal.ZERO, 3);
				DaoAccount.addAccount(acc);
			}
			/**
			 * redirection
			 */
			request.getSession(true).setAttribute("client", DaoClient.findClientByLogin(login));
			response.sendRedirect("./zoneclient.jsp");
		} else {
			/**
			 * email not checked
			 */
		}
		response.getWriter().print("Something wrong, email check not passed");
	}
}
