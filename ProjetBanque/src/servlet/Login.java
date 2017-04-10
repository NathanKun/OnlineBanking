package servlet;

import java.io.IOException;

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
 * @author DJAMEN Yann, HE Junyang
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
		response.sendRedirect("./login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
			System.out.println("clt found");
			response.sendRedirect("./zoneclient.jsp");
		} else {
			// go back to login page
			request.setAttribute("loginFailed", true);
			request.setAttribute("login", login);
			request.getRequestDispatcher("./login.jsp").forward(request, response);
		}
	}

}
