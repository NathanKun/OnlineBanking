<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>BankRading - Services</title>

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/modern-business.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

	<%@ include file="./includes/nav.inc.jsp"%>

    <!-- Page Content -->
    <div class="container">

        <!-- Page Heading/Breadcrumbs -->
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Services
                    <small>Subheading</small>
                </h1>
                <ol class="breadcrumb">
                    <li><a href="index.jsp">Home</a>
                    </li>
                    <li class="active">Services</li>
                </ol>
            </div>
        </div>
        <!-- /.row -->

        <!-- Image Header -->
        <div class="row">
            <div class="col-lg-12">
                <img src="images/bank2.png" width="1000" height="280" alt="bank" />
            </div>
        </div>
        <!-- /.row -->

        <!-- Service Panels -->
        <!-- The circle icons use Font Awesome's stacked icon classes. For more information, visit http://fontawesome.io/examples/ -->
        <div class="row">
            <div class="col-lg-12">
                <h2 class="page-header">Services Panels</h2>
            </div>
            <div class="col-md-3 col-sm-6">
                <div class="panel panel-default text-center">
                    <div class="panel-heading">
                        <span class="fa-stack fa-5x">
                              <i class="fa fa-circle fa-stack-2x text-primary"></i>
                              <i class="fa fa-tree fa-stack-1x fa-inverse"></i>
                        </span>
                    </div>
                    <div class="panel-body">
                        <h4>GRATUIT</h4>
                        <p>Carte VISA gratuite à vie Chéquier gratuit Aucuns frais de gestion
                          Compte joint sans frais Retraits gratuits Virements gratuits</p>
                    </div>
                </div>
            </div>
            <div class="col-md-3 col-sm-6">
                <div class="panel panel-default text-center">
                    <div class="panel-heading">
                        <span class="fa-stack fa-5x">
                              <i class="fa fa-circle fa-stack-2x text-primary"></i>
                              <i class="fa fa-car fa-stack-1x fa-inverse"></i>
                        </span>
                    </div>
                    <div class="panel-body">
                        <h4>DISPONIBLE</h4>
                        <p>Une équipe de conseillers-Téléphone-Chat-Réseaux sociaux-De 8h à 22h-6 jours / 7</p>
                    </div>
                </div>
            </div>
            <div class="col-md-3 col-sm-6">
                <div class="panel panel-default text-center">
                    <div class="panel-heading">
                        <span class="fa-stack fa-5x">
                              <i class="fa fa-circle fa-stack-2x text-primary"></i>
                              <i class="fa fa-support fa-stack-1x fa-inverse"></i>
                        </span>
                    </div>
                    <div class="panel-body">
                        <h4>Simplicité</h4>
                        <p>Consultez vos comptes en ligne
                        Effectuez simplement toutes vos opérations courantes</p>
                    </div>
                </div>
            </div>
            
        </div>

        <!-- Service Tabs -->
        <div class="row">
            <div class="col-lg-12">
                <h2 class="page-header">Service Tabs</h2>
            </div>
            <div class="col-lg-12">

                <ul id="myTab" class="nav nav-tabs nav-justified">
                    <li class="active"><a href="#service-one" data-toggle="tab"><i class="fa fa-tree"></i> Gratuit </a>
                    </li>
                    <li class=""><a href="#service-two" data-toggle="tab"><i class="fa fa-car"></i> DISPONIBLE</a>
                    </li>
                    <li class=""><a href="#service-three" data-toggle="tab"><i class="fa fa-support"></i> Simplicité </a>
                    </li>
                    
                </ul>

                <div id="myTabContent" class="tab-content">
                    <div class="tab-pane fade active in" id="service-one">
                        <h4>Compte sans frais</h4>
                        <p>1- l’ouverture, la tenue et la clôture du compte</p>
                        <p>2- un changement d’adresse par an</p>
                        <p>3- l’envoi mensuel d’un relevé des opérations effectuées sur la platforme en ligne</p>
                        <p>4- des moyens de consultation à distance du solde du compte</p>
                        <p>5-Carte visa gratuite délivrée par la banque</p>
                    </div>
                    <div class="tab-pane fade" id="service-two">
                        <h4>TOUJOURS LÀ POUR VOUS</h4>
                        <p>Les conseillers BankRading sont à vos côtés par Chat, Twitter, Facebook, téléphone, de 8h à 22h en semaine et de 8h à 18h le samedi. 6 jours sur 7, toutes les réponses à vos questions, en instantané !</p>
                        <p></p>
                        </div>
                    <div class="tab-pane fade" id="service-three">
                        <h4></h4>
                        <p>1-Virements en ligne permanents</p>
                        <p>2-Autorisation de prélèvement</p>
                        <p>4-Relevés Bancaires en ligne</p>
                        <p>4-Envoie de carte bancaire à domicile</p>
                        </div>
                   
                </div>

            </div>
        </div>

        <!-- Service List -->
        <!-- The circle icons use Font Awesome's stacked icon classes. For more information, visit http://fontawesome.io/examples/ -->
        <div class="row">
            <div class="col-lg-12">
                <h2 class="page-header">Service list</h2>
            </div>
            <div class="col-md-4">
                <div class="media">
                    <div class="pull-left">
                        <span class="fa-stack fa-2x">
                              <i class="fa fa-circle fa-stack-2x text-primary"></i>
                              <i class="fa fa-tree fa-stack-1x fa-inverse"></i>
                        </span> 
                    </div>
                    <div class="media-body">
                        <h4 class="media-heading">DISPONIBLE</h4>
                        <p>Equipe de conseiller disponible</p>
                    </div>
                </div>
                <div class="media">
                    <div class="pull-left">
                        <span class="fa-stack fa-2x">
                              <i class="fa fa-circle fa-stack-2x text-primary"></i>
                              <i class="fa fa-car fa-stack-1x fa-inverse"></i>
                        </span> 
                    </div>
                    <div class="media-body">
                        <h4 class="media-heading">Simplicité</h4>
                        <p>GÉREZ VOTRE COMPTE BANCAIRE SANS FRAIS
                       </p>
                    </div>
                </div>
               
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
    
    <script> window.onload = function(){document.getElementById("services").className = "dropdown active"; }</script>

</body>

</html>
