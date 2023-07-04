package com.edu.bank;

public class Customer {
	public String custName;
	public int ssn;
	
	public Account account;
	
	
	public Customer(String custName, int ssn) {
		this.custName = custName;
		this.ssn = ssn;
		
	}
		
	
	public void setAccount(Account account) {
		this.account = account;
	}




	public Account getAccount() {
		return account;
	}
	

	public String getName() {
		return custName;
	}
	

	public int getCustomerInfo() {
		return ssn;
	}



	public String getCustName() {
		return custName;
	}



	public int getSsn() {
		return ssn;
	}


	
	
	
}
