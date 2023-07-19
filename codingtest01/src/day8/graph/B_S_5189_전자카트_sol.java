package day8.graph;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_S_5189_전자카트_sol {

	static int N, ans;
	static int[][] arr;
	static boolean[] v;
	public static void main(String[] args) throws IOException {
		//	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));	//	파일로부터 읽기
		StringTokenizer st = new StringTokenizer(br.readLine());

		//	[0] 입력처리
		int TC = Integer.parseInt(st.nextToken());
		for (int tc=1; tc<=TC; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			arr = new int[N+1][N+1];
			for (int i=1;i<=N;i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=1; j<=N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

//			System.out.println(Arrays.deepToString(arr));
			v = new boolean[N+1];
			ans = 100*N;
			// 방문구역 1개, 비용 0, 기준구역 1번
			dfs(1, 0, 1);
			System.out.println("#"+tc+" "+ans);
		}
	}
	
	public static void dfs(int n, int sum, int cur) {
		if (n==N) {
			ans = Math.min(ans, sum+arr[cur][1]);
			return;
		}
		
		for(int j=2; j<=N; j++) {
			if(v[j]) continue;
			v[j]=true;
			// 현재(cur)구역에서 j구역으로 가는 경우
			dfs(n+1, sum+arr[cur][j], j);
			v[j]=false;
		}
	}
}







