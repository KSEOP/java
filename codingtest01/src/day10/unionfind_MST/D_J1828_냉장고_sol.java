package day10.unionfind_MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D_J1828_냉장고_sol {
	static int[][] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][2];
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr, (x,y)->x[1]-y[1]);
//		System.out.println(Arrays.deepToString(arr));
		
		int last=-270, ans=0;
		for (int i=0; i<N; i++) {
			if (last<arr[i][0]) {	//	등호 불포함 주의(같으면 여기서 보관가능하니..)
				last = arr[i][1];
				ans++;
			}
		}
		System.out.println(ans);
	}	
	
}

