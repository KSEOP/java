package day07.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_1920_수찾기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));	//	파일로부터 읽기
		StringTokenizer st;
				
		
		// N, M 배열 생성
		
		int N = Integer.parseInt(br.readLine());
		int[] Narr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			Narr[i] = Integer.parseInt(st.nextToken());
		}
		
		int M = Integer.parseInt(br.readLine());
		int[] Marr = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			Marr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 탐색 구현
		
		int start = 0;
		int end = N-1;
		int center=0;
		
		Arrays.sort(Narr); // 정렬
		
		for(int i=0; i<M; i++) {
			while(start <= end){
				center = (start+end)/2;
				if(center==Marr[i]) {
					System.out.println(1);
					continue;
				}else if(Narr[center] < Marr[i]) {
					start = center + 1;
				}else if(Narr[center] > Marr[i]) {
					end = center -1;					
				}
						
			}
			System.out.println("0");
						
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
