package com.edu.bank.test;
import com.edu.bank.*;
public class BankAppTest {

	public static void main(String[] args) {
	
		Customer c1 = new Customer("동은",1,new Account(1111,"kb1"));
		Customer c2 = new Customer("지수",2,new Account(2222,"kb2"));
		
		c1.account.startBalance(10000);
		System.out.println(c1.custName+"님"+c1.account.bankName+"통장 개설, 잔액:"+c1.account.balance);
		c2.account.startBalance(50000);
		System.out.println(c2.custName+"님"+c2.account.bankName+"통장 개설, 잔액:"+c2.account.balance);
		
		double temp;
		temp = c1.account.deposit(50000);
		System.out.println(c1.custName+"님"+ temp +"입금하여 현재 잔액"+c1.account.balance+"원 입니다.");
		c1.account.withdrawl(20000);
		System.out.println(c1.custName+"님 출금하여 현재 잔액"+c1.account.balance+"원 입니다");
		
		
		System.out.println(c2.custName+"님"+c2.account.deposit(100000)+"입금하여 현재 잔액"+c2.account.balance+"원 입니다.");
		c2.account.withdrawl(50000);
		System.out.println(c2.custName+"님 출금하여 현재 잔액"+c2.account.balance+"원 입니다");
		
		
		System.out.println(c1.custName+"의 계좌정보입니다.\n"+c1.account.getAccountInfo()); 
		System.out.println(c2.custName+"의 계좌정보입니다.\n"+c2.account.getAccountInfo()); 

		
		
	}

}
