package com.demo.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class TestPreparedStatement {

	public static void main(String[] args) {
		Connection conn = null;
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			String url="jdbc:mysql://192.168.10.117:3306/dac31?useSSL=false";
			conn = DriverManager.getConnection(url,"dac31","welcome");
			PreparedStatement pst = conn.prepareStatement("select * from dept");
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				System.out.println("DEPTNO : "+rs.getInt(1));
				System.out.println("DNAME : "+rs.getString(2));
				System.out.println("LOC : "+rs.getString(3));
				System.out.println("PWD : "+rs.getString(4));;	
				System.out.println("date : "+rs.getString(5));
				System.out.println("-----------------------------------");
			}
			PreparedStatement pst1 = conn.prepareStatement("insert into dept values(?,?,?,?,?)");
			int DEPTNO = 31;
			String DNAME = "CSE";
			String LOC = "Kolhapur";
			String PWD = "r50mpmpkn";
			LocalDate ldt=LocalDate.now();
			@SuppressWarnings("unused")
			String sqlDate = ldt.toString();
			pst1.setInt(1, DEPTNO);
			pst1.setString(2, DNAME);
			pst1.setString(3, LOC);
			pst1.setString(4, PWD);
			pst1.setDate(5, java.sql.Date.valueOf(ldt));
			int n= pst1.executeUpdate();
			if(n>0) {
				System.out.println("Added Successfully");
			}else {
				System.out.println("error");
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
