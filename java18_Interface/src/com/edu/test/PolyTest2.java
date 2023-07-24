package com.edu.test;

import com.edu.child.Engineer;
import com.edu.child.Manager;
import com.edu.child.Secretary;
import com.edu.parent.Employee;
import com.edu.util.MyDate;

public class PolyTest2 {

	public static void main(String[] args) {
		/*
		 * Employee m = new Manager("James", new MyDate(1990,1,1), 40000.0, "IT");
		 * 
		 * Employee eg = new Engineer("Thomas", new MyDate(1990,1,1), 40000.0, 4000,
		 * "Java");
		 * 
		 * Employee s = new Secretary("Adams", new MyDate(1990,1,1), 40000.0, "James");
		 */

		Employee[] emps = { new Manager("James", new MyDate(1990, 1, 1), 40000.0, "IT"),
				new Engineer("Thomas", new MyDate(1990, 1, 1), 35000.0, 4000, "Java"),
				new Secretary("Adams", new MyDate(1990, 1, 1), 30000.0, "James") };
		
		System.out.println("=== 정보를 출력합니다 ===");
		for(Employee e:emps)
			System.out.println(e);
		
		System.out.println("\n=== 정보를 연봉 정보를 출력합니다 ===");
		double annualSalary = 0.0;
		for(Employee e:emps) {
			// System.out.println(e.getSalary()); 이렇게만하면, 엔지니어의 보너스 정보를 포함할 수 없음.
			if(e instanceof Engineer) {
				annualSalary = e.getSalary()*12+((Engineer) e).getBonus();
				System.out.println(e.getName()+"님의 연봉, "+annualSalary);
			}else {
				annualSalary = e.getSalary()*12;
				System.out.println(e.getName()+"님의 연봉, "+annualSalary);

			}
			
			
		}
	}

}
