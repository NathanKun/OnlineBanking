package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.RandomCodeGenerator;
import util.SendMail;

/**
 * Servlet implementation class EmailCheck
 * @author HE Junyang
 */
@WebServlet("/EmailCheck")
public class EmailCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("./Subscribe");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equals("send")){
			String email = request.getParameter("email");
			String code = (new RandomCodeGenerator()).generateCode();
			request.getSession().setAttribute("code", code);
			if(SendMail.sendVerificationCode(code, email)){
				response.getWriter().write("ok");
			} else {
				response.getWriter().write("failed");
			}
		} else if(action.equals("check")){
			String inputCode = request.getParameter("code");
			String sentCode = (String) request.getSession().getAttribute("code");
			if(sentCode.equals(inputCode)){
				//request.getSession().removeAttribute("code");
				request.getSession().setAttribute("code", "ok");
				response.getWriter().write("ok");
			} else {
				response.getWriter().write("incorrect");
			}
		} else {
			response.sendRedirect("./Subscribe");
		}
	}

}
