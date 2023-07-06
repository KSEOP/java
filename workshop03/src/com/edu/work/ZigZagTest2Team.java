package com.edu.work;

public class ZigZagTest2Team {

	public static void main(String[] args) {
		
		int [][] intArray = 
			{ 
			  { 1, 2, 3, 4, 5 },
			  { 6, 7, 8, 9,10 },
			  {11,12,13,14,15 },
			  {16,17,18,19,20 },
			} ;
		
//		// 코드 구현
//		for (int i=0; i<intArray[0].length; i++) {
//			for (int j=0; j<intArray.length; j++) {
//				if(i%2 != 0) {
//					System.out.print(intArray[intArray.length-j-1][i]+" ");
//					continue;
//				}
//				System.out.print(intArray[j][i]+" ");
//			}
//			System.out.println();
//		}
//		/*
//		 * 가장 바깥 부분이 for문 세트가 도는 총 횟수니 출력값이 5줄이므로 바깥에 5를 의미하는 intArray[0]을
//		 * 내부에는 행의 개수를 사용
//		 * 그리고 i%2가 0이라는 의미는 인덱스 0,2,4를 의미하므로 제대로 출력하고
//		 * 0이 아니라면 1,3을 의미하므로 거꾸로 출력한다
//		 * 거꾸로 출력하기 위해서는 전체 길이에서 현재 for문의 로컬변수 j를 빼고 1을 추가로 더 뺀다(인덱스 오류 방지)
//		 * 여기서는 계속 for문을 돌아야 하므로 continue를 사용한다
//		 */
		
		int row = intArray.length;//세로 길이
		int column = intArray[0].length; //가로길이
		
		for(int j = 0; j<column; j++) {
			if(j % 2 != 0) {
				for(int i = row-1; i >= 0; i--) {
				System.out.print(intArray[i][j]+" ");
				}
			}
			else {
				for(int i = 0; i<row; i++) {
				System.out.print(intArray[i][j]+" ");
				}
			}
			System.out.println();
		}
		
	}
}

