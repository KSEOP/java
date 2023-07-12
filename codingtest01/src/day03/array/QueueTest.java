package day03.array;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {

	public static void main(String[] args) {
		// 1. 큐 생성 후 값 추가
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(100);
		queue.offer(200);
		queue.offer(300);
		queue.offer(400);
		queue.offer(500);
		System.out.println(queue.toString());

		// 2. 큐의 맨 앞의 값 제거
		int front = queue.poll();
		System.out.println("제거된 값 : " + front + " 제거 후 큐 : " + queue.toString());

		// 3. 큐의 맨 앞의 값 출력
		System.out.println("맨 앞의 값 : " + queue.peek());

		// 4. 큐의 모든 값 제거
		while (!queue.isEmpty()) {
			front = queue.poll();
			System.out.println("제거된 값 : " + front + " 제거 후 큐 : " + queue.toString());
		}

	}

}
