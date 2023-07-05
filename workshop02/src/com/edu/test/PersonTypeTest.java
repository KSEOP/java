package com.edu.test;

import java.util.Scanner;

/*
 <<입력 Data Sample >>
 6
 1 4 4 4 5 3
 
 */
public class PersonTypeTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		  System.out.println("Sample Data Input >>> ");
		  
		  // 코드 구현
		  
		  int countPerson = sc.nextInt();
		  
		  int arr[] = new int[countPerson];
		  int arrTypeCount[] = {0,0,0,0,0};
		  int answer = 0;
		  
		  for(int i=0; i<countPerson; i++) {
			  System.out.println((i+1)+"번째 사람의 유형을 입력");			  
		  	  arr[i] = sc.nextInt();
		  	  arrTypeCount[arr[i]-1] +=1;
		  }	  
		  
		  int maxNum = 0;
		  
		  for(int i=0; i<arrTypeCount.length; i++) {
			  
			  if(maxNum<arrTypeCount[i]) {
				  maxNum=arrTypeCount[i];
				  answer=i+1;
			  }
			  			  
		  }
		  	  
		  	  
		  	 
		    
		  

System.out.println("가장 많은 타입의 유형은 "+answer+" 타입입니다.!!");
}}
