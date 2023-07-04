package com.edu.oop.test;
import com.edu.oop.*;

public class ProgrammerTest {

	public static void main(String[] args) {
		/*
		 * 1. 객체 생성
		 * 2. 기능 호출
		 * ---------------------
		 * 1. James라는 개발자를 생성
		 *    정보를 입력...이름, 주요기술, 급여
		 * 2. James가 HP 노트북을 구매...setter주입
		 * 3. James가 구매한 노트북을 리턴 받아서
		 *    노트북의 정보를 출력
		 * 4. James의 변경된 mainSkill과, 급여를 출력
		 */
		Programmer p1 = new Programmer("James","java",100);
		
		//여기서 new쓰는거 막힘.
		p1.buyNoteBook(new NoteBook("HP",170,0));
		System.out.println("===James가 구매한 노트북정보입니다.===");
		System.out.println(p1.getNoteBook().getNoteBookInfo());
		
		//James의 변경된 mainSkiil정보.
		System.out.println("\n===James 변경된 mainSkill 정보입니다.===");
		p1.changeMainSkill("Python");
		System.out.println(p1.getMainSkill());
		
		System.out.println("\n===James 변경된 급여 정보입니다.");
		System.out.println(p1.getSalary());
		
		
		
	}

}
