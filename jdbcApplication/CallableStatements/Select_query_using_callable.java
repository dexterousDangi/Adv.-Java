package CallableStatements;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import jdbcUsingProperty.Testconn;

/*SQL> create or replace procedure getDetails(id IN number, o1 OUT number, o2 OUT
varchar2, o3 OUT number)
  2  as
  3  BEGIN
  4  select eid,ename,esal into o1,o2,o3 from emp where eid=id;
  5  END getDetails;
  6  /

Procedure created.
*/

public class Select_query_using_callable {

	public static void main(String[] args) {
		Connection connection=null;
		CallableStatement callableStatement=null;
		try {
			connection = Testconn.createConnection();
			callableStatement  = connection.prepareCall("{call getDetails(?,?,?,?)}");
			callableStatement.setInt(1, 333);  // set the variables
			callableStatement.registerOutParameter(2, Types.INTEGER);   // register the output parameters
			callableStatement.registerOutParameter(3, Types.VARCHAR);   // register the output parameters
			callableStatement.registerOutParameter(4, Types.DOUBLE);   // register the output parameters
			
			callableStatement.execute();
			
			System.out.println("employee id : "+callableStatement.getInt(2));
			System.out.println("employee name : "+callableStatement.getString(3));
			System.out.println("employee salary : "+callableStatement.getInt(4));
						
			System.out.println("process completed>>>");
			
		}catch(Exception e) {
			e.printStackTrace();
	}
		finally {
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
		}
}
}
/*
connection is created successfully...
employee id : 333
employee name : green
employee salary : 31500
process completed>>>

*/