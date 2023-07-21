package day03.array;

import java.io.*;
import java.util.*;

public class B17608_막대기_sol {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Stack<Integer> stack = new Stack<>();
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			// N개의 숫자 입력을 받음
			int n = Integer.parseInt(br.readLine());

			// 스택은 pop, peek 사용 시 ***반드시*** empty check 해야함.
			// 지금 들어온 숫자가 크거나 같은 경우(이전 숫자)
			while (!stack.isEmpty() && stack.peek() <= n) {
				stack.pop();
			}
			stack.push(n);

		}
		System.out.println(stack.size());

	}

}
