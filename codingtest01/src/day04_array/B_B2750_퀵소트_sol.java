package day04_array;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_B2750_퀵소트_sol {

	static int[] arr;

	public static void main(String[] args) throws IOException {
		//	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));	//	파일로부터 읽기
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			arr = new int[N];
			for (int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			qsort(0, N-1);	//	0~N-1 까지 오름차순 정렬
			
			StringBuilder ans = new StringBuilder();
			for (int n: arr) ans.append(n).append("\n");
			System.out.println(ans);
		}

		public static void qsort(int l, int r) {
			// 재귀함수는 시작부분에서 종료조건 체크 및 종료
			if (l>=r) return;
			int p = partition(l, r);	//	p기준 양쪽 정렬
			qsort(l, p-1);				//	왼쪽정렬
			qsort(p+1, r);				//	오른쪽 정렬
		}

		public static int partition(int l, int r) {
			int p = l++;	//	p, l, r 초기값 설정
			while (l<r) {	//	l, r 자리잡고 교환
				//	l, r 위치 잡기
				while(l<r && arr[p]>arr[l]) l++;
				while(l<r && arr[p]<arr[r]) r--;
				
				//  l<r 조건을 만족하지 않아서 탈출했는지 체크필요
				if (l<r) {	// 자리잡았다면 교환!
					int t=arr[l]; arr[l]=arr[r]; arr[r]=t;
				}			
			}
			//	while문 탈출 == (l==r), p만 자리잡고 교환!
			if (arr[p] <= arr[l]) l--;
			int t=arr[p]; arr[p]=arr[l]; arr[l]=t;
			
			return l;		
		}

	}

