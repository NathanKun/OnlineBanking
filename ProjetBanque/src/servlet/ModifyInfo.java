package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joda.time.DateTime;

import dao.DaoAccount;
import dao.DaoClient;
import model.Client;

/**
 * Servlet implementation class ModifyInfo
 */
@WebServlet("/ModifyInfo")
public class ModifyInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyInfo() {
        super();
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
        PrintWriter out = response.getWriter();
		//On doit reprendre le login precedent
		String login = DaoClient.getNextClientLogin();
		String acc_number = DaoAccount.getNextAccountNumber();
		Client c = new Client(0,login,password,prenom,nom, new DateTime(a,m,j,0,0,0,0),
                nationalite,sexe,adresse,codepostal,ville,tel,email,statut,null, 
                new DateTime().toDateTimeISO());
		DaoClient.updateClient(c);
		out.println("Modifications apportées");
	}

}
