package com.edu.test;

import com.edu.child.Manager;
import com.edu.util.MyDate;

public class InheritanceTest1 {

	public static void main(String[] args) {
		
		Manager m = new Manager("James", new MyDate(1990,1,1), 40000.0, "IT");
		
		System.out.println(m.getDetails());

	}

}
