<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="model.Client, dao.DaoClient, model.Account, dao.DaoAccount, java.util.ArrayList"%>
<!DOCTYPE html">
<html>
	<head>
		<meta charset="UTF-8">
		<title>Index</title>
    	<link rel="stylesheet" href="./css/global.css" type="text/css">
	</head>
	
	<body>
		<div id="wrapper"><!-- #wrapper -->
			<%@ include file="../includes/header.inc.jsp"%>
		
			<section id="main"><!-- #main content and sidebar area -->
				<section id="content"><!-- #content -->
			
					<c:if test="${empty client}">
							<h3>
								Veuillez vous-identifiez
							</h3>
						</c:if>
						<c:if test="${not empty client}">
					
							<%
								Client clt = (Client) session.getAttribute("client");
								ArrayList<Account> accList = DaoAccount.findAccountByClientId(clt.getClt_id());
								request.setAttribute("accList", accList);
							%>
							
						<p>Bienvenue.</p>
						<p>Votre Solde est de <%=accList.get(0).getAcc_balance()%>euros.</p>
						
						<p>Liste de compte : </p>
						
							<c:forEach var="acc" items="${accList}">
								<p>
									<c:out value="${acc}" />
								</p>
							</c:forEach>
					
							<h5><a href="./Logout">Deconnexion</a></h5>
					
						</c:if>
				
				</section><!-- end of #content -->
				<%@ include file="../includes/loginFormInIndex.inc.jsp"%>
			</section>
			
	</div><!-- #wrapper -->
	</body>
</html>