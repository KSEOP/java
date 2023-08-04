package com.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.ServerInfo;

public class JDBCTest1 {

	public JDBCTest1() throws SQLException {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
		
		conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
		System.out.println("Database Connection...");
		
		// ------------------ 이게 하나의 DeleteCustomer(); 가 될 수 있음.----------------------
		/*
		String query = "DELETE CUSTOM WHERE ID=?";
		PreparedStatement ps = conn.prepareStatement(query);
		System.out.println("PreparedStatement Creation...");
		
		ps.setInt(1, 40);
		
		int row = ps.executeUpdate(); // 이때 실질적으로 db에서 데이터 삭제 발생, commit 자동 수행.
		System.out.println(row+"ROW DELETE OK");
		*/
		//
		
		// ------------------ UPDATE :: 아이디 10번 고객의 이름을 James1, 주소를 NY로 변경 ---------
		/*
		String query = "UPDATE CUSTOM SET NAME =?, ADDRESS =? WHERE ID=?";
		PreparedStatement ps = conn.prepareStatement(query);
		System.out.println("PreparedStatement Creation...");
		
		ps.setString(1, "JAMES1");
		ps.setString(2, "NY");
		ps.setInt(3, 10);
		
		int row = ps.executeUpdate(); // 이때 실질적으로 db에서 데이터 삭제 발생, commit 자동 수행.
		System.out.println(row+" ROW UPDATE OK");
		*/
		
		//---------------------------------------------------
		
		// SELECT :: CUSTOM 테이블에 모든 데이터를 받아서 출력
		String query = "SELECT ID, NAME, ADDRESS FROM CUSTOM";
		ps = conn.prepareStatement(query);
		
		rs = ps.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getInt("id")+"\t"
								+rs.getString("name")
								+rs.getString("address"));
		}
		}finally {
			
			rs.close();
			ps.close();
			conn.close();
			
		}
		
		// 가장 마지막에 만든 것을 가장 먼저 만든다. -- 가장 먼저만든걸 가장 마지막에 닫는다.
		
		
		
		
		
	}
	public static void main(String[] args) throws SQLException {
		new JDBCTest1();
		
		
	}
	
	static {
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
			System.out.println("Driver Loading Success...");
		}catch(ClassNotFoundException e) {
			System.out.println("Driver Loading Fail...");
		}
	}

}
