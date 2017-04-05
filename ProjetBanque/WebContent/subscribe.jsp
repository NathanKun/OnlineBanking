﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    
    <link rel="stylesheet" href="./css/subscribe.css" type="text/css">

    <title>Créer compte client</title>

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
                <h1 class="page-header">Page inscription
                    <small>Créer mon compte</small>
                </h1>
                <ol class="breadcrumb">
                    <li><a href="index.html">Home</a>
                    </li>
                    <li class="active">Page inscription</li>
                </ol>
            </div>
        </div>

        <div class="row">
            <div class="col-md-8">
                <h3>Veuillez remplir le formulaire d'inscription svp :</h3>
                <form id="form" class="form-horizontal" action="./Subscribe" onsubmit="return checkInputs()" method="post">
                        <fieldset>

                        <!-- Form Name -->
                        <legend>Données Personnelles</legend>

                        <!-- Select Basic -->
                        <div class="form-group">
                          <label class="col-md-4 control-label" for="selectbasic">Titre</label>
                          <div class="col-md-4">
                            <select id="selectbasic" name="sexe" class="form-control">
                              <option value="1">Mademoiselle</option>
                              <option value="2">Madame</option>
                              <option value="3">Monsieur</option>
                            </select>
                          </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                          <label class="col-md-4 control-label" for="Nom22">Nom</label>  
                          <div class="col-md-4">
                          <input id="nom" name="nom" placeholder="Nom" class="form-control input-md" required="" type="text">
                            
                          </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                          <label class="col-md-4 control-label" for="Prénom">Prénom</label>  
                          <div class="col-md-4">
                          <input id="prenom" name="prenom" placeholder="Prénom" class="form-control input-md" required="" type="text">
                            
                          </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                          <label class="col-md-4 control-label" for="Ddn">Date de Naissance</label>  
                          <div class="col-md-4">
                          	<input type="number" name="jour" min="1" max="31" style="width: 3em;" required >
				            <input type="number"  name="mois" min="1" max="12" style="width: 3em;"  required >
				            <input type="number"  name="annee" min="1900" max="2000" style="width: 6em;" required >
                          </div>
                        </div>

                        <!-- Select Basic -->
                        <div class="form-group">
                          <label class="col-md-4 control-label" for="EtatC">Etat Civil</label>
                          <div class="col-md-4">
                            <select id="EtatC" name="statut" class="form-control">
                              <option value="1">Marié(e)</option>
                              <option value="2">Divorcé(e)</option>
                              <option value="3">Séparé(e)</option>
                              <option value="4">Célibataire</option>
                              <option value="5">Veuf(ve)</option>
                            </select>
                          </div>
                        </div>

                         <div class="form-group">
                          <label class="col-md-4 control-label" for="nationalite">Nationalité</label>  
                          <div class="col-md-4">
                          <select id="nationalite" name="nationalite" class="form-control input-md" required>
								<option></option>

								<option>	Afghan	</option>
								<option>	Albanais	</option>
								<option>	Algerien	</option>
								<option>	Allemand	</option>
								<option>	Americain	</option>
								<option>	Angolais	</option>
								<option>	Argentin	</option>
								<option>	Armenien	</option>
								<option>	Australien	</option>
								<option>	Autrichien	</option>
								<option>	Bangladais	</option>
								<option>	Belge	</option>
								<option>	Beninois	</option>
								<option>	Bosniaque	</option>
								<option>	Botswanais	</option>
								<option>	Bhoutan	</option>
								<option>	Bresilien	</option>
								<option>	Britannique	</option>
								<option>	Bulgare	</option>
								<option>	Burkinabe	</option>
								<option>	Cambodgien	</option>
								<option>	Camerounais	</option>
								<option>	Canadien	</option>
								<option>	Chilien	</option>
								<option>	Chinois	</option>
								<option>	Colombien	</option>
								<option>	Congolais	</option>
								<option>	Cubain	</option>
								<option>	Danois	</option>
								<option>	Ecossais	</option>
								<option>	Egyptien	</option>
								<option>	Espagnol	</option>
								<option>	Estonien	</option>
								<option>	Europeen	</option>
								<option>	Finlandais	</option>
								<option>	Français	</option>
								<option>	Gabonais	</option>
								<option>	Georgien	</option>
								<option>	Grec	</option>
								<option>	Guineen	</option>
								<option>	Haïtien	</option>
								<option>	Hollandais	</option>
								<option>	Hong-Kong	</option>
								<option>	Hongrois	</option>
								<option>	Indien	</option>
								<option>	Indonesien	</option>
								<option>	Irakien	</option>
								<option>	Iranien	</option>
								<option>	Irlandais	</option>
								<option>	Islandais	</option>
								<option>	Israelien	</option>
								<option>	Italien	</option>
								<option>	Ivoirien	</option>
								<option>	Jamaïcain	</option>
								<option>	Japonais	</option>
								<option>	Kazakh	</option>
								<option>	Kirghiz	</option>
								<option>	Kurde	</option>
								<option>	Letton	</option>
								<option>	Libanais	</option>
								<option>	Liechtenstein	</option>
								<option>	Lituanien	</option>
								<option>	Luxembourgeois	</option>
								<option>	Macedonien	</option>
								<option>	Madagascar	</option>
								<option>	Malaisien	</option>
								<option>	Malien	</option>
								<option>	Maltais	</option>
								<option>	Marocain	</option>
								<option>	Mauritanien	</option>
								<option>	Mauricien	</option>
								<option>	Mexicain	</option>
								<option>	Monegasque	</option>
								<option>	Mongol	</option>
								<option>	Neo-Zelandais	</option>
								<option>	Nigerien	</option>
								<option>	Nord Coreen	</option>
								<option>	Norvegien	</option>
								<option>	Pakistanais	</option>
								<option>	Palestinien	</option>
								<option>	Peruvien	</option>
								<option>	Philippins	</option>
								<option>	Polonais	</option>
								<option>	Portoricain	</option>
								<option>	Portugais	</option>
								<option>	Roumain	</option>
								<option>	Russe	</option>
								<option>	Senegalais	</option>
								<option>	Serbe	</option>
								<option>	Serbo-croate	</option>
								<option>	Singapour	</option>
								<option>	Slovaque	</option>
								<option>	Sovietique	</option>
								<option>	Sri-lankais	</option>
								<option>	Sud-Africain	</option>
								<option>	Sud-Coreen	</option>
								<option>	Suedois	</option>
								<option>	Suisse	</option>
								<option>	Syrien	</option>
								<option>	Tadjik	</option>
								<option>	Taïwanais	</option>
								<option>	Tchadien	</option>
								<option>	Tcheque	</option>
								<option>	Thailandais	</option>
								<option>	Tunisien	</option>
								<option>	Turc	</option>
								<option>	Ukrainien	</option>
								<option>	Uruguayen	</option>
								<option>	Venezuelien	</option>
								<option>	Vietnamien	</option>
			                </select>  
                          </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                          <label class="col-md-4 control-label" for="rue">Adresse</label>  
                          <div class="col-md-4">
                          <input id="adresse" name="adresse" placeholder="Adresse" class="form-control input-md" required="" type="text">
                            
                          </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                          <label class="col-md-4 control-label" for="CP">Code Postal</label>  
                          <div class="col-md-2">
                          <input id="codepostal" name="codepostal" onchange="getCity()" placeholder="Code Postal" class="form-control input-md" required="" type="text">
                            
                          </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                          <label class="col-md-4 control-label" for="ville">Ville</label>  
                          <div class="col-md-4">
                          <input id="ville" name="ville" placeholder="ville" class="form-control input-md" required="" type="text">
                            
                          </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                          <label class="col-md-4 control-label" for="mail">Adresse e-mail</label>  
                          <div class="col-md-4">
                          <input id="email" name="email" placeholder="Adresse e-mail" class="form-control input-md" required="" type="text">
                            
                          </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                          <label class="col-md-4 control-label" for="tel">Téléphone</label>  
                          <div class="col-md-4">
                          <input id="tel" name="tel"  pattern="[0-9]{10}" placeholder="Téléphone" class="form-control input-md" required="" type="text">
                            
                          </div>
                        </div>
                        
                        <!-- Text input-->
                        <div class="form-group">
                          <label class="col-md-4 control-label" for="revMensNet">Choisissez votre mot de passe </label>  
                          <div class="col-md-4">
                          <input id="password" name="password" onchange="checkPw()" placeholder="password" class="form-control input-md" required="" type="password">
                            
                          </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                          <label class="col-md-4 control-label" for="cpassword">Confirmez mot de passe</label>  
                          <div class="col-md-4">
                          <input id="password2" name="password2" onchange="checkPw()" placeholder="cpassword" class="form-control input-md" type="password">
                            
                          </div>
                        </div>



                          <div class="form-group">
                                <label class="col-md-4 control-label" for="cpassword">Je crée également un: </label> 
            
                            <div class="col-md-4">
                                <input type="checkbox" id="epargne" name="epargneCheckBox" >
                                <label for="epargne">Compte épargne</label>
                                
                                <br>

                                <input type="checkbox" id="titre" name="titreCheckBox" >
                                <label for="titre"> Compte titre.</label>
                            </div>
                          </div>
                        

                        <div class="form-group">
                         <label class="col-md-4 control-label" for="send"></label>
                          <div class="col-md-4">
			            <label id="hint"></label> <br /> 
                          </div>
                        </div>
			            
                        <!-- Button -->
                        <div class="form-group">
                         <label class="col-md-4 control-label" for="send"></label>
                          <div class="col-md-4">
                            <input type="submit" value=" Je crée mon compte !" id="submit" name="send" class="btn btn-primary">
                          </div>
                        </div>

                        </fieldset>
                        </form>

                   

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

    <script src="https://rawgit.com/leizongmin/js-xss/master/dist/xss.js"></script>
    
	<script src="./js/subscribe.js"></script>
    
    <script> window.onload = function(){document.getElementById("customerarea").className = "dropdown active"; }</script>

</body>

</html>
