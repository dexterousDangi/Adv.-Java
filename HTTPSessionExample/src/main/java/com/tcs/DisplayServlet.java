package com.tcs;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DisplayServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// details of the last form is always retervied from request object only
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");

		HttpSession session = request.getSession(false);

		// these details we get from HttpSession object

		String uname = (String) session.getAttribute("uname");
		String uage = (String) session.getAttribute("uage");
		String uqual = (String) session.getAttribute("uqual");
		String udesig = (String) session.getAttribute("udesig");

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		out.println("<html>");
		out.println("<body bgcolor='blue'>");
		out.println("<center><h1>");
		out.println("<br><br>");

		/**
		 * We can also this line of code
		 * out.println("UserName..."+session.getAttribute("uname")+<br>
		 * <br>
		 * );
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
