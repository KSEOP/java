package com.edu.test;

// 추상메소드(구현부가 없고 선언부만으로 이뤄진 메소드)들의 집합.
interface Flyer{
	void fly(); // 인터페이스 안에 있는 이런 형태는 호출 아님. 앞쪽에 public abstract가 생략되어 있는 것.
	void land();
	void takeOff();
}

class Bird implements Flyer {
	// class 는 어떤 객체의 완벽한 설계도임.
	// 그래서 모든 메소드가 "구현이 되어" 있어야함.
	// 구현 안된 메소드가 있어서는 안됨.
	@Override
	public void fly() {
		System.out.println("Bird fly...");
	} 
	public void land() {
		System.out.println("Bird land...");
	}
	public void takeOff() {
		System.out.println("Bird takeOff...");
	}
	
	public String layEggs(){
		return "알을 까다";
	}	
}

class SuperMan implements Flyer{
	@Override
	public void fly() {
		System.out.println("SuperMan fly...");
	} 
	public void land() {
		System.out.println("SuperMan land...");
	}
	public void takeOff() {
		System.out.println("SuperMan takeOff...");
	}
	public String stopBullet(){
		return "망토로 총알을 막는다";
	}	
	
}

public class InterfaceTest1 {

	public static void main(String[] args) {
		// Flyer f = new Flyer(); 추상 메소드가 있는 것은, 객체 생성 대상이 절대 될 수 없다. (=메모리에 못올라간다.) 
		Flyer b = new Bird(); // 인터페이스가 부모일 때, 객체 생성 시 타입으로는 존재가능함. -- 부모 타입으로 Bird를 만들었다. -- PolyMorphism
		Flyer s = new SuperMan();
		
		b.fly();
		s.fly();
		
		System.out.println(((Bird) b).layEggs());
		

	}

}
