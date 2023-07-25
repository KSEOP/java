package com.edu.test;


class StaticExam{
	static String name = "James"; // static V
	static int age = 44; // static V
	int count = 1; // field
	
	public static void getMember() {
		System.out.println("우/유/빛/깔 "+name);
	}
	
	public void getMember2() {
		// static String address = "역삼동" // 오류 발생. 4. static한 멤버는 로컬 레벨에서 쓸 수 없음.
		System.out.println("우/유/빛/깔 "+name);
	}
	
	
}

public class StaticExemTest1 {

	public static void main(String[] args) {
		// 객체 생성과정 없이 바로 사용 가능.
		StaticExam.getMember();
		
		StaticExam se = new StaticExam();
		// StaticExam.getMember2(); // 얘만 단독으로 기입하면, static 인 곳에서 쓸수 없다고 함. - 스태틱은 스태틱 끼리 가능
		se.getMember2();

	}
}
