
<%@ page import="model.Client, dao.DaoClient, model.Account, dao.DaoAccount, java.util.ArrayList"%>

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
<<<<<<< HEAD
<div id="wrapper"><!-- #wrapper -->
<%
								Client clt = (Client) session.getAttribute("client");
								ArrayList<Account> accList = DaoAccount.findAccountByClientId(clt.getClt_id());
								request.setAttribute("accList", accList);
							%>
	<header><!-- header -->
	<h1><img src="bank.png" alt="image"><a href="#">BankRading </a></h1><!-- header image -->
		
		
	</header><!-- end of header -->
	<nav><!-- top nav -->
		<div class="menu">
			<ul>
				<li><a href="#">Acceuil</a></li>
  			</li>
				<li><a href="#">Services</a>
					
				</li>
				<li><a href="#">About us</a>
					
				</li>
				<li><a href="#">Bourse</a></li>
				<li><a href="contact.html">Nous Contacter</a></li>
				<li><a href="#">Espace Client</a>
			    <ul>
   					<li><a href="Se connecter.html">Se connecter</a></li>
   					<li><a href="Creer un compte.php">Creer un compte</a></li>
   				</ul>
			</ul>
		</div>
	</nav><!-- end of top nav -->
	
=======

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
                                <a href="full-width.html">Acceder à mon compte</a>
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








>>>>>>> 1ca1c44de6ca5920969a03014f0b4a59258737f0
	<section id="main"><!-- #main content and sidebar area -->
			<section id="content"><!-- #content -->
			
				     <h1><legend>Afficher vos informations :<legend></h1> <!-- Titre du fieldset --> 
	   
	   
	   
	   
	   
	   
	   
	    <form method="post" action=".php">
     <center>
	 <table>

   <tr>
        
	<td> <label>Identifiant   </label> : </td>
	<td> <%=clt.getClt_login()%></td>
		 
		 </tr>

	 <tr>	
    <td><label>Nom</label> : </td>
	<td> <%=clt.getClt_lname()%></td>
	</tr>
	 
	 <tr>	
    <td><label>Prenom</label> : </td>
	<td><%=clt.getClt_fname()%> </td>
	</tr>
	 
	 <tr>
   <td> <label>Date de naissance</label> : </td>
	<td> <%=clt.getClt_birthday()%></td>
</tr>
	 
	 <tr>	 
    <td><label>Nationalite</label> : </td>
	<td> <%=clt.getClt_nationality()%></td>
	</tr>
	 
	 <tr>	
   <td> <label>Sexe</label> : </td>
	<td> <%=clt.getClt_gender()%></td>
	</tr>
	
	<tr>	
    <td><label>Adresse</label> : </td>
	<td> <%=clt.getClt_address()%></td>
	</tr>
	
	<tr>	
   <td> <label>Code postal</label> : </td>
	<td> <%=clt.getClt_postalcode()%></td>
	</tr>
	
	<tr>	
   <td> <label>Ville</label> : </td>
	<td> <%=clt.getClt_city()%></td>
	</tr>
	
	<tr>	
    <td><label>Numero de telephone</label> : </td>
	<td> <%=clt.getClt_telephonenumber()%></td>
	</tr>
	
	<tr>
   <td> <label>E-mail</label> : </td>
	<td> <%=clt.getClt_email()%><td>
	 </tr>
	
	<tr>	
   <td> <label>Statut</label> : </td>
	<td> <%=clt.getClt_status()%></td>
	</tr>
	
	</table>
	
	
	
	
	
    <p>
<input type="button" value="Modifier les informations" OnClick="location.href='modifier-infos-client.jsp'"/>          
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
