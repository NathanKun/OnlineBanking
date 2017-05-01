<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page
	import="model.Client, dao.DaoClient, model.Account, dao.DaoAccount, java.util.ArrayList"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ include file="./includes/sessionCheck.inc.jsp"%>
<!DOCTYPE html>
<html>
<head>

	<meta charset="UTF-8">
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="">
	<meta name="author" content="">
	
	<title>Modern Business - Start Bootstrap Template</title>
	
	<!-- Bootstrap Core CSS -->
	<link href="css/bootstrap.min.css" rel="stylesheet">
	
	<!-- Custom CSS -->
	<link href="css/modern-business.css" rel="stylesheet">
	<link href="css/carousel.css" rel="stylesheet">
	<!-- Custom Fonts -->
	<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet"
		type="text/css">
	<link rel="stylesheet" href="./css/subscribe.css" type="text/css">


</head>

<body>

	<%
		Client clt = (Client) session.getAttribute("client");
	%>

	<%@ include file="./includes/nav.inc.jsp"%>

	<!-- Page Content -->
	<div class="container">


		<div class="row">
			<div class="col-md-8">
				<form id="form" class="form-horizontal" action="./ModifyInfo"
					method="post" onsubmit="return checkInputs()" accept-charset="UTF-8">
					<fieldset>

						<!-- Form Name -->
						 <h1> Actualités :  </h1> 
						 
                         <legend> Spécial Présidentielle 2017 : </legend>
						 
						 OFFICIEL : MACRON ET LE PEN AU SECOND TOUR !
						 
						 HAMON appelle à voter MACRON pour l'élimination de l'extrème droite.
						 
						 le CAC40 ouvre en forte hausse après la qualification d'Emmanuel MACRON.
						 
						 Politique :
						 
						 SYRIE : Des attentats à la masse ce week-end.
						 
						 
						 
						 

						


		<hr>

		<!-- Footer -->
		<footer>
			<div class="row">
				<div class="col-lg-12">
					<p>Copyright &copy; Banque en ligne 2017</p>
				</div>
			</div>
		</footer>

	</div>
	<!-- /.container -->

	<!-- jQuery -->
	<script src="js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>

	<!-- Script to Activate the Carousel -->
	<script>
		$('.carousel').carousel({
			interval : 5000
		//changes the speed
		})
	</script>


	<!-- algolia/places api -->
	<script src="https://cdn.jsdelivr.net/places.js/1/places.min.js"></script>
	
	<!-- XSS checker -->
    <script src="https://rawgit.com/leizongmin/js-xss/master/dist/xss.js"></script>

	<script src="./js/subscribe.js"></script>

</body>

</html>