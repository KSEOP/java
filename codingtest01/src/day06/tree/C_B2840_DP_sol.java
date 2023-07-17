package day06.tree;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C_B2840_DP_sol {

	public static void main(String[] args) throws IOException {
		//	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));	//	파일로부터 읽기
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//	[0] 입력처리
		int N = Integer.parseInt(st.nextToken());
		
		// [1] 테이블 초기화
		int[] dp = new int[N+5];
		dp[0]=0; dp[1] = dp[2] = dp[4] = N;
		dp[3]= dp[5] = 1;	//	N==3인 경우 배열이 존재하지 않는 영역 접근!
							//	edge TC를 고려해서 문제가 생길수있는 부분 체크!
		
		// [2] 테이블 채우기(점화식) 
		for (int i=6; i<=N; i++) {
			dp[i] = Math.min(dp[i-3],dp[i-5])+1;
		}

		if (dp[N]>=N)	System.out.println("-1");
		else 			System.out.println(dp[N]);
	}
}
