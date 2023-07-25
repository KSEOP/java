package com.edu.test;

/*
  static 키워드와 가장 많이 함께 쓰이는 키워드는 final
  Usage Modifier
  static final ?
  final static ? -- 둘 다 상관없다.
  
- final + 변수 :: 내가 마지막 변수다 :: 상수값
- final + 메소드 :: 내가 마지막 메소드다 :: 나는 변경할 수 없는 메소드다 == 오버라이딩 금지
  상속에서 부모 메소드를 수정(오버라이드) 못하게 해서 쓰게 만들 때.
- final + 클래스 :: 내가 마지막 클래스다 :: 상속 금지

 */

class A{
	public final static int BASIC_SALARY = 30000;
	public final String test() {
		return "오버라이딩 금지";
	}
	
}

final class B{
	
}

// class C extends B{	} // 상속안됨

class D extends A{
//	public final String test() {
//		
//	}
//}
//BASIC_SALARY = 50000; // 안됨.
}

public class StaticExemTest3 {

	public static void main(String[] args) {
		
	
	}
}
