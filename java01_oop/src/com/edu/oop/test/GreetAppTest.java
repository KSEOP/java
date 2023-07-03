package com.edu.oop.test;
/*
 * ~Test 클래스가 하는 일
 * 1) 변수에 값을 입력
 * 2) 메소드는 호출
 */
import com.edu.oop.Greet;

public class GreetAppTest {

	public static void main(String[] args) {
		Greet g= new Greet();
		//
		// .은 at 의 의미임.
		g.target = "KB IT's Life 4기";
		g.message = "Hello Java~~!!";
		
		//메소드 호출
		//즉 아래의 메소드는 
		g.sayHello();
		

		/*
		 * java 실행과정 ---- JDK를 설치해야지만 원래 가능. (Java Development Kit tool)
		 
		 Greet.java | GreetAppTest.java 이 두개를 만든 상태. (.java 는 "원시소스코드"라고 함.)
		 "원시 소스코드"? -->> 기계가 아닌 인간이 이해하는 코드.
		 기계는 이 원시코드를 이해하지 못함. 기계는 0과 1을 이해함. 즉 원시 소스코드가 0과 1로 구성된 기계어로 바뀌어야함.
		 즉 프로그램은 인간이 쓴 코드를 기계어로 만들어내야함.
		 이를 컴파일화 한다고 함. (컴파일 -> 기계어로 만드는 과정)
		 
		 .java --> compile --> Greet.class | GreetAppTest.class (실행파일) 파일이 만들어짐. but 실행이 되지는 않음.
		 즉 class는 완전한 실행파일::바이너리 코드가 아님. java는 byteCode를 만듬.
		 즉 컴파일 이후의 단계, "실행(runtime)"과정이 또 필요함.
		 
	
		 
		 
		 
		 
		 */
		
		
/*
 * 수업 전문 별도 작성
 - test 클래스는 반드시 test 패키지를 만들고 실행하는 것이 컨벤션
 - 이름은 실행하고자하는 클래스이름에 Test 붙이는 것이 컨벤션
 - 이렇게 실행을 담당하는 클래스가 main 메소드를 가진다.
 - 다시. main 메소드를 가지는 클래스는 반드시 “실행”클래스, 또는 “Test”클래스임. main이 없으면 실행이라는 동작이 없음.
 
 * 사람은 [왼->오]로 읽음. 반면 기계는 [오->왼]으로 읽음. 즉 오른쪽의 "값(Literal Value)"을 왼쪽의 변수에 넣게됨. 이를 할당(=, assign)이라함.
   <<초기화>> 라고도 함. <<초기화>>는 "처음"의 의미가 아니라 <<새로운 값을 넣는 것>>을 <<초기화>>라고 함. 
   즉 위의 행위를 <<변수 초기화(Initialization)>> 이라고 함.
 */
	}

}
