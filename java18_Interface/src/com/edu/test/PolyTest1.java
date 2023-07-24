package com.edu.test;

/*
 Polymorphism
 ::
 부모 타입으로 다양한 자식 객체를 생성
 1) Object Casting
 2) Virtual Method Invocation
 */


import com.edu.child.Engineer;
import com.edu.child.Manager;
import com.edu.child.Secretary;
import com.edu.parent.Employee;
import com.edu.util.MyDate;

public class PolyTest1 {

	public static void main(String[] args) {
		
		Employee m = new Manager("James", new MyDate(1990,1,1), 40000.0, "IT");
		
		Employee eg = new Engineer("Thomas", new MyDate(1990,1,1), 40000.0, 4000, "Java");

		Employee s = new Secretary("Adams", new MyDate(1990,1,1), 40000.0, "James");

		// 1. James의 부서를 IT 부서에서 마케팅 부서로 변동... changeDept()사용
		// -- 2가지 문제가 발생할 것. 왜 생기는지 아는 것이 중요.
		// Manager m1 = (Manager)m;
		// m1.changeDept("Marketing");
		
		((Manager) m).changeDept("Marketing"); // <- employee 타입에는 없는 메서드니까 안됨. 매니저 타입으로 부르고 찾아야함.
		// 1줄로 작성하는 오브젝트 캐스팅 끝.
		

		// 2. 정보출력
		System.out.println(m); // m.toString(). toString이 생략되어있음. 근데 Employee 타입인데 다 나옴. 왜냐하면
		// -- 오버라이딩한 to String은 부모 자식간에 Link를 만듬 실행 시점에는 자식것이 올라오는 구조를 가짐.
		// -- 컴파일 시점에서는 부모 메소드를 끌어오나, 실행할 때에는 child 메소드를 끄집어 올려서 실행함.
		// -- 컴파일 타입, 런타임 타입에서는 다른 결과. 버추얼 메소드 인보케이션. 즉 여기서 Virtual은 자식 메소드를 의미함.
		
		/*
		 Virtual Method Invocation 원리
		 상속관계의 오버라이딩된 메소드에서
		 부모 타입으로 자식 객체를 생성했을 때 발생하는 원리
		 
		 1. 컴파일 시점 --- 부모의 메소드 호출
		 2. 런타임 시점 --- 자식의 메소드 호출
		 */
		
		System.out.println(eg);
		System.out.println(s);

	}

}
