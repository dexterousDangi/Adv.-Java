package jdbcUsingProperty;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcEx2 {

	public static void main(String[] args) throws SQLException {
		
		Connection connection= Testconn.createConnection();
		Statement statement = connection.createStatement();
		  // ResultSet use to store the table data and
		// ResultSetMetaData used to store the table meta data
		
		ResultSet resultSet= statement.executeQuery("select * from team11");
		
		ResultSetMetaData metadata = resultSet.getMetaData();
		System.out.println(metadata.getColumnCount());
		System.out.println(metadata.getColumnName(1));
		System.out.println(metadata.getColumnName(2));
		System.out.println(metadata.getColumnDisplaySize(1));
		System.out.println(metadata.getColumnTypeName(1));
		
		connection.close();
	}

}
/*output:
connection is created successfully...
2
ENAME
EID
20
VARCHAR2
*/