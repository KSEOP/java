package com.edu.loop.test;

public class BasicLoopTest1 {

	public static void main(String[] args) {
		System.out.println("======for======");
		for(int i=0; i<10; i++)
			System.out.println("i : "+i);
		
		// 여기서 위의 i는 반복문이 시작될 때 생기고, 브레이스가 닫힐때 사라지므로 이를 Temporary Value 라고함.
		// Automatically 변수라고도 함.
		// 같은 문장을 while로.
		// 그래서 아래의 i와 충돌하지 않음.
		
		int i=10;
		while(i>0) {
			System.out.println("i: "+i);
			i--;
			
		
		//for는 횟수가 정해져있는 뉘앙스, while은 횟수를 모르는 상황 특성이 더 강하다.
			
		}

		
		
	}

}
