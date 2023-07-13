package day04_array;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Sort_사용자지정 {

	public static void main(String[] args) {
		int[][] arr = {{1,2}, {3,4}, {9,10}, {7, 6}, {5, 6}};
		System.out.println(Arrays.deepToString(arr));
		
		// 람다함수를 이용 내림차순
		Arrays.sort(arr, (x, y) -> y[0] - x[0]);
		System.out.println(Arrays.deepToString(arr));
		
		// 람다함수를 이용하여 두번째 값 비교, 두번째 값이 같다면 첫번째 값 비교
		Arrays.sort(arr, (x, y) -> x[1] == y[1]? x[0] - y[0] : x[1] - y[1]);
		System.out.println(Arrays.deepToString(arr));
		
		// 첫번째 값 내림차순 : 같다면 두번째 값 오름차순으로
		Arrays.sort(arr, (x, y) -> y[0]==x[0]? x[1]-y[1] : y[0] - x[0]);
		System.out.println(Arrays.deepToString(arr));
		
		// 문자열의 길이를 기준으로 정렬
		String[] arr2 = {"apple", "samsung", "lg", "google"};
		Arrays.sort(arr2, (s1, s2) -> s1.length() - s2.length());
		System.out.println(Arrays.toString(arr2));
	}

}