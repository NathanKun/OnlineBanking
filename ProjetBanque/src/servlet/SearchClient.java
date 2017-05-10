package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joda.time.format.DateTimeFormat;

import dao.DaoClient;
import model.Client;
import model.TransactionHistory;

/**
 * Servlet implementation class SearchClient
 * @author BENJILANY Boubeker, DJAMEN Yann, HE Junyang
 */
@WebServlet("/SearchClient")
public class SearchClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchClient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		/**
		 * Here we get the parameters
		 */
		String login = request.getParameter("login");
		String message = "";
		String type= request.getParameter("type");
		
		/**
		 * We save the client in an object clt by his login
		 */
		Client clt = DaoClient.findClientByLogin(login);
		
		/**
		 * In case of incorrect login
		 */
		if (clt == null){
			message= "Ce client n'existe pas. Veuillez entrer un login correct SVP";
		}
		
		/**
		 * In case of login
		 */
		else
		{
			

		}
			
		
	}

}
