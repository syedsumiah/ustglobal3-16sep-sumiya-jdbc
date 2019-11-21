package com.ustglobal.jdbcapp;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class SelectWithTryResources {
	public static void main(String[] args) {
		
		try(FileReader reader = new FileReader("text.properties")){
			Properties prop = new Properties();
			prop.load(reader);
			Class.forName(prop.getProperty("driver-class-name"));
			String url = prop.getProperty("url");
			String sql = prop.getProperty("select-query");
			try(Connection conn = DriverManager.getConnection(url,prop);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)){
					while(rs.next()) {
						System.out.println("ID: "+rs.getInt("id"));
						System.out.println("Name: "+rs.getString("name"));
						System.out.println("Salary: "+rs.getInt("salary"));
						System.out.println("gender: "+rs.getString("gender"));
					}
				}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	
}
}
 