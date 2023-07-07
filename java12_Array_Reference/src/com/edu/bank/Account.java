package com.edu.bank;
//제어문 추가

/* 
 1. 입금(deposit..)시 1천원 이상의 금액만 입금 / "입금액은 1천원 이상~".. 다시 되돌린다. return.
 2. 출금(withdraw..)시 잔액보다 더 큰 금액은 출금이 안되도록 / "출금액이 잔액보다~~".. 다시 되돌린다. return  
 */

public class Account {
	private int accNumber;
	private double balance;
	private String bankName;

	public Account() {
	};

	public Account(int accNumber, String bankName, double balance) {
		this.accNumber = accNumber;
		this.bankName = bankName;
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}

	public String getBankName() {
		return bankName;
	}

	// 기능추가.. 입금/출금.. 제어문.
	public void deposit(double amt) {
		if (amt < 1000) {
			System.out.println("입금액은 1,000원 이상부터 가능합니다");
			return; // 호출 시작 지점으로 로직을 다시 돌림.
		} else
			balance += amt;

	}

	public void withdrawl(double amt) {
		if (amt > balance) {
			System.out.println("잔액보다 출금액이 더 많습니다.");
			return;
		} else
			balance -= amt;
	}
	// 필드값 리턴 
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return bankName + "-" + accNumber + "-" + balance;
	}
//	public String toStirng() {
//		return bankName + "-" + accNumber + "-" + balance;
//	}
}
