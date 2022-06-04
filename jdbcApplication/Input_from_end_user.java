package jdbcFirstApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Input_from_end_user {

	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "manager");
			statement = connection.createStatement();
			System.out.println("connection created successfully");
			
			Scanner sc= new Scanner(System.in);
			while(true) {
				System.out.println("enter team11 player name");
				String ename = sc.next();
				System.out.println("enter team11 player goal");
				int eid= sc.nextInt();
				
//				String q= "insert into team11 values('dangi',21)";
				String q1="insert into team11 values('"+ename+"',"+eid+")";	// here we use "+" operator to concat the data.		
				statement.executeUpdate(q1);
				System.out.println("Querry inserted successfully..");
				System.out.println(q1);
				System.out.println("values are inserted successfully ... Do you want to one more record(yes/no)");
				String option= sc.next();
				if(option.equals("no"))
					break;
			}
			
			
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
