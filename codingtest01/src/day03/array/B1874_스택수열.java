package day03.array;

import java.io.*;
import java.util.*;

public class B1874_스택수열 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Stack<Integer> stack = new Stack<>();
		int N = Integer.parseInt(br.readLine());
		int popcnt = 0;
		
		stack.push(1);
		System.out.println('+');
		
		
		while(!stack.isEmpty()) {			
			int n = Integer.parseInt(br.readLine());
			
			if(stack.peek()!=n) {
				stack.push(n);
				System.out.println("+");
			}
			while (stack.peek()==n) {				
				stack.pop();
				System.out.println("-");
			}
		}
	}
}
