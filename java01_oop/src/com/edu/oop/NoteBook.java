package com.edu.oop;
// 노트북에 관련된 정보를 저장하는 클래스
public class NoteBook {
	
	// 필드 선언
	public String brand;
	public int price;
	public int serialNumber;//캐멀표기법 준수
	
	//메소드 정의(선언부+구현부)
	public void printNoteBookInfo() { //메소드 선언부
		System.out.println(brand+
						   "\t"+price+
						   "\t"+serialNumber);
		
	}
	
	/*
	 * 1. member variable == field (브랜드, 가격, sn)
	 * 2. method - 노트북의 정보를 출력하는 기능
	 *    printNoteBookInfo()
	 */
	
	
	/*
	 * 필드 및 메소드 선언 시 소문자 시작.
	 * Class를 구성하는 필드와 메소드명은 "반드시" "소문자"로 시작함.
	 * 단, "Class 이름 첫시작만" "대문자"로 시작함. 이후는 캐멀케이스
	 * "패키지"는 캐멀케이스 아닌 "오직 소문자"임
	 */
	
	/*
	 * String과 System은 대문자로 시작함. 즉 이들은 Class라는 소리임. 그럼 여기서 선언한 NoteBook과 System, String 클래스는 무슨차이인가?
	 * NoteBook이라는 클래스는 내가 작성한 클래스임. User Definition Class 라고 업계에서 말함.
	 * String과 System은 타 개발자가 만들어서 제공 하는데 "실행 파일"로 제공이됨. -> JDK 안에 빌트인 되어있음.
	 * 이런 클래스들이 여러개 묶여서 <<라이브러리>>, API 라고함. 이런 경우엔 단일 클래스 하나도 라이브러리, API임.
	 * 라이브러리 = "실행파일"들의 묶음.
	 * 이런 라이브러리 들이 또한 묶여서 모델을 이루면 "프레임워크"가 됨.
	 * 결론: User Definition Class와 API Class 두개를 만나게 된다.
	 * 그러면 이제 자바실행환경-JRE는 라이브러리임을 이해해야함.
	 * 
	 * ---
	 * 자바 실행을 위해서는 OS에 종속된 JDK를 반드시 설치해야함. (설치하면 이것이 JVM 환경이되는것)
	 * JDK 내에는 java를 이용해서 프로그래밍 할 수 있도록 매우 많은 라이브러리들이 있음.
	 * 이 라이브러리들이 모여있는 JRE는 어마어마하게 많은 API 그 자체를 의미함.
	 * 그 내부에서 컴파일된 class파일이 JVM에서 실행됨. 
	 * 
	 * 
	 */
}
