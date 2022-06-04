package CallableStatements;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import jdbcUsingProperty.Testconn;

// procedure and functions are available at the database side , so we first write the code on the database command line then we write the 
// JDBC code to give input to the procedure and get an Output from it . procedure don't have return type so they have both IN and OUT parameters

// function have return type so we only need IN parameter only and function will provide the output itself

// first we write this code on the SQL command line:
/*  
SQL> create or replace procedure getAvgSal(id1 IN number,id2 IN number, sal1 OUT number,sal2 OUT number)
  2  as
  3  BEGIN
  4  select esal into sal1 from emp where eid =id1;
  5  select esal into sal2 from emp where eid =id2;
  6  END getSal;
  7  /
  
Procedure created.
 */
 
// then we write the jdbc application to give and get the output from procedure declared at the database side

public class Callable_statement {

	public static void main(String[] args) {
		
		Connection connection=null;
		CallableStatement statement=null;   // here we doesn't need statement object we will work with the callable statements here.
		try {
			connection=Testconn.createConnection();
			
			statement=connection.prepareCall("{call getAvgSal(?,?,?,?)}");   // call procedure here and provide the parameters (first ? signifies IN , and second ? OUT)
			statement.setInt(1, 222);
			statement.setInt(2, 111);
						// after setting the input parameters we have to register the output parameters
			  
			statement.registerOutParameter(3, Types.DOUBLE);   // here we are just registering one variable to store our output.
			statement.registerOutParameter(4, Types.DOUBLE); 
			statement.execute();
	
			System.out.println("Result...:"+ statement.getDouble(3));  // our output is stored in the registered variable and now we are just calling that variable 
			System.out.println("Result...:"+ statement.getDouble(4)); 
			double a =statement.getDouble(3);
			double b =statement.getDouble(4);
			double c=(a+b)/2;
			System.out.println("Av erage of the salary: "+c);
			
		}catch(Exception e){
			e.printStackTrace();
			
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("resources are released successfully...");
		}
	
	
	
	}	
}	
/*
connection is created successfully...
Result...:23500.45
Result...:13000.45
Average of the salary: 18250.45
resources are released successfully...
*/