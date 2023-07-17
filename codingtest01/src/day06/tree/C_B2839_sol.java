package day06.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C_B2839_sol {

	public static void main(String[] args) throws IOException {
		//	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));	//	파일로부터 읽기
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//	[0] 입력처리
		int N = Integer.parseInt(st.nextToken());
		
		int N5 = N/5;		// 무거운 포대를 최대한 사용해서 포대수를 줄이기 위해 계산
		int N3 = (N-5*N5)/3;// 남은 무게를 3Kg 포대수로 계산
		while (N5>=0) {
			if (N5*5+N3*3 == N) break;
			N5--;
			N3 = (N-5*N5)/3;			
		}
		if (N5>=0)	System.out.println(N5+N3);
		else		System.out.println("-1");
	}
}
