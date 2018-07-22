package com.segae.memo;

import java.util.Scanner;

public class MemoMain {

	public static void main(String[] args) {
		
		// 1. 키보드 입력으로 명령어를 받는다. 
		// + 프로그램 시작 하면 명령어 번호를 보여준다. 
		// + 1. 쓰기 2. 읽기 3. 수정 4. 삭제 
		Memo memo = new Memo();
		memo.showCommand();
		
		Memo2 memo2 = new Memo2();
		
		Scanner scanner = new Scanner(System.in);
		
		boolean runFlag = true;
		
		while(runFlag) {
		String cmd = scanner.nextLine();
	
		switch(cmd) {
			case "1" : // 쓰기
				memo.write(scanner);
				break;
			case "2" :
				memo.list();
				break;
			case "3" :
				//memo.rewrite();
				memo2.read("C:\\Temp\\memo\\20180721_090702.txt");
				break;
			case "4" :
				memo.remove();
				break;
			case "0" :
				runFlag = false;				
				break;
			default : 
				System.out.println("명령어가 잘못되었습니다 !");
		}
		}
		
		System.out.println("프로그램이 종료되었습니다!");
	}

}
