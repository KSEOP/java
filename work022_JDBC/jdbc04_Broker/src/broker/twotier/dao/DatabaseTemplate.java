package broker.twotier.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import broker.twotier.exception.DuplicateSSNException;
import broker.twotier.exception.InvalidTransactionException;
import broker.twotier.exception.RecordNotFoundException;
import broker.twotier.vo.CustomerRec;
import broker.twotier.vo.SharesRec;
import broker.twotier.vo.StockRec;

public interface DatabaseTemplate {
	// 공통로직 (커넥션 열고 닫고)
	Connection getConnect() throws SQLException;
	void closeAll(PreparedStatement ps, Connection conn)throws SQLException;
	void closeAll(ResultSet rs, PreparedStatement ps, Connection conn)throws SQLException;
	
	//비지니스 로직...CRUD
	void addCustomer(CustomerRec cust)throws SQLException,DuplicateSSNException;
	void deleteCustomer(String ssn)throws SQLException,RecordNotFoundException;
	void updateCustomer(CustomerRec cust)throws SQLException,RecordNotFoundException;
	
	ArrayList<SharesRec> getPortfolio(String ssn) throws SQLException; // 주요 포인트 1, getPortfolio를 먼저 만들었음을 이해할 수 있음 
	CustomerRec getCustomer(String ssn) throws SQLException; // 주요 포인트 2.
	ArrayList<CustomerRec> getAllCustomers() throws SQLException;
	ArrayList<StockRec> getAllStocks() throws SQLException;
	
	//비지니스 로직...특화된 로직 (이 코드에, 이 상황에 특화된 로직)
	void buyShares(String ssn, String symbol, int quantity)throws SQLException;
	void sellShares(String ssn, String symbol, int quantity)throws SQLException,InvalidTransactionException,RecordNotFoundException;

}













