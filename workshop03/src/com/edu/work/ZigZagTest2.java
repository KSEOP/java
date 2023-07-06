package com.edu.work;

public class ZigZagTest2 {

	public static void main(String[] args) {
		int [][] intArray = 
			{ 
			  { 1, 2, 3, 4, 5 },
			  { 6, 7, 8, 9,10 },
			  {11,12,13,14,15 },
			  {16,17,18,19,20 },
			} ;
		
		// #2 
		// | ^ | ^
		// | | | |
		// | | | |
		// V | V |
		
		/*
		 * 정수 10진수는 %d를 이용해서 표현한다
		 * %3d... 앞에 2개의 공간이 생긴다. ()()3
		 * %03d... 앞에 2개의 00이 생성된다. 003
		 */
		
		int col = intArray[0].length;
		int row = intArray.length;
		
		for (int i = 0; i < col; i++) {
			if( i % 2 == 0 ) {
				for (int j = 0; j < row; j++) {
					System.out.printf( "%3d", intArray[j][i]); // j 가 row i 가 col
				}
			}else {
				for (int j = row-1; j >= 0; j--) {
					System.out.printf( "%3d", intArray[j][i]);
				}
			}
			System.out.println();
		}	
	}

}
