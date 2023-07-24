package com.edu.test;

import com.edu.child.Engineer;
import com.edu.child.Manager;
import com.edu.child.Secretary;
import com.edu.parent.Employee;
import com.edu.service.EmployeeService;
import com.edu.service.impl.EmployeeServiceImpl;
import com.edu.util.MyDate;

public class PolyTest3 {

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
				new Secretary("Adams", new MyDate(1990, 1, 1), 30000.0, "James"),
				new Engineer("Thomas1", new MyDate(1992, 2, 2), 32000.0, 3000, "Java"),
				new Manager("Jane", new MyDate(1990, 3, 3), 20000.0, "IT")
		};
				
		//Service 객체 생성 == 메모리에 기능을 로딩 시킴
		EmployeeService service = new EmployeeServiceImpl();
		
		System.out.println("\n=====1. 직원 정보를 출력합니다 =====");
		service.printAllEmployee(emps);
		
		System.out.println("\n=====2. 특정 직원을 검색 =====");
		service.findEmployee(emps, "Thomas1");
			
		System.out.println("\n=====3. 동일 부서의 직원을 검색 =====");
		service.findEmployeeByDept(emps, "IT");
		
		System.out.println("\n=====4. 특정 직원의 연봉을 검색 =====");
		service.getAnnualSalary(null);
		
		System.out.println("\n=====5. 직원의 총 인건비를 검색 =====");
		service.getTotalCost(emps);
		//
		
	}

}
