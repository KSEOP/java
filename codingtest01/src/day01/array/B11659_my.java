package day01.array;

import java.io.IOException;
import java.util.Scanner;

public class B11659_my {
	public static void main(String[] a) throws IOException {
		
	Scanner sc = new Scanner(System.in);
	
	int N = sc.nextInt();
	int M = sc.nextInt();
	
	int arr[] = new int[N];
	int total = 0;
	
	
	
	for(int i=0; i<N; i++) {
		arr[i]=sc.nextInt();
	}
	
	for(int i=0; i<M; i++) {
		int s=sc.nextInt();
		int f=sc.nextInt();
		
		for(int j=s; j<=f; j++) {
			total+= arr[j-1];
		System.out.println(total);}
		
		total =0;
		
	
	
	
	}


	
	
	
	
	}

}
