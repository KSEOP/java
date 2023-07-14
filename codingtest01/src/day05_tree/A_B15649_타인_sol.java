package day05_tree;

import java.io.*;
import java.util.*;


public class A_B15649_타인_sol {
	
	public static StringTokenizer st;
	public static StringBuilder sb = new StringBuilder();
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static int n, m, arr[], anw[], idx;
	public static boolean visit[];
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n+1];
		for(int i=1;i<n+1;i++) {
			arr[i] = i;
		}
		
		visit = new boolean[n+1];
		anw = new int[m];
		dfs(0, 0);
		
		System.out.println(sb);
	}
	public static void dfs(int count, int idx) {
		if(count == m) {
			for(int i=0;i<anw.length;i++) {
				sb.append(anw[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=1;i<n+1;i++) {
			if(!visit[i]) {
				visit[i] = true;
				anw[idx] = arr[i];
				dfs(count+1, idx+1);
				visit[i] = false;
			}
		}
	}
}

