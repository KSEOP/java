package com.edu.bank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Bank {
   public ArrayList<Customer> customers = new ArrayList<Customer>();
   // ArrayList 사용 (Customer 의 리스트)

   public Bank() {}
   
   public void addCustomer(String name, int rrn, int zipCode, String region, String city) {      
      customers.add(new Customer(name, rrn, zipCode, region, city));
      // 고객 정보 생성
   }
   
   public Customer getCustomer(int rrn) {
      for(Customer cust : customers) {
         if(cust.getRrn() == rrn) return cust;
      }
      return new Customer();
   }
   
   public ArrayList<Customer> removeCustomer(int rrn) {
      int idx = -1;
      
      for(int i = 0; i < customers.size(); i++) {
         if(customers.get(i).getRrn() == rrn) {
            idx = i;
         }
      }
      customers.remove(idx);
      // 제거 후 반환
      
      return customers;
   }
   
   public void showAll() {
      Comparator<Customer> c = new Comparator<Customer>() {
         @Override
         public int compare(Customer o1, Customer o2) {
            // TODO Auto-generated method stub
            return o1.getName().compareTo(o2.getName());
            // 고객의 이름순으로 나열하기 위해 compareTo 를 사용함
         }
      };
      Collections.sort(customers, c);
      // Collections 로 정렬
      
      for(Customer cust : customers) {
         if( cust == null) continue;
         System.out.println(cust.getName());
      }
   }
}