package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.beans.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
	static Connection conn;
	static PreparedStatement insEmp,findEmployee,findById,deletebyid,updateById,sortById;
	static {
		try {
			conn = DButil.getMyConnection();
			insEmp = conn.prepareStatement("insert into employee1 values(?,?,?,?)");
			findEmployee = conn.prepareStatement("SELECT eid, ename, address, salary FROM employee1"); 
			findById=conn.prepareStatement("select * from employee1 where eid=?");
			deletebyid = conn.prepareStatement("delete from employee1 where eid = ?");
			updateById= conn.prepareStatement("update employee1 set salary=? where eid = ?");
			sortById = conn.prepareStatement("select * from employee1 order by eid");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//function to add new employee
	@Override
	public boolean save(Employee e) {
		try {
			insEmp.setInt(1, e.getEid());
			insEmp.setString(2, e.getEname());
			insEmp.setString(3, e.getAdress());
			insEmp.setInt(4, e.getSalary());
			int n = insEmp.executeUpdate();
			return n > 0;
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		return false;
	}
	
	//function to display all employees
	@Override
	public List<Employee> findAllEmployee() {
		List<Employee> elist = new ArrayList<>();
		try {
			ResultSet rs = findEmployee.executeQuery();
			while(rs.next()) {
				
					elist.add(new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
				
			}} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(elist.size()>0) {
				return elist;
			}
			return null;
		
	}
	
	//function to search specific employee By id 
	@Override
	public Employee searchById(int eid) {
		Employee e = null;
		try {
			findById.setInt(1, eid);
			ResultSet rs = findById.executeQuery();
			if (rs.next()) {

				e = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return e;
	}
	
	//function to remove an employee by id
	@Override
	public boolean deleteById(int eid) {
		try {
			deletebyid.setInt(1, eid);
			int n = deletebyid.executeUpdate();
			if(n>0) {
				return true;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
		}
		return false;
	}
	
	//function to update salary of an employee
	@Override
	public boolean updateById(int eid, int salary) {
		try {
			updateById.setInt(1, salary);
			updateById.setInt(2, eid);
			int n = updateById.executeUpdate();
			if (n > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	// function to arrange all employees by id 
	@Override
	public List<Employee> arrangeById() {
		List<Employee> elist = new ArrayList<>();
		try {
			ResultSet rs = sortById.executeQuery();
			while(rs.next()) {
				
					elist.add(new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
				
			}} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(elist.size()>0) {
				return elist;
			}
			return null;
		
	}

	//function to close the connection
	@Override
	public void closeConnection() {
		DButil.closeMyConnection();
		
	}

	

	
	
}
