package imageInsideDataBase;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import jdbcUsingProperty.Testconn;

// we usually don't store the  images in the database  because that increases our database size irrespectively.

public class Inserting_large_image {

	public static void main(String[] args)  {
	 
		try {
			
			Connection connection= Testconn.createConnection();
			
			PreparedStatement preparedStatement = connection.prepareStatement("insert into image values(?,?)");
			
			preparedStatement.setInt(1, 420);
			// now in this case we like to have dialog box to chose our file from the folder provided
			// for that purpose we use java swing class
			
			JFileChooser jf=new JFileChooser();  // JFileChooser will provide us the dialog box to choose our file
			jf.showOpenDialog(null);   // opened the dialog box at the center.
			File file=jf.getSelectedFile();  // will return us the file we have selected
			
			FileInputStream fis= new FileInputStream(file);
			
			preparedStatement.setBinaryStream(2, fis,fis.available());
			
			preparedStatement.execute();
			System.out.println("done / completed");
			
			
			JOptionPane.showConfirmDialog(null, "success");
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
	
	}

}
