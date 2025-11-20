package com.demo.service;

import java.util.List;
import java.util.Scanner;

import com.demo.beans.Employee;
import com.demo.dao.EmployeeDao;
import com.demo.dao.EmployeeDaoImpl;

public class EmployeeServiceImpl implements EmployeeService{
	private EmployeeDao dao;

	public EmployeeServiceImpl() {
		dao = new EmployeeDaoImpl() {
		};
	}
	
	public boolean addEmployee() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the employee id");
		int eid = sc.nextInt();
		
		System.out.println("Enter the Employee Name");
		String ename = sc.next();
		System.out.println("Enter the employee address");
		String address = sc.next();
		System.out.println("Enter the Employee Salary");
		int salary = sc.nextInt();
		Employee e = new Employee(eid,ename,address,salary);
		return dao.save(e);
		
	}
	public List<Employee> getAllEmployee(){
		return dao.findAllEmployee();
	}

	@Override
	public Employee findById(int eid) {
		return dao.searchById(eid);
	}

	@Override
	public boolean deleteById(int eid) {
		return dao.deleteById(eid);
	}

	@Override
	public List<Employee> sortById() {
		return dao.arrangeById();
	}

	@Override
	public void closeMyConnection() {
		dao.closeConnection();
		
	}

	@Override
	public boolean modifyEmployee(int eid,int salary) {
		return dao.updateById(eid, salary);
	}

	

}
