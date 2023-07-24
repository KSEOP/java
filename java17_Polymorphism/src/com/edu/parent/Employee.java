package com.edu.parent;
//Parent Class.

import com.edu.util.MyDate;

public class Employee {
	private String name;
	private MyDate birthday;
	private double salary;

	public Employee() {
	};

	public Employee(String name, MyDate birthday, double salary) {
		this.name = name;
		this.birthday = birthday;
		this.salary = salary;
	}

	// 기능 추가

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MyDate getBirthday() {
		return birthday;
	}

	public void setBirthday(MyDate birthday) {
		this.birthday = birthday;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String toString() {
		return "name=" + name + ", birthday=" + birthday;
	}

}
