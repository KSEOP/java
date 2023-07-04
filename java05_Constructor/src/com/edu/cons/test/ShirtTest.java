package com.edu.cons.test;

import com.edu.cons.Shirt;

public class ShirtTest {

	public static void main(String[] args) {
		/*
		 * 클래스는 객체를 생성하는 Type이됨.
		 * 앞의 Shirt는 Type이고
		 * new 뒤는 '생성자'임. 
		 * Type과 생성자는 그 역할이 완전히 다름.
		 */
		
		/* 다시,
		 * s1이라는 객체 생성시 Shirt 클래스는 Type으로 작동
		 * new Shirt()객체를 생성하면
		 * "Shirt 클래스의 멤버가 메모리에 올라간다" <-- 외워라. 
		 * Shirt 클래스의 멤버는 총 5개. (필드 3개, 메소드 2개). 멤버는 메소드와 필드임.
		 * 
		 * 즉 객체가 생성되는 것과 동시에 값주입을 원하면 생성자를 이용.
		 * 
		 */
		Shirt s1 = new Shirt("Nike",true,'R');//calling..3
		Shirt s2 = new Shirt();
		//set X 인상황. - 호출이 안된 상황... 필드 초기화가 안된 상황. 그러나 Run 하면 null, false가 뜸
		//이말은 즉, field에는 "기본값"이 들어 있다는 것임 (중요)
		System.out.println(s1.getShirt());
		System.out.println(s2.getShirt());
		

		
		
		
		
		
		
	}

}
