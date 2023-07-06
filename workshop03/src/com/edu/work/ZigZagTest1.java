package com.edu.work;

public class ZigZagTest1 {

	public static void main(String[] args) {
		int [][] intArray = 
			{ 
			  { 1, 2, 3, 4, 5 },
			  { 6, 7, 8, 9,10 },
			  {11,12,13,14,15 },
			  {16,17,18,19,20 },
			} ;
		
		// #1 
		// ---->
		// <----
		// ---->
		// <----
		int col = intArray[0].length; //5
		int row = intArray.length; //4
			
		for (int i = 0; i < row; i++) {
			if( i % 2 == 0 ) {
				for (int j = 0; j < col; j++) {
					System.out.printf( "%3d", intArray[i][j]);
//					System.out.print( intArray[i][j]);
				}
			}else {
				for (int j = col-1; j >= 0; j--) {
					System.out.printf( "%3d", intArray[i][j]);
				}
			}
			System.out.println();
		}
	}

}

