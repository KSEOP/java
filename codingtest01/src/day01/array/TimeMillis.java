package day01.array;

public class TimeMillis {

	public static void main(String[] args) {
		int N = 100000;		//	두배로 키우면 N^2에서는 대략 네배로 시간증가
		long start, end;
		
		// 반복문 : O(n)
		int total = 0;
		
		start = System.currentTimeMillis();
		for (int i = 0; i < N; i++) {
			total += i;
		}
		end = System.currentTimeMillis();
		System.out.println("반복문 실행시간(ms) : " + (end - start));
		
		
		// 2중 반복문 : O(n^2)
		total = 0;
		
		start = System.currentTimeMillis();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				total += j;				
			}
		}
		end = System.currentTimeMillis();
		System.out.println("이중 반복문 실행시간(ms) : " + (end - start));
		

	}

}
