<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ page
   import="java.util.ArrayList, dao.DaoNews, model.News"%>
<%
	ArrayList<News> bankNewsList = DaoNews.find3BankNews();
	ArrayList<News> otherNewsList = DaoNews.find3OtherNews();
%>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>RadBanking - Actualité</title>
        <!-- Bootstrap Core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <!-- Custom CSS -->
        <link href="css/modern-business.css" rel="stylesheet">
        <link href="css/carousel.css" rel="stylesheet">
        <!-- Custom Fonts -->
        <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="css/new.css" rel="stylesheet">
    </head>

    <body>
        <%@ include file="./includes/nav.inc.jsp"%>
            <!-- Page Content -->
            <div class="container">
                <!-- Page Heading/Breadcrumbs -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">Qui  sommes-nous ?
               <small>BanKrading</small>
            </h1>
                        <ol class="breadcrumb">
                            <li><a href="index.jsp">Accueil</a>
                            </li>
                            <li class="active">Actualités</li>
                        </ol>
                    </div>
                </div>
                <!-- /.row -->

                <div class='container-fluid'>
                    <div class='row'>
                        <nav class='col-xs-12'>
                            <div class='newsnav'>
                                <div id='recentnews'><i class="fa fa-newspaper-o"></i><span class='hidden-xxs'>Actualités diverses</span></div>
                            </div>
                        </nav>
                    </div>
                    <div class='row'>
                        <!--STYLE1-->
                        <a href='#' class='col-lg-3 col-md-4 col-sm-6 col-xs-6 col-xxs-12'>
                            <article class='style1'>
                                <div class='date'>
                                    <%=otherNewsList.get(0).getNws_type() %>
                                </div>
                                <!--must have larger width than height-->
                                <img src='<%=otherNewsList.get(0).getNws_image() %>'>
                                <div class='content'>
                                    <!--32 charecter max-->
                                    <div class='title'>
                                    <%=otherNewsList.get(0).getNws_title() %>
                                    </div>
                                    <div class='info'>
                                        <p><%=otherNewsList.get(0).getNws_text() %></p>
                                    </div>
                                </div>
                            </article>
                        </a>
                        <a href='#' class='col-lg-3 col-md-4 col-sm-6 col-xs-6 col-xxs-12'>
                            <article class='style1'>
                                <div class='date'>
                                    <%=otherNewsList.get(1).getNws_type() %>
                                </div>
                                <!--must have larger width than height-->
                                <img src='<%=otherNewsList.get(1).getNws_image() %>'>
                                <div class='content'>
                                    <!--32 charecter max-->
                                    <div class='title'>
                                    <%=otherNewsList.get(1).getNws_title() %>
                                    </div>
                                    <div class='info'>
                                        <p><%=otherNewsList.get(1).getNws_text() %></p>
                                    </div>
                                </div>
                            </article>
                        </a>
                        <a href='#' class='col-lg-3 col-md-4 col-sm-6 col-xs-6 col-xxs-12'>
                            <article class='style1'>
                                <div class='date'>
                                    <%=otherNewsList.get(2).getNws_type() %>
                                </div>
                                <!--must have larger width than height-->
                                <img src='<%=otherNewsList.get(2).getNws_image() %>'>
                                <div class='content'>
                                    <!--32 charecter max-->
                                    <div class='title'>
                                    <%=otherNewsList.get(2).getNws_title() %>
                                    </div>
                                    <div class='info'>
                                        <p><%=otherNewsList.get(2).getNws_text() %></p>
                                    </div>
                                </div>
                            </article>
                        </a>
                    </div>
                </div>

                <div class='container-fluid'>

                    <div class='row'>
                        <nav class='col-xs-12'>
                            <div class='newsnav'>
                                <div id='recentnews'><i class="fa fa-newspaper-o"></i><span class='hidden-xxs'>Actualités de la banque</span></div>
                            </div>
                        </nav>
                    </div>
                    <div class='row'>
                        <a href='#' class='col-lg-3 col-md-4 col-sm-6 col-xs-6 col-xxs-12'>
                            <article class='style1'>
                                <div class='date'>
                                    <%=bankNewsList.get(0).getNws_type() %>
                                </div>
                                <!--must have larger width than height-->
                                <img src='<%=bankNewsList.get(0).getNws_image() %>'>
                                <div class='content'>
                                    <!--32 charecter max-->
                                    <div class='title'>
                                    <%=bankNewsList.get(0).getNws_title() %>
                                    </div>
                                    <div class='info'>
                                        <p><%=bankNewsList.get(0).getNws_text() %></p>
                                    </div>
                                </div>
                            </article>
                        </a>
                        <a href='#' class='col-lg-3 col-md-4 col-sm-6 col-xs-6 col-xxs-12'>
                            <article class='style1'>
                                <div class='date'>
                                    <%=bankNewsList.get(1).getNws_type() %>
                                </div>
                                <!--must have larger width than height-->
                                <img src='<%=bankNewsList.get(1).getNws_image() %>'>
                                <div class='content'>
                                    <!--32 charecter max-->
                                    <div class='title'>
                                    <%=bankNewsList.get(1).getNws_title() %>
                                    </div>
                                    <div class='info'>
                                        <p><%=bankNewsList.get(1).getNws_text() %></p>
                                    </div>
                                </div>
                            </article>
                        </a>
                        <a href='#' class='col-lg-3 col-md-4 col-sm-6 col-xs-6 col-xxs-12'>
                            <article class='style1'>
                                <div class='date'>
                                    <%=bankNewsList.get(2).getNws_type() %>
                                </div>
                                <!--must have larger width than height-->
                                <img src='<%=bankNewsList.get(2).getNws_image() %>'>
                                <div class='content'>
                                    <!--32 charecter max-->
                                    <div class='title'>
                                    <%=bankNewsList.get(2).getNws_title() %>
                                    </div>
                                    <div class='info'>
                                        <p><%=bankNewsList.get(2).getNws_text() %></p>
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
                    document.getElementById("news").className = "dropdown active";
                }
            </script>
    </body>

</html>