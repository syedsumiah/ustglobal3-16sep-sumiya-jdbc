package com.ustglobal.jdbcapp;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.mysql.jdbc.Driver;

public class MyFirstJDBCProperties {
	public static void main(String[] args)  {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		FileReader reader = null;
		try {
			reader = new FileReader("text.properties");
			Properties prop = new Properties();
			prop.load(reader);
		// Step1:
		//Drir driver =  new Driver();
	//DriverManager.registerDriver(driver);
			
		Class.forName(prop.getProperty("driver-class-name"));
			//Step2: Get the Connection
			
			String url = prop.getProperty("url");
			conn = DriverManager.getConnection(url,prop);
			
			//step3: Issue the SQL Query
			stmt = conn.createStatement();
			String sql = prop.getProperty("select-query");
			rs = stmt.executeQuery(sql);
			
			//step4: Read the Result
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int salary = rs.getInt("salary");
				String gender = rs.getString("gender");
				
				System.out.println("Id: "+id);
				System.out.println("Name: "+name);
				System.out.println("Salary: "+salary);
				System.out.println("Gender: "+gender);
				System.out.println("********************");
				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			// step5: Close all JDBC objects
			try {
				if(conn != null) {
					conn.close();
				}
				if(stmt != null) {
					stmt.close();
				}
				if(rs != null) {
					rs.close();
				}
				if(reader != null) {
					reader.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		

	}

}
