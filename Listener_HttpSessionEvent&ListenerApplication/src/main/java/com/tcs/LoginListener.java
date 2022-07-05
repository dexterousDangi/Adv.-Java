package com.tcs;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class LoginListener
 *
 */
public class LoginListener implements HttpSessionListener {

	int total=1;
	int current=1;
	ServletContext context=null;
	public void sessionCreated(HttpSessionEvent se) {
		
		System.out.println("Session object is created with id: " +se.getSession().getId());
		
		total++;
		current++;
		
		// i need these variable through out the application so just place them into the SeesionContext Object
		
		context=se.getSession().getServletContext();   // this is the way to get the context object
		context.setAttribute("totaluser", total);
		context.setAttribute("currentuser", current);
		
	}

	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("Session object is Destroyed with id: " +se.getSession().getId());
		current--;
		context.setAttribute("currentuser", current);
	}

	/**
	 * Default constructor.
	 */
	public LoginListener() {
		// TODO Auto-generated constructor stub
	}

}
