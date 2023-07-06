package com.edu.work;

public class ZigZagTest1Team {

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
		
		
		//코드 구현
//		for (int i=0; i<intArray.length; i++) {
//			for (int j=0; j<intArray[i].length; j++) {
//				if(i%2 != 0) {
//					System.out.print(intArray[i][intArray[i].length-j-1]+" ");
//					continue;
//				}
//				System.out.print(intArray[i][j]+" ");
//			}
//			System.out.println();
//		}
		
		int row = intArray.length;//세로 길이
		int column = intArray[0].length; //가로길이
		
		
		for(int i = 0; i < row; i++) {
			if(i % 2 != 0) {
				for(int j = column-1; j >= 0; j--) {
					System.out.print(intArray[i][j]+" ");
				}
			}
			else {
				for(int j = 0; j < column; j++) {
					System.out.print(intArray[i][j]+" ");
				}
			}
			
			System.out.println();
		}
		
		
	}

}
