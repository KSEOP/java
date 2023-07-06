package com.edu.hw;

import java.util.Arrays;
import java.util.Scanner;

public class FlattenBoxTest1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = 10;
		int boxLen = 100;
		for(int tcn = 1; tcn<=tc; tcn++) {
			int dump = sc.nextInt();
			int[ ] boxes = new int[boxLen]; // 100개짜리 배열
			for(int i=0; i<boxes.length; i++) {
				boxes[i] = sc.nextInt();
			}//초기화 완료...
			
			int heighDiff=flatten(boxes,dump ); //boxes 배열, dump 제한 수가 들어감.
			System.out.printf("#%d %d%n",tcn, heighDiff);
		}

	}

	static int flatten(int[] boxes, int dump) {
		// 코드 구현
		
		for(int i = 0; i<dump; i++) {
			Arrays.sort(boxes);
			boxes[99]-=1;
			boxes[0]+=1;
						
		}	
		Arrays.sort(boxes);
		int result = boxes[99] - boxes[0];
			
		return result;
		
	
	}

}












