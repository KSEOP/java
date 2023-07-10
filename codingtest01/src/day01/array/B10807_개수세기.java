package day01.array;

import java.io.IOException;
import java.util.Scanner;

public class B10807_개수세기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		int v = sc.nextInt();
		int cnt=0;
		//	index를 사용해서 접근
//		for (int i=0; i<N; i++) {
//			if (arr[i]==v)	cnt++;
//		}
		
		for (int n: arr) {
			if (n==v) cnt++;
		}
		System.out.println(cnt);

		sc.close();
	}

}
