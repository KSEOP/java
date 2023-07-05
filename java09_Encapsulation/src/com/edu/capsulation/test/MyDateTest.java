package com.edu.capsulation.test;

import java.util.Scanner;

import com.edu.capsulation.*;
/*
 *  1. Scanner 사용해서 month, day값 받아온다
 *  2. 마지막 출력 결과에 절대로 0월 13일입니다, 7월 0일 입니다. 0월 0일입니다.가 안뜨도록 해야함.
 */


public class MyDateTest {

	public static void main(String[] args) {
		//1. 클래스의 멤버 메모리에 올리기
		//2. 필드 접근 호출
		
		MyDate md = new MyDate(); // calling
		// md.month = 33;
		// md.day = 33;
		// month와 day에 33은 invalid한 값이다.
		// ### 다른 Class(~~Test)에서 field에 직접적으로 접근을 못하게 해야 함.
        //**Invalid한 값이 필드에 저장되지 못하게 막아야 하기 때문임**
		// The field MyDate.month is not visible <- 있는데 볼수없다는 것.
			
		//md.setMonth(33);
		// 필드가 33으로 초기화 되기 직전, 제어문을 달 수 있음.
		//md.setDay(13);
		
		// 내가쓴 것.
		System.out.println("월 입력");
		Scanner sc1 = new Scanner(System.in);
		int month = sc1.nextInt();
		md.setMonth(month);
		
		System.out.println("날짜 입력");
		Scanner sc2 = new Scanner(System.in);
		int day = sc2.nextInt();
		md.setDay(day);
		
		// 여기서 if(md.getMonth()!=0 & md.getDay()!=0) 추가할 수도 있음. 
		
		
		System.out.println("오늘은 "+md.getMonth()+"월 "+md.getDay()+"일 입니다.");
	
		
	
	
	
	
	
	
	}

}
