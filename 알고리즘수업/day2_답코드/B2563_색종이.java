package day02.array;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2563_색종이 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));	//	파일로부터 읽기
		StringTokenizer st = new StringTokenizer(br.readLine());

		//	si, sj 시작점 입력 개수 N
		int N = Integer.parseInt(st.nextToken());
		//	배열 좌표는 1부터 입력 => 100이라는 좌표가 나올 수 있음
		int[][] arr = new int[101][101];
		//	N번 시작좌표를 입력 받음 (sj, si)
		for (int k=0; k<N; k++) {
			//	한 Line을 읽음 (" "으로 구분된 한 줄)
			st = new StringTokenizer(br.readLine(), " ");
			int sj = Integer.parseInt(st.nextToken());
			int si = Integer.parseInt(st.nextToken());
			
			//	배열에 표시
			for (int i=si; i<si+10; i++) {
				for (int j=sj; j<sj+10; j++) {
					arr[i][j] = 1;
				}
			}
		}
		
		int ans = 0;
		for (int lst[]: arr) {
			for (int n: lst) {
				ans += n;
			}
		}
		System.out.println(ans);		

	}

}
