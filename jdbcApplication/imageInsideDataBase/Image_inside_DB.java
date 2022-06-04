package imageInsideDataBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import jdbcUsingProperty.Testconn;


// blob is only applicable in case of our image size is less then 64 kb.
// for long size images go for longblob data type stands for long binary objects.
public class Image_inside_DB {

	public static void main(String[] args) throws SQLException, IOException {
			
		Connection connection=Testconn.createConnection();
		
		Statement statement= connection.createStatement();		 
		statement.executeUpdate("create table image ( id number, image blob)");  // here blob type is for -- binary long objects
		System.out.println("table is created...");
		
		PreparedStatement preparedStatement = connection.prepareStatement("insert into image values(?,?)");
		
		//PreparedStatement preparedStatement1 = connection.prepareStatement("truncate table image"); // if data inserted to many times
		
		// this is for first question mark and we given value 23		
		preparedStatement.setInt(1, 23);
		
		// for second question mark we provide a stream of binary data using setBinaryStream() method which takes input
		// from a stream of bytes provided by the fileinputstream class , and the memory available in the image used.
		
		FileInputStream fis= new FileInputStream("C:\\Users\\Microsoft\\Desktop\\own_created_error.jpg"); 
		
		preparedStatement.setBinaryStream(2,fis,fis.available() );    
		
		preparedStatement.execute();
		
		System.out.println("image inserted successfully...");
		//preparedStatement1.execute();             //if data inserted to many times
		connection.close();
	}

}
