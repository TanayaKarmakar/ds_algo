package com.app.practice.strings;

import java.util.Scanner;

public class IsomorphicStringsLeetcode205 {
	private static boolean isIsomorphic(String s, String t) {
		if(s.length() != t.length())
			return false;
		int[] sIndx = new int[256];
		int[] tIndx = new int[256];
		int[] sFreq = new int[256];
		int[] tFreq = new int[256];
		
		int n = s.length();
		
		for(int i = 0; i < n; i++) {
			sFreq[s.charAt(i)]++;
			tFreq[t.charAt(i)]++;
			
			sIndx[s.charAt(i)] = i;
			tIndx[t.charAt(i)] = i;
		}
		
		for(int i = 0; i < n; i++) {
			char sCharVal = s.charAt(i);
			char tCharVal = t.charAt(i);
			
			if(sFreq[sCharVal] != tFreq[tCharVal] 
					|| sIndx[sCharVal] != tIndx[tCharVal])
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String s = scanner.next();
		String t = scanner.next();
		
		boolean ans = isIsomorphic(s, t);
		
		System.out.println(ans);
		
		scanner.close();

	}

}
