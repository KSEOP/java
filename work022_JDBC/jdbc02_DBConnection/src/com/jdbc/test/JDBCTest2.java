package com.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jdbc.dao.CustomDAO;

import config.ServerInfo;

public class JDBCTest2 {

	public static void main(String[] args) throws Exception{
		CustomDAO dao = new CustomDAO();
		// dao.addCustom(40, "이정재", "신사동");
		
		// dao.deleteCustom(10);
		
		//dao.printAcustom(30);
		
		dao.printAllcustom();
		
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
