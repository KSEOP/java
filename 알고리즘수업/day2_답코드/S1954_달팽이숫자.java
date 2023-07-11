package day02.array;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S1954_달팽이숫자 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));	//	파일로부터 읽기
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//	계속 사용되는 배열을 밖에 생성
		int[] di= {0, 1, 0, -1};
		int[] dj= {1, 0, -1, 0};
		int TC = Integer.parseInt(st.nextToken());
		for (int tc=1; tc<=TC; tc++) {
			//	N 을 입력
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());

			int[][] arr = new int[N][N];
			int i=0, j=0, dr=0;
			for (int cnt=1; cnt<=N*N; cnt++) {
				arr[i][j] = cnt;	//	좌표에 달팽이 번호 기록
				
				//	다음 좌표가 (범위내이고 0이면) => 이동
				//	else => 꺽어서 이동
				int ni = i+di[dr];
				int nj = j+dj[dr];
				//	항상 범위이내인지 체크가 먼저, 그 후 사용!!!
				if (0<=ni && ni<N && 0<=nj && nj<N && arr[ni][nj]==0) {
					i = ni; 
					j = nj;
				}else {
					dr = (dr+1)%4;	//	0,1,2,3,0,1,2,3...
					i = i+di[dr]; 
					j = j+dj[dr];
				}
			}
			
			//	출력
			System.out.println("#"+tc);
			for (int[] lst: arr) {
				for (int n: lst) {
					System.out.print(n+" ");
				}
				System.out.println();
			}
		}

	}

}
