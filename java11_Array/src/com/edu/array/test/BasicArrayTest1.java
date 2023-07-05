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
public class BasicArrayTest1 {

	public static void main(String[] args) {
	
	//1. 선언
		int[ ] arr; // dataType + 변수명;
	//2. 생성 (이때, size를 반드시 명시해야함. 배열은 객체이기 때문에 new라는 키워드로 생성한다.)
		arr = new int[3];
		
		// stack에 arr이라는 공간이 만들어짐. heap에는 3칸짜리 객체 배열이 만들어짐. 그리고 "기본값"으로 만들어짐.- 묵시적초기화.
		// 그리고 초기화가 일어나면 "주솟값"이 생김.
		// 이제 stack의 ?에 heap의 주솟값이 배정됨.
		
		//배열의 값들을 모두 출력하고 싶으면?
		
	//3. 초기화.
		arr[0]=11; arr[1]=22; arr[2]=33;
		
		for(int i=0; i<3; i++)
			System.out.println(arr[i]);
		
		
		

	}

}
