package day10.unionfind_MST;

import java.util.*;
import java.io.*;

public class kb2반_알고리즘2번_강태섭 {

	static int N, M, day, cnt, ni, nj; // 시간의 흐름 day, 안걸린 학생 수 cnt
	static int[][] arr;
	static int[][] v;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 열 크기
		M = Integer.parseInt(st.nextToken()); // 행 크기

		// 전체 방향에서의 1 크기의 여유공간이 있는 교육장 배열 생성
		arr = new int[M + 2][N + 2];

		for (int i = 1; i <= M; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				// 여유공간 아닌곳에서 생성시작을 위해 j+1
				arr[i][j + 1] = line.charAt(j) - '0';
			}
		}

		// 첫 코로나 학생 객체 생성
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken()) + 1; // 여유공간 고려 좌표 설정
		int y = Integer.parseInt(st.nextToken()) + 1; // 여유공간 고려 좌표 설정
		Pos startStudent = new Pos(x, y);

		// 교육장 배열 생성 테스트 System.out.println(Arrays.deepToString(arr));
		bfs(startStudent);
		
		day = Math.abs(ni-x)+Math.abs(nj-y)+2; // 마지막으로 전염된 좌표와 시작 좌표의 거리.
		
		System.out.println(day);
		System.out.println(cnt);

	}

	public static void bfs(Pos s) {
		// [0] 필요한 Q, v[], 변수 등 선언
		Queue<Pos> q = new LinkedList<>();
		v = new int[M + 2][N + 2]; // 교육장과 동일한 방문 배열 생성

		// [1] 큐에 초기데이터(들)삽입, v[]표시
		q.add(s);
		v[s.i][s.j] = 1; // 코로나 발생 학생 지점, 방문 표시.

		// [2] 큐에 데이터가 있는동안 반복처리
		while (!q.isEmpty()) { // q가 비는 것이 곧 종료조건.

			// [3] 큐에서 데이터 한개 꺼냄
			Pos c = q.poll();

			// [4] 4 방향, 연결된 노드 등 반복처리
			for (int k = 0; k < 4; k++) {
				ni = c.i + di[k]; // 다음 이동 좌표 구하기
				nj = c.j + dj[k];
				// 들린적이 없는데 학생이 있다면, 큐에 추가한다.
				if (v[ni][nj] == 0 && arr[ni][nj] == 1) {
					q.add(new Pos(ni, nj));
					v[ni][nj] += 1; // 방문한 곳(전염된 곳) + 1 해준다.
				}
			}
		}

		// 안걸린 학생 수 구하기 => 교육장 배열에서 방문 배열을 빼준 뒤, 남은 학생 수를 센다.

		for (int i = 0; i < M + 2; i++) {
			for (int j = 0; j < N + 2; j++) {
				cnt += ((arr[i][j])-(v[i][j]));
			}
		}

		return;
	}

}

class Pos {
	public int i, j;

	Pos(int i, int j) {
		this.i = i;
		this.j = j;
	}
}
