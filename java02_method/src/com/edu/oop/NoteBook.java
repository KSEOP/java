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
	// 필드에 값할당하는 기능을 추가 == 주입(set~~)
	public void setNotebook(String brand, int price, int serialNumber) {//어디에 무얼 주입하는가? -- 필드에 값을.
		//필드(좌) 로컬변수(우)를 구분하기 위해서 this 키워드를 필드앞에 붙여준다.
		this.brand = brand;
		this.price = price;
		this.serialNumber = serialNumber;
	}

}
