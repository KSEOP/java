package com.edu.domain.test;

import com.edu.domain.NoteBook;

/*
 * Class DataType의 배열을 생성, 초기화...
 * Memory allocation...
 * 
 */
public class ReferenceArrayTest1 {

	public static void main(String[] args) {
		//1. 배열 생성
		NoteBook[] notebooks = new NoteBook[3]; 
		for(NoteBook nb:notebooks)
			System.out.println(nb); // 클래스의 기본값인 null이 나옴
		System.out.println("==================");
		
		notebooks[0] = new NoteBook("HP",170,123);
		notebooks[2] = new NoteBook("LG Gram",130,451);
		for(NoteBook nb:notebooks)
			System.out.println(nb); // 이러면 주솟값이 나옴.
		
		/*
		System.out.println("==================");
		for(NoteBook nb:notebooks) {
			if(nb==null) continue;
			System.out.println(nb.getNoteBookInfo()); // if로 예외처리 하지 않았다면 0과 2에는 참조객체가 있는데 1에 없음. 컴파일은 되는데 실행 중 멈춤.
		}
		*/
		System.out.println("==================");
		for(NoteBook nb:notebooks) {
			if(nb==null) continue;
			//System.out.println(nb.toString()); // 참조변수 뒤에 무조건 .toString()이 생략되어있다. 즉 우리가보는 주소는 문자열이다.
			// nb에 근데 toString()이 없지 않나? ==> 있음. object 라는 추상화 과정을 거친 상속관계 중 최상위 클래스가있음. 그 내부에 toString()이 있음.  
			System.out.println(nb); // notebook에서 toString 메서드 오버라이딩함.
			
			
		}
		
		}
			
		

		
		
		
		
		
	

}
