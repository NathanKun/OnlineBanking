<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Modern Business - Start Bootstrap Template</title>

    <!-- Bootstrap Core CSS -->
    <link href="../css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="../css/modern-business.css" rel="stylesheet">
    <link href="../css/carousel.css" rel="stylesheet">
    <!-- Custom Fonts -->
    <link href="../font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

</head>

<body>

<%@ include file="../includes/nav.inc.jsp"%>
	
    <!-- Page Content -->
    <div class="container">

        <!-- Page Heading/Breadcrumbs -->
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Nos offres
                    <small>BanKrading</small>
                </h1>
                <ol class="breadcrumb">
                    <li><a href="../index.jsp">Home</a>
                    </li>
                    <li class="active">Nos offres</li>
                </ol>
            </div>
        </div>
        <!-- /.row -->
	
        <div class="row">
            <div class="col-lg-8">
					<img src="../images/offre3.png" width="600" height="322" alt="image">
					<h2>Conditions de l'offre :</h2>
					<p>-Prime de 80€ offerte pour une première ouverture d'un Compte Bancaire BankRading 
					jusqu'au 27/04/2017 dont la Carte Bancaire a été activée dans le mois suivant l'ouverture du compte</p>  
					<p>-La prime sera versée sur le Compte Bancaire par la banque dans les 15 jours ouvrés suivant l’activation de la carte.</p>
					<h3>Si demande d'ouverture simultanée d'un Livret d'épargne BankRading :</h3>
					<p>-Prime de 50€ offerte pour une première ouverture d'un Livret d'épargne BankRading, jusqu'au 27/04/2017,
					ouvert concomitamment au compte bancaire, et 3% annuels brut garantis pendant 2 mois pour un montant de 75 000€ maximum.
					Au-delà de cette période et de ce montant, le taux standard du Livret d'épargne est appliqué. 
					Le taux standard du Livret d’épargne BforBank est actuellement de 0,30% annuel brut et est susceptible d’être révisé à tout moment par la banque.</p>
            </div>
        </div>

        <hr>

		<!-- Footer -->
		<%@ include file="../includes/footer.inc.jsp"%>

    </div>
    <!-- /.container -->

    <!-- jQuery -->
    <script src="../js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="../js/bootstrap.min.js"></script>
    
    <script> window.onload = function(){document.getElementById("offres").className = "dropdown active"; }</script>
</body>
