<%@ page import="model.Client, dao.DaoClient, model.Account, dao.DaoAccount, java.util.ArrayList"%><!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
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
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

    <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.html">BankRading</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a href="about.html">Mieux nous connaitre</a>
                    </li>
                    <li>
                        <a href="services.html">Nos services</a>
                    </li>
                    <li>
                        <a href="contact.html">Nous contacter</a>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Bourse <b class="caret"></b></a>
                      <!--  <ul class="dropdown-menu">
                            <li>
                                <a href="portfolio-1-col.html">1 Column Portfolio</a>
                            </li>
                            <li>
                                <a href="portfolio-2-col.html">2 Column Portfolio</a>
                            </li>
                            <li>
                                <a href="portfolio-3-col.html">3 Column Portfolio</a>
                            </li>
                            <li>
                                <a href="portfolio-4-col.html">4 Column Portfolio</a>
                            </li>
                            <li>
                                <a href="portfolio-item.html">Single Portfolio Item</a>
                            </li>
                        </ul> -->
                    </li>
                   <!-- <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Blog <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li>
                                <a href="blog-home-1.html">Blog Home 1</a>
                            </li>
                            <li>
                                <a href="blog-home-2.html">Blog Home 2</a>
                            </li>
                            <li>
                                <a href="blog-post.html">Blog Post</a>
                            </li> 
                        </ul>-->
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Espace client <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li>
                                <a href="full-width.html">Acc�der � mon compte</a>
                            </li>
                            <li>
                                <a href="sidebar.html">Devenir membre</a>
                            </li>
                          <!--  <li>
                                <a href="faq.html">FAQ</a>
                            </li>
                            <li>
                                <a href="404.html">404</a>
                            </li>
                            <li>
                                <a href="pricing.html">Pricing Table</a>
                            </li>-->
                        </ul>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

    <!-- Header Carousel -->
   <!-- <header id="myCarousel" class="carousel slide">-->
        <!-- Indicators -->
    <!--   <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
            <li data-target="#myCarousel" data-slide-to="2"></li>
        </ol> -->

        <!-- Wrapper for slides -->
       <!-- <div class="carousel-inner">-->
          <!--  <div class="item active"> -->
                <!--<div class="fill" style="background-image:url('Pictur/labview');"></div>-->
              <!--  <img src="cartevisa.png" alt="chuchu1">
                <div class="carousel-caption">
                    <h2>Caption 1</h2>
                </div>
            </div>
            <div class="item"> -->
               <!-- <div class="fill" style="background-image:url('http://placehold.it/1900x1080&text=Slide Two');"></div>-->
             <!--   <img src="offres.png" alt="chuchu2">
                <div class="carousel-caption">
                    <h2>Caption 2</h2>
                </div>
            </div>
            <div class="item"> -->
              <!--  <div class="fill" style="background-image:url('http://placehold.it/1900x1080&text=Slide Three');"></div>-->
             <!--   <img src="compte_sans_frais.png" alt="chuchu3">
                <div class="carousel-caption">
                    <h2>Caption 3</h2>
                </div>
            </div>
        </div> -->

        <!-- Controls -->
        <!--<a class="left carousel-control" href="#myCarousel" data-slide="prev">
            <span class="icon-prev"></span>
        </a>
        <a class="right carousel-control" href="#myCarousel" data-slide="next">
            <span class="icon-next"></span>
        </a>
    </header> -->

<%
                                Client clt = (Client) session.getAttribute("client");
                                ArrayList<Account> accList = DaoAccount.findAccountByClientId(clt.getClt_id());
                                request.setAttribute("accList", accList);
                            %>


	<section id="main"><!-- #main content and sidebar area -->
			<section id="content"><!-- #content -->
			
				     <h1><legend>Modifier vos informations :<legend></h1> <!-- Titre du fieldset --> 
	   
	   
	  
	   
	   
	    <form method="post" action=".php">
     <center>
	 <table>

   <tr>
        
	<td> <label>Identifiant   </label> : </td>
<<<<<<< HEAD:ProjetBanque/WebContent/modifier-info-client.jsp:ProjetBanque/WebContent/modifier-info-client.jsp
<<<<<<< HEAD:ProjetBanque/WebContent/modifier-info-client.jsp
	<td><input type="text" name="identifiant" id ="identifiant" /> </td>
		 
		 </tr>
		 
		 
	 <tr>
    <td><label>Mot de passe  </label> : </td>
	<td><input type="password" name="password" id ="password" /></td>
	 </tr>
	 
	  <tr>
    <td><label>Confirmer le mot de passe  </label> : </td>
	<td><input type="password" name="clt_password" id ="clt_password" /></td>
	 </tr>
	 
	 <tr>	
    <td><label>Nom</label> : </td>
	<td><input type="text" name="name" id ="name" /></td>
	</tr>
	 
	 <tr>	
    <td><label>Prénom</label> : </td>
	<td><input type="text" name="prenom" id ="prenom" /></td>
=======
	<td> <%=clt.getClt_login()%></td>
=======
	<td><%=clt.getClt_login()%> </td>
>>>>>>> 257839360dcd3726db3c5bc35eaf419676048332:ProjetBanque/WebContent/afficher-infos-client.jsp:ProjetBanque/WebContent/afficher-infos-client.jsp
		 
		 </tr>
	 
	 <tr>	
    <td><label>Nom</label> : </td>
	<td> <%=clt.getClt_lname()%></td>
	</tr>
	 
	 <tr>	
