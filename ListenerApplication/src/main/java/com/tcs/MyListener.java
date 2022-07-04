package com.tcs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Application Lifecycle Listener implementation class MyListener
 *
 */
public class MyListener implements ServletContextListener {

	/**
	 * Default constructor.
	 */
	public MyListener() {
	}

	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("ContextDestroyed method connection closed.");
		ServletContext context = sce.getServletContext();
		Connection connection = (Connection) context.getAttribute("conn");
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("contextInitialized method Connection created");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system",
					"manager");

			// placing connection in the servletcontext object , because scope of the
			// servlet context object is through out the application

			ServletContext context = sce.getServletContext();
			context.setAttribute("conn", connection);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
