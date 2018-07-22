package com.segae.memo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Memo {
	
	public static final String MEMO_DIR = "/temp/memo/";

	//종료 커맨드를 상수로 정의 
	public static final String EXIT = "/exit";
	
	//생성장에서 메모를 저장할 디렉토리를 생성해준다.
	public Memo() {
		File dir = new File(MEMO_DIR);
		if(!dir.exists()) {
			dir.mkdirs();
		}
	}

	// 1 . 명령어를 출력하는 함수
	public void showCommand() {
		System.out.println("아래 명령 번호를 입력하세요---");
		System.out.println("1. 쓰기. 2. 읽기. 3. 수정. 4. 삭제. 0. 프로그램종료.");
	}

	// 쓰기
	public void write(Scanner scanner) {
		System.out.println("--- 쓰기 모드---");
		//전체글을 저장할 변수
		StringBuilder content = new StringBuilder();
		
		// 키보드 입력을 받아야 한다. 
		while(true) {
			String line = scanner.nextLine();
			if(line.equals(EXIT)) {
				break;
			}else {		
				content.append(line + "\r\n");
			}
		}
		//작성한 내용이 있으면 파일로 쓴다.
		if(!content.toString().equals("")) {
			//가. 현재 시간 가져와서 파일명으로 만든다.
			long now = System.currentTimeMillis();
			//나. 년월일_시분초.txt 파일로 포맷팅
			SimpleDateFormat sdf = new SimpleDateFormat("yyyMMdd_hhmmss");
			String filename = sdf.format(now) + ".txt";
			//다. 내용을 저장할 파일경로 설정
			Path path = Paths.get(MEMO_DIR, filename);
			try {
			//라. 파일쓰기
			Files.write(path, content.toString().getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("메모를 등록하였습니다.");
			}
	}
	
	// 파일 목록 보기
	public void list() {
		File file = new File(MEMO_DIR);
		String fileList[] = file.list();
		for(String filename : fileList) {
			System.out.println(filename);
		}
	}

	public void remove() {
		File file = new File(MEMO_DIR);
		
		if( file.exists()) {
	    String[] fileList = file.list();        
	    for(int i=0; i<fileList.length; i++) {
	    	   System.out.println(fileList[i]); 
	            File tempFile= new File(MEMO_DIR +"\\"+ fileList[i]); 
	           tempFile.delete(); 
	    	}    
	    }       
	}	    
}  
