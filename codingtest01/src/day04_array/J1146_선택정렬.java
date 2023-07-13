package day04_array;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class J1146_선택정렬 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// BufferedReader br = new BufferedReader(new InputStreamReader(new
		// FileInputStream("input.txt"))); // 파일로부터 읽기
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// i 는 선택한 최솟값을위치시킬인덱스.
		for (int i = 0; i < N - 1; i++) {
			int minI = i;
			// j는 범위에서 최소값 인덱스
			for (int j = i + 1; j < N; j++) {
				if (arr[minI] > arr[j]) {
					minI = j;
				} 
			}
			// minI가 변했으면, 최솟값을 i위치로 교환
		int t = arr[minI];
		arr[minI] = arr[i];
		arr[i] = t;
		}
		StringBuilder ans = new StringBuilder();
		for (int n : arr) {
			ans.append(n + " ");
			System.out.println(ans);
		}
	}

}
