<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!-- now by using html file we will update the data in the bean class -->

	<%!int eid;
	String ename;
	double esal;%>
	<%
	eid = Integer.parseInt(request.getParameter("eid"));
	ename = request.getParameter("ename");
	esal = Double.parseDouble(request.getParameter("esal"));
	%>

	<!-- first configure the empbean class , here id is the reference variable for the object to be created -->
	<jsp:useBean id="eb" class="com.tcs.EmpBean" scope="page"></jsp:useBean>

	<!-- set the data to bean class using following jsp actions -->
	<jsp:setProperty property="eid" name="eb" value="<%=eid%>" />
	<jsp:setProperty property="ename" name="eb" value="<%=ename%>" />
	<jsp:setProperty property="esal" name="eb" value="<%=esal%>" />

	<!-- now get the data using getter method of the bean class and following tags -->

	Emp ID:
	<jsp:getProperty property="eid" name="eb" /><br> Emp Name:
	<jsp:getProperty property="ename" name="eb" /><br> Emp Salary:
	<jsp:getProperty property="esal" name="eb" /><br>

</body>
</html>