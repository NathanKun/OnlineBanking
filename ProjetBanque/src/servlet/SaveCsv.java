package servlet;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joda.time.format.DateTimeFormat;

import model.Account;
import model.Client;
import model.TransactionHistory;

/**
 * Servlet implementation class saveCsv
 */
@WebServlet("/SaveCsv")
public class SaveCsv extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getSession().getAttribute("client") != null) {
			String type = (String) request.getParameter("type");
			Client clt = (Client) request.getSession().getAttribute("client");
			// System.out.println(clt.getCurrentAccount());
			ArrayList<TransactionHistory> tshList = null;
			Account acc = null;
			switch (type) {
			case "currentHistory":
				acc = clt.getCurrentAccount();
				tshList = acc.getTransactionHistory();
				break;
			case "savingHistory":
				acc = clt.getSavingAccount();
				tshList = acc.getTransactionHistory();
				break;
			case "securitiesHistory":
				acc = clt.getSecuritiesAccount();
				tshList = acc.getTransactionHistory();
				break;
			}

			BufferedWriter dataOut;
			try {
				System.out.println("Wrinting file...");
				String path = request.getServletContext().getRealPath("WEB-INF/../") + "data.csv";
				dataOut = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path, false),"UTF-8"));
				
				dataOut.write("\"sep=,\"");
				dataOut.write("Client : " + clt.getFullName());
				dataOut.flush();
				dataOut.write("\n");
				dataOut.write("Numéro de compte : " + acc.getAcc_number());
				dataOut.flush();
				dataOut.write("\n");
				dataOut.write("Date,Description,Montant\n");
				dataOut.flush();
				
				for (TransactionHistory tsh : tshList) {
					dataOut.write(tsh.getTsh_transactionOn().toString(DateTimeFormat.forPattern("yyyy/MM/dd")) + ",");
					dataOut.write(tsh.getTsh_description() + ",");
					dataOut.write(String.valueOf(tsh.getTsh_amount()) + ",");
					dataOut.write("\n");
					dataOut.flush();
				}

				dataOut.close();
				System.out.println("File write complete!");
			} catch (Exception e) {
				e.printStackTrace();
			}

			response.sendRedirect(request.getContextPath() + "/data.csv");

			
		} else {
			response.getWriter().print("<h1>Login please</h1>");
		}

	}

}
