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

import model.Client;
import model.TransactionHistory;

/**
 * Servlet implementation class GetBalance
 * 
 * @author HE Junyang, BENJILANY Boubeker
 */
@WebServlet("/GetTransactionHistories")
public class GetTransactionHistories extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/**
		 * We check if the client exist
		 */
		if (request.getSession().getAttribute("client") != null) {

			/**
			 * We save the account type in an object type
			 */
			String type = (String) request.getParameter("type");

			/**
			 * We save the client in an object clt
			 */
			Client clt = (Client) request.getSession().getAttribute("client");
			// System.out.println(clt.getCurrentAccount());

			/**
			 * We create the transaction history list
			 */
			ArrayList<TransactionHistory> tshList = null;

			/**
			 * We check the account type
			 */
			switch (type) {

			/**
			 * if the history is for the current account
			 */
			case "currentHistory":
				tshList = clt.getCurrentAccount().getTransactionHistory();
				break;

			/**
			 * if the history is for the saving account
			 */
			case "savingHistory":
				tshList = clt.getSavingAccount().getTransactionHistory();
				break;

			/**
			 * if the history is for the securities account
			 */
			case "securitiesHistory":
				tshList = clt.getSecuritiesAccount().getTransactionHistory();
				break;
			}

			/**
			 * write in utf-8
			 */
			response.setContentType("text/html; charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();

			/**
			 * We create the transactionHistory table
			 */

			if (tshList.size() == 0) {
				out.print("Il n'y a pas d'historique de transaction pour ce compte.");
			} else {
				for (TransactionHistory tsh : tshList) {
					out.print("<tr>");
					out.print("<td>" + tsh.getTsh_transactionOn().toString(DateTimeFormat.forPattern("yyyy/MM/dd"))
							+ "</td>");
					out.print("<td>" + tsh.getTsh_description() + "</td>");
					out.print("<td>" + tsh.getTsh_amount() + "</td>");
					out.print("</tr>");
					// System.out.println(tsh);
				}
			}
		} else {
			response.sendRedirect("./");
		}

	}

}
