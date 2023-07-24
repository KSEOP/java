package com.edu.bank.test;

import java.util.Scanner;

import com.edu.bank.Bank;
import com.edu.bank.Account;

public class BankTest {
   public static Bank bank = new Bank();
   
   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      while(true) {
         System.out.println("1. 고객 등록   2. 계좌 생성   3. 은행 업무   4. 고객 명단   5. 고객 정보 6. 고객 삭제 7. 실행 종료");
         int order = scanner.nextInt();
         
         switch(order) {
         case 1:
            addCustomer();
            break;
         case 2:
            addAccount();
            break;
         case 3:
            banking();
            break;
         case 4:
            bank.showAll();
            break;
         case 5:
            showCustomer();
            break;
         case 6:
            delCustomer();
            break;
         case 7:
            scanner.close();
            break;
         default:
            System.out.println("잘못된 입력입니다.");
            break;
         }
      }
   }
   
   
   
   public static void addCustomer() {
      System.out.println("[ 이름  주민등록번호 우편번호 도(행정구역) 지역명 ]순으로 입력하세요.");
      
      Scanner scanner = new Scanner(System.in);
      String name = scanner.next();
      int rrn = scanner.nextInt();
      int zipCode = scanner.nextInt();
      String region = scanner.next();
      String city = scanner.next();
      
      bank.addCustomer(name, rrn, zipCode, region, city);
      System.out.println(name + "님 회원등록 성공했습니다.");
      
   }
   
   public static void addAccount() {
      System.out.print("회원의 주민번호를 입력하세요 : ");
      
      Scanner scanner = new Scanner(System.in);
      int rrn = scanner.nextInt();
      
      int balance = 0;
      if(bank.getCustomer(rrn).getName() != "") {
         System.out.print("개설할 통장의 잔액을 입력하세요 : ");
         balance = scanner.nextInt();
         
         bank.getCustomer(rrn).setAccount(new Account(balance));
      }else {
         System.out.println("존재하는 회원이 없습니다.");
         return;
      }
   }

   public static void showCustomer() {
      System.out.print("회원의 주민번호를 입력하세요 : ");
      
      Scanner scanner = new Scanner(System.in);
      int rrn = scanner.nextInt();
      
      if(bank.getCustomer(rrn).getName() != "") {
         System.out.println(bank.getCustomer(rrn));
      }else {
         System.out.println("존재하는 회원이 없습니다.");
         return;
      }
   }
   
   public static void banking() {
      System.out.print("회원의 주민번호를 입력하세요 : ");
      
      Scanner scanner = new Scanner(System.in);
      int rrn = scanner.nextInt();
      
      if(bank.getCustomer(rrn).getName() == "") {
         System.out.println("존재하는 회원이 없습니다.");
         return;
      }
      
      if(bank.getCustomer(rrn).getAccount() == null) {
         System.out.println("통장개설부터 하세요.");
         return;
      }
      
      while(true) {
         System.out.println("1.입금    2.출금    3.잔액확인    4.나가기");
         int num = scanner.nextInt();
         
         switch (num) {
         case 1:
            deposit(rrn);
            break;
            
         case 2:
            withdraw(rrn);
            break;
         case 3:
            showBalance(rrn);
            break;
         case 4:
            return;
         default:
            System.out.println("잘못된 입력입니다.");
            break;
         }
      }
   }
   
   public static void deposit(int rrn) {
      System.out.print("입금할 금액을 입력하세요 : ");
      
      Scanner scanner = new Scanner(System.in);
      int amt = scanner.nextInt();
      
      bank.getCustomer(rrn).getAccount().deposit(amt);
      System.out.println(bank.getCustomer(rrn).getAccount());
      
   }
   
   public static void withdraw(int rrn) {
      System.out.print("출금할 금액을 입력하세요 : ");
      
      Scanner scanner = new Scanner(System.in);
      int amt = scanner.nextInt();
      
      bank.getCustomer(rrn).getAccount().withdraw(amt);
      System.out.println(bank.getCustomer(rrn).getAccount());
      
   }
   
   public static void showBalance(int rrn) {
      System.out.println(bank.getCustomer(rrn).getAccount());
   }
   
   public static void delCustomer() {
      System.out.println("삭제할 고객의 주민등록번호를 입력하세요 : ");
      Scanner scanner = new Scanner(System.in);
      int rrn = scanner.nextInt();
      
      bank.removeCustomer(rrn);
      // 삭제하기
   }
}