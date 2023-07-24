package com.edu.bank;

import com.edu.bank.Address;
import com.edu.bank.Account;


public class Customer {
   private String name;
   private int rrn;
   private Account account;
   private Address address;
   
   public Customer() {}
   
   public Customer(String name, int rrn, int zipCode, String region, String city) {
      this.name = name;
      this.rrn = rrn;
      this.address = new Address(zipCode, region, city);
      this.account = new Account();
   }
   
   public String getName() {
      return name;
   }
   
   public int getRrn() {
      return rrn;
   }
   
   public Account getAccount() {
      return account;
   }
   
   public void setAccount(Account account) {
      this.account = account;
   }
   
   public Address getAddress() {
      return address;
   }
   
   public void setAddress(Address address) {
      this.address = address;
   }
   
   @Override
   public String toString() {
      return name + "\t" + rrn + "\t" + address;
   }
}