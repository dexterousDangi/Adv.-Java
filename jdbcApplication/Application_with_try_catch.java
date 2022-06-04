package jdbcFirstApplication;

// if we don't use try-catch and finally block then there is great chances of data leakage and other issues
// like if exception occur before closing the connection or statement and program terminates abnormally , then 
// our connection will remains open because close() method does'nt executed and program gets terminated , to avoid
// such condition we use try-catch with finally block , if we throws the exception then also same situation will persist
// jvm can handle the exception but can't use finally block so that it can close all the open resources.


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Application_with_try_catch {

	public static void main(String[] args) {
		Connection connection = null;
		Statement statement =null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			statement = connection.createStatement();
			statement.execute("create table emp1(ename varchar2(30), eid number)");
			statement.execute("insert into emp values('dangi',432)");		
		}
		catch(ClassNotFoundException e) {
		e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
	}
		finally {
			try {
			if(connection!=null)
				connection.close();
			if(statement !=null)
				statement.close();
			}
			catch(SQLException e) {
			e.printStackTrace();
			}
			}
	System.out.println("every thing is fine");		
	}
}
