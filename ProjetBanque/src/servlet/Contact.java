package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoContactForm;
import model.ContactForm;
/**
 * Servlet implementation class Contact
 * @author BENJILANY Boubeker, DJAMEN Yann, HE Junyang
 */
@WebServlet("/Contact")
public class Contact extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("./contact.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * Here we get the parameters
		 */
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String message = request.getParameter("message");
		
		/**
		 * We create the contact
		 */
		int rt = DaoContactForm.addContactForm(new ContactForm(0, name, email, phone, message));
		
		/**
		 * If the contact is created
		 */
		if(rt == 1){
			response.setContentType("text/html; charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write("Message envoyé"); 
			
			/**
			 * If the contact isn't created
			 */
		} else {
			response.getWriter().write("Failed"); 
		}
	}
}
