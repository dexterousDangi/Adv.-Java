package com.tcs;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter writer=response.getWriter();
		
		String tname=request.getParameter("tname");
		
		ServletContext context= request.getServletContext();
	 Connection connection=(Connection)	context.getAttribute("conn");
	try {
		Statement statement=connection.createStatement();
		ResultSet set=statement.executeQuery("select * from "+tname);
		
		while(set.next()) {
			writer.println(set.getString(1)+"...."+set.getInt(2));
			writer.println("<br><br>");
		}
		
		
	} catch (Exception e) {
		// TODO: handle exception
	}
		
		
	}
}
