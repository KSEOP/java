package day02.array;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class S_2001 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int TC = Integer.parseInt(st.nextToken());
		
		// N과 M 받기. 
		for(int i=0; i<TC; i++) {
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] arr1 = new int[N][N];

			for(int x=0; x<N; x++) {
				for(int y=0; y<N; y++) {
					arr1[x][y]=Integer.parseInt(st.nextToken());
				}
				
			}
			// 배열 생성 끝
			// 이제 합배열 구하기
			
			
			
			
			
		}
		
	
		
		
	
		
		

	}

}
