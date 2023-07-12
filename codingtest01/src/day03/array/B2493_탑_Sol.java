package day03.array;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class B2493_탑_Sol {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));	//	파일로부터 읽기
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<Integer[]> stk = new Stack<>();
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		for (int cnt = 1; cnt<=N; cnt++) {
			//	높이를 입력받음
			int n = Integer.parseInt(st.nextToken());
			//	[1] 입력받은 높이가 이전 저장된 높이보다 높으면 모두 꺼냄 => 가려지니 의미없음
			while (!stk.isEmpty() && n>stk.peek()[0]) {
				stk.pop();
			}
			
			//	[2] 처음만날 탑 번호를 저장
			if (stk.isEmpty())	sb.append("0 ");
			else				sb.append(stk.peek()[1]+" ");

			//	[3] 내 높이 + 번호 push
			stk.push(new Integer[] {n, cnt});
		}
		System.out.println(sb);
	}

}
