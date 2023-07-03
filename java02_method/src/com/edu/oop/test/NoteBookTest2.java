package com.edu.oop.test;

import com.edu.oop.NoteBook;

public class NoteBookTest2 {

	public static void main(String[] args) {

		NoteBook nb = new NoteBook();
		
		/*
		nb.brand = "LG Gram";
		nb.price = 1700000;
		nb.serialNumber = 1234;
		*/
		nb.setNotebook("LG Gram", 1700000, 1234);
		nb.printNoteBookInfo();

	}
	//
	
	
}

