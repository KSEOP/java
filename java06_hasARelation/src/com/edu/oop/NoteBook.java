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
	
	
	

	public String getNoteBookInfo() {
			return(brand+
				   "\t"+price+
				   "\t"+serialNumber);
			
	}


	
}
