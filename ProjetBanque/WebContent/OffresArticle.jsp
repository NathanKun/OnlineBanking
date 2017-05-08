<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page
   import="java.util.ArrayList, dao.DaoOffers, model.Offers"%>

<c:if test="${empty param.offresId}">
    <c:redirect url="./offres.jsp"/>
</c:if>
<%
	int id = -1;
	try {
		id = Integer.parseInt(request.getParameter("offresId"));
	} catch(NumberFormatException e) {
		response.sendRedirect("./offres.jsp");
	}
	Offers ofr = DaoOffers.getOffers(id);
	session.setAttribute("offres", ofr);
%>

<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>RadBanking - Offres - <c:out value="${offres.getOfr_title()}" /></title>
        <!-- Bootstrap Core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <!-- Custom CSS -->
        <link href="css/modern-business.css" rel="stylesheet">
        <link href="css/carousel.css" rel="stylesheet">
        <!-- Custom Fonts -->
        <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="css/offresImg.css" rel="stylesheet">
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
                            <li><a href="index.jsp">Accueil</a></li>
                            <li class="active"><a href="offres.jsp">Offres</a></li>
                            <li class="active"><c:out value="${offres.getOfr_title()}" /></li>
                        </ol>
                    </div>
                </div>
                <!-- /.row -->
                
                
                <div class="row">
                    <div class="col-lg-12">
                    <div class="col-lg-1"></div>
                    <div class="col-lg-10">
	                	<h3><c:out value="${news.getOfr_title()}" /></h3>
	                	<h4><c:out value="${news.getOfr_type()}" /></h4>
	                	<h4><c:out value="${news.getOfr_date()}" /></h4>
	                	<img class="offresImg" alt="<c:out value="${offres.getOfr_title()}" />" src="<c:out value="${offres.getOfr_image()}" />">
	                	<p><c:out value="${news.getOfr_text()}" /></p>
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
                    document.getElementById("offres").className = "dropdown active";
                }
            </script>
    </body>

</html>
<% session.removeAttribute("offres"); %>