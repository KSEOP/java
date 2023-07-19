package day8.graph;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_S_5189_전자카트 {
	
	/*
	 * 순열 조합 등을 떠올리는 것이 상황에 따라 더 복잡해질 수 있다. (시작과 끝이 1이기 때문)
	 * 
	 */
	
	
	static int tc, N, min;
	static int[][] arr;
	static int[] course;
	static boolean [] v;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		tc = Integer.parseInt(br.readLine());
		
		// TC 별 배열 생성
		for(int t=1; t<=tc; t++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			course = new int[N];
			v = new boolean[N];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());					
				}
			}
			
			
		dfs(0, 0, 0);
		System.out.println("#"+tc+" "+min);	
		}
	}
	
	public static void dfs (int n, int cnt, int sum) {
		// [0] 종료조건
		if(n==N) {
			for(int i=0; i<N; i++) {
				if(sum<=min) {
					min = sum;
				}
			} return;
		}
		
		
		// [1] 하부조건
		
		for(int i=1; i<N; i++) {
			 if(v[i]==true) continue;
			 
			 v[i]=true;
			 course[i-1]=i;
			 // dfs(n+1, sum+arr )
			
			
		}
		
		
		
		
	}

}
