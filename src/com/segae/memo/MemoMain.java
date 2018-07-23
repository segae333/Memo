package com.segae.memo;

import java.util.Scanner;

public class MemoMain {

	public static void main(String[] args) {

		Memo memo = new Memo();
		
		
		Scanner scanner = new Scanner(System.in);
		boolean runFlag =true;
		
		while(runFlag) {
			memo.showCommand();
			String command = scanner.nextLine();
		
		switch(command) {
		case"1": 
			memo.write(scanner);
			break;
		case"2":
			memo.read(scanner);
			break;
		case"3":
			memo.modify(scanner);
			break;
		case"4":
			memo.remove(scanner);
			break;
		case"0":
			runFlag = false ; 
			break;
			default : 
				System.out.println("명령어가 잘못 되었습니다");
			}
		}
		System.out.println("프로그램이 종료 되었습니다");
		
	}
	
}
