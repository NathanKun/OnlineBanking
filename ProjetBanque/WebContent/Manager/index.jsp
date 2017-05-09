<!--
Add
        <init-param>
		  <param-name>compilerSourceVM</param-name>
		  <param-value>1.8</param-value>
		</init-param>
		<init-param>
		  <param-name>compilerTargetVM</param-name>
		  <param-value>1.8</param-value>
		</init-param>
after
	<servlet-class>org.apache.jasper.servlet.JspServlet</servlet-class>
in
	web.xml of Server
-->



<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ include file="./includes/session.inc.jsp"%>
<%@ page
	import="java.util.ArrayList, java.math.BigDecimal, dao.DaoClient, model.Client, 
		model.Account, model.TransactionHistory, org.apache.commons.lang3.StringUtils, 
		org.joda.time.DateTime, java.util.HashMap, java.util.Map, java.text.DecimalFormat, 
		java.util.LinkedHashMap"%>
<%
	ArrayList<Client> cltList = DaoClient.getClientList();
	session.setAttribute("clientList", cltList);

	DecimalFormat df = new DecimalFormat("00");
	DateTime now = new DateTime();
	int thisYear = now.getYear();
	int thisMonth = now.getYear();

	BigDecimal depotSomme = new BigDecimal(0);
	BigDecimal transactionSomme = new BigDecimal(0);
	BigDecimal currentAccSomme = new BigDecimal(0);
	BigDecimal savingAccSomme = new BigDecimal(0);

	int currentAccNb = cltList.size(), savingAccNb = 0, securitiesAccNb = 0;

	HashMap<String, Integer> transactionNb = new LinkedHashMap<String, Integer>();
	HashMap<String, BigDecimal> transactionTotal = new LinkedHashMap<String, BigDecimal>();
	HashMap<String, Integer> depotNb = new LinkedHashMap<String, Integer>();
	HashMap<String, BigDecimal> depotTotal = new LinkedHashMap<String, BigDecimal>();
	// initial HashMap
	for (int i = 11; i >= 0; i--) {
		int month = now.getMonthOfYear() - i;
		if (month > 0) {
			transactionNb.put(thisYear + "-" + df.format(month), 0);
			transactionTotal.put(thisYear + "-" + df.format(month), BigDecimal.ZERO);
			depotNb.put(thisYear + "-" + df.format(month), 0);
			depotTotal.put(thisYear + "-" + df.format(month), BigDecimal.ZERO);
		} else {
			transactionNb.put((thisYear - 1) + "-" + df.format(12 + month), 0);
			transactionTotal.put((thisYear - 1) + "-" + df.format(12 + month), BigDecimal.ZERO);
			depotNb.put((thisYear - 1) + "-" + df.format(12 + month), 0);
			depotTotal.put((thisYear - 1) + "-" + df.format(12 + month), BigDecimal.ZERO);
		}
	}

	for (Client clt : cltList) {
		Account acc = clt.getCurrentAccount();
		ArrayList<TransactionHistory> tshList = acc.getTransactionHistory();

		// sum up current account total balance
		currentAccSomme = currentAccSomme.add(acc.getAcc_balance());

		for (TransactionHistory tsh : tshList) {
			if (StringUtils.contains(tsh.getTsh_description(), "via une carte de type")) {
				// sum up total save balance
				depotSomme = depotSomme.add(tsh.getTsh_amount());
				
				// sum up tsh number of month and total depot of month
				if (tsh.getTsh_transactionOn().getYear() == thisYear) {
					String key = thisYear + "-" + df.format(tsh.getTsh_transactionOn().getMonthOfYear());
					// Replace the Integer in HashMap
					int newNb = depotNb.get(key).intValue() + 1;
					depotNb.put(key, new Integer(newNb));
					// Replace the BigDecimal in HashMap
					BigDecimal newTotal = depotTotal.get(key).add(tsh.getTsh_amount());
					depotTotal.put(key, newTotal);
				} else {
					String key = (thisYear - 1) + "-" + df.format(tsh.getTsh_transactionOn().getMonthOfYear());
					// Replace the Integer in HashMap
					int newNb = depotNb.get(key).intValue() + 1;
					depotNb.put(key, new Integer(newNb));
					// Replace the BigDecimal in HashMap
					BigDecimal newTotal = depotTotal.get(key).add(tsh.getTsh_amount());
					depotTotal.put(key, newTotal);
				}
			}

			if (StringUtils.contains(tsh.getTsh_description(), "ffectue un virement au compte")) {
				// sum up total transaction amount
				transactionSomme = transactionSomme.add(tsh.getTsh_amount().multiply(new BigDecimal(-1)));
				
				// sum up transfer number of month and total transfer of month
				if (tsh.getTsh_transactionOn().getYear() == thisYear) {
					String key = thisYear + "-" + df.format(tsh.getTsh_transactionOn().getMonthOfYear());
					// Replace the Integer in HashMap
					int newNb = transactionNb.get(key).intValue() + 1;
					transactionNb.put(key, new Integer(newNb));
					// Replace the BigDecimal in HashMap
					BigDecimal newTotal = transactionTotal.get(key).add(tsh.getTsh_amount()
							.multiply(new BigDecimal(-1)));
					transactionTotal.put(key, newTotal);
				} else {
					String key = (thisYear - 1) + "-" + df.format(tsh.getTsh_transactionOn().getMonthOfYear());
					// Replace the Integer in HashMap
					int newNb = transactionNb.get(key).intValue() + 1;
					transactionNb.put(key, new Integer(newNb));
					// Replace the BigDecimal in HashMap
					BigDecimal newTotal = transactionTotal.get(key).add(tsh.getTsh_amount()
							.multiply(new BigDecimal(-1)));
					transactionTotal.put(key, newTotal);
				}
			}
		}

		if (clt.getSavingAccount() != null) {
			// sum up saving accounts number
			savingAccNb++;
			// sum up saving accounts total balance
			savingAccSomme = savingAccSomme.add(clt.getSavingAccount().getAcc_balance());

			acc = clt.getSavingAccount();
			tshList = acc.getTransactionHistory();
			for (TransactionHistory tsh : tshList) {
				if (StringUtils.contains(tsh.getTsh_description(), "via une carte de type")) {
					// sum up total save balance
					depotSomme = depotSomme.add(tsh.getTsh_amount());

					// sum up tsh number of month and total depot of month
					if (tsh.getTsh_transactionOn().getYear() == thisYear) {
						String key = thisYear + "-" + df.format(tsh.getTsh_transactionOn().getMonthOfYear());
						// Replace the Integer in HashMap
						int newNb = depotNb.get(key).intValue() + 1;
						depotNb.put(key, new Integer(newNb));
						// Replace the BigDecimal in HashMap
						BigDecimal newTotal = depotTotal.get(key).add(tsh.getTsh_amount());
						depotTotal.put(key, newTotal);
					} else {
						String key = (thisYear - 1) + "-"
								+ df.format(tsh.getTsh_transactionOn().getMonthOfYear());
						// Replace the Integer in HashMap
						int newNb = depotNb.get(key).intValue() + 1;
						depotNb.put(key, new Integer(newNb));
						// Replace the BigDecimal in HashMap
						BigDecimal newTotal = depotTotal.get(key).add(tsh.getTsh_amount());
						depotTotal.put(key, newTotal);
					}
				}

				if (StringUtils.contains(tsh.getTsh_description(), "ffectue un virement au compte")) {
					// sum up total transaction amount
					transactionSomme = transactionSomme.add(tsh.getTsh_amount().multiply(new BigDecimal(-1)));

					// sum up transfer number of month and total transfer of month
					if (tsh.getTsh_transactionOn().getYear() == thisYear) {
						String key = thisYear + "-" + df.format(tsh.getTsh_transactionOn().getMonthOfYear());
						// Replace the Integer in HashMap
						int newNb = transactionNb.get(key).intValue() + 1;
						transactionNb.put(key, new Integer(newNb));
						// Replace the BigDecimal in HashMap
						BigDecimal newTotal = transactionTotal.get(key).add(tsh.getTsh_amount()
								.multiply(new BigDecimal(-1)));
						transactionTotal.put(key, newTotal);
					} else {
						String key = (thisYear - 1) + "-"
								+ df.format(tsh.getTsh_transactionOn().getMonthOfYear());
						// Replace the Integer in HashMap
						int newNb = transactionNb.get(key).intValue() + 1;
						transactionNb.put(key, new Integer(newNb));
						// Replace the BigDecimal in HashMap
						BigDecimal newTotal = transactionTotal.get(key).add(tsh.getTsh_amount()
								.multiply(new BigDecimal(-1)));
						transactionTotal.put(key, newTotal);
					}
				}
			}
		}
		if (clt.getSecuritiesAccount() != null) {
			// sum up securities accounts number
			securitiesAccNb++;
		}
		
	}

	/*System.out.println("Depot Result: ");
	for (Map.Entry<String, Integer> entry : depotNb.entrySet()) {
		String time = entry.getKey();
		Integer nbMonth = entry.getValue();
		BigDecimal totalMonth = depotTotal.get(time);
		System.out.println(time + " => " + nbMonth + " : " + totalMonth);
	}

	System.out.println("Transaction Result: ");
	for (Map.Entry<String, Integer> entry : transactionNb.entrySet()) {
		String time = entry.getKey();
		Integer nbMonth = entry.getValue();
		BigDecimal totalMonth = transactionTotal.get(time);
		System.out.println(time + " => " + nbMonth + " : " + totalMonth);
	}*/
	
	// Extract list from HashMaps
	ArrayList<String> months = new ArrayList<String>(depotNb.keySet());
	ArrayList<Integer> depotCounts = new ArrayList<Integer>(depotNb.values());
	ArrayList<BigDecimal> depotTotals = new ArrayList<BigDecimal>(depotTotal.values());
	ArrayList<Integer> transactionCounts = new ArrayList<Integer>(transactionNb.values());
	ArrayList<BigDecimal> transactionTotals = new ArrayList<BigDecimal>(transactionTotal.values());

	//System.out.println(months);
