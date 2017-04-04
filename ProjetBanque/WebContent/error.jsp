<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE HTML">
<html>
	<head>
	<title>Sql Inject Filter</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	</head>
	
	<body>
		This is SQL inject filter, we filtered your request automatically,
		please change your inputs.
		<%=session.getAttribute("sqlInjectError")%>
		<p>
			<a href="<%=path%>">Click here to return</a>
		</p>
	</body>
</html>
