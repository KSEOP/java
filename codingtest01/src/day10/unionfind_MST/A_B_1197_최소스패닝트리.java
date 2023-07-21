package day10.unionfind_MST;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class A_B_1197_최소스패닝트리 {
	static int[] p;
	static int[][] link;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));	//	파일로부터 읽기
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// [0] 입력처리
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
				
		// Make Set
		p = new int[V+1];
		for (int i=1; i<=V; i++) p[i]=i;

		link = new int[E][3];  
		for (int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			link[i][0] = Integer.parseInt(st.nextToken());
			link[i][1] = Integer.parseInt(st.nextToken());
			link[i][2] = Integer.parseInt(st.nextToken());
		}
		
		// [1] 링크의 가중치 오름차순으로 정렬
		Arrays.sort(link, (x,y)->x[2]-y[2]);
		
		int ans=0, cnt=0;
		// [2] 같은 집합이 아닌(노드를 연결하는) 링크 V-1개를 선택
		for (int i=0; i<E; i++) {
			// [3] 같은집합이 아닌(사이클이아닌) 링크선택
			if (findSet(link[i][0])!=findSet(link[i][1])) {
				union(link[i][0], link[i][1]);
				ans += link[i][2];
				// V-1개의 링크를 선택하면 종료!
				if (++cnt==V-1) break;
			}
		}
		
		if(cnt==V-1) System.out.println(ans);
		else System.out.println("-1"); // 우리문제에는 이런상황이 없지만..
		
	}

	public static int findSet(int n) {
		// find한 경로에 있는 노드들을 루트밑에 바로 붙임
		if (n == p[n]) return n;
		return p[n] = findSet(p[n]);
//		return findSet(p[n]);    // 저장하지 않고 리턴하면 깊이가 깊은상태유지.. 느림
	}
	
	public static void union(int a, int b) {
		// 집합을 합쳐주는 것이므로 주의!!
		p[findSet(b)] = findSet(a);
	}
}
