package com.edu.condition2.test;

import java.util.Scanner;

/*
 * 간단한 알고리즘을 푸는 테스트 코드 구조
 */
public class CatchAMouseTest {
	
	public static String solv(int x, int y, int z) {
		
		if(Math.abs(x-z) > Math.abs(y-z)) return "CatB Catch!";
		else if(Math.abs(x-z) < Math.abs(y-z)) return "CatA Catch!";
		else return "Mouse Escape";
		
		
		// 코드 구현
		// static을 쓰면 아래에 solv(a,b,c)가 그냥 써진다. 그렇지 않으면 CatchAMouseTest t = CatchAMouseTest(); 객체생성을 해줘야함.
		

		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 순서대로 정수값을 입력받자.
		int cata = sc.nextInt();
		int catb = sc.nextInt();
		int mouse = sc.nextInt();
		
		// 입력받은 값들을 가지고 알고리즘을 해결해야 한다.
		// 메소드 안에서 알고리즘을 해결할 것이다.
				
		
		String result = solv(cata,catb,mouse);
		System.out.printf("Result:: %s",result);
		

	}

}
