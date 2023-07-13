package day04_array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class A_삽입정렬_틀림 {

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

		// *********************앞에서 부터 ==> 방향으로 당기는 것은 망. 
		// ******** 로직이 복잡한데다 효율적인 것 같지도 않으므로 이런 방식으로는 시도하지말자. 
		// Sol 방향성대로(뒤로 한칸씩 당기는 것은, 뒤에서부터 하나씩 당겨가며 기준점을 -- 하는것) 하자.*******************
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] < arr[j]) {
					int temp1 = arr[i];
					for(int k=j; k<i-1; k++) {
						int temp2 = arr[k+1];
						arr[k+1] = arr[k];
						arr[k+2] = temp2;
					}
					arr[j]=temp1;				
					// 앞에서부터 뒤로 당기는 것 실패.
					
					StringBuilder ans = new StringBuilder();
					for (int n: arr) ans.append(n+" ");
					System.out.println(ans);
				
				}

			}

		}

	}
}