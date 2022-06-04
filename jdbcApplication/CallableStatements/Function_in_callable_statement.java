package CallableStatements;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import jdbcUsingProperty.Testconn;

// we declare function first at the database site like the procedures, but in case functions we don't use OUT parameter as function contains return value option 
// this is how we decalre a function on the database side.


/*
SQL> create or replace function getAvg(id1 IN number, id2 IN number) return numb
er
  2  as
  3  sal1 number;
  4  sal2 number;
  5  BEGIN
  6  select esal  into sal1 from emp where eid=id1;
  7  select esal  into sal2 from emp where eid=id2;
  8  return (sal1+sal2)/2;
  9  END getAvg;
 10  /

Function created.
*/
public class Function_in_callable_statement {

	public static void main(String[] args) {

		  Connection connection=null; 
		  CallableStatement callableStatement= null;
		  
		  try {
			  connection= Testconn.createConnection();
			  callableStatement = connection.prepareCall("{?= call getAvg(?,?)}");   // this first "?" hold the returned value.
			  callableStatement.setInt(2, 111); 
			  callableStatement.setInt(3, 222);
			  
			  callableStatement.registerOutParameter(1, Types.DOUBLE);
			  
			  callableStatement.execute();
			  System.out.println("queries are executed successfully...");
			  
			  System.out.println("result  : "+ callableStatement.getDouble(1));   // in "()" provide the corresponding ? index here it is 1;
			  
			  
			  
			  
		  }catch(Exception e) {
			  e.printStackTrace();
		  }finally {
			  try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			  try {
				callableStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			  System.out.println("resources are closed successfully...");
		  }
	}

}

/* output:
connection is created successfully...
queries are executed successfully...
result  : 18250.45
resources are closed successfully...
*/