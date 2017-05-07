<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ include file="./includes/session.inc.jsp"%>
<%@ page
	import="java.util.ArrayList, dao.DaoClient, model.Client, org.apache.commons.lang3.StringUtils"%>
<%
	ArrayList<Client> clientList = DaoClient.getClientList();
	session.setAttribute("clientList", clientList);
%>
<!DOCTYPE html>
<html lang="en">

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
							<table class="table table-striped table-bordered table-hover"
								id="dataTables-example">
								
								<tbody>
									<c:set var="totalDepotSomme" scope="session" value="${0}" />
									<c:set var="totalCurrent" scope="session" value="${0}" />
									<c:set var="totalSaving" scope="session" value="${0}" />
									<c:forEach var="clt" items="${clientList}">
										<!-- Calculate Somme de depot -->
										<c:set var="tshList" scope="session"
											value="${clt.getCurrentAccount().getTransactionHistory()}" />
										<c:set var="clientDepotSomme" scope="session" value="${0}" />
										<c:forEach var="tsh" items="${tshList}">
											<c:if
												test="${fn:contains(tsh.getTsh_description(), 'ajoutés via une carte de type')}">
												<c:set var="clientDepotSomme" scope="session"
													value="${clientDepotSomme + tsh.getTsh_amount()}" />
											</c:if>
										</c:forEach>

										<!-- Calculate totals -->
										<c:set var="totalDepotSomme" scope="session"
											value="${totalDepotSomme + clientDepotSomme}" />
										<c:set var="totalCurrent" scope="session"
											value="${totalCurrent + clt.getCurrentAccount().getAcc_balance()}" />
										<c:if test="${not empty clt.getSavingAccount()}">
											<c:set var="totalSaving" scope="session"
												value="${totalSaving + clt.getSavingAccount().getAcc_balance()}" />
										</c:if>

										
									</c:forEach>
								</tbody>
							</table>
							<!-- /.table-responsive -->
							<div class="well">
								
								<h4>
									Somme des dépots clients (€):
									<c:out value="${totalDepotSomme}"></c:out>
								</h4>
							</div>
						</div>
						<!-- /.panel-body -->
					</div>
					<!-- /.panel -->
				</div>
				<!-- /.col-lg-12 -->
			</div>
			
				
			</div>
			<!-- /.panel-body -->
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

</body>

</html>
