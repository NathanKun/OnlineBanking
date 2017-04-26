package servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joda.time.DateTime;

import dao.DaoClient;
import dao.DaoHoldingShare;
import dao.DaoStock;
import dao.DaoTransactionHistory;
import model.Account;
import model.Client;
import model.HoldingShare;
import model.TransactionHistory;

/**
 * Servlet implementation class TradeStock
 * 
 * @author Junyang HE
 */
@WebServlet(description = "Buy or sell stock for a client", urlPatterns = { "/TradeStock" })
public class TradeStock extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("./stock.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ticker = (String) request.getSession().getAttribute("ticker");
		Client clt = (Client) request.getSession().getAttribute("client");

		String action = request.getParameter("tradeAction"); // Acheter/Vendre
		int nbShares = Integer.valueOf(request.getParameter("nbShares"));
		String price = request.getParameter("price");

		if (clt != null) {
			// sell stocks
			if (action.equals("Vendre")) {
				ArrayList<HoldingShare> hdsList = clt.getHoldingShare();
				boolean isHdsFound = false;

				for (HoldingShare hds : hdsList) { // find the holding share of
													// this ticker
					if (hds.getHds_stk_ticker().equals(ticker)) {
						if (hds.getHds_numberOfShares() >= nbShares) { // nbShares
																		// control
							isHdsFound = true;
							Account acc = clt.getSecuritiesAccount();

							// add money to account
							acc.setAcc_balance(acc.getAcc_balance()
									.add(new BigDecimal(Double.valueOf(price) * Integer.valueOf(nbShares))));
							acc.push();

							// add transaction history
							DaoTransactionHistory.addTransactionHistory(new TransactionHistory(0, acc.getAcc_number(),
									"Vendre " + nbShares + "action(s) de " + DaoStock.getStock(ticker).getStk_name(),
									new DateTime(), new BigDecimal(Double.valueOf(price) * Integer.valueOf(nbShares))));

							// delete(sold all) the holding share
							if (hds.getHds_numberOfShares() == nbShares) {
								DaoHoldingShare.deleteHoldingShare(hds.getHds_id());
							} else { // update(sell a part) hds
								hds.setHds_numberOfShares(hds.getHds_numberOfShares() - nbShares);
								DaoHoldingShare.updateHoldingShare(hds);
							}

							// refresh object client in session
							request.getSession().removeAttribute("client");
							request.getSession().setAttribute("client", DaoClient.getClient(clt.getClt_id()));

							response.getWriter().print("Done");

						} else {// wont't happen normally, controlled by
								// javascript in browser side
							response.getWriter().print("HoldingShare not enough");
						}
					}
				}
				if (!isHdsFound) { // wont't happen normally
					response.getWriter().print("HoldingShare not found");
				}
			}
			// buy stocks
			else if (action.equals("Acheter")) {
				if (clt.getSecuritiesAccount() == null) { // wont't happen
															// normally,
															// controlled in
															// stock.jsp
					response.getWriter().print("No account");
				} else {
					Account acc = clt.getSecuritiesAccount();

					if (acc.getAcc_balance().doubleValue() < (Double.valueOf(price) * Integer.valueOf(nbShares))) { // account
																													// balance
																													// check
						response.getWriter().print("No enough money");
					} else {
						// subtract money in account
						acc.setAcc_balance(acc.getAcc_balance()
								.subtract(new BigDecimal(Double.valueOf(price) * Integer.valueOf(nbShares))));
						acc.push(); // update account to database

						DaoTransactionHistory.addTransactionHistory(new TransactionHistory(0, acc.getAcc_number(),
								"Acheter " + nbShares + "action(s) de " + DaoStock.getStock(ticker).getStk_name(),
								new DateTime(), new BigDecimal(Double.valueOf(price) * Integer.valueOf(nbShares))
										.multiply(new BigDecimal(-1))));

						ArrayList<HoldingShare> hdsList = clt.getHoldingShare();
						boolean isHdsFound = false;
						for (HoldingShare hds : hdsList) { // find the holding
															// share of
															// this ticker
							if (hds.getHds_stk_ticker().equals(ticker)) {
								isHdsFound = true;
								hds.setHds_numberOfShares(hds.getHds_numberOfShares() + nbShares);
								DaoHoldingShare.updateHoldingShare(hds);
							}
						}

						if (!isHdsFound) {
							// add holding share in database
							DaoHoldingShare.addHoldingShare(
									new HoldingShare(0, ticker, acc.getAcc_id(), nbShares, new DateTime()));
						}

						// refresh object client in session
						request.getSession().removeAttribute("client");
						request.getSession().setAttribute("client", DaoClient.getClient(clt.getClt_id()));

						response.getWriter().print("Done");
					}
				}
			}
		} else {
			response.sendRedirect("./Login");
		}

	}

}
