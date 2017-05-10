package servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Client;
import model.HoldingShare;

/**
 * Servlet implementation class GetMyStockList
 * @author Junyang HE, Boubeker BENJILANY
 */
@WebServlet("/GetMyStockList")
public class GetMyStockList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		/**
		 *  We save  the client in an object clt
		 */
		Client clt = (Client) request.getSession().getAttribute("client");
		
		/**
		 *  We check  if the client exist
		 */
		if (clt == null) {
			response.sendRedirect(".");
		} else {
			
			/**
			 *  We create the arrayliste HoldingShare
			 */
			ArrayList<HoldingShare> hdsList = clt.getHoldingShare();
			StringBuilder s = new StringBuilder();
			for (HoldingShare hds : hdsList) {
				
				/**
				 *  return the stocks' name
				 */
				s.append("<tr><td>");
				s.append(hds.getStock().getStk_name());
				
				/**
				 *  return the number of shares
				 */
				s.append("</td><td>");
				s.append(hds.getHds_numberOfShares());
				/**
				 *  return the stocks' current price
				 */
				s.append("</td><td>");
				s.append(hds.getStock().getCurrentPrice());
				
				/**
				 *  return the transactions' final price
				 */
				s.append("</td><td>");
				s.append(hds.getStock().getCurrentPrice().multiply(new BigDecimal(hds.getHds_numberOfShares())));
				s.append("</td></tr>");
			}
			
			response.setContentType("text/html; charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(s.toString());
		}
	}
}
