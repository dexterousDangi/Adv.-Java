package com.tcs;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public SecondServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String uqual=request.getParameter("uqual");
		String udesig=request.getParameter("udesig");
		
		// these are the second request details, for this http session object is already created just need to locate the object, no need to create the object
		HttpSession session=request.getSession(false);
		
		session.setAttribute("uqual", uqual); // provide the varible name as uname, we have to provide the same varible while getting attribute.
		session.setAttribute("udesig", udesig);
		
		
		request.getRequestDispatcher("form3.html").forward(request, response);
		
	}

}
