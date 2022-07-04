package com.tcs;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 2-request details 4-cookies details -> all are store in the request object.

		Cookie[] cookies = request.getCookies();

		String uname = cookies[0].getValue();
		String uage = cookies[1].getValue();
		String uqual = cookies[2].getValue();
		String udesig = cookies[3].getValue();
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		out.println("<html>");
		out.println("<body bgcolor='blue'>");
		out.println("<center><h1>");
		out.println("<br><br>");
		/**
		 * out.println("Name..." + cookies[0].getValue() + "<br><br>");
		 * also do the same work
		 */
		out.println("Name..." + uname + "<br><br>");
		out.println("Age...." + uage + "<br><br>");
		out.println("Qualification..." + uqual + "<br><br>");
		out.println("Designation..." + udesig + "<br><br>");
		out.println("Email..." + email + "<br><br>");
		out.println("Mobile..." + mobile + "<br><br>");
		out.println("</center></h1>");
		out.println("</boby>");
		out.println("</html>");

	}

}
