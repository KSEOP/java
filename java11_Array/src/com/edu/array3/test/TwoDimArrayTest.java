package com.edu.array3.test;

public class TwoDimArrayTest {

	public static void main(String[] args) {
		// 2행 3열의 2차원 배열.
		int [][] twoArr = new int[2][3];
		
		System.out.println(twoArr.length); //2가 나옴. (row) 
		System.out.println(twoArr[0].length);//3이 나옴. (col)
		System.out.println(twoArr[1].length); //3이 나옴 (col)
		
		for(int i=0; i<twoArr.length; i++) {
			for(int j=0; j<twoArr[i].length; j++) {
				System.out.println(twoArr[i][j]+" ");
			}
		System.out.println("");
		}
		
		System.out.println("=================");
		int[][] twoArr2 = new int[2][]; // "각 행"의 열의 개수는 나중에 정하겠다는 뜻.
		//System.out.println(twoArr2[0].length); 행이 없어서 null 오류뜸
		twoArr2[0] = new int[3];
		twoArr2[1] = new int[6]; // 이렇게하면 열이 3개, 6개 각각 생성이 되는 것임.
		System.out.println(twoArr2[0].length);
		System.out.println(twoArr2[1].length);
	}

}
