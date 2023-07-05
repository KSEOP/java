package com.edu.condition.test;
/*
 * field | local V(변수)의 구분은?
 * 변수가 선언된 위치에 따라 달라진다.
 * 
 * field - 클래스 바로 아래
 *         메소드 블락 바깥
 *         * 기본 값을 가진다
 *         -->> 초기화 안하고 사용해도 에러가 안남
 *         
 * local - 메소드 블락 안쪽
 *         * 기본 값이 없다.
 *         -->> 초기화를 반드시 해야한다. 안하면 에러남.

 */

import java.util.Scanner;
/*
 * Scanner를 사용해서 성적과 함께 과목명을 입력
 * Java, A Grade... 처럼 나오도록 수정.
 */


public class GradeIfTest2 {

	public static void main(String[] args) {
		// int grade = 88; // local V 
		Scanner sc = new Scanner(System.in);
		System.out.println("과목입력");
		String subject=sc.next();
		System.out.println("성적입력>>");
		int grade = sc.nextInt();
		
		if(grade<=100 & grade>80)
			System.out.println(subject + " A Grade...");
		else if(grade<=80 & grade>70)
			System.out.println(subject + " B Grade");
		else if(grade<=70 & grade>60)
			System.out.println(subject + " C Grade");
		else
			System.out.println("Try Again");
		
		
	}

}
