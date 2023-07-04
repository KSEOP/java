package com.edu.cons.test;


class Date{
	int year;
	int month;
	int day;
	
	public Date(int year, int month, int day) {
		// 필드 초기화... 주입의 통로를 생성자로 결정
		this.year = year;
		this.month = month;
		this.day = day;
	}

	public String getDate() {
		return year+"-"+month+"-"+day;
	}
	
}

class WhiteBoard{
	//1. 필드선언
	String madeCompany;
	float price;
	boolean scratch;
	char size;
	//추가...제조일자
	Date madeDate;
	
	
	
	//2. 필드 주입(set) 기능 정의(void | 인자값) - 인자 값이 있다 - 때려 넣겠다(반환하는 애가 아니다)
	public void setWhiteBoard(String madeCompany,
	                          float price,
	                          boolean scratch,
	                          char size,
	                          Date madeDate) {
		//필드초기화
		this.madeCompany = madeCompany;
		this.price = price;
		this.scratch = scratch;
		this.size = size;
		this.madeDate = madeDate;
	}
	
	//3. 주입된 필드값을 반환(??? / 인자값x) - 받아오겠다. (주입된 값 받아오는 get 기능)
	public String getWhiteBoard() {
		return madeCompany+","
	           +price+","+
				scratch+','+
				size+","+
				madeDate.getDate();
	}
}



public class WhiteBoardTest {

	public static void main(String[] args) {
		// 객체생성...new...메모리에 로딩하는 작업임
		WhiteBoard wb = new WhiteBoard();
		
		// 아래처럼 쓰는 것이 개발자다운 코딩임.
		wb.setWhiteBoard("동신사", 34000.0F, false, 'L', new Date(2023,07,04));

		//2.get~~() 호출...System.out.println(get~~()호출)
		System.out.println(wb.getWhiteBoard());
	}
}
