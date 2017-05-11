package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joda.time.DateTime;

import dao.DaoClient;
import model.Client;
import util.PasswordAuthentication;

/**
 * Servlet implementation class ModifyInfo
 * @author  DJAMEN Yann, HE Junyang, BENJILANY Boubeker
 */
@WebServlet("/ModifyInfo")
public class ModifyInfo extends HttpServlet {
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
		
		/**
		 * Here we get the parameters
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
        int j= Integer.parseInt(jour);
        int m= Integer.parseInt(mois);
        int a= Integer.parseInt(annee);

        /**
		 *  We save  the client in an object c
		 */
		Client c= (Client)request.getSession(true).getAttribute("client");
        
        if((!password.isEmpty()) & password != null) {
			PasswordAuthentication pa = new PasswordAuthentication();
			password = pa.hash(password.toCharArray());
			c.setClt_password(password);
        }
        
		//On doit reprendre le login precedent
        
        /**
		 *  We add setters to modify client infos
		 */
		c.setClt_lname(nom);
		c.setClt_fname(prenom);
		c.setClt_nationality(nationalite);
		c.setClt_gender(sexe);
		c.setClt_address(adresse);
		c.setClt_postalcode(codepostal);
		c.setClt_city(ville);
		c.setClt_email(email);
		c.setClt_status(statut);
		c.setClt_telephonenumber(tel);
		DateTime date= new DateTime (a,m,j,0,0,0,0);
		c.setClt_birthday(date);
		

		
		DaoClient.updateClient(c);
		
		request.getSession().removeAttribute("client");
		request.getSession().setAttribute("client", DaoClient.getClient(c.getClt_id()));

		response.sendRedirect("./zoneclient.jsp");
	}

}
