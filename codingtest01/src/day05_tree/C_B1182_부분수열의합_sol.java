package day05_tree;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C_B1182_부분수열의합_sol {
	static int N, S;
	static int[] arr;
	static int ans;

	public static void main(String[] args) throws IOException {
		//	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));	//	파일로부터 읽기
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		//	입력 처리
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());

		arr = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i=0; i<N; i++) arr[i]=Integer.parseInt(st.nextToken());
		ans = 0;
		
		//	main함수에서는 가장 상위 dfs만 호출
		dfs(0, 0, 0);
		System.out.println(ans);		
	}
	
	public static void dfs(int n, int cnt, int sum) {
		//	[0] 종료조건: 정답처리
		if (n==N) {
			//	하나이상의 숫자선택, 합이 S면
			if (cnt>0 && sum==S) ans++;
			return;
		}
		
		//	[1] 하부 호출
		dfs(n+1, cnt+1, sum+arr[n]);	// 선택하는 경우
		dfs(n+1, cnt, sum);				// 선택하지 않는 경우
	}

}
