package com.edu;
/*
  Greeting이라는 클래스는 kb life 4기 교육 대상자에게 첫인사를 건네는 기능을 하는 작업으로 이뤄진 클래스
  
  하지만 핵심적인 모든 로직이 main() 메서드안에 다 때려박혀져 있기 때문에 oop적인 프로그래밍이라고 할 수 없다.
  해당 코드를 oop 적으로 다시 바꿔서 작성해보겠다.
  
  뿐만 아니라 아래 코드는 프로그램이라 할 수 없다.
  이유는 실제값이 코드에 바로 입력되어져 있기 때문이다. = 하드코딩 되어져 있다.
 */
public class Greeting {

	public static void main(String[] args) {
		//콘솔창으로 메세지를 출력하는 기능. sysout 입력후 ctrl + space
		System.out.println("kb life 4기 여러분 반갑습니다.");

	}

}