package com.edu.oop;
// NoteBook에 대한 정보를 저장하는 클래스
public class NoteBook {
	
	// 필드 선언
	public String brand;
	public int price;
	public int serialNumber;//캐멀표기법 준수
	
	
	// 필드에 값 주입(값 할당) == 전문용어로 필드초기화
	public void setNotebook(String brand, int price, int serialNumber) {//어디에 무얼 주입하는가? -- 필드에 값을.
		
		this.brand = brand;
		this.price = price;
		this.serialNumber = serialNumber;
	}
	// 콘솔창에 3개의 항목을 출력하는 메소드.
		// 그런데 이 상태에서는 Server에서 출력하는 형태가 됨.(정상적인 3티어 구조에서 출력은 Client에서 되어야함) 
		// 왜냐하면 이 클래스는 서버에서 작동하는 구조가 될 것이기 때문임.
		// 메소드는 return type을 가짐
		// return type이 void이면 반환값이 없다는 의미의 return type임.
		// 반환 값을 String 으로 지정
		// 이 메소드가 Test클래스로부터 호출되면, Test클래스로 반환값을 보냄.
	public String getNoteBookInfo() {
			return(brand+
				   "\t"+price+
				   "\t"+serialNumber);
			
	}
}
