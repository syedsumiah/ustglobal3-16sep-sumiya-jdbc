package com.ustglobal.jdbcapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

import com.mysql.jdbc.Driver;
 
public class ExecuteInsertQuery {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		
		try {// Step1:Load the Driver
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			
			//step2: Get The Connection
			String url = "jdbc:mysql://localhost:3306/ust_ty_db?user=root&password=root";
			conn = DriverManager.getConnection(url);
			
			//step3: Issue SQL Query
			String sql = "insert into employee_info "
							 + " values(6,'Giridhar',30000,'male')";
			stmt = conn.createStatement();
			int count = stmt.executeUpdate(sql);
			
			//step4: Read the Result
			System.out.println(count + "Row(s) inserted");
			
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//step5: close all JDBC objects
			try {
				if(conn != null) {
					conn.close();
				}
				if(stmt != null) {
					stmt.close();
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
	}// end of main()

}// end of ExecuteInsertQuery
