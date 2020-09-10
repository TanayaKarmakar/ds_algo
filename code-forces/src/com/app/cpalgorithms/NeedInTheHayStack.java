package com.app.cpalgorithms;

import java.util.Scanner;

public class NeedInTheHayStack {
	private static int[] getLps(String needle, int needleLen) {
		int[] lps = new int[needleLen];
		
		int i = 1;
		int j = 0;

		while(i < needleLen) {
			if(needle.charAt(i) == needle.charAt(j)) {
				lps[i] = j + 1;
				i++;
				j++;
			} else {
				if(j == 0)
					i++;
				else
					j = lps[j - 1];
			}
		}
		
		return lps;
	}
	
	private static void findNeedles(String needle, int needleLen, 
			String hayStack) {
		if(needleLen > hayStack.length())
			return;
		int[] lps = getLps(needle, needleLen);
		
		int hayStackLen = hayStack.length();
		
		int i = 0;
		int j = 0;
		
		while(i < hayStackLen && j < needleLen) {
			if(hayStack.charAt(i) == needle.charAt(j)) {
				i++;
				j++;
				if(j == needleLen) {
					System.out.println(i - needleLen);
					j = lps[j - 1];
				}
			} else {
				if(j == 0)
					i++;
				else
					j = lps[j - 1];
			}
		}
 	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int patLen = scanner.nextInt();
		String needle = scanner.next();
		String hayStack = scanner.next();
		
		findNeedles(needle, patLen, hayStack);
		
		scanner.close();
	}

}
