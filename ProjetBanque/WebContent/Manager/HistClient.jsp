<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="./includes/session.inc.jsp"%>
<%@ page
   import="model.Client,model.TransactionHistory, dao.DaoClient, model.Account, dao.DaoAccount, java.util.ArrayList,java.math.BigDecimal, org.joda.time.format.DateTimeFormat" %>
 <%
String name = request.getParameter("name");
String message = "",fname="",lname="",actionnumber="";
String type= request.getParameter("type");
BigDecimal amount1 = new BigDecimal("0");
BigDecimal amount2 = new BigDecimal("0");
BigDecimal amount3 = new BigDecimal("0");
Client clt = DaoClient.findClientByName2(name);
ArrayList<TransactionHistory> tshList1 = null;
ArrayList<TransactionHistory> tshList2 = null;
ArrayList<TransactionHistory> tshList3 = null;
session.setAttribute("name", name);
if (clt != null){
		amount1= clt.getCurrentAccount().getAcc_balance();
		session.setAttribute("amount1", amount1);
		tshList1 = clt.getCurrentAccount().getTransactionHistory();
		session.setAttribute("tshList1", tshList1);
		fname=clt.getClt_fname();
		lname=clt.getClt_lname();
		session.setAttribute("fname",fname);
		session.setAttribute("lname",lname);
		
		if ( clt.getSavingAccount()!=null){
		amount2= clt.getSavingAccount().getAcc_balance();
		session.setAttribute("amount2", amount2);
		tshList2 = clt.getSavingAccount().getTransactionHistory();
		session.setAttribute("tshList2", tshList2);
		
		}
		
		if ( clt.getSecuritiesAccount()!=null){
		
		tshList3 = clt.getSecuritiesAccount().getTransactionHistory();
		session.setAttribute("tshList3", tshList3);
		}
		
}
else{message="Aucun client trouvé, veuillez verifier le nom";
session.setAttribute("message", message);}
%>


<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>SB Admin 2 - Bootstrap Admin Theme</title>

<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- MetisMenu CSS -->
<link href="css/metisMenu.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="css/sb-admin-2.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

	<div id="wrapper">


		<%@ include file="./includes/nav.inc.jsp"%>

		<!-- Page Content -->
		<div id="page-wrapper">

			<div class="container">
				<div class="row">
					
					<!-- /.panel-heading -->
						<div class="col-md-3">
							<table class="table table-striped table-bordered table-hover"
								id="dataTables-example">
								<thead>
									<tr>
										<th>Nom du Client</th>
										
									</tr>
								</thead>
								<tbody>
									<c:forEach var="clt" items="${clientList}">

										<!-- Generate table -->
										<tr class="gradeA">
											<td> <a href="./HistClient.jsp?name=${clt.getClt_lname()}&send=+Rechercher" ><c:out value="${clt.getFullName()}"></c:out></a></td>
											
										</tr>
									</c:forEach>
								</tbody>
							</table>
					</div>
					
					<div class="col-md-9">
					<form class="form-horizontal" id="SearchClient" action="HistClient.jsp" onsubmit="return transferSubmit();" method="get" accept-charset="UTF-8">
						
						<div class="panel with-nav-tabs panel-info">
							<div class="panel-heading">
							
					<ul> <h3>
								Client:
								<c:out value="${lname}"></c:out> 
								<c:out value="${fname} "></c:out></h3></ul>
								<ul class="nav nav-tabs">
									
									
									<li  ><a href="#courant" data-toggle="tab">Historique compte courant</a></li>
									<li><a href="#epargne" data-toggle="tab">Historique compte épargne </a></li>
									<li><a href="#titre" data-toggle="tab" >Historique compte titre </a></li>
									<li><a href="#solde" data-toggle="tab" >Solde des comptes </a></li>
								
								</ul>
							</div>
							<div class="panel-body">
								<div class="tab-content">
									<div class="tab-pane fade in active" id="courant" >
								
						<%if(message.equals("Aucun client trouvé, veuillez verifier le nom")){ %>
						<c:out value="${message}"></c:out>
						<%} 
						else 
						{ %>	
								
								<table class="table table-striped table-bordered table-hover"
								id="dataTables-example">
								
								<thead>
									<tr>
										<th>Date</th>
										<th>Description</th>
										<th>Montant</th>
										
									</tr>
								</thead>
								<tbody>
									
									<c:forEach var="tsh" items="${tshList1}">
										<!-- Generate table -->
										<tr class="gradeA">
											<td><c:out value="${tsh.getTsh_transactionOn().toString(DateTimeFormat.forPattern(\"yyyy/MM/dd\"))}"></c:out></td>
											<td><c:out value="${tsh.getTsh_description()} "></c:out></td>
											<td><c:out value="${tsh.getTsh_amount()} "></c:out></td>
										
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<% } %>				
											
											
											
																								
									</div>
									<div class="tab-pane fade" id="epargne">
									<br>
									<%if(message.equals("Aucun client trouvé, veuillez verifier le nom")){ %>
						<c:out value="${message}"></c:out>
						<%} 
						else 
						{ %>
									<table class="table table-striped table-bordered table-hover"
								id="dataTables-example">
								<thead>
									<tr>
										<th>Date</th>
										<th>Description</th>
										<th>Montant</th>
										
									</tr>
								</thead>
								<tbody>
									
									<c:forEach var="tsh" items="${tshList2}">


										<!-- Generate table -->
										<tr class="gradeA">
											<td><c:out value="${tsh.getTsh_transactionOn().toString(DateTimeFormat.forPattern(\"yyyy/MM/dd\"))}"></c:out></td>
											<td><c:out value="${tsh.getTsh_description()} "></c:out></td>
											<td><c:out value="${tsh.getTsh_amount()} "></c:out></td>
										
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<%} %>
							</div>
							
									<div class="tab-pane fade" id="titre" > 
									<br>
									<%if(message.equals("Aucun client trouvé, veuillez verifier le nom")){ %>
						<c:out value="${message}"></c:out>
						<%} 
						else 
						{ %>
									<table class="table table-striped table-bordered table-hover"
								id="dataTables-example">
								<thead>
									<tr>
										<th>Date</th>
										<th>Description</th>
										<th>Montant</th>
										
									</tr>
								</thead>
								<tbody>
									
									<c:forEach var="tsh" items="${tshList3}">


										<!-- Generate table -->
										<tr class="gradeA">
											<td><c:out value="${tsh.getTsh_transactionOn().toString(DateTimeFormat.forPattern(\"yyyy/MM/dd\"))}"></c:out></td>
											<td><c:out value="${tsh.getTsh_description()} "></c:out></td>
											<td><c:out value="${tsh.getTsh_amount()} "></c:out></td>
										
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<%} %>
									</div>
									<div class="tab-pane fade" id="solde">
									<br>
									<%if(message.equals("Aucun client trouvé, veuillez verifier le nom")){ %>
						<c:out value="${message}"></c:out>
						<%} 
						else 
						{ %>		<table class="table table-striped table-bordered table-hover"
								id="dataTables-example">
								<thead>
									<td>Compte courant (€):</td> 
									<td>Compte epargne (€):</td> 
									</tr>
									</thead>
									<tbody>
									<tr>
									<td><c:out value="${amount1}"></c:out></td>
									<td><c:out value="${amount2}"></c:out></td>
									</tr>
									</tbody>
									</table>
									<%} %>
									
									</div>

								</div>
							</div>
						</div>
						</form>
					</div>
					
				</div>
			
		        <!-- Footer -->
		        <%@ include file="./includes/footer.inc.jsp"%>
			</div>

			<!-- /#page-wrapper -->

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
