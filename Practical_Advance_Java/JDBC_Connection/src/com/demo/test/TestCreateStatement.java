package com.demo.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class TestCreateStatement {

	public static void main(String[] args) {
		Connection conn = null;
	try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			String url="jdbc:mysql://192.168.10.117:3306/dac31?useSSL=false";
			conn =  DriverManager.getConnection(url,"dac31","welcome");
			if(conn!=null) {
				System.out.println("Connection Done");
			}else {
				System.out.println("Connection not Done");
			}
			
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from dept");
			while(rs.next()) {
				System.out.println("DEPTNO : "+rs.getInt(1));
				System.out.println("DNAME : "+rs.getString(2));
				System.out.println("LOC : "+rs.getString(3));
				System.out.println("PWD : "+rs.getString(4));;	
				System.out.println("date : "+rs.getString(5));
			}
			
			int DEPTNO = 131;
			String DNAME = "Civil";
			String LOC = "Pune";
			String PWD = "r50mpmpkn";
			LocalDate ldt=LocalDate.now();
			String sqlDate = ldt.toString();
			String query = "insert into dept values("+DEPTNO+",'"+DNAME+"','"+LOC+"','"+PWD+"','"+sqlDate+"')";
			System.out.println(query);
				int n =  st.executeUpdate(query);
				if(n>0) {
					System.out.println("Data Added Successfully");
				}else {
					System.out.println("Data not added Successfully");
				}
			
	}catch(SQLException e) {
		e.printStackTrace();
	}
	finally{
		try {
			conn.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	}

}
