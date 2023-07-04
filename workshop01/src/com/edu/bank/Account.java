package com.edu.bank;

public class Account {
	public int accNumber;
	public double balance;
	public String bankName;
	
	
	public Account(int accNumber, String bankName, double balance) {
		this.accNumber=accNumber;
		this.bankName=bankName;
		this.balance = balance;
	}
	
	
	public String getAccountInfo() {
		return bankName+"\n"+accNumber+"\n"+balance;
	}
	
	public double getBalance() {
		return balance;
	}

	public String getBankName() {
		return bankName;
	}

	// 기능추가
	public void deposit(double amt) {
		balance += amt;
		
	}
	public void withdrawl(double amt) {
		balance -= amt;
	}		
}

	
