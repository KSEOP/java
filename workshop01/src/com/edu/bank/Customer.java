package com.edu.bank;

public class Customer {
	public String custName;
	public int ssn;
	public Account account;
	
	
	public Customer(String custName, int ssn, Account account) {
		this.custName = custName;
		this.ssn = ssn;
		this.account = account;
	}
		
	
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getName() {
		return custName;
	}
	
	public void setSsn(int ssn) {
		this.ssn = ssn;
	}
	
	public int getCustomerInfo() {
		return ssn;
	}
	
	
}
