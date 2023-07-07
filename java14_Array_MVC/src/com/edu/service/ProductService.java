package com.edu.service;

import com.edu.vo.Product;

//Product들을 관리하는 기능만으로 구성된 서비스 클래스...
//메소드 identifier/return type, 인자값
//구현
//...
//"메소드 하나 당 완벽한 서비스다"
public class ProductService {

	// 1. 배열 안에 있는 모든 상품들의 메이커를 출력하는 기능
	public void printAllProductMakers(Product[] products) {
		for (Product product : products) {
			System.out.println(product.getMaker());
		}
	}

	// 2. 상품들의 총 구입액을 리턴하는 기능
	public int getTotalPrice(Product[] products) {
		int total = 0;
		for (Product product : products) {
			total += product.getPrice() * product.getQuantity();
		}
		return total;
	}

	// 3. 특정 금액 이상의 상품을 리턴하는 기능
	public Product[] getAbovePriceProducts(Product[] products, int price) {
		Product[] temp = new Product[products.length];
		int idx = 0;
		for (Product product : products) {
			if(product.getPrice() > 10000) {
				temp[idx++] = product;
			}
		}
		return temp;
	}

	// 4. 동일한 회사의 제품들만 리턴하는 기능
	public Product[] getCertainCompanyProducts(Product[] products, String company) {
		Product[] temp = new Product[products.length];
		int idx = 0;
		for (Product product : products) {
			if(product.getCompany().equals(company)) {
				temp[idx++] = product;
			}
		}
		return temp;
	}
	
	// 5. 구입한 상품들의 평균가격을 리턴하는 기능
	public int getAvgPrice(Product[] products) {
		return getTotalPrice(products) / products.length;
	}
}
