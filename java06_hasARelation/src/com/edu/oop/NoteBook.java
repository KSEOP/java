package com.edu.oop;
// NoteBook에 대한 정보를 저장하는 클래스
public class NoteBook {
	
	// 필드 선언
	public String brand;
	public int price;
	public int serialNumber;
	
	// 필드에 값 주입(값 할당) == 전문용어로 필드초기화.
	// set 할당할 것인가, 생성자 할당할 것인가 결정. 이 경우엔 생성자로 할당함. 왜냐? 노트북 생산될떄 다 정해지니까
	public NoteBook(String brand, int price, int serialNumber) {
		this.brand = brand;
		this.price = price;
		this.serialNumber = serialNumber;
	}
	
	public NoteBook() {}
	/*
	 * 생성자가 2개인 상황.
	 * 이 경우를 "생성자 오버로딩" 이라고함.
	 * 하나의 클래스에서는 반드시 "하나 이상"의 생성자가 존재함.
	 *  -> 명시적 생성자(인자를 구체적으로 입력해놓은)가 정의되어져 있지 않을 때, 컴파일러가 무조건 기본 생성자를 넣어준다.
	 *  그런데 만약에,
	 *  "명시적 생성자가 하나라도 정의되어져 있으면"
	 *  "컴파일러가 기본 생성자를 넣어주지 않음." 그래서 필요 시 추가 해주어야함.
	 *  
	 */
	

	public String getNoteBookInfo() {
			return(brand+
				   "\t"+price+
				   "\t"+serialNumber);
			
	}


	
}
