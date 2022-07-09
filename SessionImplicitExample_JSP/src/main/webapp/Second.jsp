<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%!String uqual;
	String udesig;%>
	<%
	uqual = request.getParameter("uqual");
	udesig = request.getParameter("udesign");

	session.setAttribute("uqual", uqual);
	session.setAttribute("udesig", udesig);
	%>
	<jsp:forward page="form3.html"></jsp:forward>
</body>
</html>