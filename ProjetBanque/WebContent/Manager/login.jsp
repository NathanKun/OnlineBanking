<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	// get entered login if redirection by login failed (login/password incorrect)
	String login = (String) request.getAttribute("login");
	String hint = "";
	if (login == null)
		login = "";
	else
		hint = "ID ou mot de passe incorrect";
%>

<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<title>Page d'authentification manager</title>
	<link href="css/manager.css" rel="stylesheet">
	<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-offset-5 col-md-3">
				<div class="form-login">
					<h4>BankRading</h4>
					<form id="frm-Connexion" class="form-horizontal"
						action="./Login" method="post">
						<input type="text" id="login" name="login"
							class="form-control input-sm chat-input" placeholder="login"
							maxlength="20" />
						<input type="text" id="password" name="password"
							class="form-control input-sm chat-input" placeholder="password"
							maxlength="178" />
						<div class="form-group">
							<label class="col-md-4 control-label" for="send"> </label>
							<div class="col-md-4">
								<button id="send" name="send" class="btn btn-primary">
									S'authentifier</button>
							</div>
						</div>
						<p><%=hint%></p>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
