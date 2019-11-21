package com.ustglobal.jdbcapp;

import java.sql.*;

import com.mysql.jdbc.Driver;

public class MyFirstJDBC {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
		// Step1:
			Driver driver =  new Driver();
			DriverManager.registerDriver(driver);
			
			//Class.forName("com.mysql.jdbc.Driver");
			//Step2: Get the Connection
			String url = "jdbc:mysql://localhost:3306/ust_ty_db?user=root&password=root";
			conn = DriverManager.getConnection(url);
			
			//step3: Issue the SQL Query
			stmt = conn.createStatement();
			String sql = "select * from Employee_info";
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
		}catch (SQLException e) {
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
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}// end of main()

} //  end of MyFirstJDBC
