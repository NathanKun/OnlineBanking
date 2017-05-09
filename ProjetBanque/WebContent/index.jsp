<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>BankRading</title>

<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="css/modern-business.css" rel="stylesheet">
<link href="css/carousel.css" rel="stylesheet">
<!-- Custom Fonts -->
<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">

</head>

<body>

	<%@ include file="./includes/nav.inc.jsp"%>

	<header id="myCarousel" class="carousel slide">
		<div class="carousel fade-carousel slide" data-ride="carousel"
			data-interval="4000" id="bs-carousel">

			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#bs-carousel" data-slide-to="0" class="active"></li>
				<li data-target="#bs-carousel" data-slide-to="1"></li>
				<li data-target="#bs-carousel" data-slide-to="2"></li>
			</ol>

			<!-- Wrapper for slides -->
			<div class="carousel-inner">
				<div class="item slides active">
					<div class="slide-1"></div>
					<div class="hero">
						<hgroup>
							<h1>We are creative</h1>
							<h3>Rejoignez nous</h3>
						</hgroup>
						<button role="button" onclick="location.href='about.jsp'"
							class="btn btn-hero btn-lg">Détails</button>
					</div>
				</div>
				<div class="item slides">
					<div class="slide-2"></div>
					<div class="hero">
						<hgroup>
							<h1>We are smart</h1>
							<h3>Bénéficiez d'un compte sans frais</h3>
						</hgroup>
						<button class="btn btn-hero btn-lg" role="button"
							onclick="location.href='offres/offre1.jsp'">Détails</button>
					</div>
				</div>
				<div class="item slides">
					<div class="slide-3"></div>
					<div class="hero">
						<hgroup>
							<h1>We are amazing</h1>
							<h3>Obtenez gratuitement votre carte visa</h3>
						</hgroup>
						<button class="btn btn-hero btn-lg" role="button"
							onclick="location.href='offres/offre2.jsp'">Détails</button>
					</div>
				</div>
			</div>
		</div>


	</header>








	<!-- Page Content -->
	<div class="container">

		<!-- Marketing Icons Section -->
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header"></h1>
			</div>
			<div class="col-md-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h4>
							<i class="fa fa-fw fa-check"></i>  Prêt Personnel BankRading
						</h4>
					</div>
					<div class="panel-body">
						<p>Vous avez envie de partir en vacances ou de changer de voiture, 
						vous avez besoin de remplacer une partie de votre équipement? 
						Les projets ne manquent pas, encore faut-il disposer des bons leviers
						 pour les rendre concrets !</p>
						
						<a class="btn btn-lg btn-default btn-block"
						href="offres/news.jsp">plus d'actualités</a>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h4>
							<i class="fa fa-fw fa-gift"></i> &amp; Offre d'emploi
						</h4>
					</div>
					<div class="panel-body">
						<p>Ingénieur Expert en Collaboration (Voix et Vidéo)</p>
						<a class="btn btn-lg btn-default btn-block"
						href="offres/news.jsp">en savoir plus</a>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h4>
							<i class="fa fa-fw fa-compass"></i> Autres services
						</h4>
					</div>
					<div class="panel-body">
						<p>Compte bancaire BankRading : Jusqu'à 130 offertes dès l'ouverture !</p>
						<a class="btn btn-lg btn-default btn-block"
						href="offres/offre3.jsp">consulter l'offre</a>
					</div>
				</div>
			</div>
		</div>
		<!-- /.row -->

		<!-- Portfolio Section // des images -->
		<!--  <div class="row">
            <div class="col-lg-12">
                <h2 class="page-header">Portfolio Heading</h2>
            </div>
            <div class="col-md-4 col-sm-6">
                <a href="portfolio-item.html">
                    <img class="img-responsive img-portfolio img-hover" src="http://placehold.it/700x450" alt="">
                </a>
            </div>
            <div class="col-md-4 col-sm-6">
                <a href="portfolio-item.html">
                    <img class="img-responsive img-portfolio img-hover" src="http://placehold.it/700x450" alt="">
                </a>
            </div>
            <div class="col-md-4 col-sm-6">
                <a href="portfolio-item.html">
                    <img class="img-responsive img-portfolio img-hover" src="http://placehold.it/700x450" alt="">
                </a>
            </div>
            <div class="col-md-4 col-sm-6">
                <a href="portfolio-item.html">
                    <img class="img-responsive img-portfolio img-hover" src="http://placehold.it/700x450" alt="">
                </a>
            </div>
            <div class="col-md-4 col-sm-6">
                <a href="portfolio-item.html">
                    <img class="img-responsive img-portfolio img-hover" src="http://placehold.it/700x450" alt="">
                </a>
            </div>
            <div class="col-md-4 col-sm-6">
                <a href="portfolio-item.html">
                    <img class="img-responsive img-portfolio img-hover" src="http://placehold.it/700x450" alt="">
                </a>
            </div>
        </div>
       ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
		<!-- /.row -->

		<!-- Features Section -->
		<div class="row">
			<div class="col-lg-12">
				<h2 class="page-header">BankRading</h2>
			</div>
			<div class="col-md-6">
				<p>La banque en ligne Bankrading inclut des services tels que:</p>
				<ul>
					<!-- <li><strong>Bootstrap v3.3.7</strong>
                    </li>-->
					
					<li>Des conseillers clients en chair et en os</li>
					<li>Une assistance de proximité</li>
					<li>Accès instantané à la bourse</li>
					<li>Actualités en temps réel</li>
				</ul>
				<p>Pilotez vos finances au juste prix. Vous ne payez que pour
					les services qui ont de la valeur. Découvrez tous les services
					quotidiens gratuits, ça change la vie.</p>
			</div>
			<div class="col-md-6">
				<img class="img-responsive" src="http://placehold.it/700x450" alt="">
			</div>
		</div>
		<!-- /.row -->

		<hr>

		<!-- Call to Action Section -->
		<div class="well">
			<div class="row">
				<div class="col-md-8">
					<p>Une offre claire. Peu de frais... Jamais cachés</p>
				</div>
				<div class="col-md-4">
					<a class="btn btn-lg btn-default btn-block"
						href="offres/offre1.jsp">consulter l'offre</a>
				</div>
			</div>
		</div>

		<hr>

		<!-- Footer -->
		<%@ include file="./includes/footer.inc.jsp"%>

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

</body>

</html>