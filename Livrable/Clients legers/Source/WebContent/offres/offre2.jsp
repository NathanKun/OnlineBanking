<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>RadBanking - Nos offres</title>

<!-- Bootstrap Core CSS -->
<link href="../css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="../css/modern-business.css" rel="stylesheet">
<link href="../css/carousel.css" rel="stylesheet">
<!-- Custom Fonts -->
<link href="../font-awesome/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">

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
				<!-- #content -->
				<h1>
					<img src="../images/offre2.png" width="600" height="322" alt="image">
				</h1>
				<h2>*Mentions legales</h2>
	
				<p>Avec votre Carte Bancaire Visa Premier BankRading, c’est vous
					qui décidez, vous pouvez :</p>
				<p>-Bénéficier de garanties d’assurance et assistance pour vous
					et votre famille, en France et à l’étranger lors de vos voyages</p>
				<p>-Choisir entre le débit immédiat et différé</p>
				<p>-Ajuster vous-même vos plafonds de façon temporaire ou
					définitive en fonction de vos besoins (Sous réserve d’acceptation en
					ligne par la Banque)</p>
				<p>-Disposer du paiement sans contact</p>
				<p>-Fixer les alertes sur vos opérations cartes depuis votre
					Espace Client</p>
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