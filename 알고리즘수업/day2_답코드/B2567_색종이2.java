package day02.array;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2567_색종이2 {

	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));	//	파일로부터 읽기
		StringTokenizer st = new StringTokenizer(br.readLine());

		//	si, sj 시작점 입력 개수 N
		int N = Integer.parseInt(st.nextToken());
		//	배열 좌표는 1부터 입력 => 100이라는 좌표가 나올 수 있음
		int[][] arr = new int[102][102];
		//	N번 시작좌표를 입력 받음 (sj, si)
		for (int k=0; k<N; k++) {
			//	한 Line을 읽음 (" "으로 구분된 한 줄)
			st = new StringTokenizer(br.readLine(), " ");
			int sj = Integer.parseInt(st.nextToken());
			int si = Integer.parseInt(st.nextToken());
			
			//	[1] 배열에 표시
			for (int i=si; i<si+10; i++) {
				for (int j=sj; j<sj+10; j++) {
					arr[i][j] = 1;
				}
			}
		}
	
		int ans = 0;
		//			상 하 좌 우
		int[] di = {-1,1,0,0};
		int[] dj = {0,0,-1,1};
		//	[2] 전체순회 1을 찾아서 4방향 0의 개수를 누적
		for (int i=1; i<=100; i++) {
			for (int j=1; j<=100; j++) {
				if (arr[i][j]==1) {
					//	4방향 (0,1,2,3)
					for (int k=0; k<4; k++) {
						//	next i, j 좌표 계산
						int ni = i + di[k];	
						int nj = j + dj[k];	
						
						//	ni, nj가 범위내인지 체크! => 이번에는 생략!
						if (arr[ni][nj]==0) ans++;
						
					}
					
//					//	4방향 상/하/좌/우 0의 개수 카운트(0이면 ans++)
//					//	범위내인지 체크하지 않기 위해 (4방향에 0을 추가)
//					if (arr[i-1][j]==0)	ans++;	//	상
//					if (arr[i+1][j]==0) ans++;	//	하
//					if (arr[i][j-1]==0) ans++;	//	좌
//					if (arr[i][j+1]==0) ans++;	//	우
				}
			}
		}
		
		System.out.println(ans);		

	}

}
