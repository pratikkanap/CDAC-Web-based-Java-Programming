package com.demo.beans;

public class Employee {
	private int eid;
	private String ename;
	private String adress;
	private int salary;
	
	//constructor
	public Employee() {
		super();
	}
	
	//constructor with parameter
	public Employee(int eid, String ename, String adress, int salary) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.adress = adress;
		this.salary = salary;
	}
	
	//getter and setter
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	//toString
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", adress=" + adress + ", salary=" + salary + "]";
	}
	
	
}
