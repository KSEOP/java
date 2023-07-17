package day06.tree;

import java.io.*;
import java.util.*;

public class A_S1233 {
	static int N, ans;
	static char[] node;
	static int [] nodeLength;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 파일로부터 읽기

		// TC는 10개로 고정
		for (int tc = 1; tc <= 10; tc++) {
			N = Integer.parseInt(br.readLine());
			node = new char[N + 1];
			ans = 1;

			for (int i = 1; i <= N; i++) {
				// 입력 받은 줄에서, 공배
				String sp = br.readLine(); 
				node[i] = sp.split(" ")[1].charAt(0);
				nodeLength[i]=sp.length();
			}
			// 입력 정확히 받았는지 확인
			System.out.println(node);
		}
	}

}