package com.ustglobal.empapp;

import java.util.List;
import java.util.Scanner;

import com.ustglobal.empapp.dao.EmployeeDAO;
import com.ustglobal.empapp.dao.EmployeeDAOImpl;
import com.ustglobal.empapp.dto.EmployeeBean;
import com.ustglobal.empapp.util.EmployeeManager;

public class App {
	public static void main(String[] args) {
		System.out.println("Press 1 to show all employee data");
		System.out.println("Press 2 to insert employee data");
		System.out.println("Press 3 to update employee data");
		System.out.println("Press 4 to delete employee data");
		System.out.println("Press 5 to search single employee data");

		Scanner scn = new Scanner(System.in);
		int ch = scn.nextInt();

		switch(ch) {
		case 1:
			EmployeeDAO dao = EmployeeManager.getEmployeeDAO();
			List<EmployeeBean> result = dao.getAllEmployeeData();
			
			for(EmployeeBean bean : result) {
				System.out.println("Id :"+bean.getId());
				System.out.println("Name :"+bean.getName());
				System.out.println("Gender :"+bean.getGender());
				System.out.println("Salary :"+bean.getSalary());
			}

			break;
		case 2:
			System.out.println("Enter id name salary gender");
			int id2 = scn.nextInt();
			String name2 = scn.next();
			int sal2 = scn.nextInt();
			String gender2 = scn.next();
			
			EmployeeBean bean2 = new EmployeeBean();
			bean2.setId(id2);
			bean2.setName(name2);
			bean2.setSalary(sal2);
			bean2.setGender(gender2);
			
			EmployeeDAO dao2 = EmployeeManager.getEmployeeDAO();
			int count2 = dao2.insertEmployeeData(bean2);
			
			System.out.println(count2+" Row(s) effected");
			
			break;
			

		case 3:
			System.out.println("Enter id name salary gender");
			int id3 = scn.nextInt();
			String name3 = scn.next();
			int sal3 = scn.nextInt();
			String gender3 = scn.next();
			
			EmployeeBean bean3 = new EmployeeBean();
			bean3.setId(id3);
			bean3.setName(name3);
			bean3.setSalary(sal3);
			bean3.setGender(gender3);
			
			EmployeeDAO dao3 = EmployeeManager.getEmployeeDAO();
			int count3 = dao3.updateEmployeeData(bean3);
			
			System.out.println(count3+" Row(s) effected");
		
			break;
		case 4:
			System.out.println("enter id");
			int id4 = scn.nextInt();
			
			EmployeeDAO dao4 = EmployeeManager.getEmployeeDAO();
			int count4 = dao4.deleteEmployeeData(id4);
			
			System.out.println(count4+" Row(s) deleted");
		
			break;
		case 5:
			EmployeeDAO dao5 = EmployeeManager.getEmployeeDAO();
			int id = scn.nextInt();
			EmployeeBean bean = dao5.searchEmployeeData(id);
			if(bean != null) {
				System.out.println("Id :"+bean.getId());
				System.out.println("Name :"+bean.getName());
				System.out.println("Gender :"+bean.getGender());
				System.out.println("Salary :"+bean.getSalary());
				
			}else {
				System.out.println("No data found");
			}
			break;
		}// end of switch
	}// end of main()

}// end of App
 