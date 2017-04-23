package servlet;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoAccount;
import dao.DaoClient;
import model.Account;
import model.Client;
import util.IbanUtil;

/**
 * Servlet implementation class CreateAccount
 */
@WebServlet("/CreateAccount")
public class CreateAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Client clt = (Client) request.getSession().getAttribute("client");
		if (clt != null) {
			if (request.getParameter("type").equals("SavingAccount") && clt.getSavingAccount() == null) {
				DaoAccount.addAccount(
						new Account(0, DaoAccount.getNextAccountNumber(), IbanUtil.generateIban(clt.getClt_id(), 2),
								clt.getClt_id(), new BigDecimal(0), new BigDecimal(2.5), 2));
				response.getWriter().print("Done");
			} else if (request.getParameter("type").equals("SecuritiesAccount") && clt.getSecuritiesAccount() == null) {
				DaoAccount.addAccount(
						new Account(0, DaoAccount.getNextAccountNumber(), IbanUtil.generateIban(clt.getClt_id(), 3),
								clt.getClt_id(), new BigDecimal(0), new BigDecimal(0), 3));
				response.getWriter().print("Done");
			} else {
				response.sendRedirect("./Login");
			}
			request.getSession().removeAttribute("client");
			request.getSession().setAttribute("client", DaoClient.getClient(clt.getClt_id()));
		} else {
			response.sendRedirect("./index.jsp");
		}
	}

}
