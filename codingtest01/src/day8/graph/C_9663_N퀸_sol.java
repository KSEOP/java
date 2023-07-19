package day8.graph;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C_9663_N퀸_sol {

	static int N, ans;
	static boolean[] v1,v2,v3;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));	//	파일로부터 읽기
		StringTokenizer st = new StringTokenizer(br.readLine());

		//	[0] 입력처리
		N = Integer.parseInt(st.nextToken());

		v1 = new boolean[2*N];
		v2 = new boolean[2*N]; // 여유롭게 설정한 크기.
		v3 = new boolean[2*N];
		ans = 0;
		
		dfs(0);
		System.out.println(ans);
	}
	
	public static void dfs(int n) {
		if (n==N) {
			ans++;
			return;
		}
		
		for (int j=0; j<N; j++) {
			if (!v1[j] && !v2[n+j] && !v3[n-j+N]) {
				v1[j] = v2[n+j] = v3[n-j+N] = true;
				dfs(n+1);
				v1[j] = v2[n+j] = v3[n-j+N] = false;
			}
		}
	}
}







