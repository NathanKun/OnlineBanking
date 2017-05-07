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

import dao.DaoClient;
import model.Client;
import model.TransactionHistory;

/**
 * Servlet implementation class Transactions
 */
@WebServlet("/Transactions")
public class Transactions extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Transactions() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String login = (String)request.getParameter("login");
		String message = "";
		String type= (String)request.getParameter("type");
		
		Client clt = DaoClient.findClientByLogin(login);
		
		if(clt!= null){
			
			//System.out.println(clt.getCurrentAccount());
			ArrayList<TransactionHistory> tshList = null;
			switch(type){
				case "courant":
					tshList = clt.getCurrentAccount().getTransactionHistory();
				
				/*	case "savingHistory":
					tshList = clt.getSavingAccount().getTransactionHistory();
					break;
				case "securitiesHistory":
					tshList = clt.getSecuritiesAccount().getTransactionHistory();
					break;
			}*/
			
			// write in utf-8
			response.setContentType("text/html; charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			
			for (TransactionHistory tsh : tshList){
				out.print("<tr>");
				out.print("<td>" + tsh.getTsh_transactionOn().toString(DateTimeFormat.forPattern("yyyy/MM/dd")) + "</td>");
				out.print("<td>" + tsh.getTsh_description() + "</td>");
				out.print("<td>" + tsh.getTsh_amount() + "</td>");
				out.print("</tr>");
				//System.out.println(tsh);
			}
			break;
		
	}

		}}}
