package day03.array;

import java.io.*;
import java.util.*;

public class B17608_막대기 {

	public static void main(String[] args) throws IOException {
		/*
		 * stack으로 풀어야하는 문제들이 있다. 이 문제는 단순 배열로 풀 수도 있으나 stack으로 풀어봄이 필요하다.
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Stack<Integer> stack = new Stack<>();

		int i = 0;
		int stick = 0;

		int N = Integer.parseInt(br.readLine());

		while (i < N) {
			stick = Integer.parseInt(br.readLine());
			if (stack.isEmpty()) {
				stack.add(stick);
				i++;
			} else if (stack.peek() > stick) {
				stack.add(stick);
				i++;
				continue;
			} else if (stack.peek() == stick) {
				i++;
				continue;
			} else {
				while (i < N) {
					if (stack.isEmpty()) {
						stack.add(stick);
						i++;
						break;
					} else if (stack.peek() < stick) {
						stack.pop();
						continue;
					} else if (stack.peek() == stick) {
						i++;
						break;
					} else {
						stack.add(stick);
						i++;
						break;
					}
				}

			}

		}
		System.out.print(stack.size());

	}

}
