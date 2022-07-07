<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>

	<%-- this is declaration : declaration --%>

	<%!String username;
	String password;

	public String name() {
		return "this is instance method with String return type";
	}

	public String last() {
		return "dangi";
	}%>

	<!--  this is block of java code: scriplet -->
	<%
	username = request.getParameter("username");
	password = request.getParameter("password");

	if (username.equalsIgnoreCase("pardeep") && password.equals("dangi")) {
		out.println("login suceessfull..." + username);
	} else {
		out.println("Login fail try with valid data..." + username);
		out.println("<a href='Login.html'>Login again</a>");
	}
	out.print("<br>");
	 out.println(name());
				
	out.print("<br>");
	out.println(last());
	%>
	<br>
	<%=  name() %>
	<br>
	<%= username %>
	<br>
	<%=   password %>

</body>
</html>