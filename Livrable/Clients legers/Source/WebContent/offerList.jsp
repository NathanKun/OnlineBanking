<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ page
   import="java.util.ArrayList, dao.DaoOffer, model.Offer"%>
<%
	ArrayList<Offer> bankOffresList = DaoOffer.getOfferList();
%>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>RadBanking - Offres</title>
        <!-- Bootstrap Core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <!-- Custom CSS -->
        <link href="css/modern-business.css" rel="stylesheet">
        <link href="css/carousel.css" rel="stylesheet">
        <!-- Custom Fonts -->
        <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="css/offres.css" rel="stylesheet">
    </head>

    <body>
        <%@ include file="./includes/nav.inc.jsp"%>
            <!-- Page Content -->
            <div class="container">
                <!-- Page Heading/Breadcrumbs -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">Offres<small>BanKrading</small></h1>
                        <ol class="breadcrumb">
                            <li><a href="index.jsp">Accueil</a>
                            </li>
                            <li class="active">Offres</li>
                        </ol>
                    </div>
                </div>
                
               
                <div class='container-fluid'>

                    <div class='row'>
                        <nav class='col-xs-12'>
                            <div class='offresnav'>
                                <div id='recentoffres'><i class="fa fa-offrespaper-o"></i><span class='hidden-xxs'>Offres de la banque</span></div>
                                
                            </div>
                        </nav>
                    </div>
                    <div class='row'>
                        <a href='./offerDetail.jsp?offerId=<%=bankOffresList.get(0).getOfr_id() %>' class='col-lg-3 col-md-4 col-sm-6 col-xs-6 col-xxs-12'>
                           <article class='style1'>
                                <!--must have larger width than height-->
                                <img src='<%=bankOffresList.get(0).getOfr_image() %>'>
                                <div class='content'>
                                    <!--32 charecter max-->
                                    <div class='title'>
                                    <%=bankOffresList.get(0).getOfr_title() %>
                                    </div>
                                    <div class='info'>
                                        <p><%=bankOffresList.get(0).getOfr_text() %></p>
                                    </div>
                                </div>
                            </article>
                        </a>
                        <a href='./offerDetail.jsp?offerId=<%=bankOffresList.get(1).getOfr_id() %>' class='col-lg-3 col-md-4 col-sm-6 col-xs-6 col-xxs-12'>
                           <article class='style1'>
                                <!--must have larger width than height-->
                                <img src='<%=bankOffresList.get(1).getOfr_image() %>'>
                                <div class='content'>
                                    <!--32 charecter max-->
                                    <div class='title'>
                                    <%=bankOffresList.get(1).getOfr_title() %>
                                    </div>
                                    <div class='info'>
                                        <p><%=bankOffresList.get(1).getOfr_text() %></p>
                                    </div>
                                </div>
                            </article>
                        </a>
                        <a href='./offerDetail.jsp?offerId=<%=bankOffresList.get(2).getOfr_id() %>' class='col-lg-3 col-md-4 col-sm-6 col-xs-6 col-xxs-12'>
                            <article class='style1'>
                                <!--must have larger width than height-->
                                <img src='<%=bankOffresList.get(2).getOfr_image() %>'>
                                <div class='content'>
                                    <!--32 charecter max-->
                                    <div class='title'>
                                    <%=bankOffresList.get(2).getOfr_title() %>
                                    </div>
                                    <div class='info'>
                                        <p><%=bankOffresList.get(2).getOfr_text() %></p>
                                    </div>
                                </div>
                            </article>
                        </a>
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
            <script>
                window.onload = function() {
                    document.getElementById("offres").className = "dropdown active";
                }
            </script>
    </body>

</html>