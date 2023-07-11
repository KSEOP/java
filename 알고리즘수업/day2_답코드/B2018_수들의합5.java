package day02.array;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2018_수들의합5 {

	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));	//	파일로부터 읽기
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int s = 1, e = 1, sum = 1, ans = 1;
		while(e<=(N/2+1)) {
			if (sum == N) {	//	일치
				ans++;
				sum = sum - s++ + ++e;	
//				sum -= s++;		//	혼동되면 여러줄에 표현하자
//				sum += ++e;
			}else if(sum > N) {	//	크다 => s를 빼주자
				sum -= s++;
			}else {				//	작다 => e를 더해주자
				sum += ++e;
			}
		}
		System.out.println(ans);
	}

}
