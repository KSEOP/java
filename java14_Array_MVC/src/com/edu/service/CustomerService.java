package com.edu.service;

import com.edu.vo.Customer;
import com.edu.vo.Product;

/*
 * 아울렛에서 상품을 구매하는 고객에 대한 기능을 다루는
 * 서비스 클래스
 * 기능들만 정의되어 있다.
 * 하나의 기능은 독자적인 서비스로 이해하자.
 */
public class CustomerService {
	// 1. 특정 고객이 구입한 상품을 리턴하는 기능
	public Product[] getProducts(Customer c) {
		return c.getProducts();
	}

	// 2. 특정 고객이 구입한 상품들의 maker들을 리턴
	public String[] getAllProductMaker(Customer c) {
		String[] temp = new String[c.getProducts().length];
		int idx = 0;
		Product[] pros = c.getProducts();
		for (Product product : pros) {
			temp[idx++] = product.getMaker();
		}
		return temp;
	}
	//=======================오버로딩1============================
	// 3. 모든 고객 중에서 특정한 고객을 검색
	public Customer findCustomer(Customer[] custs, int ssn) {
		Customer customer = null;
		for (Customer cust : custs) {
			if(cust.getSsn() == ssn) {
				customer = cust;
				break;
			}
		}
		return customer;
	}

	// 4. 모든 고객 중에서 특정한 동네에 사는 고객을 검색
	public Customer[] findCustomer(Customer[] custs, String address) {
		Customer[] customer = new Customer[custs.length];
		int idx = 0;
		for (Customer cust : custs) {
			if(cust.getAddress().equals(address)) {
				customer[idx++] = cust;
			}
		}
		return customer;
	}

	//=======================오버로딩2============================
	// 3. 모든 고객 중에서 특정한 고객을 검색
	public Customer findCustomerBySsn(Customer[] custs, int ssn) {
		Customer customer = null;
		for (Customer cust : custs) {
			if(cust.getSsn() == ssn) {
				customer = cust;
				break;
			}
		}
		return customer;
	}
	

	// 4. 모든 고객 중에서 특정한 동네에 사는 고객을 검색
	public Customer[] findCustomerByAddress(Customer[] custs, String address) {
		Customer[] customer = new Customer[custs.length];
		int idx = 0;
		for (Customer cust : custs) {
			if(cust.getAddress().equals(address)) {
				customer[idx++] = cust;
			}
		}
		return customer;
	}
}