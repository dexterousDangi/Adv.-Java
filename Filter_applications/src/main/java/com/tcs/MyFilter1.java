package com.tcs;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFilter1 implements Filter {

	public MyFilter1() {
		// TODO Auto-generated constructor stub
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		int age = Integer.parseInt(request.getParameter("uage"));
		if (age > 20) {
			// pass the request along the filter chain
		    long before=System.currentTimeMillis();   
		    
			chain.doFilter(request, response);
			
			   long after=System.currentTimeMillis();  
		    
			   writer.println("<br>");
			   writer.println("<br>");
			   
			   writer.println("<br/>Total response time "+(after-before)+" miliseconds");  
			
		}
		else {
			writer.println("you are not eligible for marriage, your age is below 20 years");
			request.getRequestDispatcher("Form.html").include(request, response);
		}

	
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
