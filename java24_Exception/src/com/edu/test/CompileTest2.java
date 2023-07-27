package com.edu.test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class FileReading {
	public void readFile(String filename) {
		FileReader reader = null;
		try {
			reader = new FileReader(filename);
			
			//이 부분에서 24/0 같은 코드...
			System.out.println("1. 파일을 잘 찾았음.");
				
		} catch (FileNotFoundException e) {
			System.out.println("1. 파일을 찾을 수 없음.");
		} catch (IOException e) {
			System.out.println("1. 파일을 찾을 수 없음.");
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
			} // local v는 try 안에서 선언된 건 try 안에서, catch 안에서 선언된건 catch 안에서만 사용가능
		}
		
		
		
		System.out.println("2. FileReader API...");
	}

}
public class CompileTest2 {

	public static void main(String[] args) {
		FileReading fr = new FileReading();
		fr.readFile("C:\\KB_EDU\\doc\\KB_WS11_JAVA .pdf");
		
		System.out.println("3. readFile() calling...");

	}

}
