package day05_tree;

import java.io.*;
import java.util.*;

public class E_과정평가_1_선택정렬 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());

		// 배열의 크기 N 받기.
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		// 초기 원소값 배열 생성
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		// 투 포인터 탐색

		for (int i = 0; i < N - 1; i++) {
			// i는 선택한 최댓값을 위치시킬 인덱스
			int maxI = i;
			// j는 범위에서 최댓값 인덱스
			for (int j = i + 1; j < N; j++) {
				if (arr[maxI] < arr[j]) {
					maxI = j;
				}
			}
			// maxI 값을 j로 변경, 최대값을 i 위치로 교환

			// 최댓값을 임시 저장
			int temp = arr[maxI];
			// 최댓값을 발견한 j 인덱스에, 이전까지 최댓값이었던 i 인덱스 값으로 초기화
			arr[maxI] = arr[i];
			// 임시 저장한 최댓값을 i인덱스에 초기화
			arr[i] = temp;

		}
		StringBuilder ans = new StringBuilder();
		for (int n : arr) {
			ans.append(n + "\n");}
		System.out.println(ans);
	}

}
