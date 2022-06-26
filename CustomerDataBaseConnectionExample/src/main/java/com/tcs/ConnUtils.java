package com.tcs;

import org.apache.commons.dbcp.BasicDataSource;

public class ConnUtils {
	static BasicDataSource dataSource=null;
	static {
		dataSource=new BasicDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		dataSource.setUsername("system");
		dataSource.setPassword("manager");
		dataSource.setMaxActive(10);
		
	}
}
