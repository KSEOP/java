package com.edu.test;

import com.edu.service.CustomerService;
import com.edu.vo.Customer;
import com.edu.vo.Product;

public class ProductOutletTest3 {
	public static void main(String[] args) {
		Product[] pros1= { 
				new Product("신라면", 1200, 10, "농심"), 
				new Product("삼다수생수", 1100, 2, "농심"),
				new Product("옥시크린", 34000, 1, "엘지"), 
				new Product("I-Phone", 1000000, 1, "애플") 
				};
		
		Product[] pros2= { 
				new Product("새우깡", 1000, 2, "농심"), 
				new Product("Terra", 5000, 2, "T"),
				new Product("정수기", 304000, 1, "엘지") 
				};
		
		Customer[] custs = {
				new Customer(111,"원빈","방배동"),
				new Customer(222,"이나영","방배동")					
		};
		custs[0].buyProducts(pros2);
		custs[1].buyProducts(pros1);
		CustomerService service = new CustomerService();
		System.out.println("=========1=========");
		Product[] pros = service.getProducts(custs[0]);
		for (Product product : pros)
			System.out.println(product);
		System.out.println();
		
		System.out.println("=========2=========");
		//2
		String[] makers = service.getAllProductMaker(custs[0]);
		for (String maker: makers) {
			System.out.println(maker);
		}
		System.out.println();
		
		System.out.println("=========3=========");
		//3
		Customer custBySsn = service.findCustomer(custs, 111);
		if(custBySsn == null) {
			System.err.println("ERROR");
		}
		System.out.println(custBySsn.getCustomerInfo());
		System.out.println();
		
		System.out.println("=========4=========");
		//4
		Customer[] custsByAddress = service.findCustomer(custs, "방배동");
		for (Customer customer : custsByAddress) {
			System.out.println(customer.getCustomerInfo());
		}
		
	}
}
