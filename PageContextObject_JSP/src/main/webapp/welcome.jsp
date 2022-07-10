<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	String username = request.getParameter("username");
	pageContext.setAttribute("username", username,PageContext.SESSION_SCOPE);
	out.println("<a href='second.jsp'>click here to get msg</a>");
	
	%>
</body>
</html>