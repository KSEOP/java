package day02.stack_q;

import java.util.Stack;

public class StackTest {

	public static void main(String[] args) {
		// 1. 스택 생성 후 값 추가
		Stack<Integer> stack = new Stack<>();
		stack.push(100);
		stack.push(200);
		stack.push(300);
		stack.push(400);
		stack.push(500);
		System.out.println("스택 생성 : " + stack.toString());
		
		// 2. 스택의 맨 위의 값 제거
		int top = stack.pop();
		System.out.println("제거된 값 : " + top + " 제거 후 스택 : " + stack.toString());
		
		// 3. 스택의 맨 위의 값 출력
		System.out.println("맨 위의 값 : " + stack.peek());
		
		// 4. 스택의 모든 값 제거
		while (!stack.isEmpty()) {
			top = stack.pop();
			System.out.println("제거된 값 : " + top + " 제거 후 스택 : " + stack.toString());
		}
	}
}
