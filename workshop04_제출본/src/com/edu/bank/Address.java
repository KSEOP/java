package com.edu.bank;

public class Address {
   private int zipCode;
   private String region;
   private String city;
   
   public Address(int zipCode, String region, String city) {
      this.zipCode = zipCode;
      this.city = city;
      this.region = region;
   }
   
   @Override
   public String toString() {
      return zipCode + ") " + region + " " + city;
   }
}