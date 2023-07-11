package day02.stack_q;

import java.util.ArrayList;
import java.util.LinkedList;

public class TimeMillis {

	public static void main(String[] args) {
		int N = 10_000;	
		long start, end;
		
		start = System.currentTimeMillis();

		ArrayList<Integer> arr1 = new ArrayList<>();
		for (int i=0; i<N; i++) {
			arr1.add(0, i);
		}
		
		end = System.currentTimeMillis();
		System.out.println("ArrayList 실행시간(ms) : " + (end - start));
//		System.out.println(arr1);

		start = System.currentTimeMillis();

		LinkedList<Integer> arr2 = new LinkedList<>();
		for (int i=0; i<N; i++) {
			arr2.add(0, i);
		}
		
		end = System.currentTimeMillis();
		System.out.println("LinkedList 실행시간(ms) : " + (end - start));
	
	}

}
