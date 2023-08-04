package com.jdbc.dao;
//Business Logic의 Template...

import java.sql.SQLException;
import java.util.ArrayList;

import com.jdbc.vo.Custom;

public interface CustomDAO {
	void  addCustom(Custom cust)throws SQLException;
	void  deleteCustom(int id) throws SQLException;
	void  updateCustom(Custom cust)throws SQLException;
	
	Custom getCustomer(int id) throws SQLException;
	ArrayList<Custom> getAllCustomer()throws SQLException;
}
