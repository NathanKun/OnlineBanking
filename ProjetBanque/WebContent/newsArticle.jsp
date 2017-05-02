<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page
   import="java.util.ArrayList, dao.DaoNews, model.News"%>

<c:if test="${empty param.newsId}">
    <c:redirect url="./news.jsp"/>
</c:if>
<%
	int id = -1;
	try {
		id = Integer.parseInt(request.getParameter("newsId"));
	} catch(NumberFormatException e) {
		response.sendRedirect("./news.jsp");
	}
	News nws = DaoNews.getNews(id);
	session.setAttribute("news", nws);
%>

<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>RadBanking - Actualité - <c:out value="${news.getNws_title()}" /></title>
        <!-- Bootstrap Core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <!-- Custom CSS -->
        <link href="css/modern-business.css" rel="stylesheet">
        <link href="css/carousel.css" rel="stylesheet">
        <!-- Custom Fonts -->
        <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="css/newArticle.css" rel="stylesheet">
    </head>

    <body>
        <%@ include file="./includes/nav.inc.jsp"%>
            <!-- Page Content -->
            <div class="container">
                <!-- Page Heading/Breadcrumbs -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">Actualités<small>BanKrading</small></h1>
                        <ol class="breadcrumb">
                            <li><a href="index.jsp">Accueil</a></li>
                            <li class="active"><a href="news.jsp">Actualités</a></li>
                            <li class="active"><c:out value="${news.getNws_title()}" /></li>
                        </ol>
                    </div>
                </div>
                <!-- /.row -->
                
                
                <div class="row">
                    <div class="col-lg-12">
                    <div class="col-lg-1"></div>
                    <div class="col-lg-10">
	                	<h3><c:out value="${news.getNws_title()}" /></h3>
	                	<h4><c:out value="${news.getNws_type()}" /></h4>
	                	<h4><c:out value="${news.getNws_date()}" /></h4>
	                	<img class="newsImg" alt="<c:out value="${news.getNws_title()}" />" src="<c:out value="${news.getNws_image()}" />">
	                	<p><c:out value="${news.getNws_text()}" /></p>
                    </div>
                    <div class="col-lg-1"></div>
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
<% session.removeAttribute("news"); %>