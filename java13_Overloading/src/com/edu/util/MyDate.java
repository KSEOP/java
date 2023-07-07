package com.edu.util;

public class MyDate {
	private int year;
	private int month;
	private int day;
	
	public MyDate(int year, int month, int day) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	@Override
	public String toString() {
		// return super.toString();
		return year+"-"+month+"-"+day; // 이건 부모 클래스 내용인데 나에게 필요한 것으로 바꿔버리는 것이 자식 클래스의 활용법.
	}
	
	
	
	
}
