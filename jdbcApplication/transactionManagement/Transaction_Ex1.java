package transactionManagement;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

import jdbcUsingProperty.Testconn;

// using jdbc we can only deal with local transactions only , because in jdbc we hard code the query and can only interact with  one database only.
// for global transactions we use spring jdbc or Hybernet , with can write operations automatically at runtime and can interact with multiple databases

public class Transaction_Ex1 {



	public static void main(String[] args) {
		Connection connection=null;
		Statement statement=null; 
		  Savepoint savepoint=null;
										// if we declare the variables inside the try block then scope of these variable will be with in the try block only and we are not able to perform the rollBack() operations. 
        try {
          
        	connection=Testconn.createConnection();
		   statement=connection.createStatement();
		
		connection.setAutoCommit(false);   // earlier it is by default it is set to True, it will just commit the changes whenever the operations are completed
		          							// but by setting it false it will wait for the programmer consent that, if he want to commit() or rollBack()
											// and that's what we required in the transaction management => do everything or do nothing
		
		
		statement.executeUpdate("insert into emp values(444,'ratan',20000)");
		statement.executeUpdate("insert into emp values(555,'tanuj',40000)");
		statement.executeUpdate("insert into emp values(666,'rama',50000)");
		statement.executeUpdate("update emp set esal = esal + 500 where esal <31000");
		statement.executeUpdate("insert into emp values(777,'matriya',230000)"); 
		savepoint= connection.setSavepoint();
		//statement.executeUpdate("delete from emp where eid=777");
		statement.executeUpdate("delete from emp where eid=666");
		statement.executeUpdate("delete from emp where eid=555");
		statement.executeUpdate("delete from emp where eid=444");
		  											// here autoCommit is false so even after completion of the operations also database is not modified without
													// programmers consent, it has to declare the commit() function then only it can be updated in the database.
		
		connection.commit();
		System.out.println("transaction is successfull...");
	     }
        catch( Exception e  ){
        	try {
				connection.rollback();
				System.out.println("transection falied... try again");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
        }
        finally {
        	if(statement !=null)
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
        	if(connection!=null)
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
	}

}
}
