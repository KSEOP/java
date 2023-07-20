package day09.graph;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class A_B_2178_미로탐색_sol {
	/*
	 * bfs로 푸는 것이 더 적절함 문제임.
	 * 
	 * - 범위 체크를 줄이는 방법 // 2차원 배열을 1칸의 0 여유 공간이 생기게 함.
	 * bfs(si,sj)를 생성한다면?
	 * q 와 v[] 생성.
	 * q 초기데이터 삽입.v[] 방문 표시
	 * while !q
	 * 	ci. cj <-- q.poll();
	 *  4방향, 방문안했던 곳이고, 1이면 (길이 1이니까)
	 *  ci, cj <-- Q삽입?                       //--- 이 Line은 불확실 
	 */

		static int N, M;
		static int[][] arr;
		static int[] di = {-1,1,0,0};
		static int[] dj = {0,0,-1,1};
		public static void main(String[] args) throws IOException {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			// BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));	//	파일로부터 읽기
			StringTokenizer st = new StringTokenizer(br.readLine());

			// [0] 입력처리
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			arr = new int[N+2][M+2];
			for (int i=1; i<=N; i++) {
				String line = br.readLine();
				for (int j=0; j<M; j++) {
					arr[i][j+1]=line.charAt(j)-'0';
				}
			}
//			System.out.println(Arrays.deepToString(arr));
			
			int ans = bfs(new Pos(1,1));
			System.out.println(ans);
		}
		
		public static int bfs(Pos s) {
			// [0] 필요한 Q, v[], 변수 등 선언
			Queue<Pos> q = new LinkedList<>();
			int[][] v = new int[N+2][M+2];
			
			// [1] 큐에 초기데이터(들)삽입, v[]표시, 필요시 정답관련처리
			q.add(s);
			v[s.i][s.j]=1;		//	v[]배열에 시작위치로부터 증가되는 거리를 표시
			
			// [2] 큐에 데이터가 있는동안 반복처리
			while (!q.isEmpty()) {
				// [3] 큐에서 데이터 한개 꺼냄 (종료관련 처리 이곳에서)
				Pos c = q.poll();
				if (c.i==N && c.j==M) return v[c.i][c.j];
				
				// [4] 4/8방향, 연결된 노드 등 반복처리
				for (int k=0; k<4; k++) {
					int ni = c.i + di[k];	//	다음 이동 좌표 구하기
					int nj = c.j + dj[k];
					// 제일먼저!! 범위내(skip), 미방문, 조건 맞으면(길이면)
					if (v[ni][nj]==0 && arr[ni][nj]==1) {
						q.add(new Pos(ni,nj));
						v[ni][nj] = v[c.i][c.j]+1;
					}
				}
			}
			// 지금문제에서는 이곳에 올리가 없지만... 디버깅을 위해서
			// 목적지를 찾지 못한 경우.. -1리턴
			return -1;
		}
	}

	class Pos{	//	좌표(position을 저장하는)
		public int i, j;
		Pos(int i, int j){
			this.i=i;
			this.j=j;
		}
	}
