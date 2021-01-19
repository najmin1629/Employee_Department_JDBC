package com.practice.model;

public class Employee {
	private String id;
	private String name;
	private String phn_no;
	private String email;
	public Employee(String id, String name, String phn_no, String email) {
		super();
		this.id = id;
		this.name = name;
		this.phn_no = phn_no;
		this.email = email;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public String setId(String id) {
		return this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhn_no() {
		return phn_no;
	}
	public void setPhn_no(String phn_no) {
		this.phn_no = phn_no;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", phn_no=" + phn_no + ", email=" + email + "]";
	}
	
}
