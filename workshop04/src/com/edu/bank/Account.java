package com.edu.bank;

public class Account {
	private int balance;
	
	public Account(int balance) {
		this.balance = balance;
		System.out.println("성공적으로 통장개설하였습니다.");
	}
	
	public int getBalance() {
		return balance;
	}
	
	public void deposit(int amt) {
		if(amt < 1000) {
			System.out.println("1000이상 입금해야 합니다.");
		}else {
			balance+=amt;
		}
	}
	
	public void withdraw(int amt) {
		if(amt > balance) {
			System.out.println("잔액이 부족합니다.");
		}else {
			balance-=amt;
		}
	}
	
	@Override
	public String toString() {
		return "현재 잔액은 " + balance + "원입니다.";
	}
	
}
