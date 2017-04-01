<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta charset="utf-8">
	<title>Accueil Client</title>
</head>
<body>
<%   
   	// if logged in  
	if(session.getAttribute("client")!=null) {
%> 


Bienvenue Votre Solde est de 
<%@ page import="model.Client, dao.DaoClient, model.Account, dao.DaoAccount, java.util.ArrayList" %>
<%
	Client clt = (Client)session.getAttribute("client"); 
	ArrayList<Account> accList = DaoAccount.findAccountByClientId(clt.getClt_id());
%>
<%= accList.get(0).getAcc_balance() %>
 euros
 
 <h5><a href="./Logout">Deconnexion</a></h5> 
<%
   } else{
%> 
	<h3>Veuillez <a href="./login.jsp">vous identifiez</a></h3> 
<%      
   }
 %>
</body>
</html>