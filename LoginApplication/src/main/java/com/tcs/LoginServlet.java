package com.tcs;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// general setting , what type of response we are sending to the client
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();

		// get all the details present in request object using getParameter() method.
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		// request processing logic
		if (username.equalsIgnoreCase("pardeep") && password.equals("dangi")) {
			writer.println("login successful..." + username);
		} else {
			writer.println("Login fails... try with correct credential");
		}
		
/*       
 *   or
 *  we can also perform redirect operation and declare our customized error messages too.
 * 
		if (username.equalsIgnoreCase("pardeep") && password.equals("dangi")) {
			response.sendRedirect("http://www.google.com");
		} else {
			response.sendError(420, "login failed....");
		}
*/	
		// or
		// above we are providing static messages like login successful or login fails
		// we can make it little dynamic using html code inside the java code
		// but to use html code with java is not a good practice so, we declare this 
		// message in a html file and forward the request to that page after if condition is ture
/*		
		if (username.equalsIgnoreCase("pardeep") && password.equals("dangi")) {
			writer.println("login <h1>successful</h1>"+  "..." + username);
		} else {
			writer.println("Login fails... try with correct credential");
		}
*/			
		
	/*	  or
	 * we can render our message of successful login or login failed to another html page
	 * using the RequestDispatcher and forward() method.	 
	 
		if (username.equalsIgnoreCase("pardeep") && password.equals("dangi")) {
			RequestDispatcher dispatcher= request.getRequestDispatcher("success.html");
			dispatcher.forward(request, response);
		} else {
			RequestDispatcher dispatcher= request.getRequestDispatcher("failedmsg.html");
			dispatcher.forward(request, response);
		}
	*/	
		
	// or 
		//we can also use the HyperLink to process the next step after successful login or login failed
	/*
		if (username.equalsIgnoreCase("pardeep") && password.equals("dangi")) {
			writer.println("<a href='http://www.google.com'> click here to go to google page</a>");
		} else {
			writer.println("<a href='FailServlet'> click here to get the failed information</a>");
		}
		
		*/
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response); 
	}

}
