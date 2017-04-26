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
                <a class="navbar-brand" href="<%=request.getContextPath()%>/index.jsp">BankRading</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li id="about">
                        <a href="<%=request.getContextPath()%>/about.jsp">Mieux nous connaitre</a>
                    </li>
                    <li id="news">
                        <a href="<%=request.getContextPath()%>/news.jsp">Actualités</a>
                    </li>
                    <li id="services">
                        <a href="<%=request.getContextPath()%>/services.jsp">Nos services</a>
                    </li>
                    <li id="offres" class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Nos offres <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li>
                                <a href="<%=request.getContextPath()%>/offres/offre1.jsp">Compte sans frais</a>
                            </li>
                            <li >
                                <a href="<%=request.getContextPath()%>/offres/offre2.jsp">Carte VISA graduite</a>
                            </li>
                            <li>
                                <a href="<%=request.getContextPath()%>/offres/offre3.jsp">Offre compte bancaire</a>
                            </li>
                        </ul>
                    </li>
                    <li id="bourse">
                        <a href="<%=request.getContextPath()%>/stock.jsp">Bourse</a>
                    </li>
                    <li id="contact">
                        <a href="<%=request.getContextPath()%>/contact.jsp">Nous contacter</a>
                    </li>
                    <li id="customerarea" class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Espace client <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li>
                                <a href="<%=request.getContextPath()%>/login.jsp">Accéder à mon compte</a>
                            </li>
                            <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
							<c:if test="${not empty client}">
	                            <li>
	                                <a href="<%=request.getContextPath()%>/Logout">Déconnexion</a>
	                            </li>
							</c:if>
							<c:if test="${empty client}">
	                            <li>
	                                <a href="<%=request.getContextPath()%>/subscribe.jsp">Devenir membre</a>
	                            </li>
							</c:if>
                        </ul>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
