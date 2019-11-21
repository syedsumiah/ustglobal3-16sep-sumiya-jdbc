 package com.ustglobal.empapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ustglobal.empapp.dto.EmployeeBean;

public class EmployeeDAOImpl implements EmployeeDAO{
	
	public List<EmployeeBean> getAllEmployeeData() {
		String url = "jdbc:mysql://localhost:3306/ust_ty_db?user=root&password=root";
		String sql = "select * from employee_info";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection(url);
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			ArrayList<EmployeeBean> result = new ArrayList<EmployeeBean>();
			while(rs.next()) {
				EmployeeBean bean = new EmployeeBean();
				int id = rs.getInt("id");
				bean.setId(id);
				String name = rs.getString("name");
		 		bean.setName(name);
				int salary = rs.getInt("salary");
				bean.setSalary(salary);
				String gender = rs.getString("gender");
				bean.setGender(gender);
				
				result.add(bean);
				
			}
			return result;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}finally {
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
			}catch(Exception e) {
				e.printStackTrace();
			}
		}

	}//End of getAllEmployeeData()

	public EmployeeBean searchEmployeeData(int id) {
		String url = "jdbc:mysql://localhost:3306/ust_ty_db?user=root&password=root";
		String sql = "select * from employee_info where id =?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection(url);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				EmployeeBean bean = new EmployeeBean();
				bean.setId(rs.getInt("id"));
				bean.setName(rs.getString("name"));
				bean.setSalary(rs.getInt("salary"));
				bean.setGender(rs.getString("gender"));
				return bean;
			}else {
				return null;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			try {
				if(conn != null) {
					conn.close();
				}
				if( pstmt != null) {
					pstmt.close();
				}
				if(rs != null) {
					rs.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	
	@Override
	public int insertEmployeeData(EmployeeBean bean) {
		int id = bean.getId();
		String name = bean.getName();
		int salary = bean.getSalary();
		String gender = bean.getGender();
		
		String url = "jdbc:mysql://localhost:3306/ust_ty_db?user=root&password=root";
		String sql = "insert into employee_info values(?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setInt(3, salary);
			pstmt.setString(4, gender);
			
			int count = pstmt.executeUpdate();
			
			return count;
			
		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}finally {
			try {
				if(conn != null) {
					conn.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public int updateEmployeeData(EmployeeBean bean) {
		
		int id = bean.getId();
		String name = bean.getName();
		int salary = bean.getSalary();
		String gender = bean.getGender();
		
		String url = "jdbc:mysql://localhost:3306/ust_ty_db?user=root&password=root";
		String sql = "update employee_info set name=?,salary=?,gender=? where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(4, id);
			pstmt.setString(1, name);
			pstmt.setInt(2, salary);
			pstmt.setString(3, gender);
			
            int count = pstmt.executeUpdate();
			
			return count;
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}finally {
			try {
				if(conn!=null) {
					conn.close();
				}
				if(pstmt!=null) {
					pstmt.close();
				
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}//end of try_catch_finally
		
	}//end of updateEmployeeData method
	
	

	@Override
	public int deleteEmployeeData(int id) {
		String url = "jdbc:mysql://localhost:3306/ust_ty_db?user=root&password=root";
		String sql = "delete from employee_info where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
//			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, id);
			
			int count = pstmt.executeUpdate();
			return count;
			
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}finally {
			try {
				if(conn!=null) {
					conn.close();
				}
				if(pstmt!=null) {
					pstmt.close();
				
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}//end of try_catch_finally
		
	}//end of deleteEmployeeData method
	

	
}// end of EmployeeDAOImpl
