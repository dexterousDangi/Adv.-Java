package com.tcs;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public LoginServlet() {
		super();
	}
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String name=request.getParameter("username");
		out.println("welcome : "+name);

		HttpSession session=request.getSession();  // when we get this object only then void sessionCreated() method is extecuted in the listener.
		
		ServletContext ctx=request.getServletContext();
		/**
		 * we put all the information in the servletContext Object , becuase this object have scope all over the web application
		 * so this information can be accessed all over the web application
		 */
		
		int t=(Integer)ctx.getAttribute("totaluser");
		int c=(Integer)ctx.getAttribute("currentuser");
		
		out.print("<br> total users= "+t);
		out.print("<br> current users= "+c);
		
		out.print("<br><a href='LogoutServlet'>Logout</a>");  // anchor tag only send get request only
		out.close();
	
	}

}
