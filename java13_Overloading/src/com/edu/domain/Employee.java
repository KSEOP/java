package com.edu.domain;

import com.edu.util.MyDate;

//직원에 대한 정보를 저장하는 클래스..
/*
 * 접근하는 범위를 지정하는 키워드
 * <<Access Modifier>>
 * private: 같은 클래스 안에서만 접근을 허용함.
 * +
 * protected - 상속과 연결됨. 많이 안쓰이지만 난이도가 조금 있는 코드의 경우 씀.
 * + 
 * public: 어디서든지 접근을 허용함.
 * 
 생성자 OverLoading
 ::
 필수적인 정보로만 객체를 생성
 미처 입력되지 않은 정보는 기본값으로 채울 때 반드시 필요한 기법
 이 때 다른 생성자를 호출하기 위한 this키워드를 사용한다. 
 */
public class Employee {
	// encapsulation을 배웠기에 항상 준수한다.
	private String name;
	private double salary;
	private MyDate birthDate;

	// salary의 기본값지정.. 보통 변하지 않으므로 '상수'로 지정.
	public static final double BASIC_SALARY = 100.0; // 그리고 이 상수는 무조건 대문자로 기입. 비스듬히 눕는 문자는 상수임.

	public Employee() {
	}; // 이것을 명시적 생성자 만들고 나서, 별도로 만들어 두는게 습관화 되어 있는 것을 권고함.
	// 즉 하나의 클래스는 2개 이상의 생성자를 갖도록. 즉 모든 class는 생성자가 "오버로딩" 되어있음.

	public Employee(String name, MyDate birthDate) {
		// salary는 입력을 안한상태로 받은 상황.
		/*
		 * 생성자 앞에 this :: 같은 클래스 내에서 또다른 생성자를 호출할 때 사용하는 키워드임.
		 */
		// this(name, 100.0, birthDate); // 이렇게 해서 salary를 안넣었더라도 null이 아닌 100.0이 들어감.
		this(name, BASIC_SALARY, birthDate);
		// this. 이 경우는 3개짜리 생성자를 찾아가므로 우선 3개의 인자를 모두 받는 생성자가 있는 상태에서 해당형태로 씀.
	}

	public Employee(String name, double salary, MyDate birthDate) {
		super();
		this.name = name;
		this.salary = salary;
		this.birthDate = birthDate;
	}

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	public MyDate getBirthDate() {
		return birthDate;
	}

	@Override
	public String toString() {
		// return super.toString();
		return name + "," + salary + "," + birthDate; // 원래 그냥 객체를 호출하면 주솟값나오는데 이렇게하면 값이 제대로 나옴. (Review 및 이해 필요)
	}

}
