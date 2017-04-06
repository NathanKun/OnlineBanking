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

		<section id="main">
			<section id="content">
				<!-- #content -->
				<img src="../images/offre_1.png" width="600" height="322" alt="offre1" />
				<h2>*Mentions legales</h2>
				<img src="../images/mentions.png" alt="Mentions legals" />
			</section>
			<!-- end of #content -->
	
		</section>

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
