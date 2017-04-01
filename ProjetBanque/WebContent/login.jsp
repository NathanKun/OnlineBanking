<%	
	// get entered login if redirection by login failed (login/password incorrect)
	String login = (String)request.getAttribute("login"); 
	String hint = "";
	if (login == null)
		login = "";
	else
		hint = "ID ou mot de passe incorrect";
%>
<!DOCTYPE html>
<html>
<head>
	<title>Page Connexion</title>
    <meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="login.css">
</head>

<body>
	<%   
   		// if logged in  
   		if(session.getAttribute("client")!=null) {  
   			response.sendRedirect("./AccueilClient.jsp");
   		}
	%> 
	<div id="bandeau">menu horizontal ? image ?</div>
	<div id="menu">Menu ???</div>

	<div id="contenu">
		<form action="http://localhost:8080/ProjetBanque/Login" method="post">
			<fieldset>
				<legend>Vos Identifiants :</legend>
				<label for="login"> Identifiant :</label> 
				<input type="text" name="login" size="20" maxlength="30" id="login" value='<%=login%>' required /> 
				<label for="password"> Mot de passe :</label> 
				<input type="password" size="20" name="password" maxlength="30" id="password" required />
				<label id="hint"><%=hint%></label> 
			</fieldset>
			<p>
				<input type="submit" value="Connexion" />
			</p>
		</form>
	</div>
	<div id="newcli">
		<p>Pas encore client de notre banque ?</p>
		<label for="Ide"><a href="./subscribe.html">CrÃ©er votre </a></label>
	</div>

	<div id="piedpage">Ceci est le pied de page</div>
</body>

</html>