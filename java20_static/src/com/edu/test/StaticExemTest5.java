package com.edu.test;
/*
 Singletone Pattern
 ::
 클래스로부터 오직 단 하나의 객체만 생성하도록 하는 디자인 패턴
 ::
 <Syntax>
 1. 일단 클래스 안에서 객체 하나는 먼저 생성
 	- static private으로 객체 생성
 
 2. 다른 클래스에서는 객체 생성 못하도록 막아둔다.
  	private 생성자 (생성자 앞에 private 붙이면 다른 곳에서 못만듬)
  	
 3. 하나 생성한 객체를 여기저기서 갖다 쓰도록 public 한 기능으로 리턴 받아둔다.
 	public Instance getInstance()
 	이때 반드시 static 한 성질의 메소드로 만들어둔다.
 	public static ServiceImpl getInstance();
 */

class ServiceImpl{
	static private ServiceImpl service = new ServiceImpl(); // 1 수행
	private ServiceImpl(){ // 2 수행.
		System.out.println("Singletone Pattern Ready...");		
	}
	
	public static ServiceImpl getInstance() { // 3 수행.
		return service;
	}
}
public class StaticExemTest5 {
	public static void main(String[] args) {
		// ServiceImpl ss = new ServiceImpl(); // 3에서 static 하지 않으면 외부에서 이렇게 생성이 안됨.
		ServiceImpl service1=ServiceImpl.getInstance();
		ServiceImpl service2=ServiceImpl.getInstance();
		ServiceImpl service3=ServiceImpl.getInstance();
		
		System.out.println(service1);
		System.out.println(service2);
		System.out.println(service3);
		// 동일한 주솟값을 갖고 있음.
	}//main
}