<<<<<<< HEAD:ProjetBanque/WebContent/modifier-info-client.jsp:ProjetBanque/WebContent/modifier-info-client.jsp
    <td><label>Prenom</label> : </td>
	<td><%=clt.getClt_fname()%> </td>
>>>>>>> origin/master:ProjetBanque/WebContent/afficher-infos-client.jsp
=======
    <td><label>Pr�nom</label> : </td>
	<td> <%=clt.getClt_fname()%></td>
>>>>>>> 257839360dcd3726db3c5bc35eaf419676048332:ProjetBanque/WebContent/afficher-infos-client.jsp:ProjetBanque/WebContent/afficher-infos-client.jsp
	</tr>
	 
	 <tr>
   <td> <label>Date de naissance</label> : </td>
<<<<<<< HEAD:ProjetBanque/WebContent/modifier-info-client.jsp
	<td><input type="date" name="date" id ="date" /></td>
</tr>
	 
	 <tr>	 
    <td><label>Nationalité</label> : </td>
	<td><input type="text" name="nationalite" id ="nationalite" /></td>
=======
	<td> <%=clt.getClt_birthday()%></td>
</tr>
	 
	 <tr>	 
    <td><label>Nationalit�</label> : </td>
	<td> <%=clt.getClt_nationality()%></td>
>>>>>>> origin/master:ProjetBanque/WebContent/afficher-infos-client.jsp
	</tr>
	 
	 <tr>	
   <td> <label>Sexe</label> : </td>
<<<<<<< HEAD:ProjetBanque/WebContent/modifier-info-client.jsp
	<td><input type="text" name="sexe" id ="sexe" /></td>
=======
	<td> <%=clt.getClt_gender()%></td>
>>>>>>> origin/master:ProjetBanque/WebContent/afficher-infos-client.jsp
	</tr>
	
	<tr>	
    <td><label>Adresse</label> : </td>
<<<<<<< HEAD:ProjetBanque/WebContent/modifier-info-client.jsp
	<td><input type="text" name="addresse" id ="addresse" /></td>
=======
	<td> <%=clt.getClt_address()%></td>
>>>>>>> origin/master:ProjetBanque/WebContent/afficher-infos-client.jsp
	</tr>
	
	<tr>	
   <td> <label>Code postal</label> : </td>
<<<<<<< HEAD:ProjetBanque/WebContent/modifier-info-client.jsp:ProjetBanque/WebContent/modifier-info-client.jsp
<<<<<<< HEAD:ProjetBanque/WebContent/modifier-info-client.jsp
	<td><input type="number" onkeypress="return isNumberKey(evt)" name="codepostal" id ="codepostal" /></td>
=======
	<td> <%=clt.getClt_postalcode()%></td>
>>>>>>> origin/master:ProjetBanque/WebContent/afficher-infos-client.jsp
=======
	<td><%=clt.getClt_postalcode()%> </td>
>>>>>>> 257839360dcd3726db3c5bc35eaf419676048332:ProjetBanque/WebContent/afficher-infos-client.jsp:ProjetBanque/WebContent/afficher-infos-client.jsp
	</tr>
	
	<tr>	
   <td> <label>Ville</label> : </td>
<<<<<<< HEAD:ProjetBanque/WebContent/modifier-info-client.jsp
	<td><input type="text" name="ville" id ="ville" /></td>
	</tr>
	
	<tr>	
    <td><label>Numéro de téléphone</label> : </td>
	<td><input type="number" onkeypress="return isNumberKey(evt)" name="tel" id ="tel" /></td>
=======
	<td> <%=clt.getClt_city()%></td>
	</tr>
	
	<tr>	
    <td><label>Num�ro de t�l�phone</label> : </td>
	<td> <%=clt.getClt_telephonenumber()%></td>
>>>>>>> origin/master:ProjetBanque/WebContent/afficher-infos-client.jsp
	</tr>
	
	<tr>
   <td> <label>E-mail</label> : </td>
<<<<<<< HEAD:ProjetBanque/WebContent/modifier-info-client.jsp
	<td><input type="email" name="mail" id ="mail" /></td>
=======
	<td> <%=clt.getClt_email()%><td>
>>>>>>> origin/master:ProjetBanque/WebContent/afficher-infos-client.jsp
	 </tr>
	
	<tr>	
   <td> <label>Statut</label> : </td>
<<<<<<< HEAD:ProjetBanque/WebContent/modifier-info-client.jsp
	<td><input type="text" name="statut" id ="statut" /></td>
=======
	<td> <%=clt.getClt_status()%></td>
>>>>>>> origin/master:ProjetBanque/WebContent/afficher-infos-client.jsp
	</tr>
	
	</table>
	
	
	
<<<<<<< HEAD:ProjetBanque/WebContent/modifier-info-client.jsp:ProjetBanque/WebContent/modifier-info-client.jsp
=======
	
	<br><br>
>>>>>>> 257839360dcd3726db3c5bc35eaf419676048332:ProjetBanque/WebContent/afficher-infos-client.jsp:ProjetBanque/WebContent/afficher-infos-client.jsp
    <p>
	<input type="submit" value="Enregistrer les modifications" OnClick="zoneclient.html"/> 
    <input type="button" value="Annuler"  OnClick= "location.href='zoneclient.html'"/>
    <input type="reset" value="Recommencer" />
	</p>
	
 </form>
 
   </fieldset>
	
	
	</center>
			
			
			
			</section><!-- end of #content -->


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
        interval: 5000 //changes the speed
    })
    </script>

</body>

</html>
