<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%!String email;
	String mobile;
	Connection connection;
	PreparedStatement preparedStatement;
	%>
	<%
	
	// create the connection
	Class.forName("oracle.jdbc.driver.OracleDriver");
	connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
	
	// first create the table using: SQL> create table user_details(username varchar2(30), age number, qualification
    // varchar2(30), designation varchar2(30), email varchar2(30), mobile varchar2(13));
	
	preparedStatement=connection.prepareStatement("insert into user_details values(?,?,?,?,?,?)");
	preparedStatement.setString(1,(String)session.getAttribute("uname"));
	preparedStatement.setInt(2,(Integer)session.getAttribute("uage"));
	preparedStatement.setString(3,(String)session.getAttribute("udesig"));
	preparedStatement.setString(4,session.getAttribute("uqual").toString());   // this is also fine
	preparedStatement.setString(5,request.getParameter("email"));
	preparedStatement.setString(6,request.getParameter("mobile"));
	preparedStatement.executeUpdate();
	
	out.println("data inserted successfully");
	
	
	email = request.getParameter("email");
	mobile = request.getParameter("mobile");

	out.println("User Name: " + session.getAttribute("uname"));
	out.println("<br>");
	out.println("User Age: " + session.getAttribute("uage"));
	out.println("<br>");
	out.println("Designation: " + session.getAttribute("udesig"));
	out.println("<br>");
	out.println("Qualification: " + session.getAttribute("uqual"));
	out.println("<br>");
	out.println("Mobile: " + mobile);
	out.println("<br>");
	out.println("Email: " + email);
	out.println("<br>");
	%>

</body>
</html>