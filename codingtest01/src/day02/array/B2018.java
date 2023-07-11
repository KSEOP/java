package day02.array;

import java.io.*;
import java.util.StringTokenizer;

public class B2018 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int arr[] = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = i+1;
		}		
		
		int cnt=0;
		for(int si=0; si<N; si++) { 
			for(int sj=N; sj>0; sj--) {
				int sum=0;
				for(int p1=si; p1<sj; p1++) {
					sum+=arr[p1];
					System.out.println(sum);
					if(sum==N) cnt ++;
				}
				

			}
			
		}
		System.out.println(cnt);

	}

}
