package day01.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


	// 역방향으로 생각을하면 단순해지는 유형이 있으니 인지한다.
	// 이 문제는 좌우가 우선 순위를 가지고, 좌우가 없으면 위쪽으로 이동하는 로직이다
	// 내가 풀면서 헷갈린점, 좌우가 상하 좌표값에 대한 인지.
	// ************************************************
	// 범위밖에 여유공간을 하나둔다.(이 경우 0인 양쪽 범위를 하나 더 둬서, 범위 밖을 체크할 때 range 벗어나는 에러를 방지할 수
	// 있다.)
	// (물론 최종 결괏값이 틀어지지 않게 보정까지 철저히)
	// *************************************************
	// 내가 지금 곤란을 겪은 것.
	// 10개짜리 테스트 케이스를 배열에 10분할 반복으로 할당하는 것.
	// 좌로 한번 갔을때, 좌 우가 모두 1인 상황의 예외처리 - 생각 못해냄.
	// 1. visit[]로 방문표시를하거나, (디버깅시 좋아서 권장함.)
	// 2. 이전에 왔던 길을 없애는 방법도 있음(0으로 처리해버리는). 단 이 방법은 디버깅 시 안좋음.

public class S1210_ladder1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int TC = 10;
		int[][] arr = new int[100][102];
		for (int tc=1; tc<=TC; tc++) {
			//	[0] 입력처리 (100*100)
			int t = Integer.parseInt(br.readLine()); //	사용하지 않음
			for (int i=0; i<100; i++) {
				//	100행 데이터를 읽음
				st = new StringTokenizer(br.readLine(), " ");
				for (int j=1; j<=100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken()); 
				}
			}
			
			//	[1] 목적지 == 2, j 좌표 찾기
			int ci=99, cj=1;
			for (cj=1; cj<=100; cj++) {
				if (arr[ci][cj]==2) break;
			}
			
			//	[2] 좌우우선, 없으면 위로 (지나온길 0으로)
			while (ci>0) {
				arr[ci][cj]=0;	//	길 지우기
				if (arr[ci][cj-1]==1)		cj--;
				else if (arr[ci][cj+1]==1)	cj++;
				else 						ci--;
			}
			System.out.println("#"+tc+" "+(cj-1));
		}

	}

}
