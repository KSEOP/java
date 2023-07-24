package com.edu.parent;
//Parent Class.

import com.edu.util.MyDate;

public class Employee {
	private String name;
	private MyDate birthday;
	private double salary;
	
	public Employee() {};
	public Employee(String name, MyDate birthday, double salary) {
		this.name = name;
		this.birthday = birthday;
		this.salary = salary;
	}

	public String getDetails() {
		return "name=" + name + ", birthday=" + birthday;
	}
	
	

}
