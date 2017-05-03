<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>SB Admin 2 - Bootstrap Admin Theme</title>

<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- MetisMenu CSS -->
<link href="css/metisMenu.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="css/sb-admin-2.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

	<div id="wrapper">


		<%@ include file="./includes/nav.inc.jsp"%>

		<!-- Page Content -->
		<div id="page-wrapper">

			<div class="container">
				<div class="row">

					<div class="col-md-6">
						<div class="panel with-nav-tabs panel-info">
							<div class="panel-heading">
								<ul class="nav nav-tabs">
									<li class="active"><a href="#courant" data-toggle="tab">
											Historique compte courant</a></li>
									<li><a href="#epargne" data-toggle="tab">Historique compte épargne </a></li>
									<li><a href="#titre" data-toggle="tab">Historique compte titre </a></li>
									<li><a href="#solde" data-toggle="tab">Solde du compte</a></li>
								</ul>
							</div>
							<div class="panel-body">
								<div class="tab-content">
									<div class="tab-pane fade in active" id="courants">
										Les transactions effectuees															
									</div>
									<div class="tab-pane fade" id="epargne">Les transactions effectuees</div>
									<div class="tab-pane fade" id="titre">les transactions des actions effectuées sont:</div>
									<div class="tab-pane fade" id="solde">Solde des comptes</div>

								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

			<!-- /#page-wrapper -->

		</div>
		<!-- /#wrapper -->

		<!-- jQuery -->
		<script src="js/jquery.js"></script>

		<!-- Bootstrap Core JavaScript -->
		<script src="js/bootstrap.min.js"></script>

		<!-- Metis Menu Plugin JavaScript -->
		<script src="js/metisMenu.min.js"></script>

		<!-- Custom Theme JavaScript -->
		<script src="js/sb-admin-2.js"></script>
</body>

</html>
