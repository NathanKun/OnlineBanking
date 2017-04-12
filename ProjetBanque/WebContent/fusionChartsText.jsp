<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Loading Data from a Static JSON String - fusioncharts.com</title>
<script src="./js/fusioncharts.js"></script>
</head>
<body>
	<div id="chart"></div>
	<%@page
		import="util.FusionCharts, util.JsonReader, org.json.JSONObject"%>
	<%
		String url = "http://query.yahooapis.com/v1/public/yql?q=select%20Date%2C+Close%20from%20yahoo.finance.historicaldata%20where%20symbol%20%3D%20%22AIR.PA%22%20and%20startDate%20%3D%20%222016-09-11%22%20and%20endDate%20%3D%20%222017-02-11%22&format=json&diagnostics=false&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys&callback=";
		
		JSONObject jsonObj = JsonReader.readJsonFromUrl(url).getJSONObject("query").getJSONObject("results");
		String jsonStr = jsonObj.toString();
		
		jsonStr = jsonStr.replace("Date", "label");
		jsonStr = jsonStr.replace("Close", "value");
		jsonStr = jsonStr.replace("quote", "data");
		
		System.out.println("{\"results\": {}," + jsonStr.substring(1));
		FusionCharts column2dChart = new FusionCharts(
				// chartType
				"line",
				// chartId
				"chart1",
				// chartWidth, chartHeight
				"800", "400",
				// chartContainer
				"chart",
				// dataFormat
				//"json",
				//"{\"results\": {},\"data\": [{\"label\": \"Jan\",\"value\": \"420000\"}, {\"label\": \"Feb\",\"value\": \"810000\"}]}");
				"json", 
				"{\"chart\": {" + 
				        "\"caption\": \"Adobe Inc. Stock Monitor\"," + 
				        "\"subcaption\": \"Daily from 2009-2010. Source: Yahoo Finance.\"," + 
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
	%>

	<%=column2dChart.render()%>
</body>
</html>