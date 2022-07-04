package com.tcs;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public FirstServlet() {
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		String uname=request.getParameter("uname");
		String uage=request.getParameter("uage");
		
		/**
		 * while processing form1.html these details comes to server side and for before processing 
		 * next request we have to store these details, so that in near future we can recall them
		 * so, we use cookie object to store these details at the client side 
		 */
		Cookie cookie1= new Cookie("uname", uname);
		Cookie cookie2= new Cookie("uage", uage);
		
		/**
		 * only the response goes back to the client side not the request object
		 * so we add these cookies to the response object.
		 */
		
		response.addCookie(cookie1);
		response.addCookie(cookie2);
		
		/**
		 * when this response object comes to the client then only the cookies will be stored to the client side.
		 */
		request.getRequestDispatcher("form2.html").forward(request, response);
	
	}

}
