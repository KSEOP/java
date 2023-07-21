package day02.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.io.InputStreamReader;

public class B2563_색종이 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		// tc의 수 받음
		int Tc = Integer.parseInt(br.readLine());
		int pLength = 10;

		// 배열 생성
		int[][] arr = new int[100][100];

		// TC만큼 반복 + 도화지 위치 받기 + 배열

		for (int tc = 0; tc < Tc; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int si = Integer.parseInt(st.nextToken());
			int sj = Integer.parseInt(st.nextToken());

			for (int i = si; i < si + pLength; i++) {
				for (int j = sj; j < sj + pLength; j++) {
					arr[i][j] = 1;
				}
			}

		}
		int cnt = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (arr[i][j] == 1)
					cnt++;
				
			}
		}
		System.out.println(cnt);
	}

}
