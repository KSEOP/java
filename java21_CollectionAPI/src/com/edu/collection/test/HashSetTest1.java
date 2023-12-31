package com.edu.collection.test;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest1 {

	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		set.add("탁재훈");
		set.add("이수근");
		set.add("김희철");
		set.add("탁재훈");
		set.add("서장훈");		

		System.out.println(set); // 데이터 출력으로 toString 오버라이딩 되어있음. 그냥 출력해도됨.
		
		// 1.set에 저장된 데이터 갯수 출력
		System.out.println(set.size());
		
		// 2.김준호 멤버가 저장되어 있는지 여부
		System.out.println(set.contains("김준호"));
		
		// 3.이수근을 삭제
	
		System.out.println(set.remove("이수근"));
		
		// 4.모든 멤버를 삭제
		set.clear();
		
		// 5.set이 비어져 있는지 확인
		System.out.println(set.isEmpty());
		
	}

}
