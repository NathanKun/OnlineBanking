<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page
	import="java.util.ArrayList, java.io.IOException, util.FusionCharts, util.HttpUtil,
     	dao.DaoStock, model.Client, model.Stock, model.HoldingShare"%>
<%
	Client clt = (Client) session.getAttribute("client");
	FusionCharts chart = (FusionCharts) session.getAttribute("chart");
	String ticker = (String) session.getAttribute("ticker");
	String title = (String) session.getAttribute("title");
	if (chart == null) {
		response.sendRedirect("./GetStockChart");
		return;
	} else {
		request.setAttribute("stockList", DaoStock.getStockList());
		String csv = "";
		try {
			csv = HttpUtil.get("http://finance.yahoo.com/d/quotes.csv?s=" + ticker + "&f=l1d1t1c1ohg&e=.csv");

			// Csv in format "price, date, time, variation", split to array
			// Ex: 71.30,"4/11/2017","5:38pm",70.54
			String[] splitedCsv = csv.split(",");

			// remove " around date and time
			splitedCsv[1] = splitedCsv[1].replace("\"", "");
			splitedCsv[2] = splitedCsv[2].replace("\"", "");

			// date in format MM/dd/yyyy, split to array
			// Ex: 4/11/2017
			String[] splitedDate = splitedCsv[1].split("/");
			// reconstruct date to format dd-MM-YYYY
			splitedCsv[1] = splitedDate[1] + "-" + splitedDate[0] + "-" + splitedDate[2];
			session.setAttribute("stockData", splitedCsv);
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<title>BankRading - Bourse</title>
<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- Custom CSS -->
<link href="css/modern-business.css" rel="stylesheet">
<!-- Custom Fonts -->
<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">
<link href="css/stock.css" rel="stylesheet">
<!-- Preloader -->
<link href="css/preloader.css" rel="stylesheet">
<script src="./js/fusioncharts.js"></script>
</head>
<body>
    <div class="preloader"></div>
	<%@ include file="./includes/nav.inc.jsp"%>
	<!-- Page Content -->
	<div class="container">
		<!-- Page Heading/Breadcrumbs -->
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">
					Bourse <small>BanKrading</small>
				</h1>
				<ol class="breadcrumb">
					<li><a href="index.jsp">Accueil</a></li>
					<li class="active">Home</li>
				</ol>
			</div>
		</div>
		<!-- /.row -->
		<aside>
			<ul>
				<c:forEach var="stock" items="${stockList}">
					<c:if test="${stock.getStk_ticker() != '^FCHI'}">
						<li><a href="./GetStockChart?ticker=${stock.getStk_ticker()}"
							onclick="location.href=this.href+'&width='+$(window).width();return false;">
								${stock.getStk_name()}</a></li>
					</c:if>
				</c:forEach>
			</ul>
		</aside>
		<section>
			<div class="sectionRow">
				<h3><%=title%></h3>
				<!-- Add some space between elements -->
				<p>
					Cours :
					<%=splitedCsv[0]%>
					&nbsp;&nbsp;&nbsp;&nbsp;Date :
					<%=splitedCsv[1]%>
					&nbsp;&nbsp;&nbsp;&nbsp; Heure :
					<%=splitedCsv[2]%>
					&nbsp;&nbsp;&nbsp;&nbsp;Variation :
					<%=splitedCsv[3]%>
					<c:choose>
						<c:when test="${Double.valueOf(stockData[3]) > 0}">
							<span class="green">↗</span>
						</c:when>
						<c:otherwise>
							<span class="red">↘</span>
						</c:otherwise>
					</c:choose>
				</p>
			</div>
			<div class="row">
				<div class="col-md-8">
					<div id="chart"></div>
				</div>
			</div>
			<%
				if (clt != null) {
							if (clt.getSecuritiesAccount() != null) {
								ArrayList<HoldingShare> hdsList = clt.getHoldingShare();
								int nbShares = 0;
								for (HoldingShare hds : hdsList) {
									if (hds.getHds_stk_ticker().equals((String) session.getAttribute("ticker"))) {
										nbShares = hds.getHds_numberOfShares();
									}
								}
								request.setAttribute("nbShares", nbShares);
			%>
			<div class="row">
				<div class="col-md-8">
					<h4>
						Vous avez
						<%=nbShares%>
						action(s).
					</h4>
				</div>
			</div>
			<div class="row">
				<c:if test="${nbShares > 0}">
					<h3>Vendre</h3>
					<form id="sellForm" action="./TradeStock" method="post">
						<div class="form-group">
							<div class="col-md-4">
								<input id="sellShare" name="nbShares" type="number"
									max="${nbShares}" min="0" value="0"
									onchange="sellShareOnchange();" onkeypress="this.onchange();"
									onpaste="this.onchange();" oninput="this.onchange();" required
									class="form-control input-md"> <input id="priceSell"
									name="price" type="hidden" value="<%=splitedCsv[0]%>">
								<input id="sellAction" name="tradeAction" type="hidden"
									value="Vendre"> <label id="lbReceive"></label>
							</div>
							<div class="col-md-4">
								<input id="submitSell" type="submit" class="btn btn-primary"
									value="Vendre" disabled>
							</div>
							<div class="form-group">
								<div class="col-md-8">
									<label id="lbInfo1">* Le montant final depend au cours
										du moment ou la vente effectue.</label>
								</div>
							</div>
							<label id="sellHint" class="col-md-4 control-label"></label>
						</div>
					</form>
				</c:if>
			</div>
			<div class="row">
				<h3>Acheter</h3>
				<form id="buyForm" action="./TradeStock" method="post">
					<div class="form-group">
						<div class="col-md-4">
							<input id="buyShare" name="nbShares" type="number" min="0"
								value="0" onchange="buyShareOnchange();"
								onkeypress="this.onchange();" onpaste="this.onchange();"
								oninput="this.onchange();" required
								class="form-control input-md"> <input id="priceBuy"
								name="price" type="hidden" value="<%=splitedCsv[0]%>"> <input
								id="buyAction" name="tradeAction" type="hidden" value="Acheter">
							<label id="lbPay"></label>
						</div>
						<div class="col-md-4">
							<input id="submitBuy" type="submit" disabled
								class="btn btn-primary" value="Acheter">
						</div>
						<div class="form-group">
							<div class="col-md-8">
								<label id="lbInfo2">* Le montant final depend au cours
									du moment ou l'achat effectue.</label>
							</div>
						</div>
						<label id="buyHint" class="col-md-4 control-label"></label>
					</div>
				</form>
			</div>
		</section>
		<%
			} // securitiesAccount != null
						else {
		%>
		<h3>Vous devez créer un compte de titre pour acheter ou vendre
			des actions.</h3>
		<%
			}

					} // client != null
					else {
		%>
		<h3>Identifiez-vous pour acheter ou vendre des actions.</h3>
		<%
			}
		%>
		<hr>
		<!-- Footer -->
		<%@ include file="./includes/footer.inc.jsp"%>
	</div>
	<!-- /.container -->
	<!-- jQuery -->
	<script src="js/jquery.js"></script>
	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>
	<script>
		window.onload = function() {
			document.getElementById("bourse").className = "dropdown active";
			$(".preloader").delay(300).fadeOut(500);
		}

		// control sellShare input when it change
		function sellShareOnchange() {
			var sellShare = $("#sellShare");
			var price = $("#priceSell");
			if (sellShare.val() == "") {
				sellShare.val(0);
			}
			if (sellShare.val() == 0) {
				submitSell.disabled = true;
			} else {
				submitSell.disabled = false;
			}
			if (sellShare.val() > sellShare.prop("max")) {
				sellShare.val(sellShare.prop("max"));
			}
			$("#lbReceive").text(
					"Vous allez recevoir " + (price.val() * sellShare.val())
							+ "€");
		}

		// control buyShare input when it change
		function buyShareOnchange() {
			var buyShare = $("#buyShare");
			var price = $("#priceBuy");
			if (buyShare.val() == "") {
				buyShare.val(0);
			}
			if (buyShare.val() == 0) {
				submitBuy.disabled = true;
			} else {
				submitBuy.disabled = false;
			}
			$("#lbPay").text(
					"Vous allez payer "
							+ (price.val() * buyShare.val()).toFixed(2) + "€");
		}

		// Sell stock by Ajax, action depends on responseText
		$(document).on("submit", "#sellForm",
						function() {
							var $form = $(this);
							$.post($form.attr("action"), $form.serialize(),
								function(responseText) {
									if (responseText == "HoldingShare not found") {
										$("#sellHint").text("Vous n'avez pas cette action dans votre compte!");
										$("#sellHint").css('color', 'red');
									} else if (responseText == "HoldingShare not enough") {
										$("#sellHint").text("Vous n'avez pas assez d'action pour vendre dans votre compte!");
										$("#sellHint").css('color', 'red');
									} else if (responseText == "Done") {
										$("#sellHint").text("La vente est bien réussie");
										$("#sellHint").css('color', 'green');
										window.location.reload();
									} else {
										alert("responseText = " + responseText);
									}
								});
							event.preventDefault(); // Important! Prevents submitting the form.
						});

		// Buy stock by Ajax, action depends on responseText
		$(document).on("submit", "#buyForm", 
				function() {
							var $form = $(this);
							$.post($form.attr("action"), $form.serialize(),
								function(responseText) {
									if (responseText == "No account") {
										$("#buyHint").text("Vous n'avez pas de compte de titre!");
										$("#buyHint").css('color', 'red');
									} else if (responseText == "No enough money") {
										$("#buyHint").text("Vous n'avez pas assez d'argent dans votre compte de titre!");
										$("#buyHint").css('color', 'red');
									} else if (responseText == "Done") {
										$("#buyHint").text("L'achat est bien réussi!");
										$("#buyHint").css('color', 'green');
										window.location.reload();
									} else {
										alert("responseText = " + responseText);
									}
								});
							event.preventDefault(); // Important! Prevents submitting the form.
						});
	</script>
</body>
</html>
<%=chart.render()%>
<%
	} catch (IOException e) {
			response.getWriter().print("Connextion failed.");
		} catch (java.lang.ArrayIndexOutOfBoundsException e) {
			response.getWriter().print("No data for stock " + ticker);
		}
	}
%>