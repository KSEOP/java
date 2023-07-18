package day07.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class A_1931_sol_그리디_회의실예약 {
	/*
	 * 최선의 방법을 찾는 것
	 * 다양한 반례가 있을 수 있으나 회피하는것이 중요.
	 * 
	 * 경우의 수를 잘 생각하고 선정하여 테스트케이스에서 확인
	 * (시작시간이 빠른, 회의시간이 짧은, 종료시간이 빠른 등.)
	 * 
	 * 10분 찾아서 안나오는 허점이나 버그는 계속 찾아지지 않아질 가능성이 높다.
	 * 그럴땐 문제에 있는 제약 조건을 다시 점검하고 리스트업 제대로 하는 것이 좋다.
	 * 
	 * 풀때엔 3~40분 집중하는 연습.
	 * 혼자서 디버깅 일정시간 하는 연습.
	 * 
	 * !! 테스트케이스가 2~3번 째가 있으면, 놓치지 말아야할 제약 조건을 포함하고 있을 가능성이 높다. !!
	 * 
	 *  
	 * 이 문제의 N 은 100,000이고 굉장히 크다. N^2이 안되도록 조심해야함.
	 * ==> 2중 포문 해서는 안되고, 정렬+루프 한번으로 끝낸다 생각할 수 있어야 함.
	 *  
	 */
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));	//	파일로부터 읽기
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// [0] 입력처리
		int N = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][2]; 
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		// [1] 종료시간기준 오름차순, 같으면 시작시간 오름차순 정렬
		Arrays.sort(arr, (x,y)->x[1]==y[1]?(x[0]-y[0]):x[1]-y[1]);

		int ans=0, last=0;
		for (int i=0; i<N; i++) {
			if (last<=arr[i][0]) {	//	마지막종료시간<=시작시간 => 할당 가능한 회의
				ans++;				//	회의수 ++
				last = arr[i][1];	//	마지막회의시간 갱신
				
			}
		}
		System.out.println(ans);
	}
}
