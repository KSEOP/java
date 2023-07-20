package day09.graph;

import java.util.Arrays;

public class D_유니온파인드_sol {

	static int[] p;
	public static void main(String[] args) {
		// [0] Make Set: 각자 자신이 대표가되는 서로소 집합 생성
		p = new int[7];
		for (int i=0; i<7; i++) p[i]=i;
		
		// [1] union(0,1) : p[1의 대표자] = 0의 대표자;
		union(1, 2);
		union(2, 3);
		
		// [2] 3과 5가 같은 집합인지 판단
		if (findSet(3)==findSet(5))  System.out.println("같은집합");
		else System.out.println("다른집합");

		union(4,5);
		union(3,5);

		if (findSet(2)==findSet(4))  System.out.println("같은집합");
		else System.out.println("다른집합");
		
		System.out.println(Arrays.toString(p));
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

