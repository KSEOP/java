package day05_tree;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D_B2961_만든음식_sol {
	
	static int N, S;
	static int[][] arr;
	static int ans;
	
	public static void main(String[] args) throws IOException {
		//	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));	//	파일로부터 읽기
		StringTokenizer st = new StringTokenizer(br.readLine());

		//	입력 처리
		N = Integer.parseInt(st.nextToken());
		arr = new int[N][2];

		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		ans = (int)(1e9);	//	무조건 갱신될 수 있는 최악의 값으로 초기화
		
		//	main함수에서는 가장 상위 dfs만 호출
		dfs(0, 1, 0);
		System.out.println(ans);		
	}
	
	public static void dfs(int n, int s, int b) {
		//	[0] 종료조건: 정답처리
		if (n==N) {
			// 재료 하나이상이고 맛의차이가 최소면 갱신
			if (b>0 && ans > Math.abs(s-b)) {
				ans = Math.abs(s-b);
			}
			return;
		}
		
		//	[1] 하부 호출
		dfs(n+1, s*arr[n][0], b+arr[n][1]);	// 선택하는 경우
		dfs(n+1, s, b);					    // 선택하지 않는 경우
	}

}


