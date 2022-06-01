package com.tcs;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FirstGenericServletApp extends GenericServlet {
	private static final long serialVersionUID = 1L;
       
  
    public FirstGenericServletApp() {
        super();
    }

	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// set the general setting 
		response.setContentType("text/html");
		
		PrintWriter writer= response.getWriter();
		writer.println("this is second servlet application using Generic servlet class...");
;
	}

}
