package com.tcs;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SecondServlet() {
        super();

    }

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");	
		PrintWriter writer=response.getWriter();
		
		ServletConfig config=this.getServletConfig();
		writer.println("Second Servlet init Param-1: "+ config.getInitParameter("vcs1"));
		writer.println("<br><br>");
		writer.println("Second Servlet init Param-2: "+ config.getInitParameter("vcs2"));
		writer.println("<br><br>");
		
		ServletContext context= request.getServletContext();
		writer.println("Second Servlet Context Param-1: "+ context.getInitParameter("username"));
		writer.println("<br><br>");
		writer.println("Second Servlet Context Param-2: "+ context.getInitParameter("password"));
		writer.println("<br><br>");
	}

 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
		doGet(request, response);
	}

}
