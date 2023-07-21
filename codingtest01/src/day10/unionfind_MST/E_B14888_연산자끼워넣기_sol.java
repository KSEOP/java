package day10.unionfind_MST;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class E_B14888_연산자끼워넣기_sol {
	static int N, add, sub, mul, div, max, min;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		//	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));	//	파일로부터 읽기
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int add = Integer.parseInt(st.nextToken());
		int sub = Integer.parseInt(st.nextToken());
		int mul = Integer.parseInt(st.nextToken());
		int div = Integer.parseInt(st.nextToken());
		
		max = (int)-1e9;
		min = (int)1e9;
		
		dfs(1,arr[0], add, sub, mul, div);
		System.out.println(max);
		System.out.println(min);
	}
	
	public static void dfs(int n, int sum, int add, int sub, int mul, int div) {
		if (n==N) {
			max = Math.max(max, sum);
			min = Math.min(min, sum);
			return;
		}
		
		if (add>0) dfs(n+1, sum+arr[n], add-1, sub, mul, div);
		if (sub>0) dfs(n+1, sum-arr[n], add, sub-1, mul, div);
		if (mul>0) dfs(n+1, sum*arr[n], add, sub, mul-1, div);
		if (div>0) dfs(n+1, sum/arr[n], add, sub, mul, div-1);
	}
}
