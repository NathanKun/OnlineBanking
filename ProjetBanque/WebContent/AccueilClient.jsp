<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="model.Client, dao.DaoClient, model.Account, dao.DaoAccount, java.util.ArrayList"%>
	
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta charset="utf-8">
<title>Accueil Client</title>
</head>

<body>
	<c:if test="${empty client}">
		<h3>
			Veuillez <a href="./login.jsp">vous identifiez</a>
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
</body>
</html>