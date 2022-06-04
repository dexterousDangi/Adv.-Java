package CallableStatements;

	import java.sql.CallableStatement;
	import java.sql.Connection;
	import java.sql.SQLException;

	import jdbcUsingProperty.Testconn;

	// procedure and functions are available at the database side , so we first write the code on the database command line then we write the 
	// JDBC code to give input to the procedure and get an Output from it . procedure don't have return type so they have both IN and OUT parameters

	// function have return type so we only need IN parameter only and function will provide the output itself

	// first we write this code on the SQL command line:
	/*  
	SQL> create or replace procedure insert_data(id IN number, name IN varchar2, sal IN number)
	  2  as
	  3  BEGIN
	  4  insert into emp values(id,name,sal);
	  5  END insert_data;
	  6  /
	  
	Procedure created.
	 */
	 
	// then we write the jdbc application to give and get the output from procedure declared at the database side
	
	
	// in insert data queries we don't have to register the output parameters because we are only inserting data not getting any output
	
	public class Insert_Query_using_callable_statements {

		public static void main(String[] args) {
			
			Connection connection=null;
			CallableStatement statement=null;   // here we doesn't need statement object we will work with the callable statements here.
			try {
				connection=Testconn.createConnection();
				
				statement=connection.prepareCall("{call insert_data(?,?,?)}");   // call procedure here and provide the parameters (first ? signifies IN , and second ? OUT)
				statement.setInt(1, 444);
				statement.setString(2, "pardeep");
				statement.setDouble(3, 22200.22);
							// after setting the input parameters we have to register the output parameters
								
				statement.execute();				
				
				System.out.println("operations completed...");
				
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
