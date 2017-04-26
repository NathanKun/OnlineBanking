<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>

    <meta charset="utf-8">
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>BankRading - nous contactez</title>

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
                <h1 class="page-header">Comment nous joindre ?
                    <small>...</small>
                </h1>
                <ol class="breadcrumb">
                    <li><a href="index.jsp">Home</a>
                    </li>
                    <li class="active">Des questions? Nous avons les réponses qu'il vous faut </li>
                </ol>
            </div>
        </div>
        <!-- /.row -->

        <!-- Content Row -->
        <div class="row">
            <!-- Map Column -->
            <div class="col-md-8">
                <!-- Embedded Google Map -->
                <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2596.887202679294!2d1.0585573160435044!3d49.392125679343394!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x47e0dfd7401611f5%3A0x9fb4bf974015e3b0!2s1+Avenue+Maryse+Basti%C3%A9%2C+76800+Saint-%C3%89tienne-du-Rouvray!5e0!3m2!1szh-CN!2sfr!4v1491409782330"
 					width="100%" height="400" style="border:0" ></iframe>
                </div>
            <!-- Contact Details Column -->
            <div class="col-md-4">
                <h3>Nos coordonnées</h3>
                <p>
                    1, avenue Maryse Bastié<br>76800, Saint-Etienne-Du-Rouvray<br>
                </p>
                <p><i class="fa fa-phone"></i> 
                    <abbr title="Phone">Tél: </abbr>: +33(0)653541829</p>
                <p><i class="fa fa-envelope-o"></i> 
                    <abbr title="Email">E-mail</abbr>: <a href="mailto:name@example.com">contact@bankrading.com</a>
                </p>
                <p><i class="fa fa-clock-o"></i> 
                    <abbr title="Hours">Horaires:</abbr>: Lundi - Vendredi: 9h:00  Ã  17h:30</p>
                <ul class="list-unstyled list-inline list-social-icons">
                    <li>
                        <a href="#"><i class="fa fa-facebook-square fa-2x"></i></a>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-linkedin-square fa-2x"></i></a>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-twitter-square fa-2x"></i></a>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-google-plus-square fa-2x"></i></a>
                    </li>
                </ul>
            </div>
        </div>
        <!-- /.row -->

        <!-- Contact Form -->
        <!-- In order to set the email address and subject line for the contact form go to the bin/contact_me.php file. -->
        <div class="row">
            <div class="col-md-8">
                <h3>Envoyez nous un message</h3>
                <form id="form" name="sentMessage" id="contactForm" action="./Contact" onsubmit='return checkInput();'>
                    <div class="control-group form-group">
                        <div class="controls">
                            <label>Nom complet :</label>
                            <input type="text" class="form-control" id="name" name="name" required data-validation-required-message="Please enter your name.">
                            <p class="help-block"></p>
                        </div>
                    </div>
                    <div class="control-group form-group">
                        <div class="controls">
                            <label>Numéro de téléphone :</label>
                            <input type="text" class="form-control" id="phone" name="phone" maxlength="10" required data-validation-required-message="Please enter your phone number.">
                        </div>
                    </div>
                    <div class="control-group form-group">
                        <div class="controls">
                            <label>Adresse mail:</label>
                            <input type="email" class="form-control" id="email" name="email" required data-validation-required-message="Please enter your email address.">
                        </div>
                    </div>
                    <div class="control-group form-group">
                        <div class="controls">
                            <label>Message:</label>
                            <textarea rows="10" cols="100" class="form-control" id="message" name="message" required data-validation-required-message="Please enter your message" maxlength="999" style="resize:none"></textarea>
                        </div>
                    </div>
                    <div id="success"></div>
                    <!-- For success/fail messages -->
                    <input type="submit" class="btn btn-primary" value="Envoyez le message">
               
					<br> <br>
					<label id="hint"></label>
                </form>
            </div>

        </div>
        <!-- /.row -->

        <hr>

		<!-- Footer -->
		<%@ include file="./includes/footer.inc.jsp"%>

    </div>
    <!-- /.container -->

    <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

    <!-- Contact Form JavaScript -->
    <!-- Do not edit these files! In order to set the email address and subject line for the contact form go to the bin/contact_me.php file. -->
    <script src="js/jqBootstrapValidation.js"></script>
    <script src="js/contact_me.js"></script>
    
    <script> window.onload = function(){document.getElementById("contact").className = "dropdown active"; }</script>

	<script>
		// ajax to save the form and get return message
        $(document).on("submit", "#form", function() {
            var $form = $(this);
            $.post($form.attr("action"), $form.serialize(), function(responseText) {
                $("#hint").text(responseText);
            });
            event.preventDefault(); // Important! Prevents submitting the form.
        });
		
        <script>
        function checkInput() {
        	var tel = $('#phone').val();
        	if (tel.startsWith("0") && tel.length == 10) {
    			return true;
    		} else if (tel.startsWith("+33")
    				&& tel.length == 12) {
    			return true;
    		} else if (tel.startsWith("0033")
    				&& tel.length == 13) {
    			return true;
    		} else {
    			alert("Votre numéro de téléphone est incorrect");
    			return false;
    		}
        }
        </script>
    </script>
    
</body>

</html>
