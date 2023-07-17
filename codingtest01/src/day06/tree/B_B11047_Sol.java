package day06.tree;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_B11047_Sol {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));	//	파일로부터 읽기
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//	[0] 입력처리
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int ans = 0;
		// [2] 큰 금액부터 1) 나누기로 몫구하고 2) 나머지금액 구하기
		for (int i=N-1; i>=0; i--) {
			ans += K/arr[i];	//	동전개수 누적
			K %= arr[i];		//	남은 금액처리
		}
		System.out.println(ans);

	}

}
