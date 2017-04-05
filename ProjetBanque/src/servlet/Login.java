package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoClient;
import model.Client;
import util.PasswordAuthentication;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("./index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 PrintWriter out= response.getWriter();
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		Client clt = DaoClient.findClientByLogin(login);
		boolean isFound = false;
		Client cltFound = null;

		PasswordAuthentication pa = new PasswordAuthentication();

		if (clt != null) {
			if (pa.authenticate(password.toCharArray(), clt.getClt_password())) {
				isFound = true;
				cltFound = clt;
			}
		}

		if (isFound) {
			// redirection
			request.getSession(true).setAttribute("client", cltFound);
			System.out.println("found");
			response.sendRedirect("./CustomerArea.jsp");
		} else {
			// go back to login page
			request.setAttribute("loginFailed", true);
			request.setAttribute("login", login);
			System.out.println("not found");
			response.sendRedirect("./CustomerArea.jsp");
		}
	}

}
