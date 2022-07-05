package com.tcs;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public LogoutServlet() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		HttpSession session=request.getSession(false); // for first time only the getSession() is true, after that we first check if there is
														// any session object is present in the application we locate that and use it 
		
		session.invalidate();  // to execute the sessionDestroyed() method in the listener
		
		out.print("you are successfully logged out");
		out.close();
		
		
	}



}
