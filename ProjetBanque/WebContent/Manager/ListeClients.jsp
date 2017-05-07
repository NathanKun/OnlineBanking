<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page
	import="java.util.ArrayList, dao.DaoClient, model.Client, org.apache.commons.lang3.StringUtils"%>
<%
	ArrayList<Client> clientList = DaoClient.getClientList();
	session.setAttribute("clientList", clientList);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>Liste Clients</title>
<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- MetisMenu CSS -->
<link href="css/metisMenu.min.css" rel="stylesheet">
<!-- DataTables CSS -->
<link href="css/dataTables.bootstrap.css" rel="stylesheet">
<!-- DataTables Responsive CSS -->
<link href="css/dataTables.responsive.css" rel="stylesheet">
<!-- Custom CSS -->
<link href="css/sb-admin-2.css" rel="stylesheet">
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
					<h1 class="page-header">Comptes clients</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">
							<b>Liste des clients de la banque</b>
						</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
							<table class="table table-striped table-bordered table-hover"
								id="dataTables-example">
								<thead>
									<tr>
										<th>Nom du Client</th>
										<th>Numéro du Client</th>
										<th>Numéro de compte</th>
										<th>IBAN</th>
										<th>Solde du compte courant</th>
										<th>Somme des dépôts</th>
									</tr>
								</thead>
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

										<!-- Generate table -->
										<tr class="gradeA">
											<td><c:out value="${clt.getFullName()}"></c:out></td>
											<td><c:out value="${clt.getClt_login()}"></c:out></td>
											<td><c:out
													value="${clt.getCurrentAccount().getAcc_number()}"></c:out></td>
											<td><c:out
													value="${clt.getCurrentAccount().getAcc_iban()}"></c:out></td>
											<td><c:out
													value="${clt.getCurrentAccount().getAcc_balance()}"></c:out></td>
											<td><c:out value="${clientDepotSomme}"></c:out></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<!-- /.table-responsive -->
							<div class="well">
								<h4>
									Somme des soldes de compte courrant clients :
									<c:out value="${totalCurrent}"></c:out>
								</h4>
								<h4>
									Somme des soldes de compte épargne clients :
									<c:out value="${totalSaving}"></c:out>
								</h4>
								<h4>
									Somme des dépots clients :
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
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-6">
					<div class="panel panel-default">
						<div class="panel-heading">
							<b>Liste des clients ayant un compte épargne</b>
						</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
							<div class="table-responsive">
								<table class="table table-striped table-bordered table-hover">
									<thead>
										<tr>
											<th>Nom Client</th>
											<th>Numéro de compte</th>
											<th>Solde du compte</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="clt" items="${clientList}">
											<c:if test="${not empty clt.getSavingAccount()}">
												<tr class="gradeA">
													<td><c:out value="${clt.getFullName()}"></c:out></td>
													<td><c:out
															value="${clt.getSavingAccount().getAcc_number()}"></c:out></td>
													<td><c:out
															value="${clt.getSavingAccount().getAcc_balance()}"></c:out></td>
												</tr>
											</c:if>
										</c:forEach>
									</tbody>
								</table>
							</div>
							<!-- /.table-responsive -->
						</div>
						<!-- /.panel-body -->
					</div>
					<!-- /.panel -->
				</div>
				<div class="col-lg-6">
					<div class="panel panel-default">
						<div class="panel-heading">
							<b>Liste des clients ayant un compte titre</b>
						</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
							<div class="table-responsive">
								<table class="table table-striped table-bordered table-hover">
									<thead>
										<tr>
											<th>Nom Client</th>
											<th>Numéro de compte</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="clt" items="${clientList}">
											<c:if test="${not empty clt.getSecuritiesAccount()}">
												<tr class="gradeA">
													<td><c:out value="${clt.getFullName()}"></c:out></td>
													<td><c:out
															value="${clt.getSecuritiesAccount().getAcc_number()}"></c:out></td>
												</tr>
											</c:if>
										</c:forEach>
									</tbody>
								</table>
							</div>
							<!-- /.table-responsive -->
							<!-- /.table-responsive -->
						</div>
						<!-- /.panel-body -->
					</div>
					<!-- /.panel -->
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
	<!-- DataTables JavaScript -->
	<script src="js/jquery.dataTables.min.js"></script>
	<script src="js/dataTables.bootstrap.min.js"></script>
	<script src="js/dataTables.responsive.js"></script>
	<!-- Custom Theme JavaScript -->
	<script src="js/sb-admin-2.min.js"></script>
	<!-- Page-Level Demo Scripts - Tables - Use for reference -->
	<script>
		$(document).ready(function() {
			$('#dataTables-example').DataTable({
				responsive : true
			});
		});
	</script>
</body>
</html>