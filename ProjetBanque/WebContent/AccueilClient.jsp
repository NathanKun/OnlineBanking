<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Bienvenue Votre Solde est de 
<%@ page import="model.Client, dao.DaoClient, model.Account, dao.DaoAccount" %>
<%
	//Client clt = DaoClient.getClient(1);
	Account acc = DaoAccount.getAccount(1);
%>
<%= acc.getAcc_balance() %>
 euros
</body>
</html>