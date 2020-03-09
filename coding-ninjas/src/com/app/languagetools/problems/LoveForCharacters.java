package com.app.languagetools.problems;

import java.util.Scanner;

public class LoveForCharacters {
	private static int getIndex(char ch) {
		if(ch == 'a')
			return 0;
		else if(ch == 's')
			return 1;
		else if(ch == 'p')
			return 2;
		else
			return -1;
	}
	
	private static void printOutput(String str, int len) {
		int[] freq = new int[3];
		for(int i = 0;i<len;i++) {
			char ch = str.charAt(i);
			int indx = getIndex(ch);
			if(indx != -1) {
				freq[indx]++;
			}
		}
		
		for(int f: freq) {
			System.out.print(f + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nLen = Integer.parseInt(scanner.nextLine());
		String inputStr = scanner.nextLine();
		printOutput(inputStr, nLen);
		scanner.close();
	}

}
