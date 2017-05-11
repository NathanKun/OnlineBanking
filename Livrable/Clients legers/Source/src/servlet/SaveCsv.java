package servlet;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
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
 * @author HE Junyang
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
			
			/**
			 * We check that the account exists
			 */
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

			String path = request.getServletContext().getRealPath("WEB-INF/../") + "data.csv";
			BufferedWriter dataOut  = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path, false),"UTF-8"));
			
			try {
				System.out.println("Wrinting file...");
				// UTF-8 BOM to tell excel the file encode in UTF-8
				dataOut.write("\uFEFF");
				// Tell excel to use',' as CSV separator
				dataOut.write("\"sep=,\"\n");
				
				// write file header
				dataOut.write("Client : " + clt.getFullName());
				dataOut.write("\n");
				dataOut.write("Numero de compte : " + acc.getAcc_number());
				dataOut.write("\n");
				
				// write table header
				dataOut.write("Date,Description,Montant\n");
				dataOut.flush();
				
				// write data
				for (TransactionHistory tsh : tshList) {
					dataOut.write(tsh.getTsh_transactionOn().toString(DateTimeFormat.forPattern("yyyy/MM/dd")) + ",");
					dataOut.write(tsh.getTsh_description() + ",");
					dataOut.write(String.valueOf(tsh.getTsh_amount()) + ",");
					dataOut.write("\n");
					dataOut.flush();
				}

				System.out.println("Write file complete!");
			} catch (Exception e) {
				System.out.println("Write file faild!");
				e.printStackTrace();
			} finally {
				dataOut.close();
			}

			response.sendRedirect(request.getContextPath() + "/data.csv");

			
		} else {
			response.sendRedirect("./");
		}

	}

}
