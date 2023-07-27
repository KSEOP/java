package day02.array;

import java.util.*;
import java.io.*;

public class B2567_색종이2번_연습 {
	/*
	 * 
	 * 첫째 줄에 색종이의 수가 주어진다. 이어 둘째 줄부터 한 줄에 하나씩 색종이를 붙인 위치가 주어진다. 색종이의 크기는 10이다. 색종이를
	 * 붙인 위치는 두 개의 자연수로 주어지는데 첫 번째 자연수는 색종이의 왼쪽 변과 도화지의 왼쪽 변 사이의 거리이고, 두 번째 자연수는
	 * 색종이의 아래쪽 변과 도화지의 아래쪽 변 사이의 거리이다. 색종이의 수는 100이하이며, 색종이가 도화지 밖으로 나가는 경우는 없다.
	 * 
	 * 4 3 7 5 2 15 7 13 14
	 */
	static int a, b, cnt1, cnt2;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int[][] arr = new int[102][102];
		int tc = Integer.parseInt(br.readLine());
		

		for (int t = 0; t < tc; t++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			cnt1=0;
			cnt2=0;
			
			for (int i = (100 - a - 10); i < (100 - a); i++) {
				for (int j = b; j < b + 10; j++) {
					arr[i][j] = 1;
				}
			}

			// 둘레 구하기
			// 1. 행 방향 탐색

			for (int i = 1; i < 102; i++) {
				for (int j = 1; j < 102; j++) {
					if (arr[i][j - 1] != arr[i][j]) {
						cnt1++;
					}

				}

			}

			// 2. 열 방향 탐색
			for (int j = 1; j < 102; j++) {
				for (int i = 1; i < 102; i++) {
					if (arr[i - 1][j] != arr[i][j]) {
						cnt2++;
					}
				}
			}
			
		}
		System.out.println(cnt1+cnt2);
	}

}
