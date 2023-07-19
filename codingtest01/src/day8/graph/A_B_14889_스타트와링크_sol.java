package day8.graph;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class A_B_14889_스타트와링크_sol {

	static int N, ans;
	static int[][] arr;
	static int[] alst, blst;

	public static void main(String[] args) throws IOException {
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt"))); // 파일로부터 읽기
		StringTokenizer st = new StringTokenizer(br.readLine());

		// [0] 입력처리
		N = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		alst = new int[N];
		blst = new int[N];
//			System.out.println(Arrays.deepToString(arr));

		ans = 100 * N;
		dfs(0, 0, 0);
		System.out.println(ans);
	}

	public static void dfs(int n, int aCnt, int bCnt) {
		// 가지치기는 제일 위에! 가장 마지막순서로!
//			if (aCnt>N/2 || bCnt>N/2)	return;

		// 종료조건(두 팀의 인원수가 동일할 때 시너지 차이 최소값 갱신)
		if (n == N) {
			if (aCnt == bCnt) {
				int aSum = 0, bSum = 0;
				for (int i = 0; i < aCnt - 1; i++) {
					for (int j = i + 1; j < aCnt; j++) {
						aSum += (arr[alst[i]][alst[j]] + arr[alst[j]][alst[i]]);
						bSum += (arr[blst[i]][blst[j]] + arr[blst[j]][blst[i]]);
					}
				}
//					for (int i=0; i<aCnt; i++) {
//						for (int j=0; j<aCnt; j++) {
//							aSum += arr[alst[i]][alst[j]];
//							bSum += arr[blst[i]][blst[j]];
//						}
//					}
				ans = Math.min(ans, Math.abs(aSum - bSum));
			}
			return;
		}

		alst[aCnt] = n;
		dfs(n + 1, aCnt + 1, bCnt); // 0팀을 선택하는 경우
		blst[bCnt] = n;
		dfs(n + 1, aCnt, bCnt + 1); // 1팀을 선택하는 경우

	}

}
