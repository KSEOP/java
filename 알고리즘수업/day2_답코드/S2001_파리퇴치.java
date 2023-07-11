package day02.array;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S2001_파리퇴치 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));	//	파일로부터 읽기
		StringTokenizer st = new StringTokenizer(br.readLine());
		int TC = Integer.parseInt(st.nextToken());
		
		for (int tc=1; tc<=TC; tc++) {
			//	N, M 입력
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] arr = new int[N][N];
			
			//	arr 입력처리(2차원)
			for (int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j=0; j<N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
//			System.out.println(Arrays.deepToString(arr));
			//	기준이 되는 전체 순회
			int ans = 0;
			for (int si=0; si<=N-M; si++) {
				for (int sj=0; sj<=N-M; sj++) {
					//	si, sj를 기준으로 영역의 합을 구함 => 최대값 찾기
					int cnt = 0;
					for (int i=si; i<si+M; i++) {
						for (int j=sj; j<sj+M; j++) {
							cnt += arr[i][j];
						}
					}
					if (ans<cnt) ans=cnt;
					// ans = Math.max(ans, cnt);
				}
			}
			System.out.println("#"+tc+" "+ans);
		}

	}

}
