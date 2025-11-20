package com.demo.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class TestCallableStatement {

	public static void main(String[] args) {
		Connection conn = null;
		
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			String url = "jdbc:mysql://192.168.10.117:3306/dac31?useSSL=false";
			conn =  DriverManager.getConnection(url,"dac31","welcome");
			java.sql.CallableStatement cst=conn.prepareCall("call getcnt(?,?,?,?,?)");
			cst.setInt(1, 10);
			cst.registerOutParameter(5, java.sql.Types.INTEGER);
			cst.execute();
			int cnt=cst.getInt(2);
			System.out.println("count : "+cnt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
