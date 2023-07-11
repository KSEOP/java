package day02.array;

import java.io.*;
import java.util.StringTokenizer;

public class B2018_sol {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		// 목표 합
		int s = 1;
		int e = 1; // 시작, 끝 자연수(포인터)
		int ans = 0;
		int sum = 1; // 개수, start부터 end까지 연속된 자연수의 합

		while (e <= N) { // *** e는 N/2+1를 넘어선 이후는 있을 수 없음을, 해당 상황을 인지했다면 적용하여 시간을 더 줄일 수도 있다. 
						//  *** 다만 이렇게하면 e=N인 유일한 1 케이스를 제외시켜버리므로 ans = 1 로 시작해야한다.
						//  *** + 추가로 N=1일때, 답이 2가 나와버리는 오답이 나와버림. 
						//  즉 극단치에서의 예상하지 못한 오답이 발생할 수 있다. 그러므로.... "효율화"에 너무 치우치지말고, 답을 낼 수 있는 것에 더 집중하라
			if (sum == N) {
				ans++;
				sum = sum - s++ + ++e;
//				sum -= s;
//				s++;
//				e++;
//				sum +=e;
			} else if (sum > N) { // 크다 => S를 빼준다.
				sum -= s++;

			} else if (sum < N) { // 작다 => e를 더한다.
				sum += ++e;

			}
		}
		System.out.println(ans);

	}

}
