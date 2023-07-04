package com.edu.bank.test;

import com.edu.bank.Account;
import com.edu.bank.Customer;

public class BankAppTest {

	public static void main(String[] args) {
	
//		Customer c1 = new Customer("동은", 111, new Account(1, "국민은행", 10000.0));
//		Customer c2 = new Customer("지수", 222, new Account(2, "국민은행", 20000.0));
		
		
		Customer c1 = new Customer("동은", 111);
		Customer c2 = new Customer("지수", 222);
		
		c1.setAccount(new Account(1, "국민은행", 10000.0));
		c2.setAccount(new Account(2, "국민은행", 20000.0));
		
		//동은이가 개설한 통장을 반환
		Account dong=c1.getAccount();
		Account jisu=c2.getAccount();
		
		//동은이 통장 사용
		dong.deposit(5000);
		dong.deposit(2000);
		dong.withdrawl(7000);
		
		System.out.println("동은이의 잔약을 확인합니다...");
		System.out.println(dong.getBalance()+" 원");
		
		//  지수도 입금, 출금, 출금...잔액확인
		// 지수의 나머지; 정보도 확인
	}

}
