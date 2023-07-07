package com.edu.bank.test;

import com.edu.bank.Account;
import com.edu.bank.Customer;

public class BankTest1 {
	public static void main(String[] args) {
		/*
		 * 1. Account타입의 배열을 생성 111. 국민은행, 12만원 222. 신한은행, 340만원 333. 하나은행, 9만원
		 * 
		 * 2. 김국민 이라는 고객이 1번에서 생성된 배열을 가짐. 이는 김국민에게는 국민은행, 신한은행, 하나은행 통장을 개설했다는 뜻.
		 * 
		 * 3. 반복문을 사용해 김국민이 개설한 통장의 정보를 출력
		 */
		Account[] accounts = { new Account(111, "국민은행", 120000), new Account(222, "신한은행", 3400000),
				new Account(333, "하나은행", 90000) };
		// 2.
		Customer custom = new Customer(123, "김국민");
		custom.setAccounts(accounts);

		// 3.
		Account[] accs = custom.getAccounts();

		System.out.println("개설한 통장의 정보입니다.");

		for (Account acc : accs) {
			System.out.println(acc);
		}

		System.out.println("============");

		// 1. 김국민이 개설한 통장중에서 국민은행 통장을 찾아서 해당 통장의 잔액을 출금
		System.out.println("====개설한 통장중 국민은행 통장입니다.");
		for (Account acc : accs) {
			if (acc.getBankName().equals("국민은행")) {
				acc.withdrawl(5000);
				System.out.println("잔액은" + acc.getBalance() + "원 입니다.");
			}

		}

//		}

		double totalBalance = 0;
		// 2. 김국민이 개설한 통장의 모든 잔액의 총합을 출력
		for (Account acc : accs) {
			totalBalance += acc.getBalance();
		}
		System.out.println("김국민님이 개설한 통장의 모든 잔액은" + totalBalance + "원 입니다.");

		// 3. 김국민이 개설한 통장 중에서 가장 많은 잔액이 들어있는 은행의 이름과 해당 잔액을 출금

		double balance = 0;
		for (Account acc : accs) {
			if (acc.getBalance() > balance) {
				balance = acc.getBalance();
			} else
				continue;
		}
		for (Account acc : accs) {
			if (acc.getBalance()==balance) {
				System.out.println(acc);
				acc.withdrawl(acc.getBalance());
				System.out.println("현재잔액은"+acc.getBalance()+"원입니다.");
				
			}
		
		}
		
		

		/*
		 * 
		 * /* 내가쓴것. 미완 Account acc1 = new Account(111,"국민은행",120000); Account acc2 = new
		 * Account(222,"신한은행",3400000); Account acc3 = new Account(333,"하나은행",90000);
		 * 
		 * Account[] accs = {acc1, acc2, acc3};
		 * 
		 * Customer cust1 = new Customer(1,"김국민");
		 * 
		 * cust1.setAccounts(accs);
		 * 
		 * for(int i=0; i<accs.length; i++) { System.out.println(cust1.accs[i]);
		 * 
		 * }
		 */

		// Account[] acc1 =
		// {(111,"국민은행",120000),(222,"신한은행",3400000),(333,"하나은행",90000)};

	}

}
