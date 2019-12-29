package com.app.string.practice;

import java.util.Arrays;

public class MinimumIndexedCharacter {
	private static int minIndexedChar(String txt, String patt) {
		int n = txt.length();
		
		int[] charIndx = new int[256];
		Arrays.fill(charIndx, -1);
		
		for(int i = 0;i<n;i++) {
			if(charIndx[txt.charAt(i)] == -1) {
				charIndx[txt.charAt(i)] = i;
			}	
		}
		
		int res = Integer.MAX_VALUE;
		for(int i = 0;i<patt.length();i++) {
			char ch = patt.charAt(i);
			if(charIndx[ch] >= 0) {
				res = Integer.min(res, charIndx[ch]);
			}
		}
		
		if(res == Integer.MAX_VALUE)
			res = -1;
		return res;
	}

	public static void main(String[] args) {
		String str1 = "geeksforgeeks";
		String str2 = "set";
		
		System.out.println("Min Index - " + minIndexedChar(str1, str2));
		
		str1 = "adcffaet";
		str2 = "onkl";
		
		System.out.println("Min Index - " + minIndexedChar(str1, str2));
		
		str1 = "laacbjfedrkwollbhfqfvkvpndxetrvetvgvenb";
		str2 = "jflhvzuwgconxaionnnugfpky";
		
		System.out.println("Min Index - " + minIndexedChar(str1, str2));
	}

}
