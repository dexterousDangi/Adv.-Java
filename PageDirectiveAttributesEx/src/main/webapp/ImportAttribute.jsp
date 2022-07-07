<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="java.util.Date" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<body>
	<!-- this date class belong to the java.util.Date class and we are importing that using PageDirective tag -->
	<%!Date date = null;%>
	<% date=new Date(); %>
	Todays Date:  <%= date %>
</body>
</html>