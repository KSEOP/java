package com.edu.oop;

public class Programmer {
	public String name;
	public String mainSkill;
	public int salary;
	
	///// Has a Relation /////
	public NoteBook noteBook; // 가장 좋은 것은 변수명도 그대로 해주면 된다. 단 변수 명이니 첫글자만 소문자, 좋은이유 2. 그래야 getter setter 만들때 바로 직관성 좋게 만들어짐.
	
	public Programmer(String name, String mainSkill, int salary) {
		this.name = name;
		this.mainSkill = mainSkill;
		this.salary = salary;
	}

	// set을 buy로 바꿈.이게 setter를 활용하는 방법임.
	public void buyNoteBook(NoteBook noteBook) {
		this.noteBook = noteBook;
	}
	public NoteBook getNoteBook() {
		return noteBook;
	}
	//이때에는 생성자로 값 만들고, 이후 수정을 세터처럼할때, set을 change로 바꿔 쓸 수 있다.
	public void changeMainSkill(String mainSkill) {
		this.mainSkill = mainSkill;
	}
	public String getMainSkill() {
		return mainSkill;
	}

	
	// 현 필드 4개. 이제 주입 통로를 결정함.
	// 강사님은 이름, 스킬, 봉급은 생성자 결정함. 노트북은 setter 주입함.
	
	//기능추가...
	public int annualSalary() {
		return salary*12;
	}
	public void increamentSalary(int amt) {
		// salary = salary + amt;
		salary += amt;
	}
	public int getSalary() {
		return salary;
	}
	
	

}
