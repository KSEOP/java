package day05_tree;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_조합_다른접근_B15650 {

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

			
			//	main함수에서는 가장 상위 dfs만 호출
			dfs(0, 1);
			System.out.println(ans);		
		}
		
		public static void dfs(int n, int s) {
			//	[0] 종료조건: 정답처리
			if (n==M) {
				for (int t: arr) ans.append(t).append(" ");
				ans.append("\n");
				return;
			}
			
			//	[1] 하부 호출 (1~N)
			for (int j=s; j<=N; j++) {
				arr[n] = j;     // 선택한 숫자 저장,(출력을 위해서)
				dfs(n+1, j+1);  // 다음 숫자 선택
				
				
			}		
		}

	}
