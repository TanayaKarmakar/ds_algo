package com.app.string.practice;

public class NaivePatternSearch {
	private static boolean search(String txt, String pattern) {
		return txt.indexOf(pattern) >= 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String txt = "aabaacaadaabaaabaa";
		String pattern = "aaba";
		
		System.out.println(search(txt, pattern));
		
		txt = "aabaacaadaabaaabaa";
		pattern = "ccda";
		
		System.out.println(search(txt, pattern));
	}

}
