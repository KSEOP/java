package com.edu.child;
//Child Class...

/*
 
 Employee
     |
 Manager
 상속관계 시 중요한 지점
 
 1. 자식 객체 생성 시 무조건 부모 객체를 먼저 생성한다.
 2. 부모에게서 물려받는 필드에 값 주입은 super()-슈퍼 생성자, 혹은 super.setXxx() 사용 -- 중요
 3. 부모에게서 물려받은 메소드는 자식클래스에서 구현부를 자식에게 맡게 고쳐쓴다.
 	(메소드 오버라이딩)
 	선언부는 모두 일치 해야함.
 	구현부는 반드시 조금이라도 다르게 구현해야함. 
 	
 	상속 개념 끝.
 
 */

import com.edu.parent.Employee;
import com.edu.util.MyDate;

public class Manager extends Employee {

	private String dept;

	@Override
	public String toString() {
		return super.toString() + " dept: " + dept;
	}

	public Manager(String name, MyDate birthday, double salary, String dept) { // 마지막 자동완성.
		super(name, birthday, salary);
		this.dept = dept;
	}

	public void changeDept(String dept) {
		this.dept = dept;
	}

	public String getDept() {
		return dept;
	}

}
