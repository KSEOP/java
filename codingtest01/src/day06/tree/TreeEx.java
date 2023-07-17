package day06.tree;

import java.io.*;
import java.util.*;

public class TreeEx {

	static int N;
	static int[] tree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		tree = new int[N + 1];

		// [0] tree 데이터 저장
		for (int i = 1; i <= N; i++) {
			tree[i] = (char) ('A' + i - 1);
		}

		preOrder(1); // 전위순회로 루트부터 탐색

	}

	public static void preOrder(int n) {

		// 종료 조건 (1~N만 존재하는 노드)
		if (1 <= n && n <= N) {
			System.out.print((char) tree[n] + " ");
			preOrder(n * 2);
			preOrder(n * 2 + 1);
		}

	}

}
