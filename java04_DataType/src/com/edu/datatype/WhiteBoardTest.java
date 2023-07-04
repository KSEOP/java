package com.edu.datatype;


class Date{
	// 필드 선언
	int year;
	int month;
	int day;
	// 필드의 선언 다음에는 바로 값주입이 떠올라야함
	public void setDate(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}
	/*
	 * 왜 int만 받아왔는데 String으로 반환하게했나?
	 * String + Non-String ==> String 으로 컨버팅됨.
	 */
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
		//객체생성...new...메모리에 로딩하는 작업임
		WhiteBoard wb = new WhiteBoard();
		
		//1.set~~() 호출...필드값이 채워진다.
		//인자값의 갯수, 순서, 타입이 일치해야한다.
		//실수형은 데이터의 커버리지가 아닌 타입으로 판단하므로, float로 쓰려면 디폴트 d 붙어있는걸 수정해야함.
		Date d = new Date();
		d.setDate(2023, 07, 04);
		wb.setWhiteBoard("동신사", 34000.0F, false, 'L', d);

		//2.get~~() 호출...System.out.println(get~~()호출)
		System.out.println(wb.getWhiteBoard());
	}
}
