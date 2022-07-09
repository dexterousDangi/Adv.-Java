<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%!String uname;
	int uage;
	String uage1;%>
	
	
	<%
	uname = request.getParameter("uname");
	uage1=request.getParameter("uage");
	uage = Integer.parseInt(uage1);

	session.setAttribute("uname", uname);
	session.setAttribute("uage", uage);
	%>
	<jsp:forward page="form2.html"></jsp:forward>
</body>
</html>