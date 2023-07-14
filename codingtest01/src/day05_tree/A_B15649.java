package day05_tree;

import java.io.*;
import java.util.*;

public class A_B15649 {
	
	// 조건들을 잘 살핀다.
	// ** 수열은 사전순으로 증가하는 순서로 출력해야한다
	// 거의 default한 수준인, 오름차순을 요구했기에 큰 변환없이
	// 구현을 성공했음. 그러나 출력되어야 하는 순서가 변할 시
	// 코드는 일부 변화되어야 할 것임.

	static boolean[] v;
	static int[] ans;
	static int M, N, cnt = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 수열의 길이
		M = Integer.parseInt(st.nextToken()); // 자연수 범위

		v = new boolean[N + 1];
		ans = new int[M];

		// 시작

		dfs(0);

	}

	public static void dfs(int n) {
		// [0] 종료 조건
		if (n == M) {
			for (int t : ans) {
				System.out.print(t + " ");
			}
			System.out.println();
			return;
		}

		// [1] 하부단계 호출

		for (int j = 1; j <= N; j++) {
			// 시작이 지금 처럼 1~N까지의 자연수가 아니라 2~N까지였다면
			// int j=2; 가 시작이었을 수도.

			if (v[j])
				continue;

			v[j] = true;
			ans[n] = j;
			dfs(n + 1);
			v[j] = false;

		}

	}

}
