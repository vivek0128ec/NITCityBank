package com.nt.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyDao {
private static Connection conn=null;
private MyDao() {
	
}
public static Connection getDbConn() throws Exception {
	Class.forName("oracle.jdbc.driver.OracleDriver");
	conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
return conn;
}
}
