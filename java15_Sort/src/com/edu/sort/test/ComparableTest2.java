package com.edu.sort.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

class Person implements Comparable<Person>{
	int age;
	String name;
	public Person(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + "]";
	}
	
	/*
	 * int 리턴타입의 의미
	 * ::
	 * 나이가 작으면 -1
	 * 나이가 더 많으면 1
	 * 같으면 0을 리턴
	 */
	@Override
	public int compareTo(Person per) {
		if(age<per.age) return -1;
		else if(age>per.age) return 1;
		else return 0;
	}
	
	
}
public class ComparableTest2 {
	public static void main(String[] args) {
		ArrayList<Person> plist = new ArrayList<>(); // 뒤의 어레이 리스트 <> 안에 Person 써도됨.		
		plist.add(new Person(68,"이순재"));
		plist.add(new Person(23,"제니"));
		plist.add(new Person(53,"엄정화"));
		
		// 이렇게는 못씀. Arrays.sort(plist);
		Collections.sort(plist);
		System.out.println(plist); // 내림차순 정렬하려면 compareTo 메서드의 리턴 1, -1 순서를 바꾸면 됨.
		
	}

}
