package jdbcFirstApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Prepared_statement_example2 {

	public static void main(String[] args) {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system",
					"manager");
			System.out.println("connection created successfully");
			// Prepared statement object is used when we have to execute a same querry for
			// multiple time.
			// syntax:
			PreparedStatement ps1 = connection.prepareStatement("update team11 set eid=eid+? where eid>?");
			PreparedStatement ps2 = connection.prepareStatement("select * from team11 where eid <?");
			Scanner scanner = new Scanner(System.in);

			while (true) {
				System.out.println("enter team11 playe goals above which you want to update:");
				int limit = scanner.nextInt();
				System.out.println("enter the new goal soccored :");
				int goal = scanner.nextInt();
				ps1.setInt(1, goal); // 1 representing index of first "?" mark
				ps1.setInt(2, limit); // here 2 representing second ? mark.

				ps1.executeUpdate();
				System.out.println("record updated...");
				System.out.println("select the goals below which you want to see the player recored:");
				int gl = scanner.nextInt();
				ps2.setInt(1, gl);
				ResultSet set = ps2.executeQuery(); // return the result set
				while (set.next()) {
					System.out.println(set.getString(1) + "," + set.getInt(2));
				}
				System.out.println("do you want to repeat the operations yes/no");
				String option = scanner.next();

				if (option.equals("no"))
					break;
			}
			scanner.close();
			connection.close();
			ps1.close();
			ps2.close();
			System.out.println("connection closed successfully");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
