 package com.tcs;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

 
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection connection=null;
   
    public CustomerServlet() {
        // TODO Auto-generated constructor stub
    }
 
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
		response.setContentType("text/html");
		PrintWriter writer=response.getWriter();
		
		String firstName= request.getParameter("firstName");
		String lastName= request.getParameter("lastName");
		String mobile= request.getParameter("mobile");
		String email= request.getParameter("email");
		
		String [] addr= request.getParameterValues("t1");
		
		StringBuffer buffer= new StringBuffer();
		for(String data: addr) {
			buffer.append(data+",");
		}
		
		String caddr=buffer.toString();
		
		
		 try {
			 
			 if(connection==null) {
//			 Class.forName("oracle.jdbc.driver.OracleDriver");
//			connection= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
				 
			/*
			 * this is how third party connection pooling is done.
			 */
			//	 connection=ConnUtils.dataSource.getConnection();
				
				 
				 /*
				 * server side connection pooling 
				 */
			   Context initContext=new InitialContext();
			   DataSource ds=(DataSource)initContext.lookup("java:/comp/env/mypool");
			  connection=  ds.getConnection();
				 
			 }
			 PreparedStatement preparedStatement = connection.prepareStatement("insert into customer values (?,?,?,?,?)");
			 preparedStatement.setString(1, firstName);
			 preparedStatement.setString(2, lastName);
			 preparedStatement.setString(3, email);
			 preparedStatement.setString(4, mobile);
			 preparedStatement.setString(5, caddr);
			 
			 int a=preparedStatement.executeUpdate();
			 if(a==1) {
				 writer.println("Data inserted successfully....");
				 writer.println("<a href='DisplayServlet'>Click here to Display all records.</a>");
			 }
			 
			 
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		
	}

}
























