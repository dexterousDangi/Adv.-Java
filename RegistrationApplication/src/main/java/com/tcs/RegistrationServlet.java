package com.tcs;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public RegistrationServlet() {
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		String[] qualificaiton = request.getParameterValues("qualification");

		String gender = request.getParameter("gender");

		String[] technologies = request.getParameterValues("technologies");

		String[] address = request.getParameterValues("address");

		writer.println("<html>");
		writer.println("<body bgcolor='lightgreen'>");
		writer.println("<center><b><font size='6'>");
		writer.println("Name - " + username);
		writer.println("<br><br>");
		writer.println("Password- " + password);
		writer.println("<br><br>");
		writer.println("Qualification<br><br>");
		for (int i = 0; i < qualificaiton.length; i++) {
			writer.println(qualificaiton[i]);
			writer.println("<br><br>");
		}
		writer.println("Gender - " + gender);
		writer.println("<br><br>");
		writer.println("Technologies<br><br>");
		for (int i = 0; i < technologies.length; i++) {
			writer.println(technologies[i]);
			writer.println("<br><br>");
		}
		writer.println("Address: ");
		for(String addr:address) {
			writer.println(addr);
			writer.println("<br>");
		}
		writer.println("<br><br>");
		writer.println("Congratulations..." + username);
		writer.println("<br><br> You are Registeraion success");
		writer.println("</font></b></center></body></html>");

	}

}
