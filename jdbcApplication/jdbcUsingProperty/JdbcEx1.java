import java.sql.Connection;



public class JdbcEx1 {

	public static void main(String[] args) {
		
		Connection connection= Testconn.createConnection();
		// now we want to get the database metadata object, which provide information about the data
		// data about data is meta data.
		System.out.println(Math.random());
	}

}