%>

<!DOCTYPE html>
<html>

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="La page d'accueil du manager">
<meta name="author" content="Ursula">

<title>Reportings</title>

<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- MetisMenu CSS -->
<link href="css/metisMenu.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="css/sb-admin-2.css" rel="stylesheet">
<!-- Morris Charts CSS
		    	<link href="css/morris.css" rel="stylesheet">
			-->
<!-- Custom Fonts -->
<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">

<link href="css/index.css" rel="stylesheet" type="text/css">

</head>

<body>

	<div id="wrapper">
		<%@ include file="./includes/nav.inc.jsp"%>
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">Reporting</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">

						<div class="panel-body">
							<div class="row">
								<div class="well">
									<h4 class="headerCenter">Somme des solde des compte courant et des compte d'épargne</h4>
									<h5>
										Somme des soldes de compte courrant clients :
										<%=currentAccSomme%>€
									</h5>
									<h5>
										Somme des soldes de compte épargne clients :
										<%=savingAccSomme%>€
									</h5>
									<canvas id="balancesChart"></canvas>
								</div>
								
								<div class="well">
									<h4 class="headerCenter">Nombre de compte courant, d'épargne et de titre</h4>
									<h5>Compte courant : <%=currentAccNb%></h5>
									<h5>Compte d'épargne : <%=savingAccNb%></h5>
									<h5>Compte de titre : <%=securitiesAccNb%></h5>
									<canvas id="accountsNbChart"></canvas>
								</div>
							</div>
							<div class="row">
								<div class="well">
									<h4 class="headerCenter">Historique des dépots</h4>
									<h5>
										Somme des dépots clients :
										<%=depotSomme%>€
									</h5>
									<canvas id="depotChart"></canvas>
								</div>
								
								<div class="well">
								    <h4 class="headerCenter">Historique des transactions</h4>
								    <h5>
								    	Somme des virement :
								    	<%=transactionSomme%>€
								    </h5>
									<canvas id="transactionChart"></canvas>
								</div>
							</div>
						</div>
						<!-- /.panel-body -->
					</div>
					<!-- /.panel -->
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.panel-body -->
			
	        <!-- Footer -->
	        <%@ include file="./includes/footer.inc.jsp"%>
		</div>
		<!-- /.panel -->
	</div>
	<!-- /#wrapper -->

	<!-- jQuery -->
	<script src="js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script src="js/metisMenu.min.js"></script>

	<!-- Custom Theme JavaScript -->
	<script src="js/sb-admin-2.js"></script>

	<!-- Chart.js -->
	<script src="js/Chart.js"></script>

	<script type="text/javascript">
		$(function() {
			// Handler for .ready() called.
			createBalancesChart();
			createAccountsNbChart();
			createDepotChart();
			createTransactionChart();
		});

		function createBalancesChart() {
			var current = <%=currentAccSomme%>;
			var saving = <%=savingAccSomme%>;
			var data = {
				labels : [ "Compte de courant", "Compte d'epargne" ],
				datasets : [ {
					data : [ current, saving ],
					backgroundColor : [ "#FB6D51", "#5E9CEA" ],
					hoverBackgroundColor : [ "#FC8370", "#73B1F4" ]
				} ]
			};

			var chart = new Chart(document.getElementById('balancesChart'), {
				type : 'doughnut',
				data : data,
				options : {
					responsive : true
				}
			});
		}
		
		function createAccountsNbChart() {
			var current = <%=currentAccNb%>;
			var saving = <%=savingAccNb%>;
			var security = <%=securitiesAccNb%>;
			var data = {
				labels : [ "Compte de courant", "Compte d'epargne",
						"Compte de titre" ],
				datasets : [ {
					data : [ current, saving, security ],
					backgroundColor : [ "#EC5564", "#46CEAD", "#AC92EA" ],
					hoverBackgroundColor : [ "#F76D82", "#62DDBD", "#B3A5EF" ]
				} ]
			};

			var chart = new Chart(document.getElementById('accountsNbChart'), {
				type : 'doughnut',
				data : data,
				options : {
					responsive : true
				}
			});
		}
		
		function createDepotChart() {
			var data = {
				    labels: ['<%=months.get(0)%>', '<%=months.get(1)%>', '<%=months.get(2)%>', '<%=months.get(3)%>', 
				    	'<%=months.get(4)%>', '<%=months.get(5)%>', '<%=months.get(6)%>', '<%=months.get(7)%>', 
				    	'<%=months.get(8)%>', '<%=months.get(9)%>', '<%=months.get(10)%>', '<%=months.get(11)%>'],
				    datasets: [
				        {
				            label: "Nombre de dépôt (Gauche)",
				            data: <%=depotCounts%>,
				            yAxisID: "y-depotCounts",
				            fill: false,
				            lineTension: 0.15,
				            backgroundColor: "rgba(254,205,87,0.4)",
				            borderColor: "rgba(254,205,87,1)",
				            borderCapStyle: 'butt',
				            borderDash: [],
				            borderDashOffset: 0.0,
				            borderJoinStyle: 'miter',
				            pointBorderColor: "rgba(254,205,87,1)",
				            pointBackgroundColor: "#fff",
				            pointBorderWidth: 1,
				            pointHoverRadius: 5,
				            pointHoverBackgroundColor: "rgba(254,205,87,1)",
				            pointHoverBorderColor: "rgba(220,220,220,1)",
				            pointHoverBorderWidth: 2,
				            pointRadius: 1,
				            pointHitRadius: 10,
				            spanGaps: false
				        }, {
				            label: "Montant de dépôt (Droite)",
				            data: <%=depotTotals%>,
				            yAxisID: "y-depotTotals",
				            fill: false,
				            lineTension: 0.15,
				            backgroundColor: "rgba(172,146,234,0.4)",
				            borderColor: "rgba(172,146,234,1)",
				            borderCapStyle: 'butt',
				            borderDash: [],
				            borderDashOffset: 0.0,
				            borderJoinStyle: 'miter',
				            pointBorderColor: "rgba(172,146,234,1)",
				            pointBackgroundColor: "#fff",
				            pointBorderWidth: 1,
				            pointHoverRadius: 5,
				            pointHoverBackgroundColor: "rgba(172,146,234,1)",
				            pointHoverBorderColor: "rgba(220,220,220,1)",
				            pointHoverBorderWidth: 2,
				            pointRadius: 1,
				            pointHitRadius: 10,
				            spanGaps: false
					    }
				    ]
				};

			var myLineChart = new Chart(document.getElementById('depotChart'), {
			    type: 'line',
			    data: data,
			    options: {
			    	  scales: {
			    	      yAxes: [{
			    	    	  position: "left",
			    	            "id": "y-depotCounts"
			    	          }, {
			    	            position: "right",
			    	            "id": "y-depotTotals"
			    	      }]
					}
				}
			});
		}
		
		function createTransactionChart() {
			var data = {
				    labels: ['<%=months.get(0)%>', '<%=months.get(1)%>', '<%=months.get(2)%>', '<%=months.get(3)%>', 
				    	'<%=months.get(4)%>', '<%=months.get(5)%>', '<%=months.get(6)%>', '<%=months.get(7)%>', 
				    	'<%=months.get(8)%>', '<%=months.get(9)%>', '<%=months.get(10)%>', '<%=months.get(11)%>'],
				    datasets: [
				        {
				            label: "Nombre de dépôt (Gauche)",
				            data: <%=transactionCounts%>,
				            yAxisID: "y-depotCounts",
				            fill: false,
				            lineTension: 0.15,
				            backgroundColor: "rgba(75,192,192,0.4)",
				            borderColor: "rgba(75,192,192,1)",
				            borderCapStyle: 'butt',
				            borderDash: [],
				            borderDashOffset: 0.0,
				            borderJoinStyle: 'miter',
				            pointBorderColor: "rgba(75,192,192,1)",
				            pointBackgroundColor: "#fff",
				            pointBorderWidth: 1,
				            pointHoverRadius: 5,
				            pointHoverBackgroundColor: "rgba(75,192,192,1)",
				            pointHoverBorderColor: "rgba(220,220,220,1)",
				            pointHoverBorderWidth: 2,
				            pointRadius: 1,
				            pointHitRadius: 10,
				            spanGaps: false
				        }, {
				            label: "Montant de dépôt (Droite)",
				            data: <%=transactionTotals%>,
				            yAxisID: "y-depotTotals",
				            fill: false,
				            lineTension: 0.15,
				            backgroundColor: "rgba(175,92,192,0.4)",
				            borderColor: "rgba(175,92,192,1)",
				            borderCapStyle: 'butt',
				            borderDash: [],
				            borderDashOffset: 0.0,
				            borderJoinStyle: 'miter',
				            pointBorderColor: "rgba(175,92,192,1)",
				            pointBackgroundColor: "#fff",
				            pointBorderWidth: 1,
				            pointHoverRadius: 5,
				            pointHoverBackgroundColor: "rgba(175,92,192,1)",
				            pointHoverBorderColor: "rgba(220,220,220,1)",
				            pointHoverBorderWidth: 2,
				            pointRadius: 1,
				            pointHitRadius: 10,
				            spanGaps: false
					    }
				    ]
				};

			var myLineChart = new Chart(document.getElementById('transactionChart'), {
			    type: 'line',
			    data: data,
			    options: {
			    	  scales: {
			    	      yAxes: [{
			    	    	  position: "left",
			    	            "id": "y-depotCounts"
			    	          }, {
			    	            position: "right",
			    	            "id": "y-depotTotals"
			    	      }]
					}
				}
			});
		}
	</script>

</body>

</html>
