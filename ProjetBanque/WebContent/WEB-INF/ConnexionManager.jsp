<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!doctype html>
<html>
<head>
	<meta charset="utf-8" />
	<title>Page d'authentification manager</title>
	<link href="css/manager.css" rel="stylesheet">
	

</head>
<body>


<div class="container">
    <div class="row">
        <div class="col-md-offset-5 col-md-3">
            <div class="form-login">
            <h4>BankRading</h4>
            <form id="frm-Connexion" class="form-horizontal" action="./Connexion"
					method="post">
            <input type="text" id="login" class="form-control input-sm chat-input" placeholder="login" maxlength= "20" />
            <input type="text" id="password" class="form-control input-sm chat-input" placeholder="password" malength= "178"  />
            <div class="form-group">
                         <label class="col-md-4 control-label" for="send">                                   </label>
                          <div class="col-md-4">
                            <button id="send" name="send" class="btn btn-primary"> S'authentifier </button>
                          </div>
                        </div>
            </div>
        
        </div>
    </div>
</div>

</body>
</html>
	