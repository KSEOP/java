package day10.unionfind_MST;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class C_B11724_연결요소의개수 {
	static int N, M;
	static boolean[] v;
	static ArrayList<Integer> adj[];
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	//  BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));	//	파일로부터 읽기
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		adj = new ArrayList[N+1];
		for (int i=1; i<=N; i++) {
			adj[i] = new ArrayList<Integer>();	
		}
		
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			adj[s].add(e);
			adj[e].add(s);		//	개수가 많지 않으면, AdjArray가 빠를수도!
		}

		v = new boolean[N+1];
		int ans=0;
		for (int i=1; i<=N; i++) {
			if (!v[i]) {
				bfs(i);
				ans++;
			}
		}
		System.out.println(ans);
		
	}
	
	public static void bfs(int s) {
		Queue<Integer> q = new LinkedList<>();

		q.add(s);
		v[s]=true;
		
		while (!q.isEmpty()) {
			int c = q.poll();
			for (int n: adj[c]) {
				if (v[n]) continue;
				v[n] = true;
				q.add(n);
			}
		}
	}

}
