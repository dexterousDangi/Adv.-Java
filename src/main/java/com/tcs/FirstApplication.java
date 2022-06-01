package com.tcs;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet implementation class FirstApplication
 */
public class FirstApplication implements Servlet {

   
    public FirstApplication() {
       
    }

	
	public void init(ServletConfig config) throws ServletException {
		System.out.println("this is init() method....");
	}

	public void destroy() {
		System.out.println("this is destroy() method");
	}

	public ServletConfig getServletConfig() {
		System.out.println("this is getServletConfig() method");
		return null;
	}

	
	public String getServletInfo() {
	System.out.println("this is getServletInfo() method ");
		return null; 
	}

	
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		
		System.out.println("this is service() method");
		// for every servlet application these two steps are common
		// setp 1: set the response type we are sending towards client side 
		
		 response.setContentType("text/html");
		
		// step 2: add the response to the response object using  PrintWriter object.
	
		  PrintWriter writer=response.getWriter();
		 writer.println("this is servlet first application...");
		
	}

}
