package com.edu.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.edu.domain.Person;



public class Manager {
	//싱글톤 1
	private static Manager manager = new Manager(100);
	
	private Map<Integer,Person> map;
	
	//싱글톤 2
	private Manager(int size){
		System.out.println("싱글톤 Pattern...");
		map = new HashMap<>();
	}
	
	//싱글톤 3
	public static Manager getInstance() {
		return manager;
	}
	public void printAllPersonInfo(){
		Set<Integer> set = map.keySet();
		for(int ssn:set) {
			System.out.println(ssn+"PersonInfo :"+map.get(ssn));
		}
		
	}	
	
	public void addPerson(Person person){		
		//추가하려는 사람이 있을떄는 추가되지 않도록 작성
		if(map.containsKey(person.getSsn())) {
			System.out.println(person.getName()+"님은 이미 회원입니다.");
			return;
		}else {
			map.put(person.getSsn(), person);
			System.out.println(person.getName()+"님이 등록됨.");
		}
		
	}
	
	public void deletePerson(int ssn){
		// 삭제 대상이있을때만 삭제되도록
		Person p = map.remove(ssn);
		// ContainsKey()를 사용 안하는 대신에 Person값을 리턴.
		// 만약 ssn이 없으면 Null이 나올 것
		if(p==null) {
			System.out.println("삭제 대상이 없습니다.");
			return;
		}else {
			System.out.println(p.getName()+" 님 삭제됨."); // p안에 제거된, 해당 ssn값을 가진 사람이 반환됨.
			
		}
	}
	public Person findPerson(int ssn){
		return map.get(ssn);
	}//

	public ArrayList<Person> findPerson(String addr){
		
		ArrayList<Person> temp = new ArrayList<>();
		Set<Integer> set = map.keySet();
		for(int key:set) {
			Person p = map.get(key);
			if(p.getAddress().equals(addr)) {
				temp.add(p);
			}
		}
		return temp;
	}
	// map에는 set() 함수가 별도로 존재하지 않고, / key에 해당하는 값을 다시 put하면 overWritting이 됨.
	public void updatePerson(Person p, int ssn){	
		if(map.containsKey(ssn)) {
			map.put(ssn, p);
			System.out.println("UPDATE OK~~!!");
		}else {
			System.out.println("UPDATE FAIL~~!!");
		}
	}
}











