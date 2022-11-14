package com.h3.common;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCTemplate {
	
	public static Connection getConnection() throws Exception {
		
		Properties prop = new Properties();
		String filePath = JDBCTemplate.class.getResource("/setup/data.properties").getPath();
		prop.load(new FileInputStream(filePath));
		
		String driver = prop.getProperty("driver");
		String url = prop.getProperty("url");
		String dbId = prop.getProperty("id");
		String dbPwd = prop.getProperty("pwd");
		
		Class.forName(driver);
		
		Connection conn = DriverManager.getConnection(url,dbId,dbPwd);
		conn.setAutoCommit(false);
		
		return conn;
	}
	
	public static void commit(Connection conn) {
		try {
				if (conn!= null && !conn.isClosed()) conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void rollback(Connection conn) {
		try {
			if (conn!= null && !conn.isClosed()) conn.rollback();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	}
	
	public static void close(Connection conn) {
		try {
			if (conn!=null && !conn.isClosed()) conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rs) {
		try {
			if (rs!=null && !rs.isClosed()) rs.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Statement stmt) {
		try {
			if (stmt!=null && !stmt.isClosed()) stmt.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
