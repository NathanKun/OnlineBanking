package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoManager;
import model.Manager;
import util.PasswordAuthentication;

/**
 * Servlet implementation class connexion
 * 
 * @author Amghar zakaria
 */
@WebServlet("/Manager/Login")

public class LoginManager extends HttpServlet {
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
		/* Recuperation des champs du formulaire */
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		Manager mng = DaoManager.findManagerByLogin(login);
		boolean isFound = false;
		Manager mngFound = null;

		//System.out.println(mng);

		PasswordAuthentication pa = new PasswordAuthentication();

		if (mng != null) {
			if (pa.authenticate(password.toCharArray(), mng.getmng_password())) {
				isFound = true;
				mngFound = mng;
			}
		}

		if (isFound) {
			request.getSession(true).setAttribute("manager", mngFound);
			response.sendRedirect("./index.jsp");
			System.out.println("login ok");
		} else {
			// Revenir a la page ConnexionManager
			request.setAttribute("loginFailed", true);
			request.setAttribute("login", login);
			request.getRequestDispatcher("./login.jsp").forward(request, response);
			System.out.println("login failed");
		}
	}
}
