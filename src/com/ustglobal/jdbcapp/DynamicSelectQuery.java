package com.ustglobal.jdbcapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class DynamicSelectQuery {
	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String url = "jdbc:mysql://localhost:3306/ust_ty_db?user=root&password=root";
		String sql = "select * from employee_info where id = ?";
		
		try {
			Driver driver =  new Driver();
			DriverManager.registerDriver(driver);
			//s2: Get the Connection
			conn = DriverManager.getConnection(url);
			//s3: Issue SQL Query
			pstmt = conn.prepareStatement(sql);
			
			String empid = args[0];
			int id = Integer.parseInt(empid);
			pstmt.setInt(1, id);
			
			rs = pstmt.executeQuery();
			
			//s4: read the result
			if(rs.next()) {
				int emp_id =rs.getInt("id");
				int salary = rs.getInt("salary");
				String name = rs.getString("name");
				String gender = rs.getString("gender");
				
				System.out.println("ID :"+emp_id);
				System.out.println("Name:"+name);
				System.out.println("Salary :"+salary);
				System.out.println("Gender :"+gender);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null) {
					conn.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(rs != null) {
					rs.close();
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
		
	}// end main();

}// end of DynamicSelectQuery
