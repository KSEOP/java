package com.edu.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import config.ServerInfo;

public class DBConnectionTest2 {
	public DBConnectionTest2() {
		// jdbc 4단계 작업.
		try {
			// 1. Driver Loading
			// FQCN(Full Quialified Class Name) 으로 넣어야함.
			Class.forName(ServerInfo.DRIVER_NAME);
			System.out.println("Driver Loading...Success~!");
			
			// 2. DBConnection
			// getConnection(String url, String user, String password)
			
			// 통신 (protocol)
			// jdbc.:oracle:thin:@127.0.0.1:1521:XE
			// 1521은 오라클 포트
			
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
			String user = "mykb";
			String password = "1234";
			
			try {
			Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER , ServerInfo.PASSWORD );
			System.out.println("DB Connection...");
				
			// 3. PrepareStatement 객체 생성
			// custom 테이블에 하나의 행을 추가하는 쿼리문
			String query = "INSERT INTO custom (ID, NAME, ADDRESS) VALUES(?,?,?)";
			PreparedStatement ps = conn.prepareStatement(query);
			System.out.println("Creating PreparedStatement...");
				
				// 바인딩: ?에 값을 넣는다라는 의미의 전문용어임. 모두가 다 쓰는 정도는 아님.
			ps.setInt(1, 12); // 1은 첫번째 물음표, 그곳에 바인딩할 값이 두번째 인자임
			ps.setString(2, "Hinson");
			ps.setString(3, "Brandon");
			
			// 4.쿼리문 실행
			int result = ps.executeUpdate();
			System.out.println(result); // DML 의 M, 추가된 행 수를 리턴함.
						// commit 안했는데도 왜 들어갔는가?
						// 위는 프로그램에서 SQL을 동작한 것, 애플리케이션.
						// ==> 프로그램으로 SQL을 동작시키면 자동 커밋임. 반면 콘솔 CMD 등에서 하면 수동 커밋.
						// DDL일때는 자동커밋, DML 일때에는 커밋해줘야함. <-- 확실히 무슨 말인지?
			
			
			
				
				
			} catch (SQLException e) {
				System.out.println("Driver Loading...Fail");			}
		
			} catch (ClassNotFoundException e) {
				System.out.println("Driver Loading...Fail");
			}
		
		
		
	}

	public static void main(String[] args) {
		new DBConnectionTest2();
		

	}

}
