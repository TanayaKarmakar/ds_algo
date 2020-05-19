package com.app.questions.slidingwindow;

import java.util.Scanner;

public class CountOccurencesOfAnagramGeeksforGeeks {
	private static boolean isEqual(int[] pFreq, int[] sFreq) {
		for(int i = 0; i < 26; i++) {
			if(pFreq[i] != sFreq[i])
				return false;
		}
		return true;
	}
	
	private static int countOccurences(String str, String pattern) {
		int[] pFreq = new int[26];
		int[] sFreq = new int[26];
		
		int windowSize = pattern.length();
		int n = str.length();
		int l = 0;
		int r = 0;
		while(r < windowSize) {
			int pChar = pattern.charAt(r) - 'a';
			int sChar = str.charAt(r) - 'a';
			pFreq[pChar]++;
			sFreq[sChar]++;
			r++;
		}
		
		int count = 0;
		while(r < n) {
			if(isEqual(pFreq, sFreq))
				count++;
			sFreq[str.charAt(r) - 'a']++;
			sFreq[str.charAt(l) - 'a']--;
			l++;
			r++;
		}
		if(isEqual(pFreq, sFreq))
			count++;
		return count;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nTestCases = scanner.nextInt();
		while(nTestCases-- > 0) {
			String str = scanner.next();
			String pattern = scanner.next();
			
			System.out.println(countOccurences(str, pattern));
		}
		scanner.close();
	}

}
