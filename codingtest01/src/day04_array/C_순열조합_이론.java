package day04_array;

public class C_순열조합_이론 {

	public static void main(String[] args) {
		/*
		 * 서로 다른 4장의 카드 1,2,3,4 중 3장을 뽑아 나열하는 사건을 구하라.
		 * 
		 * ==> K=4, N=3
		 * 
		 * 
		 * dfs-깊이우선 탐색(n,
		 * 위의 템플릿 대로 정의한다.
		 * n: 종료조건.
		 * 
		 * ----1----
		 * if(n==N){
		 * 
		 *  - ans 출력 -
		 *  [---- 정답처리 로직 ----]
		 * 	return;} -- n 이 N 이 되면 종료한다
		 * 
		 * Visited 배열 활용
		 * 
		 * ----2----
		 * for(j=1; j<=k; j++)
		 *  if(v[j]) continue;
		 *  ans[n] <- j
		 *   dfs(n+1, ) ---
		 * 
		 * 
		 * ** 주의, 첫 경로인 1을 완전히 다 훑고 왔을 때, 이제 2를 선택해야하는데 1을 탐색하면서 visit 배열이
		 * ** 모두 체크가 되어있으면 두 번째로 가야할 경로 2를 안가는 경우가 있을 수 있다
		 * ** 해당하는 경우에서 visit 배열의 전체 체크 해제함을 잊지 않는다.
		 */
		
		
		

	}

}
