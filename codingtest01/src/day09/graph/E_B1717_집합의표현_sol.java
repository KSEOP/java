package day09.graph;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class E_B1717_집합의표현_sol {
	static int[] p;
	public static void main(String[] args) throws IOException {
		//	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));	//	파일로부터 읽기
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// Make Set
		p = new int[N+1];
		for (int i=1; i<=N; i++) p[i]=i;
		
		StringBuilder ans = new StringBuilder();
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int OP = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			if (OP==0)	union(A, B);
			else {
				if (findSet(A)==findSet(B)) ans.append("YES\n");
				else ans.append("NO\n");
			}
		}
		System.out.println(ans);
	}

	public static int findSet(int n) {
		// find한 경로에 있는 노드들을 루트밑에 바로 붙임
		if (n == p[n]) return n;
		return p[n] = findSet(p[n]);
	}
	
	public static void union(int a, int b) {
		// 집합을 합쳐주는 것이므로 주의!!
		p[findSet(b)] = findSet(a);
	}
}
