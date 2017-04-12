package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import dao.DaoStock;
import util.FusionCharts;
import util.JsonReader;

/**
 * Servlet implementation class GetStockChart
 * @author Junyang HE
 */
@WebServlet("/GetStockChart")
public class GetStockChart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		
		DateTime today = new DateTime();
		String url = "http://query.yahooapis.com/v1/public/yql?q="
				+ "select%20Date%2C+Close%20"
				+ "from%20yahoo.finance.historicaldata%20"
				+ "where%20symbol%20%3D%20%22" + ticker + "%22%20"
				+ "and%20startDate%20%3D%20%22" 
				+ today.minusMonths(6).toString(DateTimeFormat.forPattern("yyyy-MM-dd")) + "%22%20"
				+ "and%20endDate%20%3D%20%22" 
				+ today.toString(DateTimeFormat.forPattern("yyyy-MM-dd")) + "%22&"
				+ "format=json&diagnostics=false&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys&callback=";
		
		JSONObject jsonObj = null;
		try {	// try connect
			jsonObj = JsonReader.readJsonFromUrl(url);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		try {
			// get the result set
			jsonObj = jsonObj.getJSONObject("query").getJSONObject("results");
			// reverse the order of quote to from old to new (for show in chart)
			JSONArray array = jsonObj.getJSONArray("quote");
			JSONArray reverseArray = new JSONArray();
			for (int i = array.length()-1; i>=0; i--) {
				reverseArray.put(array.get(i));
			}
			jsonObj.remove("quote");
			jsonObj.put("quote", reverseArray);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		String jsonStr = jsonObj.toString();
		
		jsonStr = jsonStr.replace("Date", "label");
		jsonStr = jsonStr.replace("Close", "value");
		jsonStr = jsonStr.replace("quote", "data");
		
		//System.out.println("{\"results\": {}," + jsonStr.substring(1));
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
