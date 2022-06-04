package jdbcFirstApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// try with resources means we declare all the resources inside the try block and will automatically close the 
// all the resources by itself when ever control moves out side the try block.
// this all happens because of the AutoClosble Interface. belong to java.lang package 
// internally calling close() method

public class Try_with_resoureces_application {

	public static void main(String[] args) {
		// loading the driver is optional
		
		try(Connection connection= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");   // Syntax is important
				
			Statement statement= connection.createStatement())
		{
//		statement.execute("create table team11(ename varchar2(20), eid number)");
//			statement.execute("insert into team11 values ('dani', 3)");
//			statement.execute("insert into team11 values ('dangi', 30)");
//		statement.execute("insert into team11 values ('danggi', 300)");
//			statement.execute("insert into team11 values ('dangggi', 3000)");
			
			String qer= "select * from team11";
			ResultSet set= statement.executeQuery(qer); // return type of executeQuery method is Result set type
			
			
		while(set.next()) {		
			System.out.println(set.getString("ename")+"..."+set.getInt("eid"));   // or System.out.println(set.getString(1)+"..."+set.getInt(2));  
		}
		
			
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("everything is fine");
	}

}
