package com.tcs;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public FirstServlet() {
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	 	String uname=request.getParameter("uname");
		String uage=request.getParameter("uage");
		
		// to maintain this data we required HTTPSession object
		HttpSession session=request.getSession();
		
		session.setAttribute("uname", uname); // provide the varible name as uname, we have to provide the same varible while getting attribute.
		session.setAttribute("uage", uage);
		
		request.getRequestDispatcher("form2.html").forward(request, response);
	}

}
