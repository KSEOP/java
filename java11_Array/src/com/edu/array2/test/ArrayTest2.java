package com.edu.array2.test;

public class ArrayTest2 {

	public static void main(String[] args) {
		int [] member = {1,2,3,4,5};
		member = new int[8];
		member[5] = 6;
		member[6] = 7;
		member[7] = 8;
		
		// 0,0,0,0,0,6,7,8 로 나옴. 왜?
		// ** 배열은 Re-size 가 안됨 **
		for(int v:member) System.out.println(v);
		
		
		
	}

}
