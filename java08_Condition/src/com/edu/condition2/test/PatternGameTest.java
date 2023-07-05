package com.edu.condition2.test;

import java.util.Scanner;

public class PatternGameTest {

	public static void solv(int num) {
		// 코드는 여기서 구현...

		if (num / 10 == 3 || num / 10 == 6 || num / 10 == 9) {
			if (num % 10 == 3 || num % 10 == 6 || num % 10 == 9)
				System.out.println("@@");
			else
				System.out.println("@");
		} 
		
		else if (num / 10 != 3 & num / 10 != 6 & num / 10 != 9) {
			if (num % 10 == 3 || num % 10 == 6 || num % 10 == 9) {
				System.out.println("@");
				
				}
			
			else System.out.println(num);
			}
		

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("값 입력 >>");
		int n = sc.nextInt();

		solv(n);

	}

}
