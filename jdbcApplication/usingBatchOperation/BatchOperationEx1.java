package usingBatchOperation;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import jdbcUsingProperty.Testconn;

public class BatchOperationEx1 {

	public static void main(String[] args) throws SQLException {
          
		// using property class and common file to create the connection
		
		Connection connection= Testconn.createConnection();
		Statement statement = connection.createStatement();
		  
		// to add querries to batch we use statement class addBatch() method
		// here we create 5 querries and send them to DB in just one call
		
		statement.addBatch("create table emp(eid number, ename varchar2(30), esal number) "); // WILL return 0 if table is created
		statement.addBatch("insert into emp values (111,'ratan',10000.45)");   // will return 1 if data  is inserted into the table
		statement.addBatch("insert into emp values (222,'dangi',20000.45)");   // will return 1 if data  is inserted into the table
		statement.addBatch("insert into emp values (333,'anu',30000.45)");     // will return 1 if data  is inserted into the table
		statement.addBatch("update emp set esal=esal+500 where esal>15000");    // will return the count of rows updated like 2 in our case
		
		statement.addBatch("drop table emp");   // will return 0 in case of table is dropped.
		
		// here we are making only one network call for 6 querries.
		
		int [] a =statement.executeBatch();  // will return a integer array with updates
		
		for(int aa:a) {   // just print the int array to check whether the data is updated or not 
			System.out.println(aa);
		}
		
		statement.close();
		connection.close();
		}

}

// in batch operations select querry is not allwoed because select query have return type result set and
// batch operation have return type integer array.
   
/*output be like:
 * connection is created successfully...
0  -- for creating the table
1  -- for insertion operation
1   -- for insertion operation 
1   -- for insertion operation 
2   -- 2 row are updated
0   -- in case of row is dropped
*/
