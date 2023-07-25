package com.edu.collection.test;

import java.util.*;
/*
 ArrayList
 ::
 순서가 있고,
 중복이 허용된다.
 */


public class ArrayListTest1 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("신동엽");
		list.add("이수근");
		list.add("강호동");
		list.add("신동엽");
		list.add("탁재훈");
		
		System.out.println(list);
		//1. 세번째 강호동 삭제... 강호동 삭제 되었다는 메세지 함께 추가
		String delName=list.remove(2);
		System.out.println(delName+"님 삭제됨");
		//2. 2번째 데이터를 아이유로 수정
		list.set(1, "아이유");
		//3. 탁재훈 앞에 김준호를 추가.
		list.add(3,"김준호");
		System.out.println(list);
		//4. 4번쩨 데이터를 받아서 출력
		System.out.println(list.get(3));
		//5. 모든 데이터 삭제
		list.clear();
		System.out.println(list.isEmpty());
	}

}
