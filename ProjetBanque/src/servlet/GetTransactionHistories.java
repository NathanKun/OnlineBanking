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
 * @author HE Junyang
 */
@WebServlet("/GetTransactionHistories")
public class GetTransactionHistories extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("client") != null){
			String type = (String) request.getParameter("type");
			Client clt = (Client)request.getSession().getAttribute("client");
			//System.out.println(clt.getCurrentAccount());
			ArrayList<TransactionHistory> tshList = null;
			switch(type){
				case "currentHistory":
					tshList = clt.getCurrentAccount().getTransactionHistory();
					break;
				case "savingHistory":
					tshList = clt.getSavingAccount().getTransactionHistory();
					break;
				case "securitiesHistory":
					tshList = clt.getSecuritiesAccount().getTransactionHistory();
					break;
			}
			
			PrintWriter out = response.getWriter();
			for (TransactionHistory tsh : tshList){
				out.print("<tr>");
				out.print("<td>" + tsh.getTsh_transactionOn().toString(DateTimeFormat.forPattern("yyyy/MM/dd")) + "</td>");
				out.print("<td>" + tsh.getTsh_description() + "</td>");
				out.print("<td>" + tsh.getTsh_amount() + "</td>");
				out.print("</tr>");
				//System.out.println(tsh);
			}
		} else {
			response.getWriter().print("<h1>Login please</h1>");
		}
		
	}

}
