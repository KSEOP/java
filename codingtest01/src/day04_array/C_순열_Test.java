package day04_array;

public class C_순열_Test {

		static boolean[] v;
		static int[] ans;
		static int K=4, N=3, cnt=0;	//	1~K카드 중에서 중복X 순서대로 선택
		public static void main(String[] args) {
			
			v = new boolean[K+1];
			ans = new int[N];
			
			//	항상 가장위의 함수를 호출하면 됨
			dfs(0);
			System.out.println(cnt);
		}
		
		public static void dfs(int n) {
			//	[0] 종료조건(n관련) 확인 후 정답처리
			if (n==N) {
				//	정답에 관련된 처리 진행
				for(int t: ans) {System.out.print(t);}
				
				System.out.println();
				cnt++;
				return;
			}
			
			//	[1] 하부단계 호출
			for (int j=1; j<=K; j++) {
				//	중복체크 후 사용하지 않았다면 선택
				if (v[j]) continue;	// 사용했다면 다음번호로..

				v[j]=true;
				ans[n]=j;
				dfs(n+1);
				v[j]=false;
			}
		}

	}
