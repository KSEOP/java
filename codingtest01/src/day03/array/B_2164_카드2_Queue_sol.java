package day03.array;

import java.util.LinkedList;
import java.util.Queue;
import java.io.*;

public class B_2164_카드2_Queue_sol {

	public static void main(String[] args) throws IOException {

		// 한 턴에 해야할 일
		// 반복을 구현하는 것.

		// while (q.size()>1)
		// 언제까지 반복해야할지도 좋은 방법이 있다.

		// 1. 일단 queue에 숫자가 들어와 있다.
		// 2. 제일 위에 것을 버린다 => q.poll(); // 꺼냄
		// 3. 2번째 것을 다시 큐로 집어넣는다. => q.add(q.poll())

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Queue<Integer> queue = new LinkedList<>();

		// [0] 1~N을 큐에 순서대로 넣기

		int N = Integer.parseInt(br.readLine());

		for (int i = 1; i <= N; i++) {
			queue.add(i);
		}
		// [1] 큐 크기 1 초과인 동안, 1개 버리고, 1개 다시 넣고.
		while(queue.size()>1) {
			queue.poll();
			queue.add(queue.poll());
		}
		System.out.println(queue.poll());

	}

}
