package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joda.time.DateTime;

import dao.DaoClient;
import model.Account;
import model.Client;

/**
 * Servlet implementation class Inscription
 */
@WebServlet("/Inscription")
public class Inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Inscription() {
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
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// On recupere les parametres entrés dans le formulaire HTML
		String nom= request.getParameter("nom");
		String prenom= request.getParameter("prenom");
		String nationalite= request.getParameter("nationalite");
		String sexe= request.getParameter("sexe");
		String adresse= request.getParameter("adresse");
		String codepostal= request.getParameter("codepostal");
		String ville= request.getParameter("ville");
		String email= request.getParameter("email");
		String password= request.getParameter("password");
		String statut= request.getParameter("statut");
		String tel= request.getParameter("tel");
		String naissance= request.getParameter("naissance");
		sexe="M";
		PrintWriter out= response.getWriter();
		Random rn = new Random();
		String login= String.valueOf(rn.nextInt(99999999)) ;
		String acc_number= login + "01" ;
		out.println(login + " "+ acc_number);
		Client c =new Client(0,login,password,prenom,nom,new DateTime(1993, 03, 03, 13, 45),
				nationalite,sexe,adresse,codepostal,ville,tel,email,statut,null, 
				new DateTime(2017, 03, 03, 13, 45));
		
		out.println("OK ");
		
		out.println(DaoClient.addClient(c));
		/*c = DaoClient.get
		ArrayDaoClient.getClientList();
		Account acc=new Account(0,acc_number,);*/
	}
}
