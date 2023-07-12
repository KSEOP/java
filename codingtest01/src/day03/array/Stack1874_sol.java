package day03.array;

import java.io.*;
import java.util.*;

public class Stack1874_sol {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Stack<Integer> stack = new Stack<>();
		int N = Integer.parseInt(br.readLine());
		int cnt = 1;
		StringBuilder sb = new StringBuilder();
		
		
		// N개의 숫자를 입력받아서 스택에서 꺼낸 숫자와 비교
		for (int i=0; i<N; i++) {
			int n = Integer.parseInt(br.readLine());
			
			// 스택 제일 위 값이 n인지 체크
			while(cnt <=N+1) {
				if(!stack.isEmpty() && stack.peek()==n) {
					sb.append("-\n");
					stack.pop();
					break;				
				}else{
					stack.push(cnt++);
					sb.append("+\n");
				}
				if (cnt>N+1) break;
			}
			
		}
		if (cnt>N+1) {
			System.out.println("NO");
		}else {
			System.out.println(sb);
		}
	}
}
