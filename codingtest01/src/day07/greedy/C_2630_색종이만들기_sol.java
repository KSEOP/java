package day07.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C_2630_색종이만들기_sol {
	static int[][] arr;
	static int wCnt, bCnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));	//	파일로부터 읽기
		StringTokenizer st = new StringTokenizer(br.readLine());

		//	[0] 입력처리
		int N = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
//		System.out.println(Arrays.deepToString(arr));
		
		//	[1] 주어진 범위에서 흰/파란색 색종이 개수를 증가시키는 함수 호출
		wCnt = bCnt = 0;
		countColor(0, 0, N);
		System.out.println(wCnt);
		System.out.println(bCnt);
	}
	
	public static void countColor(int si, int sj, int N) {
		// [0] 종료조건: N<1
		if (N<1)	return;		
		
		//	[1] 흰색과 파란색 개수를 카운트
		int[] cnts = {0, 0};
		for (int i=si; i<si+N; i++) {
			for (int j=sj; j<sj+N; j++) {
				cnts[arr[i][j]]++;
			}
		}
		
		//	[2] 모두 같은색이면 w/bCnt++, 아니면 4등분
		if (cnts[0]==N*N) {			// 모두 흰색
			wCnt++;
		}else if (cnts[1]==N*N) {	// 모두 파란색
			bCnt++;
		}else {						//	4등분해서 호출
			int m = N/2;
			countColor(si, 	sj, 	m);
			countColor(si+m,sj, 	m);
			countColor(si, 	sj+m, 	m);
			countColor(si+m,sj+m,	m);
		}
	}
}
