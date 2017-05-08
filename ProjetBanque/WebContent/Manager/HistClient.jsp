<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="./includes/session.inc.jsp"%>
<%@ page
   import="model.Client,model.TransactionHistory, dao.DaoClient, model.Account, dao.DaoAccount, java.util.ArrayList,java.math.BigDecimal, org.joda.time.format.DateTimeFormat" %>
 <%
String login = request.getParameter("login");
String message = "";
String type= request.getParameter("type");
BigDecimal amount1 = new BigDecimal("0");
BigDecimal amount2 = new BigDecimal("0");
BigDecimal amount3 = new BigDecimal("0");
Client clt = DaoClient.findClientByLogin(login);
ArrayList<TransactionHistory> tshList1 = null;
ArrayList<TransactionHistory> tshList2 = null;
ArrayList<TransactionHistory> tshList3 = null;
if (clt != null){
		amount1= clt.getCurrentAccount().getAcc_balance();
		session.setAttribute("amount1", amount1);
		tshList1 = clt.getCurrentAccount().getTransactionHistory();
		session.setAttribute("tshList1", tshList1);
		if ( clt.getSavingAccount()!=null){
		amount2= clt.getSavingAccount().getAcc_balance();
		session.setAttribute("amount2", amount2);
		tshList2 = clt.getSavingAccount().getTransactionHistory();
		session.setAttribute("tshList2", tshList2);
		
		}
		
		if ( clt.getSecuritiesAccount()!=null){
		amount3= clt.getSecuritiesAccount().getAcc_balance();
		session.setAttribute("amount3", amount3);
		tshList3 = clt.getSecuritiesAccount().getTransactionHistory();
		session.setAttribute("tshList3", tshList3);
		}
		
}
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

					<div class="col-md-6">
					<form class="form-horizontal" id="SearchClient" action="HistClient.jsp" onsubmit="return transferSubmit();" method="get" accept-charset="UTF-8">
						
						<div class="panel with-nav-tabs panel-info">
							<div class="panel-heading">
							<ul>
							
							<div class="input-group custom-search-form">
						<input type="text" class="form-control" name="login" placeholder="Login client"> 
						<span class="input-group-btn">
							<input type="submit" value=" Rechercher" id="submit" name="send" class="btn btn-primary">
						</span>
						
					</div></ul>
								<ul class="nav nav-tabs">
									
									
									<li class="active" ><a href="#courant" data-toggle="tab"name= "type" value="courant">Historique compte courant</a></li>
									<li><a href="#epargne" data-toggle="tab"name="type" value = "epargne">Historique compte épargne </a></li>
									<li><a href="#titre" data-toggle="tab" name="type" value = "titre">Historique compte titre </a></li>
									<li><a href="#solde" data-toggle="tab" name="type" value = "solde">Solde du compte</a></li>
								
								</ul>
							</div>
							<div class="panel-body">
								<div class="tab-content">
									<div class="tab-pane fade in active" id="courant" >
										<c:forEach var="tsh" items="${tshList1}">
											<c:out value="${tsh.getTsh_description()} "></c:out>
											<br>
											</c:forEach>													
									</div>
									<div class="tab-pane fade" id="epargne">
									<br>
									<c:forEach var="tsh" items="${tshList2}">
											<c:out value="${tsh.getTsh_description()} "></c:out>
											<br>
											</c:forEach></div>
									<div class="tab-pane fade" id="titre" > </div>
									<div class="tab-pane fade" id="solde">Solde des comptes 
									<br>
									Compte courant (€): <c:out value="${amount1}"></c:out>
									<br>
									Compte epargne (€): <c:out value="${amount2}"></c:out>
									<br>
									Compte titre: <c:out value="${amount3}"></c:out>
									</div>

								</div>
							</div>
						</div>
						</form>
					</div>
				</div>
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
