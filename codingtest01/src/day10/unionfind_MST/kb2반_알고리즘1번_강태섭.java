package day10.unionfind_MST;

import java.util.Arrays;
import java.util.*;
import java.io.*;


public class kb2반_알고리즘1번_강태섭 {
	
	
	static int N, R, cnt;
	static int[] p;
	
	public static void main(String[] args) throws IOException{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		R = Integer.parseInt(br.readLine());
		
		// 각자가 각자의 부모인 서로소 집합을 생성한다.
		// 0번은 없으므로, 마을사람수 +1 크기로 만든다.
		p = new int[N+1];
		for(int i=0; i<N+1; i++) {
			p[i]=i;
		}
		
		// 제공된 관계에 따라 유니온 작업을 진행한다.
		// 방향성이 없기에 제공된 모든 관계를 단순히 유니온 해도 출력해야할 값과는 무관할 듯 하다.
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a,b);
		}
		
		// 합집합 관계 정리가 끝난 후, find 작업을 진행한다.
		// 관계가 없는 노드가 있을 수 있으므로 전체 주민을 find 한번씩 다 해준다.
		// 철수가 1인 루트임을 가정한다.
		for(int i=1; i<N+1; i++) {
			findSet(i);
		}
		
		// find로 철수가 최종 parent인 주민 idx들의 값은 모두 1이 되었을 것이므로
		// p 배열의 1의 갯수를 count한다.
		for(int i: p) {
			if(i==1) {cnt++;
			}
		}
		
		// 철수는 제외이므로 1을 뺀 cnt 값을 출력한다.
		System.out.println(cnt-1);
		
	}
	
	public static int findSet(int n) {
		if (n == p[n]) return n;
		return p[n] = findSet(p[n]);
	}
	
	
	public static void union(int a, int b) {
		p[findSet(b)] = findSet(a);
	}
	
	
}

