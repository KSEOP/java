package day05_tree;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A_B15649_N과M_sol {
	static int N, M;
	static int[] arr;
	static boolean[] v;
	static StringBuilder ans = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));	//	파일로부터 읽기
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		//	입력 처리
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];
		v = new boolean[N+1];
		
		//	main함수에서는 가장 상위 dfs만 호출
		dfs(0);
		System.out.println(ans);		
	}
	
	public static void dfs(int n) {
		//	[0] 종료조건: 정답처리
		if (n==M) {
			for (int t: arr) ans.append(t).append(" ");
			ans.append("\n");
			return;
		}
		
		//	[1] 하부 호출 (1~N)
		for (int j=1; j<=N; j++) {
			if (v[j]) continue;	//	이미 사용했다면 다음숫자로...
			// j숫자를 선택하는 상황 (v, arr 표시)
			v[j]=true;
			arr[n]=j;
			dfs(n+1);
			v[j]=false;			// 	반드시, 원래대로..!			
		}		
	}

}
