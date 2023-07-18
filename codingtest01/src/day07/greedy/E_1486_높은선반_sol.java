package day07.greedy;

import java.io.*;
import java.util.*;

public class E_1486_높은선반_sol {

	static int N, B, ans;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// BufferedReader br = new BufferedReader(new InputStreamReader(new
		// FileInputStream("input.txt"))); // 파일로부터 읽기
		StringTokenizer st = new StringTokenizer(br.readLine());

		// [0] 입력처리
		int TC = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= TC; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
//	          System.out.println(Arrays.toString(arr));

			ans = 10000 * N;
			dfs(0, 0);
			System.out.println("#" + tc + " " + ans);
		}
	}

	public static void dfs(int n, int sum) {
		if (n == N) {
			if (sum >= B) {
				ans = Math.min(ans, sum - B);
			}
			return;
		}

		dfs(n + 1, sum + arr[n]); // 선택하는 경우
		dfs(n + 1, sum); // 선택하지 않는 경우
	}

}