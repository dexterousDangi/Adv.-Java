package jdbcUsingProperty;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

// properties file is used to common elements
// this class is used to create a connection method, which create the connection and return the connection

public class Testconn {

	public static Connection createConnection() {

		Connection connection = null;
		try {
			// load the properties file
			Properties properties = new Properties();
			String path="F:\\eclipse workspace\\jdbc first\\jdbcFirstApplication\\src\\jdbcUsingProperty\\abc.properties";
			properties.load(new FileInputStream(path));
			// load the driver class from properties file
			Class.forName(properties.getProperty("driver"));

			connection = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("username"),
					properties.getProperty("password"));
			System.out.println("connection is created successfully...");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
}
