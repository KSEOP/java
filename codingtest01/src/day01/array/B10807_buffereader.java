package day01.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B10807_buffereader {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 입력받는 부분
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		
		String str = reader.readLine();
		String [] strs = str.split(" ");
		
		int V = Integer.parseInt(reader.readLine());
		int cnt = 0;
		
		int [] arr = new int [N];
		for (int i=0; i<strs.length;i++) {
			arr[i] = Integer.parseInt(strs[i]);
		}
		
		for (int j=0; j< N; j++) {
			if (arr[j] == V) {
				cnt += 1;
			}
			
		}
		System.out.println(cnt);

	}

}