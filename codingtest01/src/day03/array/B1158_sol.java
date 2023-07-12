package day03.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1158_sol {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> q = new LinkedList<>();
		
		sb.append("<");
		// [0] 1~N 을 큐에 저장
		for (int i=1; i<=N; i++) {
			q.add(i);
		}
		// [1] K-1개는 뒤로 붙이고, 1개는 poll
		// 큐에 데이터가 있는 동안 반복 처리
		while (q.size()>0) {
			for(int j=0; j<K-1; j++) {
				q.add(q.poll());
			}
			sb.append(q.poll()+", ");
		}
		sb.delete(sb.length()-2, sb.length());
		sb.append(">");
		System.out.println(sb);
		

	}

}
