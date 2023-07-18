package day07.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_1920_수찾기_sol {

	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// BufferedReader br = new BufferedReader(new InputStreamReader(new
		// FileInputStream("input.txt"))); // 파일로부터 읽기
		StringTokenizer st = new StringTokenizer(br.readLine());

		// [0] 입력처리
		int N = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 이진탐색의 기본조건 => 오름차순 정렬
		Arrays.sort(arr);

		StringBuilder ans = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken()); // 나는 배열만들었는데 그냥 이렇게 받는게 효율적일듯.
		
		
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			// 찾을 데이터를 한 개씩 입력
			int d = Integer.parseInt(st.nextToken());
			int t = bs(0, N - 1, d);
			ans.append(t + "\n");
		}
		System.out.println(ans);
	}

	public static int bs(int s, int e, int d) {
		while (s <= e) {
			int m = (s + e) / 2; // 중간인덱스 찾기
			if (arr[m] == d)
				return 1; // 찾은 경우
			else if (arr[m] < d)
				s = m + 1; // 찾는데이터가 오른쪽에
			else
				e = m - 1; // 찾는데이터는 왼쪽에..
		}
		// 가능한 범위를 모두 찾았는데 없는경우..
		return 0;
	}
}
