package com.edu.test;

class Person{
	String name;
	

	public Person(String name) {
		super();
		this.name = name;
	}
	
}

public class StaticExemTest4 {
	static int counter;
	public static void main(String[] args) {
		
		Person p = new Person("JAMES");
		System.out.println("James Person Instance Initialization");
	
	}//main
	
	static { // main 보다 먼저 동작됨을 실행 시 알 수 있음.
		counter++;
		System.out.println("static initialization block..."+counter);
	}
}
