package com.tcs;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFilter2 implements Filter {

	public MyFilter2() {
		// TODO Auto-generated constructor stub
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();

		String uaddr = request.getParameter("uaddr");
		if (uaddr.equalsIgnoreCase("Haryana")) {
			// pass the request along the filter chain
			chain.doFilter(request, response);
		} else {
			writer.println("this application only for the haryana person");
			request.getRequestDispatcher("Form.html").include(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
