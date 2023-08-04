package com.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.jdbc.dao.CustomDAO;
import com.jdbc.vo.Custom;

import config.ServerInfo;

public class CustomDAOImpl implements CustomDAO {

	private static CustomDAOImpl dao = new CustomDAOImpl();

	private CustomDAOImpl() {
		System.out.println("CustomDAOImpl Creating... Using Singletone");
	}

	public static CustomDAOImpl getInstance() {
		return dao;
	}

	/////////////// 공통 로직 ///////////////////

////////   공통적으로 반복되는 로직    /////////
	private Connection getConnect() throws SQLException {
		Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
		System.out.println("DB Connect....");
		return conn;
	}

	private void closeAll(Connection conn, PreparedStatement ps) throws SQLException {
		if (ps != null) ps.close();
		if (conn != null) ps.close();

	}

	private void closeAll(Connection conn, PreparedStatement ps, ResultSet rs) throws SQLException {
		if (rs != null)
			rs.close();
		ps.close();
		conn.close();
	}

	////////////// 비즈니스 로직 /////////////////
	public boolean idExists(int id, Connection conn) throws SQLException {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
			
			String query = "SELECT ID FROM CUSTOM WHERE ID=?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			return rs.next(); // next 했는데 있으면 자체적으로 true, 없으면 false임.					

		
	}

	@Override
	public void addCustom(Custom cust) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnect();
			if(!idExists(cust.getId(), conn)) {// id가 없으면, 추가. 없으면 추가안함.
				String query = "INSERT INTO CUSTOM (ID, NAME, ADDRESS) VALUES(?,?,?)";
				ps = conn.prepareStatement(query);
				ps.setInt(1, cust.getId());
				ps.setString(2, cust.getName());
				ps.setString(3, cust.getAddress());
				
				System.out.println(ps.executeUpdate()+" 명 회원 등록.");
			}else {
				// 예외 발생.. throw new DulicateIDException()
				System.out.println(cust.getName()+"님은 이미 회원입니다.");
			}			
		}finally{
			closeAll(conn, ps);
		}
		
		// 존재유무 확인!!

	}


	@Override
	public void deleteCustom(int id) throws SQLException {		
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnect();
			
			
		}finally {
			closeAll(conn, ps);
		}
	}

	@Override
	public void updateCustom(Custom cust) throws SQLException {		
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnect();
			
			
		}finally {
			closeAll(conn, ps);
		}
	}

	@Override
	public Custom getCustomer(int id) throws SQLException {
		
		return null;
	}

	@Override
	public ArrayList<Custom> getAllCustomer() throws SQLException {
	
		return null;
	}

}