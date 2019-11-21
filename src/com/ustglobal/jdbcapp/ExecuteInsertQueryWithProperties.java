package com.ustglobal.jdbcapp;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class ExecuteInsertQueryWithProperties {
	public static void main(String[] args) {
		
		Connection conn = null;
		Statement stmt = null;
		FileReader reader = null;
		
		try {
			reader = new FileReader("text.properties");
			Properties prop = new Properties();
			prop.load(reader);
			//Driver driver = new Driver();
			//DriverManager.registerDriver(driver);
			Class.forName(prop.getProperty("driver-class-name"));
			
			String url = prop.getProperty("url");
			conn = DriverManager.getConnection(url);
			
			String sql = prop.getProperty("delete-query");
		
			int count = stmt.executeUpdate(sql);
			
			System.out.println(count + "Row(s) deleted");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null) {
					conn.close();
				}
				if(stmt != null) {
					stmt.close();
				}
				if(reader != null) {
					reader.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}


	}

}
