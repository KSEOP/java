package com.edu.loop.test;

/*
 * if문과 함께 사용되는 반복문의 키워드
 * if + break
 * if + continue
 * 
 * 둘 다 반드시 조건을 주고 break 하거나, 조건을 주고 continue를 함.
 * break와 continue는 반드시 if와 함께 쓰인다는 것임.
 * 
 */
public class BasicLoopTest2 {

	public static void main(String[] args) {
		int total = 0;
		/*
		 * System.out.println("======break======"); for(int member =1; member<10;
		 * member++) { if(total>=30) break; total += member; }
		 * 
		 * System.out.println(total);
		 */

		System.out.println("======continue======");
		// 건너 뛰면서 반복하고싶을 때 continue임.
		for (int num = 1; num <= 10; num++) {
			//짝수일 때 continue, 더하지 않고 건너 뛰고 반복하므로 이 for문은 홀수의 총합이됨.
			if (num % 2 == 0)
				continue;
			total += num;

		}
		System.out.println(total);

	}

}
