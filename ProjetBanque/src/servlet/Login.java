package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoClient;
import model.Client;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		PrintWriter out= response.getWriter();
		String login= request.getParameter("login");
		String password=request.getParameter("password");
		ArrayList<Client> cltList= DaoClient.getClientList();
		Boolean isFound = false;
		Client cltFound = null;
		out.println(login);
		out.println(password);
		for (Client clt : cltList){
			if(clt.getClt_login().equals(login) && clt.getClt_password().equals(password)) {
				isFound = true;
				cltFound = clt;
				out.println("Client found");
			}

			out.println(clt.getClt_login());
			out.println(clt.getClt_password());
		}
		
		if(isFound){
			// redirection
			request.setAttribute("client", cltFound);
			request.getRequestDispatcher("./AccueilClient.jsp").forward(request, response);
		}
		else{out.println("Not found");}
	}

}