package day10.unionfind_MST;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_B1976_여행가자_sol {
	static int[] p;
	public static void main(String[] args) throws IOException {
		//	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));	//	파일로부터 읽기
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// [0] 입력처리
		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
				
		// Make Set
		p = new int[N+1];
		for (int i=1; i<=N; i++) p[i]=i;
		
		for (int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=1; j<=N; j++) {
				int t = Integer.parseInt(st.nextToken());
				if (t==1)	union(i, j);	//	연결되있으므로 i, j를 같은 집합으로
			}
		}

		st = new StringTokenizer(br.readLine());
		// 첫번째 도시 입력
		int i=0;
		int g = Integer.parseInt(st.nextToken());
		for (i=0; i<M-1;i++) {
			// 도시입력 받아서 g와 같은 그룹인지 확인
			int t = Integer.parseInt(st.nextToken());
			if (findSet(g)!=findSet(t))	break;
		}
		if (i<M-1) {	//	중간에 탈출! 같은그룹 아님!
			System.out.println("NO");
		}else {
			System.out.println("YES");
		}
		// 집합의 개수
//		int gcnt=0;
//		for (int i=1; i<=N; i++) {
//			if (p[i]==i) gcnt++;
//		}
//		System.out.println(gcnt);
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
