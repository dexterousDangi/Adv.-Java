<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%!String uname;
	int uage;
	String uaddr;

	static Connection con;
	static Statement st;
	ResultSet rs;

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "manager");
			st = con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}%>
	<%
	try {
		uname = request.getParameter("uname");
		uage = Integer.parseInt(request.getParameter("uage"));
		uaddr = request.getParameter("uaddr");

		rs = st.executeQuery("select * from reg_users where uname='" + uname + "'");
		boolean b = rs.next();
		if (b == true) {
	%>
	<jsp:forward page="existed.jsp"></jsp:forward>
	<%
	} else {
	int rowCount = st.executeUpdate("insert into reg_users values('" + uname + "','" + uage + "','" + uaddr + "')");
	if (rowCount == 1) {
	%>

	<jsp:forward page="success.jsp" />
	<%
	} else {
	%>
	<jsp:forward page="failure.jsp"></jsp:forward>
	<%
	}
	}
	} catch (Exception e) {
	%>
	<jsp:forward page="failure.jsp" />
	<%
	e.printStackTrace();
	}
	%>
</body>
</html>