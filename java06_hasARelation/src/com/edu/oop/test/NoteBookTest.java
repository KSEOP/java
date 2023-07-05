package com.edu.oop.test;

import com.edu.oop.*;

public class NoteBookTest {

	public static void main(String[] args) {
		/* !! 공식처럼 외워라 !!
		 * main 안에서 하는 일.
		 * 1. 객체 생성 == class의 멤버를 메모리에 올린다.
		 *    멤버는 필드의 수 + 메소드의 수. // !! 생성자는 구성요소가 아님 !!, 세터 게터는 구성요소 맞음.
		 *    -- 그 외에는 멤버가 아님.
		 *    즉 Notebook의 멤버는 4개.
		 * 2. 멤버에 접근
		 *     필드  --> 값할당
		 *     메소드 --> 호출
		 *     
		 *     끝. 이 외에 Test에서 하면 안됨.
		 */
		
		NoteBook nb1 = new NoteBook("LG Gram", 170, 12);
		// 객체 생성 시 앞의 NoteBook의 용도: 이 Type으로 만들겠다는 의미.
		// 뒤의 NoteBook은 생성자인데, 필드 초기화::값할당임.
		
		nb1.brand = "HP";
		System.out.println(nb1.getNoteBookInfo());
		
		NoteBook nb2 = new NoteBook(); 
		// 생성자 () 안에 인자값이 없으면 기본 생성자임. 근데 해당 클래스 만들때 인자값이 있는 생성자 만들어서 에러남.
		// =인자값 세개짜리 생성자만 있다, 이런 생성자 없다는 오류문.
		// 즉 Notebook 클래스에서 인자값 없는 생성자(기본생성자)를 만들어놓으면 오류는 사라짐.
		
		
		
		
	}

}
