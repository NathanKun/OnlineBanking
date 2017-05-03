package src.servlet;

import java.io.IOException;


/**
 * Servlet implementation class connexion
 * @author Amghar zakaria
 */
@WebServlet("/Connexion")

public class Connexion extends HttpServlet {
private static final long serialVersionUID = 1L;

	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("./ConnexionManager.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/* Récupération des champs du formulaire */
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		Manager mng = DaoManager.findManagerByLogin(login);
		boolean isFound = false;
		Manager mngFound = null;

		PasswordAuthentication pa = new PasswordAuthentication();
		
		if (mng != null) {
			if (pa.authenticate(password.toCharArray(), mng.getmng_password())) {
				isFound = true;
				mngFound = mng;
				request.getSession(true).setAttribute("manager", mngFound);
				response.sendRedirect("./AccesMng.jsp");
			}
		}
		
		else {
			// Revenir à la page ConnexionManager 
			request.setAttribute("loginFailed", true);
			request.setAttribute("login", login);
			request.getRequestDispatcher("./login.jsp").forward(request, response);
    }
}}

