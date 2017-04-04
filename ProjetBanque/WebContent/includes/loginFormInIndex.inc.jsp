<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:if test="${empty client}">
	<aside id="sidebar">
		<form method="post" action="./Login">
			<label for="pseudo"> Login : </label>
			<input type="text" name="login" id="login" size="20" maxlength="10" /><br/>
			<label for="pass">Password:</label>
			<input type="password" name="password" id="password" />
			<input type="submit" value="Connexion">
			<a href="./Subscribe">
			<input type="button" value="S'inscrire" /></a>
		</form>
	</aside>
</c:if>