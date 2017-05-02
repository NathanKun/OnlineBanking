<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page
   import="java.util.ArrayList, dao.DaoNews, model.News, org.apache.commons.lang3.StringUtils"%>
<%
	String input = request.getParameter("search");
	if(input == null){
		input = "";
	}
	String[] keyWords = input.split(" ");
	System.out.println("input = " + input);
	System.out.println("keyWords");
	for(String str : keyWords){
		System.out.println(str);
		
	}

	ArrayList<News> bankNewsList = DaoNews.findAllBankNews();
	ArrayList<News> otherNewsList = DaoNews.findAllOtherNews();
	
	ArrayList<News> bankNewsShowList = new ArrayList<News>();
	ArrayList<News> otherNewsShowList = new ArrayList<News>();
	
	for(News nws : bankNewsList){
		boolean isContains = false;
		for(String key : keyWords){
			
			if(StringUtils.containsIgnoreCase(nws.getNws_title(), key) || 
					StringUtils.containsIgnoreCase(nws.getNws_text(), key) ||
					StringUtils.containsIgnoreCase(nws.getNws_type(), key) ){
				isContains = true;
			}
			if(isContains){
				bankNewsShowList.add(nws);
			}
		}
	}
	
	for(News nws : otherNewsList){
		boolean isContains = false;
		for(String key : keyWords){
			if(StringUtils.containsIgnoreCase(nws.getNws_title(), key) || 
					StringUtils.containsIgnoreCase(nws.getNws_text(), key) ||
					StringUtils.containsIgnoreCase(nws.getNws_type(), key) ){
				isContains = true;
			}
			if(isContains){
				otherNewsShowList.add(nws);
			}
		}
	}

	session.setAttribute("bankNewsList", bankNewsShowList);
	session.setAttribute("otherNewsList", otherNewsShowList);
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
                        <h1 class="page-header">Actualités<small>BanKrading</small></h1>
                        <ol class="breadcrumb">
                            <li><a href="index.jsp">Accueil</a></li>
                            <li class="active"><a href="news.jsp">Actualités</a></li>
                            <li class="active">recherche</li>
                        </ol>
                    </div>
                </div>
                
                <div class="row">
                	<form action="./newsList.jsp" method="get" accept-charset="UTF-8" class="form-horizontal">
		                <div class="form-group">
				            <div class="col-md-6">
				            	<input id="search" name="search" placeholder="Mots clés" class="form-control input-md" type="text">
				            </div>
		                    <div class="col-md-6">
		                    	<input type="submit" value="Rechercher" id="searchBtn" class="btn btn-primary">
		                    </div>
			            </div>
		            </form>
                </div>

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
                        <c:forEach var="nws" items="${otherNewsList}">
	                        <a href='./newsArticle.jsp?newsId=${nws.getNws_id()}' class='col-lg-3 col-md-4 col-sm-6 col-xs-6 col-xxs-12'>
	                            <article class='style1'>
	                                <div class='date'>
	                                    <c:out value="${nws.getNws_type()}"></c:out>
	                                </div>
	                                <!--must have larger width than height-->
	                                <img src='${nws.getNws_image()}'>
	                                <div class='content'>
	                                    <!--32 charecter max-->
	                                    <div class='title'>
	                                    <c:out value="${nws.getNws_title()}"></c:out>
	                                    </div>
	                                    <div class='info'>
	                                        <p><c:out value="${nws.getNws_text()}"></c:out></p>
	                                    </div>
	                                </div>
	                            </article>
	                        </a>
                        </c:forEach>
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
                        <c:forEach var="nws" items="${bankNewsList}">
	                        <a href='./newsArticle.jsp?newsId=${nws.getNws_id()}' class='col-lg-3 col-md-4 col-sm-6 col-xs-6 col-xxs-12'>
	                            <article class='style1'>
	                                <div class='date'>
	                                    <c:out value="${nws.getNws_type()}"></c:out>
	                                </div>
	                                <!--must have larger width than height-->
	                                <img src='${nws.getNws_image()}'>
	                                <div class='content'>
	                                    <!--32 charecter max-->
	                                    <div class='title'>
	                                    <c:out value="${nws.getNws_title()}"></c:out>
	                                    </div>
	                                    <div class='info'>
	                                        <p><c:out value="${nws.getNws_text()}"></c:out></p>
	                                    </div>
	                                </div>
	                            </article>
	                        </a>
                        </c:forEach>
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