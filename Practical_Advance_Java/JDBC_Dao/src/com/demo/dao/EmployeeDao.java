package com.demo.dao;

import java.util.List;

import com.demo.beans.Employee;

public interface EmployeeDao {
	
	boolean save(Employee e);

	List<Employee> findAllEmployee();

	Employee searchById(int eid);

	boolean deleteById(int eid);

	List<Employee> arrangeById();

	void closeConnection();

	boolean updateById(int eid, int salary);

	

}
