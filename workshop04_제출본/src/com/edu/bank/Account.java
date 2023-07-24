package com.edu.bank;

public class Account {
   private int balance = 1000;
   
   public Account() {}
   
   public Account(int balance) {
      this.balance = balance;
   }
   

   
   public int getBalance() {
      return balance;
   } // 잔액 조회
   
   public void deposit(double amount) {
      if(amount < 1000) {
         System.out.println("천원 이상부터 가능합니다.");
         return;
      }
      balance += amount;
   } // 입금
   
   public void withdraw(double amount) {
      if(balance < amount) {
         System.out.println("잔액 부족");
         return;
      }
      balance -= amount;
   } // 출금

   
   
   @Override
   public String toString() {
      return  "잔액 >" + balance;
   }
}