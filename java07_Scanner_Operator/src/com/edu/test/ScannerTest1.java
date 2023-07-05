package com.edu.test;
/*
  지금까지 우리가 작성한 코드를 보면,
  실제값(literal value)이 컴파일 시점에서 입력되었다.
  원래 값은 실행 시점에서 입력되어야함.
   
  실행시점에서 실제값을 입력하기 위해서는 Scanner를 사용해야한다.
  
  Scanner 생성하는 방법은 과연 어떻게 알 수 있을까?
    스캐너를 생성한다는 것은 스캐너 타입으로만든 다는 것.
  
  Scanner sc = new Scanner(System.in);
  일단 기본적인 생성은 이러함.
  Account acc= newAccount(12,"ㅇㅇ",10000)
  Account는 내가 만들어서 위 처럼 인자를넣을 수 있음
  근데 스캐너는 내가 안만들었음.
  그러면 어떻게 써야할까? = 어떤 타입의 어떤 객체를 생성할 때, 어떻게 그 객체를 생성해야할 지 알려면 무엇을 알아야하는가?
  "생성자"
  . 즉 해당 객체의 생성자 형태를 보고, 어떤 인자를 넣어야하는지 참고해서 짜야함.
	-> 구글 -> java api 8 검색 -> Constructor Summary를 읽을줄 안다.
	검색해보니 System.in이 아닌 InputStream 이라고 되어있는데?
	
	다시. 실행 시 값을 입력 받는 방법.
	1. 키보드로 입력
	2. 파일의 값을 입력
	------------------
	즉, 키보드로 값을 받을때에는 
	1. Scanner sc = new Scanner(System.in); 임.
	
	파일로 받을 때에는
	2. Scanner sc = new Scanner(new File("input.txt")); 인 것.
	------------------
	
	 System은 클래스임. 지금까지 System.out.~ 을 출력하려고 썼었음.
	 즉 "시스템에 있는" 것의 "출력"을 의미함.
	 
	 System.out ---> OutputStream(콘솔)
	 System.in  ---> InputStream(키보드)
	 ::
	 nextInt()
	 - 공백을 기준으로 값을 반환함.
	 - Enter를 치더라도 Enter값을 없애고 해당 라인에 커서가 위치함. 그래서 space를 치더라도 같은 결과가 나옴.
	 - int에 해당하는 정수값을 받아온다.
	 
 */

import java.util.Scanner;

public class ScannerTest1 {
	public static void main(String[] args) {
		// 키보드로 입력되는 값을 받아오는 Scanner 생성
		Scanner sc = new Scanner(System.in);
		// 정수값을 입력 받는 기능.
		System.out.println("값입력 >>>");
		int num1=sc.nextInt();
		int num2=sc.nextInt();
		
		// System.out.println("숫자값 :: num1: "+num1+", num2: "+num2);
		// System.out.printf("%d %d", num1, num2); // d 정수 s 문자 f 실수
		System.out.printf("num1: %d, num2: %d", num1, num2);
	}

}
