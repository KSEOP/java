package com.edu.domain.test;

import com.edu.domain.Employee;
import com.edu.util.MyDate;

public class EmployeeTest {

	public static void main(String[] args) {
		Employee emp1 = new Employee("James", new MyDate(2000,1,1)); // 인자 2개만 받는 생성자 만들어 놨으니 오류 없음. 그리고 salary는 null이아닌 100.0이 뜸.
		Employee emp2 = new Employee("Thomas", 340000, new MyDate(2000,1,1));
		Employee emp3 = new Employee("Jane", 670000, new MyDate(1980, 11, 12));
		
		// 직원이 여러명이니 배열
		// 선언 생성 초기화 한번에.
		Employee[] emps = {emp1, emp2, emp3};
		for(Employee emp:emps) {
			System.out.println(emp); // ToString() 클래스를 현재의 필요에 맞게 리턴값을 오버라이딩 했으므로 주솟값이 아닌 실제 값이 나옴.
			// emp1의 salary가 기본 상수값으로 채워진 것 확인 가능.
		}
		
		
	}

}
