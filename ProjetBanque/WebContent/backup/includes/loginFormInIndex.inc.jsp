<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="model.Client"%>

<c:if test="${empty client}">
	<aside id="sidebar">
		<form method="post" action="<%=request.getContextPath()%>/Login">
			<label for="login"> Login : </label>
			<input type="text" name="login" id="login" size="20" maxlength="10" /><br/>
			<label for="password">Password:</label>
			<input type="password" name="password" id="password" /><br>
			<input type="submit" value="Connexion"><br>
			<label><a href="<%=request.getContextPath()%>/Subscribe">Créer votre compte</a></label>
		</form>
	</aside>
</c:if>
<c:if test="${not empty client}">
	<%
		Client clt = (Client) session.getAttribute("client");
	%>
	<aside id="sidebar">
		<p>Bonjour, <%= clt.getClt_lname() %>.</p>
		<a href="./Logout">Déconnexion</a>
	</aside>
</c:if>