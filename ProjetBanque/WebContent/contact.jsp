<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<head>
<meta charset="utf-8" />
<title>Contacter Nous</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<link rel="stylesheet" href="./css/offres.css" type="text/css" media="screen" />


</head>
<body>
	<div id="wrapper">
		<!-- #wrapper -->
		
		<%@ include file="./includes/header.inc.jsp"%>

		<section id="main">
			<!-- #main content and sidebar area -->
			<section id="content">
				<!-- #content -->
				
				<h3>Contactez nous</h3>
				</br> </br>
				
				<form id="form" method="post" action="./Contact">
					<label>Votre nom</label> 
					<input type="text" id="name" name="name" maxlength="60" required />
					</br> </br>
					<label>Votre numero de téléphone</label>
					<input type="tel" id="phone" name="phone" pattern="[0-9]{10}" placeholder = "10 chiffres"
						 maxlength="10" required />
					</br> </br>
					<label>Votre mail</label>
					<input type="email" id="email" name="email"  maxlength="254"required />
					</br> </br>
					<label>Message</label>
					</br> </br>
					<textarea rows="10" cols="60" id="message" name="message" maxlength="999" 
						style="resize: none" required></textarea>
					</br> </br>
					<input type="submit" id="submit" value="Envoyer"></button>
					</br> </br>
					<label id="hint"></label>
				</form>
				
			</section>
			<!-- end of #content -->

			<%@ include file="./includes/loginFormInIndex.inc.jsp"%>
			
	</div>
	<script>
	// ajax to save the form and get return message
        $(document).on("submit", "#form", function() {
            var $form = $(this);
            $.post($form.attr("action"), $form.serialize(), function(responseText) {
                $("#hint").text(responseText);
            });
            event.preventDefault(); // Important! Prevents submitting the form.
        });
    </script>


</body>
</html>
