package day05_tree;

import java.io.*;
import java.util.*;

public class E_과정평가_2_유퀴즈숫자합퀴즈 {

	// 수열의 크기, 수열을 받을 배열, 넘지말아야 할 값, 최댓값(정답) 변수 선언
	static int N;
	static int[] arr;
	static int limit;
	static int max=0; // 최댓값을 저장할 변수.

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 배열의 크기 N 초기화
		N = Integer.parseInt(st.nextToken());
		arr = new int[N];

		// 넘지말아야 할 값 초기화
		limit = Integer.parseInt(st.nextToken());

		// 초기 원소값 배열 생성
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());}
				
		// dfs 호출
		
		dfs(0, 0, 0);
		System.out.println(max);
		

		
	}

	public static void dfs(int n, int sum, int cnt) {
		// [0] 종료조건
		if (n == N) {
			if(cnt==3 && sum<=limit && sum>=max) {
			//  숫자 선택, 합한 값이 ans보다 크고 limit 이하이면, ans 배열에 값 추가
			max =sum;
			}
			return;
		}
		
		// [1] 하부 호출
		dfs(n+1, sum+arr[n], cnt+1);
		dfs(n+1, sum, cnt);

	}

}
