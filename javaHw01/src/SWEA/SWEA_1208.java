package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1208 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 이건 그냥 스캐너 대용으로 쓴 것 같다.

		for (int t = 1; t <= 10; t++) { 
			int dump = Integer.parseInt(br.readLine()); // 스캐너 처럼 입력을 받는데 String이라 덤프는 정수이므로 parseInt라는 기능을 쓰고있음

			int[] arr = new int[100];  // 크기 100짜리 배열 생성
			StringTokenizer st = new StringTokenizer(br.readLine()); //토크나이저 값을 입력 받는다.
			for (int i = 0; i < 100; i++) { // 100번 돌린다.
				arr[i] = Integer.parseInt(st.nextToken()); //
			}

			for (int i = 0; i < dump; i++) { // dump가 한계 수 인데. 한계 수 만큼 그냥 해버림. 이 경우 딱히 break를 하지는 않았음.
				Arrays.sort(arr); // 가장 큰 값과, 작은 값을 1씩 줄이고, 1씩 늘린뒤 sort를 하며 flatten 하는 과정.
				arr[0]++;
				arr[99]--;
			}
			Arrays.sort(arr); // sort를 해서 크기가 오락가락인 박스 높이들을 한방에 정렬 (이 문제는 2차원 배열문제로 풀 필요가 없던 수준)
			int result = arr[99] - arr[0]; // 가장 높이 있는 것 99 인덱스에 있는 값(높이)와 가장 낮아야할 것 두개의 차를 보여줌.
			System.out.println("#" + t + " " + result);
		}
	}
}