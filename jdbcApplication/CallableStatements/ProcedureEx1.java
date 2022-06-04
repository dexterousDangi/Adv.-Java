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
SQL> create or replace procedure getSal(id IN number, sal OUT number)
  2  as
  3  BEGIN
  4  select esal into sal from emp where eid =id;
  5  END getSal;
  6  /
  
Procedure created.
 */
 
// then we write the jdbc application to give and get the output from procedure declared at the database side

public class ProcedureEx1 {

	public static void main(String[] args) {
		
		Connection connection=null;
		CallableStatement statement=null;   // here we doesn't need statement object we will work with the callable statements here.
		try {
			connection=Testconn.createConnection();
			
			statement=connection.prepareCall("{call getSal(?,?)}");   // call procedure here and provide the parameters (first ? signifies IN , and second ? OUT)
			statement.setInt(1, 222);
						// after setting the input parameters we have to register the output parameters
			  
			statement.registerOutParameter(2, Types.DOUBLE);   // here we are just registering one variable to store our output.
			
			statement.execute();
	
			System.out.println("Result...:"+ statement.getDouble(2));  // our output is stored in the registered variable and now we are just calling that variable 
			
			
			
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
Result...:13000.45
resources are released successfully...
*/
















