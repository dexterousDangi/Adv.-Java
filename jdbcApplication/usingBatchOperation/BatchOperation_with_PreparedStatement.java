package usingBatchOperation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jdbcUsingProperty.Testconn;
import oracle.jdbc.OracleDriver;

public class BatchOperation_with_PreparedStatement {

	public static void main(String[] args) throws SQLException {
	// using property class and common file to create the connection
		
		Connection connection= Testconn.createConnection();
        PreparedStatement preparedStatement= connection.prepareStatement("update emp set ename=? where eid=?");
        preparedStatement.setString(1, "danilo");
        preparedStatement.setInt(2, 111);
       //  preparedStatement.executeUpdate();   // earlier we have to use this method to execute the statements 
        // now we are going to use Batch operations
        preparedStatement.addBatch();
        
        preparedStatement.setString(1, "apple");
        preparedStatement.setInt(2, 222);
        preparedStatement.addBatch();
        
        preparedStatement.setString(1, "green");
        preparedStatement.setInt(2, 333);
        preparedStatement.addBatch();
        
        // now instead of executing the preparedStatement.executeUpdate();  for three times we use addBatch() method
        // and executeBatch() method for requesting and getting response in one network call
        
       int [] a=   preparedStatement.executeBatch();
        for(int x:a)
        	System.out.println(x);
        
        System.out.println(OracleDriver.getCompileTime());
        
        connection.close();
        preparedStatement.close();
	}

}
