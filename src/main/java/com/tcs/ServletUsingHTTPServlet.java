package com.tcs;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletUsingHTTPServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletUsingHTTPServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		PrintWriter writer = response.getWriter().append("Served at: ").append(request.getContextPath());
		writer.println(" this is http servlet get() method");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		PrintWriter writer = response.getWriter().append("Served at: ").append(request.getContextPath());
		writer.println(" this is http servlet Post() method");
	}

} 
