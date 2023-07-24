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
/*
	public Manager(String name, MyDate birthday, double salary,String dept) { // Employee에 있는 필드도 복붙해옴.
		//생성자 안에서 필드 초기화 진행
		super(name, birthday, salary); // 부모 필드 값 주임
//		this.name = name;
//		this.birthday = birthday;
//		this.salary = salary; 이렇게 하면 오류.
		this.dept = dept;	
	}
	*/
	@Override
	public String getDetails(){
		return super.getDetails()+" dept"+dept;
	}

	public Manager(String name, MyDate birthday, double salary, String dept) { // 마지막 자동완성.
		super(name, birthday, salary);
		this.dept = dept;
	}
	
	//자동완성
//	public Manager(String dept) {
//		// 자동완성하면 이렇게 super가 먼저 깔리는데 
//		// 이는 자식이 생성되려면 반드시 부모가 먼저 생성되어야 한다는 것.
//		// 자식 생성자 첫 라인에서 무조건 부모 생성자 호출이 일어남.
//		// (부모 기본 생성자 호출 무조건 생김. 혹은 부모 명시적 생성자호출)
//		super(); // 즉 public Employee() {}; 이걸 안해주면, 여기서 super() 도 오류남.
//		this.dept = dept;}
//	
	
	
	
	
	
	
	
	
	
}
