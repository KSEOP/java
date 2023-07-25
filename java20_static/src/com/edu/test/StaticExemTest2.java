package com.edu.test;


class Car{
	int serialNumber; // field
	static int counter; // static V
	
	Car(){
		counter++; // Car 객체 하나 만들면 counter는 1이됨.
		serialNumber=counter; // 그러면 serialNumber도 1이되게.
	}
	
	
}

public class StaticExemTest2 {

	public static void main(String[] args) {
		Car car1 = new Car();
		Car car2 = new Car();
		Car car3 = new Car(); // counter, sN은 3이 되어 있을 것.
		
		System.out.println("=====field=====");
		System.out.println(car1.serialNumber);
		System.out.println(car2.serialNumber);
		System.out.println(car3.serialNumber);
		
		System.out.println("/n=====static V=====");
		System.out.println(car1.counter);
		System.out.println(car2.counter);
		System.out.println(car3.counter);
		System.out.println(Car.counter);

	
	}
}
