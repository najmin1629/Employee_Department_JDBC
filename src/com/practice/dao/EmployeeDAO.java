package com.practice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.practice.connection.JdbcPostgresConnection;
import com.practice.model.Employee;


public class EmployeeDAO {
	public void addEmployee(Employee obj) throws SQLException
	{
		String query="insert into employee values(?,?,?,?)";
		JdbcPostgresConnection con=new JdbcPostgresConnection();
		Connection cnt=con.connect();
		PreparedStatement st=cnt.prepareStatement(query);
		st.setString(1,obj.getId());
		st.setString(2,obj.getName());
		st.setString(3,obj.getPhn_no());
		st.setString(4,obj.getEmail());
		int count=st.executeUpdate();
		System.out.println(count+ "row/s affected");
		st.close();
		cnt.close();
	}
	public void deleteEmployee(String id) throws SQLException
	{
		String query="delete from employee where id=?";
		JdbcPostgresConnection con=new JdbcPostgresConnection();
		Connection cnt=con.connect();
		PreparedStatement st=cnt.prepareStatement(query);
		st.setString(1,id);
		int count=st.executeUpdate();
		System.out.println(count+ "row/s affected");
		st.close();
		cnt.close();
	}
	public Employee getEmployee(String id) throws SQLException, ClassNotFoundException
	{
			Employee e=new Employee();
			e.setId(id);
			String query="select * from employee where id='"+id+"'";
			JdbcPostgresConnection con=new JdbcPostgresConnection();
			Connection cnt=con.connect();
			Class.forName("org.postgresql.Driver");
			Statement st=cnt.createStatement();
			ResultSet rs=st.executeQuery(query);
			rs.next();
			e.setId(rs.getString(1));
			e.setName(rs.getString(2));
			e.setPhn_no(rs.getString(3));
			e.setEmail(rs.getString(4));
			return e;
	}
	public void updateEmployee() throws SQLException
	{
		System.out.println("Enter which column you want to update : ");
		Scanner sc=new Scanner(System.in);
		String input=sc.next();
		JdbcPostgresConnection con=new JdbcPostgresConnection();
		Connection cnt=con.connect();
		String id="";
		String query="";
		int count=0;
		PreparedStatement st= null;
		switch(input)
		{
			   case "id":   System.out.println("Enter old id : ");
							id=sc.next();
							System.out.println("Enter new id : ");
							String nid=sc.next();
							query="update employee set id=? where id=?";
							st=cnt.prepareStatement(query);
							st.setString(1,nid);
							st.setString(2,id);
							count=st.executeUpdate();
							System.out.println(count+"row/s affected");
							st.close();
							cnt.close();  
							break;
				case "name": System.out.println("Enter id : ");
					   		 id=sc.next();
							 System.out.println("Enter name : ");
							 String name=sc.next();
							 query="update employee set name=? where id=?";
							 st=cnt.prepareStatement(query);
							 st.setString(1,name);
							 st.setString(2,id);
							 count=st.executeUpdate();
							 System.out.println(count+"row/s affected");
							 st.close();
							 cnt.close();
							 break;
				case "phn_no":  System.out.println("Enter id : ");
					  			id=sc.next();
								System.out.println("Enter phone number : ");
								String phn_no=sc.next();
								query="update employee set phn_no=? where id=?";
								st=cnt.prepareStatement(query);
								st.setString(1,phn_no);
								st.setString(2,id);
								count=st.executeUpdate();
								System.out.println(count+"row/s affected");
								st.close();
								cnt.close();
								break;
				case "email":  System.out.println("Enter id : ");
					  		   id=sc.next();
							   System.out.println("Enter email : ");
							   String email=sc.next();
							   query="update employee set email=? where id=?";
							   st=cnt.prepareStatement(query);
							   st.setString(1,email);
							   st.setString(2,id);
							   count=st.executeUpdate();
							   System.out.println(count+"row/s affected");
							   st.close();
							   cnt.close();
							   break;
		}
	}
	
}
