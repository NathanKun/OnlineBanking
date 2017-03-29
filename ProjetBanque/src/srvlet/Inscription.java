package srvlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		PrintWriter out= response.getWriter();
		String nom,prenom,nationalite,sexe,adresse,codepostal,ville,email,password,statut;
		String tel;
		String naissance;
		nom= request.getParameter("nom");
		prenom= request.getParameter("prenom");
		nationalite= request.getParameter("nationalite");
		sexe= request.getParameter("sexe");
		adresse= request.getParameter("adresse");
		codepostal= request.getParameter("codepostal");
		ville= request.getParameter("ville");
		email= request.getParameter("email");
		password= request.getParameter("password");
		statut= request.getParameter("statut");
		tel= request.getParameter("");
		naissance= request.getParameter("naissance");

		
	}
}
