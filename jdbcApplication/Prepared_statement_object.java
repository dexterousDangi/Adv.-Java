package jdbcFirstApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Prepared_statement_object {

	public static void main(String[] args) 
 {
		try{Class.forName("oracle.jdbc.driver.OracleDriver");

		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "manager");
		System.out.println("connection created successfully");
		// Prepared statement object is used when we have to execute a same querry for multiple time.
		//syntax:
		PreparedStatement preparedStatement= connection.prepareStatement("insert into team11 values(?,?)"); 
		Scanner scanner= new Scanner(System.in);
		
		while(true) {
			System.out.println("enter team11 player name");
			String ename = scanner.next();
			System.out.println("enter team11 player goal");
			int eid= scanner.nextInt();
			preparedStatement.setString(1, ename);  // 1 representing index of first "?" mark
			preparedStatement.setInt(2, eid);   // here 2 representing second ? mark.
			preparedStatement.executeUpdate();
			System.out.println("value added... want to add more data type yes/no");
			String option = scanner.next();
			if(option.equals("no"))
				break;			
		}scanner.close();
		connection.close();
		preparedStatement.close();
		System.out.println("connection closed successfully");
		
	}catch(ClassNotFoundException e) {
		e.printStackTrace();
	}catch(SQLException e) {
		e.printStackTrace();
	}
		}

}
