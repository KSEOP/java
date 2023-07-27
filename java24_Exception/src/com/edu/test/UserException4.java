package com.edu.test;

class ZeroBoom extends Exception{ // extends~ 붙여 줘야. 예외처리용 클래스임.
	ZeroBoom(){
		this("This is ZeroBoom Exception");
	}
	ZeroBoom(String message){
		super(message);
		
	}
}

class User{
	public void go() throws ZeroBoom{
		int i=10; // 3
		int j=0;  // 4
		
		System.out.println("2. go()...진입..."); //5
		// 저 밑에 어느 부분에서 연산이 진행...  i/j...j에 0값이 할당되면 안되는 상황.
		// 만약에 J가 0이라면, Exception을 발생 시킬것이다.
		if(j==0) throw new ZeroBoom("분모가 0이면 안됨"); //6 -- 터짐
		
		System.out.println("ArithmeticException 터짐");
	}
}

public class UserException4 {

	public static void main(String[] args) {
		User user = new User();
		System.out.println("1. go()...호출"); // 1
		try {
		user.go(); // 2, 7
		}catch(ZeroBoom e){
			System.out.println(e.getMessage());
		}
	}

}
