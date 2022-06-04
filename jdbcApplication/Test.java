package jdbcFirstApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		// STEP 1: LOAD THE DRIVE:(means it is automatically registered in DMS(driver manager services))
		
		// these driver class names provided by the database vendors, and given in the form of jar files only
		// like "ojdbc6.jar" or "ojdbc5.jar" files. we have to make eligible these jar files to the application
		// means we have to give the jar files to this application. how to provide these jar
		// with the help of the "Build Path" options
		// now load those '.class ' files with the help of class Class forName() method)
	Class.forName("oracle.jdbc.driver.OracleDriver");
	System.out.println("driver loading completed...");
		
		// STEP 2: CREATE A CONNECTION :using DriverManager class getConnection(args1,args2,args3) method
		// arg1= url patter of DB, args2= username of DB, args3= password of DB
	
		Connection connection =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
		System.out.println("connection established..."+connection);
		
		// STEP: 3 write the querry 
		String querry1= "create table team(eid number, ename varchar2(30), esal number)";
		String querry2="insert into team values(12,'anu',232355)";
		// 	STEP 4: process the querry means simply handover the querry to the data base using Statement object
		Statement statement=connection.createStatement();
	
		// of three method executeQuerry(), executeUpdate(), execute() use the appropriate one according to the querry used.
		
		int x=statement.executeUpdate(querry1);
		boolean b=	statement.execute(querry2);
		System.out.println("table created successfully..."+x);
		System.out.println("table updated..."+b);
		// STEP 5: close the resources
		connection.close();
		System.out.println("connection closed successfully...");
	 }

}
  
