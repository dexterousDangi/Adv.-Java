package com.tcs;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet(urlPatterns={"/FirstServlet"},
initParams=  { 
		@WebInitParam(name="user1", value="dangi"),
		@WebInitParam(name="user2",  value="ratan")		
})	
		
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public FirstServlet() {
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter writer= response.getWriter();
		
		writer.println("This is our First Annotated Servlet");
		
		ServletConfig config=this.getServletConfig();
		writer.println(("<br><br>"));
		writer.println(config.getInitParameter("user1"));
		writer.println(("<br><br>"));
		writer.println(config.getInitParameter("user2"));
		
		
	}


}
