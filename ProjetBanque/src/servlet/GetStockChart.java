package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joda.time.DateTime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import dao.DaoStock;
import util.FixYahooFinance;
import util.FusionCharts;
import util.JsonReader;

/**
 * Servlet implementation class GetStockChart
 * @author Junyang HE, Boubeker BENJILANY
 */
@WebServlet("/GetStockChart")
public class GetStockChart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/**
		 * Here we get the parameters
		 */
		String ticker = request.getParameter("ticker");
		String width = request.getParameter("width");
		System.out.println("width = " + width);

		String title = "";

		int chartWidth = 800;
		if(width != null){
			chartWidth = (int) (Integer.valueOf(width) * 0.60);
			if(Integer.valueOf(width) < 800){
				chartWidth = 500;
			}
		}


		if(ticker == null){
			ticker = "^FCHI";
			title = "CAC40";
		}
		request.getSession().setAttribute("ticker", ticker);
		// %5EF convert to ^ automatically
		/*
		if(ticker.equals("%5EFCHI"))
			ticker = "^FCHI";*/
		title = DaoStock.getStock(ticker).getStk_name();
		title = "test";
		FixYahooFinance.get_yahoo_crumb();
		
		DateTime today = new DateTime();
		String url = "https://query1.finance.yahoo.com/v7/finance/download/" + "SOP.PA" + 
				"?period1=" + today.minusMonths(6).getMillis()/1000 + 
				"&period2=" + today.getMillis()/1000 + 
				"&interval=" + "1d" + 
				"&events=history&crumb=" + FixYahooFinance.getCrumb();
		System.out.println(FixYahooFinance.getCookie());
		System.out.println(FixYahooFinance.getCrumb());
		System.out.println(url);
		JSONObject jsonObj = null;
		try {	// try connect
			jsonObj = JsonReader.readJsonFromUrl(url, FixYahooFinance.getCookie());
		} catch (JSONException | IOException e) {
			e.printStackTrace();
		}
		try {
			// get the result set
			JSONArray array = jsonObj.getJSONArray("stock");
			JSONArray array2 = new JSONArray();
			JSONObject jobj = null;
			for(int i = 0; i < array.length(); i++) {
				jobj = (JSONObject) array.get(i);
				jobj.remove("Open");
				jobj.remove("High");
				jobj.remove("Low");
				jobj.remove("Adj Close");
				jobj.remove("Volume");
				array2.put(jobj);
			}
			jsonObj.remove("stock");
			jsonObj.put("data", array2);
		} catch (JSONException e) {
			e.printStackTrace();
		}

		String jsonStr = jsonObj.toString();

		jsonStr = jsonStr.replace("Date", "label");
		jsonStr = jsonStr.replace("Close", "value");

		FusionCharts chart = new FusionCharts(
				// chartType
				"line",
				// chartId
				"chart1",
				// chartWidth, chartHeight
				String.valueOf(chartWidth), String.valueOf(chartWidth * 0.5625),
				// chartContainer
				"chart",
				// dataFormat
				//"json",
				//"{\"results\": {},\"data\": [{\"label\": \"Jan\",\"value\": \"420000\"}, {\"label\": \"Feb\",\"value\": \"810000\"}]}");
				"json",
				"{\"chart\": {" +
				        "\"caption\": \"" + title + "\"," +
				        "\"subcaption\": \"Source: Yahoo Finance.\"," +
				        "\"axis\": \"linear\"," +
				        "\"numberprefix\": \"€\"," +
				        "\"formatnumberscale\": \"0\"," +
				        "\"allowpinmode\": \"0\"," +
				        "\"enableiconmousecursors\": \"0\"," +
				        "\"dynamicaxis\": \"1\"," +
				        "\"showlegend\": \"0\"," +
				        "\"slantlabels\": \"1\"," +
				        "\"rotatelabels\": \"1\"," +
				        "\"bgcolor\": \"FFFFFF\"," +
				        "\"showalternatehgridcolor\": \"0\"," +
				        "\"showplotborder\": \"0\"," +
				        "\"showvalues\": \"0\"," +
				        "\"divlinecolor\": \"CCCCCC\"," +
				        "\"showcanvasborder\": \"0\"," +
				        "\"linecolor\": \"008ee4\"," +
				        "\"showshadow\": \"0\"," +
				        "\"linethickness\": \"3\"," +
				        "\"captionpadding\": \"20\"," +
				        "\"canvasbottommargin\": \"30\"," +
				        "\"yaxisvaluespadding\": \"10\"," +
				        "\"setAdaptiveYMin\": \"1\"," +
				        "\"compactDataMode\": \"0\"," +
				        "\"scrollcolor\": \"CCCCCC\"},"
				+ jsonStr.substring(1));

		request.getSession().setAttribute("chart", chart);
		request.getSession().setAttribute("title", title);
		response.sendRedirect("./stock.jsp");

		
	}
}
