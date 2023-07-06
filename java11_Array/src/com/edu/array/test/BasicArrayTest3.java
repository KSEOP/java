package com.edu.array.test;
/*
 * 배열은 여러개의 값이 들어간 "하나"다. (=객체다)
 * 단, 같은 DataType이어야 한다. 다르면 못 묶는다.
 * 
 * Same Data Type의 서로 다른 값들을 하나루 묶을 수 있는데 이게 바로 Array 라는 객체이다.
 * ::
 * Array는
 * 1) 선언  +  2) 생성  +  3) 초기화, 로 만들 수 있다.
 * 
 */
public class BasicArrayTest3 {

	public static void main(String[] args) {
	
	//1. 선언 + 2.생성 + 3.초기화
		int[] arr = {11,22,33};
		
		//3.
		//  for(int i=0; i<arr.length; i++)
		//  	System.out.println(arr[i]);
		//  강사님도 알고리즘 가르칠땐 위 처럼 for문을 한다.
		//  다만 프로그래밍 할 때에는 X
		//  향상된 인덱스에서는 arr[i]를 다르게 쓰고자한다.
		
		// 뭐가 어디서 돌아가는가?
		for(int num:arr) System.out.println(num);// 이렇게하면 arr의 각 값들이 num으로 바로들어간다.
		
		

	}

}
