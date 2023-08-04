package com.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.ServerInfo;

/*
 * Business Logic을 가지고 있는 DAO 클래스
 * 하나의 기능이 완벽한 서비스 단위이다.
 * 
 * 
 */
public class CustomDAO {
	public CustomDAO() {
		System.out.println("CustomDAO...Creating...");
		
	}
	////////   공통적으로 반복되는 로직    /////////
	private Connection getConnect() throws SQLException{
		Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
		System.out.println("DB Connect....");
		
		return conn;
	}
	
	private void closeAll(Connection conn, PreparedStatement ps) throws SQLException{
		
		ps.close();
		conn.close();
	}
		
	private void closeAll(Connection conn, PreparedStatement ps, ResultSet rs) throws SQLException{
			if(rs!=null) rs.close();
			ps.close();
			conn.close();
	}	
	
	
	
	////////            Business Logic :: basic CRUD             /////////
	public void addCustom(int id, String name, String addr) throws SQLException{
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
		conn = getConnect();
		String query = "INSERT INTO CUSTOM (id, name, address) VALUES(?,?,?)";
		ps = conn.prepareStatement(query);
		
		ps.setInt(1, id);
		ps.setString(2, name);
		ps.setString(3, addr);
		
		System.out.println(ps.executeUpdate()+" 명 등록 성공");
		}finally{
			closeAll(conn, ps);
		}
	}// addCustom
	
	public void deleteCustom(int id) throws SQLException{
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
		conn = getConnect();
		String query = "DELETE CUSTOM WHERE ID=?";
		ps = conn.prepareStatement(query);
		System.out.println("PreparedStatement Creation...");
		
		ps.setInt(1, id);
		
		System.out.println(ps.executeUpdate()+" ROW DELETE OK");
		
		}finally{
		closeAll(conn, ps);
		}
	}
	
	public void updateCustom(int id, String name, String addr) {
		
	}
	
	public void printAllcustom() throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = getConnect();
			String query = "SELECT ID, NAME, ADDRESS FROM CUSTOM";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt("id")+"\t"
									+rs.getString("name")+"\t"
									+rs.getString("address"));
			}
			
			
		}finally {
			closeAll(conn, ps, rs);
		}
		
		
		
	}
	
	public void printAcustom(int id) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn=getConnect();
			String query = "SELECT ID, NAME, ADDRESS FROM CUSTOM WHERE ID=?";
			
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			// 특정한 1명의 고객을 찾을 때에는 while이 아닌 if 하면 된다.
			if(rs.next()) {
				System.out.println(rs.getString("name")+"\t"+rs.getString("address"));
			}
			
		}finally {
			if(rs!=null) rs.close();
			closeAll(conn, ps);
		}
		
		
		
	}
	
	
	
	
}
