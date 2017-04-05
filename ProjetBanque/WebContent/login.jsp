<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="./includes/sessionCheck.inc.jsp"%>
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
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Modern Business - Start Bootstrap Template</title>

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/modern-business.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
</head>

<body>

	<%@ include file="./includes/nav.inc.jsp"%>

    <!-- Page Content -->
    <div class="container">

        <!-- Page Heading/Breadcrumbs -->
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header"> <img src="./images/brokenbanques.png" alt="Une imaaaaaaaage ou un messaaaage">
                    <small></small>
                </h1> 
        
                </br>
                <div id="login" class="panel panel-primary container">
  <div class="panel-heading"><h3 class="panel-title"><strong> Identification</strong></h3></div>
  <div class="panel-body">
    <form id="frm-login" class="form-horizontal" action="./Login" method="post">
      <fieldset>
        <!-- Text input-->
        <div class="form-group">
          <label class="control-label" for="nomUtilisateur"><span class="glyphicon glyphicon-user"></span> Nom d'utilisateur</label>  
          <a class="pull-right" href="javascript:ctrl.chargerVue('compte');">Créer un compte</a>
          <div>
            <input id="nomUtilisateur" name="login" type="text" placeholder="Entrez votre nom d'utilisateur" class="form-control input-md" required="">
          </div>
        </div>

        <!-- Password input-->
        <div class="form-group">
          <label class="control-label" for="password"><span class="glyphicon glyphicon-lock"></span> Mot de passe</label>
          <a class="pull-right">Mot de passe oublié</a>
          <div>
            <input id="password" name="password" type="password" placeholder="Entrez votre mot de passe" class="form-control input-md" required="">
          </div>
        </div>
        <!-- Button -->
        <div class="form-group">
          <label class="control-label" for="btnSigner"></label>
          <div>
              <input id="btnSigner" type="submit" name="btnSigner" class="btn btn-primary" value="Se connecter" />
          </div>  
		<label id="hint"><%=hint%></label> 
           

        <!--</div> -->
      </fieldset>
    </form>

  </div>
</div>


            </div>
        </nav>
    </div>
</div>




            </div>
        </div>
        <!-- /.row -->

        <!-- Content Row -->
        <div class="row">
           <!-- <div class="col-lg-12">
                <p>Most of Start Bootstrap's unstyled templates can be directly integrated into the Modern Business template. You can view all of our unstyled templates on our website at <a href="http://startbootstrap.com/template-categories/unstyled">http://startbootstrap.com/template-categories/unstyled</a>.</p>
            </div> -->
        </div>
        <!-- /.row -->

        <hr>

        <!-- Footer -->
        <footer>
            <div class="row">
                <div class="col-lg-12">
                    <p>Copyright &copy; BanKrading 2017</p>
                </div>
            </div>
        </footer>

    </div>
    <!-- /.container -->

    <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>
    
    <script> window.onload = function(){document.getElementById("costumerarea").className = "dropdown active"; }</script>

</body>

</html>
