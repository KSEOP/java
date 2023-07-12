package day03.array;

import java.io.IOException;
import java.io.*;
import java.util.*;

public class B2493_탑 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		Stack<Integer> stack = new Stack<>();
		Stack<Integer> stack2 = new Stack<>();
		Stack<Integer> destStack = new Stack<>();

		int N = Integer.parseInt(br.readLine());

		// 기본 스택, 탐색용 스택2 제작
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			stack.push(Integer.parseInt(st.nextToken()));
		}
		
		System.out.println(stack.size());
		
		// 탐색 추적 시작.

		while (!stack.isEmpty()) {
			stack2 = stack;
			while (!stack.isEmpty()) {
				if (stack2.pop() > stack2.peek()) {
					if(stack2.size()!=0)
					stack2.pop();
					else {
						destStack.add(0);
					}
				} else {
					destStack.add(stack2.size());
					break;
				}
				stack.pop();
			}

		}
		for(int i=0; i<destStack.size(); i++) {
			if(!destStack.isEmpty()){
			sb.append(destStack.pop()+" ");
			}}
		
	}
}
