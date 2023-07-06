package com.edu.array2.test;
/*
 * 배열의 특징
 * 1. 여러개의 값을 하나로 묶는 객체.. SameDataType이 전제임.
 * 2. 배열은 사이즈를 변경할 수 없다. (새로운 것이 생겨날 뿐.)
 * 3. 사이즈가 다른 배열의 element 값을 copy해 올 수는 있다.
 *    일부분만 카피, 전체 카피 포함해서 가능.
 * 4. 배열은 클래스타입이 존재하지 않는 객체이다.
 * 	  length 라는 필드가 있긴하나 메소드가 없음.
 * 	  CRUD 기능이없어서 다 일일이 짜야함.
 */

class Person {
	String name;
	int age;

}

public class ArrayTest3 {

	public static void main(String[] args) {
		int[] target = { 1, 2, 3, 4, 5, 6 }; // 크기 6 배열
		int[] source = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 }; // 크기 10 배열

		// 사이즈가 다른 배열 source의 내용을 copy해서 target 값 변경
		// 변경된 값을 8,7,6,5,4,3이 되도록 한다.
		// System.arraycopy() 를 써서 한다.
		// arraycopy(Object src, int srcPos, Object dest, int destPos, int length)

		System.arraycopy(source, 2, target, 0, target.length);
		for (int i : target)
			System.out.println(i);
		
		System.out.println("===================");
		Person p = new Person();
		System.out.println(target); 
		
		
		// com.edu.array2.test.Person@626b2d4a  ---  626b2d4a가 가상주소임.
		// 실제 클래스의 Full Name은 com.edu~Person 전체를 포함함.
		// 이게 FQCN(Full Qualified Class Name)임.
		// 그래서 클래스가 아닌 배열 target의 주솟값을 보면 [I@626b2d4a 라고나옴.
		// 클래스가 아니기 때문에 기능이없고, 원시적이므로, java 알고리즘은 이렇게 다루기 까다로운 배열이 나오는 것.

	}//main

}
