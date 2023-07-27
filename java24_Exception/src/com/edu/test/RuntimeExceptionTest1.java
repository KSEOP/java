package com.edu.test;

/*
 * 컴파일 시에는 에러가 없는데
 * 실행시점에서 에러가 발생...
 * == 컴파일러가 인지하지 못함.
 * 
 * 명시적인 예외 처리하지 않고
 * 바로 코드를 수정하면 정상 처리 됨. 
 * 
 * 명시적인 예외처리 방법
 * try, catch, finally, throws, throw
 * 
 * try{
 *    // 예외 발생 가능 코드 
 * }catch(ArrayIndexOutOfBoundsException e){
 *  //예외 발생하면 이곳으로 코드가 이동... 여기서 예외 잡혔을 때 코드.
 * }catch(~~~ Exception e){
 *  //여러개의 예외를 대응하는, 여러개 작성 가능.
 * }finally{
 *  // 예외 발생 하건, 안하건 무조건 작성해야하는 코드
 * }
 * 
 * ::
 * SQLException -- 컴파일에선 에러가 안남.
 * 
 *  
 */
public class RuntimeExceptionTest1 {

	public static void main(String[] args) {
		String[] str= {
			"Hello",
			"No, I mean it",
			"Nice to meet you"
		};
		int i = 0;
		
		while(i<=3) { // <= 하면 인덱스 3 접근 시, 런타임 에러 발생.
			try {
			System.out.println(str[i]);
			}catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("Nice Catch1");
			}catch(ArithmeticException e) {
				System.out.println("Nice Catch2");
			}catch(Exception e) {
				System.out.println("Nice Catch3"); // catch는 제대로 잡힌 "처음" 것만 돌아감. Exception이 부모인데도 이 부분은 안돌아감.
												   // 즉 catch는 좁은 부분에서 내려올수록 그냥 Exception으로 와야함.
			}finally {
				System.out.println("Always-");
				
			}
			i++;
		}
				
	}

}
