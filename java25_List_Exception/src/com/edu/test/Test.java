package com.edu.test;

public class Test {

	public static void main(String[] args) {
		String str1 = new String("JAVA");
		String str2 = new String("JAVA");
		
		///////// 원래는 위처럼 하는게 클래스 관점에선 맞으나, 아래처럼 하는 것 만으로도 생성함.
		
		String str3 = "JAVA"; 
		String str4 = "JAVA";
		
		
		System.out.println(str1==str2); // false
		// 값은 같지만 주솟값이 다름.
		System.out.println(str1.equals(str2)); // true
		
		System.out.println(str3==str4); // true
		
		System.out.println(str1.equals(str2)); // true
		
	}

}
