package day06.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C_B2839 {

	static int N;
	static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(br.readLine());

		for (int i = 1; i <= 1000; i++) {
			if ((N - (5 * i)) % 3 != 0) {
				continue;
			} else if (N % 3 == 0) {
				count = N / 3;
			} else {
				count += i;
				N = N - (5 * (i));

				count += (N / 3);
				N = (N % 3);

				if (N != 0) {
					count = -1;
				}
				break;

			}

		}
		System.out.println(count);

	}
}