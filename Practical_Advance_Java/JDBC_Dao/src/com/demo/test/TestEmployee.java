package com.demo.test;

import java.util.List;
import java.util.Scanner;

import com.demo.beans.Employee;
import com.demo.service.EmployeeService;
import com.demo.service.EmployeeServiceImpl;

public class TestEmployee {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice =0;
		EmployeeService eservice = new EmployeeServiceImpl();
		do {
			System.out.println("1.Add new Employee\n  2.display All\n3.find By Id");
			System.out.println("4.Delete Employee\n 5.display in sorted order\\n  6.modify Employee\n 7.exit ");
			System.out.println("Choice : ");
			choice = sc.nextInt();
			switch(choice) {
			case 1->{
				boolean status = eservice.addEmployee(); 
				if(status) {
					System.out.println("Employee Added Sucessfully");
				}else {
					System.out.println("Not found");
				}
			}
			case 2 ->{
				List<Employee> elist = eservice.getAllEmployee();
				elist.forEach(System.out::println);
			}
			case 3 ->{
				System.out.println("Enter the Employee ID : ");
				int eid = sc.nextInt();
				Employee e = eservice.findById(eid);
				if(e == null) {
					System.out.println("not found");
				}else {
					System.out.println(e);
				}
			}
			case 4 ->{
					System.out.println("Enter the Employee ID");
					int eid = sc.nextInt();
					boolean status = eservice.deleteById(eid);
					if(status) {
						System.out.println("Employee deleted successfully");
					}else {
						System.out.println("Not found");
					}
			}
			
			case 5 ->{
				List<Employee> elist = eservice.sortById();
				elist.forEach(System.out::println);
			}
			case 6 ->{
				System.out.println("Enter employee Id:");
				int eid = sc.nextInt();
				System.out.println("Enter salary:");
				int salary = sc.nextInt();
				boolean status = eservice.modifyEmployee(eid,salary);
				if(status) {
					System.out.println("updated successfully");
				}
				else {
					System.out.println("Not found");
				}
			}
		
			case 7 ->{
				System.out.println("Thank you for visiting");
				sc.close();
				eservice.closeMyConnection();	
			
		}
			}
		}while(choice!=7);
	}

}
