package day06.tree;

import java.io.*;
import java.util.*;

public class B_B11047 {
	
	static int N;
	static int K;
	static int[] coins;
	static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		
		coins = new int[N];
		
		for(int i=0; i<N; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}

		for(int i=N-1; i>=0; i--) {
			if(K/coins[i]==0) {
				continue;
			}else if(K/coins[i]>0) {
				count += K/coins[i];
				K=K-((K/coins[i])*coins[i]); 
				//K=K%(coins[i]);
		
			}
		}
		
		System.out.println(count);
		
		
	}

}
