package com.edu.bank;

public class Account {
	public int accNumber;
	public double balance;
	public String bankName;
	
	
	public Account(int accNumber, String bankName) {
		this.accNumber=accNumber;
		this.bankName=bankName;
	}
	
	
	public String getAccountInfo() {
		return bankName+"\n"+accNumber+"\n"+balance;
	}
	public void startBalance(double balance) {
		this.balance = balance;
	}	
	public double getBalance() {
		return balance;
	}

	public String getBankName() {
		return bankName;
	}

	// 기능추가
	public double deposit(double amt) {
		balance += amt;
		return amt;
	}
	public void withdrawl(double amt) {
		balance -= amt;
	}
		
}

	
