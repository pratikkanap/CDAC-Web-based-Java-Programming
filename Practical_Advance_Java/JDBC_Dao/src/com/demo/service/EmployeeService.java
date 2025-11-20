package com.demo.service;

import java.util.List;

import com.demo.beans.Employee;
import com.demo.dao.EmployeeDao;

public interface EmployeeService {

	boolean addEmployee();

	List<Employee> getAllEmployee();

	Employee findById(int eid);

	boolean deleteById(int eid);

	List<Employee> sortById();

	void closeMyConnection();

	boolean modifyEmployee(int eid, int salary);

	

	
}
