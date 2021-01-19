package com.practice.implement;

import java.sql.SQLException;
import java.util.Scanner;

import com.practice.dao.EmployeeDAO;
import com.practice.model.Employee;

public class EmployeeImplement {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		while(true)
		{
			System.out.println("1.Insert\n2.Delete\n3.Update\n4.View");
			System.out.println("Enter your choice : ");
			Scanner sc=new Scanner(System.in);
			int choice=sc.nextInt();
			String id="";
			if(choice<=0)
				break;
			EmployeeDAO employeedao=new EmployeeDAO();
			switch(choice)
			{
			case 1: Employee emp=new Employee();
					System.out.println("Enter id,name,phone number,email");
					emp.setId(sc.next());
					emp.setName(sc.next());
					emp.setPhn_no(sc.next());
					emp.setEmail(sc.next());
					employeedao.addEmployee(emp);
					break;
			case 2: System.out.println("Enter id which you want to delete : ");
					id=sc.next();
					employeedao.deleteEmployee(id);
					break;
			case 3: employeedao.updateEmployee();
					break;
			case 4: System.out.println("Enter id for which you want to show the details : ");
					id=sc.next();
					System.out.println(employeedao.getEmployee(id));
					break;
			}
		}
	}
}
