package com.app.string.practice;

public class DistinctPatternSearch {
	private static boolean search(String pat, String txt) {
		int patLen = pat.length();
		int start = 0;
		
		while(start + patLen <= txt.length()) {
			if(txt.substring(start, start + patLen).equals(pat)) {
				return true;
			}
			start++;
		}
		
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String txt = "abceabcfabceabcd";
		String pattern = "abcd";
		
		System.out.println(search(pattern, txt));
	}

}
