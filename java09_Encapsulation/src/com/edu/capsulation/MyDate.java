package com.edu.capsulation;

/*
 * 오늘 날짜를 저장하는 클래스..
 * valid한 값만 month, day에 할당 되도록 제어문을 사용하라.
 * month는 1~12사이의 값만 필드초기화.. / "Invalid Month"
 * day는? 월에 따라 달라짐.
 * 1,3,5,7,8,10,12월일 때 1~31일
 * 4,6,9,11월일 때 1~30일
 * 2월 일때. 1~28일
 * 
 * 
 * Encapsulation 작성 Pattern
 * 1.field -- private
 * 2.method(setter/getter) 앞 -- public
 * 3.setter메소드 필드초기화 하기 직전에
 *   타당한 값만 필드에 저장되도록 문장을 제어한다.
 * 
 */
public class MyDate {
	// private: 같은 클래스에서만 접근을 허용
	private int month;
	private int day;

	// public MyDate() {} <- 이게 있는 상태임.

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		// 이 위치에 제어문 적용 가능.

		if (month < 12 & month != 0)
			this.month = month;
		
		else {
			System.out.println("invalid month");
			System.exit(0); // 이 안에 숫자에는 다 들어갈 수 있는데 상징적인 숫자가들어감
		}			// 0은 정상 종료임.(break의 기능을함)

	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {

		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			if (day < 32 & day != 0) {
				this.day = day;	
			}else {System.out.println("Invalid day");
			System.exit(0);	
				break;		
				
			}
		case 4:
		case 6:
		case 9:
		case 11:
			if (day > 31 & day != 0) {
				this.day = day;
				break;
			}
		case 2:
			if (day >28 & day !=0) {
				this.day=day;
				break;
			}
		default:
			System.exit(0);
			System.out.println("Invalid Day");
	}
}}
