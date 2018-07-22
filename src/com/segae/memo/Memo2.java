package com.segae.memo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Memo2 {

	public static final String EXIT = "/exit";
	public String read(String filepath) {
		 
		String result = "";
		String newLine = "";
		StringBuilder content = new StringBuilder();
		
		Path path = Paths.get(filepath);
		try{
			
			List<String> lines = Files.readAllLines(path);
			 
			for(String line : lines) {
				result += line + "\r\n";
			}						
			Scanner scanner = new Scanner(System.in);
			
			while(true) {		
				newLine = scanner.nextLine();
				if(newLine.equals(EXIT)) {
					break;
				}else {		
					content.append(newLine + "\r\n");
								} 
			}						
			result += content.toString();			
			
			Files.write(path, result.getBytes());		
			}catch(Exception e) {
			e.printStackTrace();
		}		
		return result;
	} 
}

