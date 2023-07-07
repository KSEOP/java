package com.edu.bank;

public class Customer {
	private int ssn;
	private String custName;
	// private Account account; //선언만으로 주입이 이뤄지진 않는다.
	private Account[] accounts;

	public Customer(int ssn, String custName) {
		super();
		this.ssn = ssn;
		this.custName = custName;
		
	}

	public void setAccounts(Account[] accounts) {
		this.accounts = accounts;
	}

	public Account[] getAccounts() {
		return accounts;
	}

	public String getCustomerInfo() {
		return ssn + "-" + custName;
	}

//
//	public String toString() {
//		return ssn + custName + accounts;
//
//	}
	@Override
	public String toString() {
		return ssn + custName + accounts;
}
	
}