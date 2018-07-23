package com.segae.memo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Memo {
	public static final String MEMO_DIR = "/temp/memo/";
	
	public static final String EXIT = "/exit";
	
	public Memo() {
		File dir = new File(MEMO_DIR);
		if(dir.exists()) {
			dir.mkdirs();
		}
	}
	
	public void showCommand() {
		System.out.println("아래명령 번호를 입력하세요-----");
		System.out.println("1.쓰기 2.읽기 3.수정 4.삭제 0.종료");
	}

	public void write(Scanner scanner) {
		System.out.println("-----쓰기모드------");
		StringBuilder content = new StringBuilder();
		while(true) {
		String line = scanner.nextLine();
		if(line.equals(EXIT)) {
			break;
		}else {
			content.append(line + "\r\n");
		}
	  }
	
		if(!content.toString().equals("")) {
			long now = System.currentTimeMillis();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_hhmmss");
			String filename = sdf.format(now) + ".txt";
			// 내용을 저장할 파일경로 설정
			Path path = Paths.get(MEMO_DIR, filename);
			try {
			// 파일쓰기	
				Files.write(path, content.toString().getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("메모를 등록하였습니다");
		}
	
	}

	public void list() {

		File file = new File(MEMO_DIR);
		String[] list = file.list();

		for (String lists : list) {
			System.out.println(lists);
		}
		System.out.println("");
	}
	
	public void read(Scanner scanner) {

		String result = "";

		list(); 

		System.out.println("---파일 목록---");
		System.out.println("파일목록을 선택하세요 ");
		String name = scanner.nextLine();
		String filePath = MEMO_DIR.concat(name);

		File file = new File(filePath);
		if (file.exists()) {
			try (FileReader fr = new FileReader(file)) { 
			  int oneChar = 0; 
			  	while (true) {
			  		oneChar = fr.read();
			  	if (oneChar == -1) { 
						break; 
			  	} else {
						result = result + (char) oneChar; 
					}
				}
			  	System.out.println(result);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
				} else {
					System.out.println("파일이름을 잘못 입력하였습니다.");
		}

	
	}
	
		public void modify(Scanner scanner) {
		list(); 
			System.out.println("---파일 목록---");
			System.out.println("파일을 선택하세요");
		String name = scanner.nextLine(); 
		String filePath = MEMO_DIR.concat(name);
			File file = new File(filePath);
		if (!file.delete()) { 
			}
			System.out.println("수정 할 내용을 입력하세요");
			StringBuilder content = new StringBuilder();
		while (true) {
			String line = scanner.nextLine();
		if (line.equals(EXIT))
				break;
			else {
				content.append(line + "\r\n");
			}
		}
			if (!content.toString().equals("")) {
				Path path = Paths.get(filePath);
			try {
				Files.write(path, content.toString().getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("수정 저장 되었습니다");

	}

		public void remove(Scanner scanner) {
			list(); // 
			System.out.println("---파일 목록---");
			System.out.println("파일을 선택하세요 ");
			String name = scanner.nextLine(); 
			String filePath = MEMO_DIR.concat(name); 
		File file = new File(filePath);
			if (!file.delete()) { 
				System.out.println("다시 선택해주세요");
			} else {
				System.out.println("삭제완료");}
			list(); 

			
		}



}
