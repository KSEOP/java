package com.edu.array.test;
/*
 * 배열은 여러개의 값이 들어간 "하나"다. (=객체다)
 * 단, 같은 DataType이어야 한다. 다르면 못 묶는다.
 * 
 * Same Data Type의 서로 다른 값들을 하나루 묶을 수 있는데 이게 바로 Array 라는 객체이다.
 * ::
 * Array는
 * 1) 선언   2) 생성   3) 초기화, 로 만들 수 있다.
 * 
 */
public class BasicArrayTest3 {

	public static void main(String[] args) {
	
	//1. 선언 + 2.생성 + 3.초기화
		int[] arr = {11,22,33};
		
		//3.
		for(int i=0; i<arr.length; i++)
			System.out.println(arr[i]);
		
		

	}

}
