package day04_array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class A_삽입정렬_sol {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// BufferedReader br = new BufferedReader(new InputStreamReader(new
		// FileInputStream("input.txt"))); // 파일로부터 읽기
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 1위치가 삽입할 대상 => 0 ~ i-1 까지는 이미 정렬되어 있음으로 봄.
		for(int i=1; i<N; i++) {
			//j는 삽입할 위치(0~i-1 까지 나보다 큰 값 위치 찾기
			for(int j=0; j<i; j++ ) {
				if(arr[i]<arr[j]) {
					// [1] 내 값 백업 후 한칸씩 밀기
					int t = arr[i];
					// 뒤에서부터 한 칸 뒤로 복사.
					for(int k=i-1; k>=j; k--) {
						arr[k+1] = arr[k];
					}
					arr[j]=t;					
				}
			}
			StringBuilder ans = new StringBuilder();
			for (int n: arr) ans.append(n+" ");
			System.out.println(ans);
		}
		
	

	}
}