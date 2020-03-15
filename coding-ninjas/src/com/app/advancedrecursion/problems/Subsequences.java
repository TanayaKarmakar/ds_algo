package com.app.advancedrecursion.problems;

public class Subsequences {
	private static int getSubsequences(String str, String[] res) {
		if(str.length() == 0) {
			res[0] = "";
			return 1;
		}
		String smallString = str.substring(1);
		int len = getSubsequences(smallString, res);
		for(int i = 0; i < len;i++) {
			res[i + len] = str.charAt(0) + res[i];
		}
		return 2 * len;
	}

	private static int getDimension(int len) {
		return (int)Math.pow(2, len);
	}
	
	public static void main(String[] args) {
		String str = "abc";
		String[] res = new String[getDimension(str.length())];
		int len = getSubsequences(str, res);
		for(String el: res) {
			System.out.println(el);
		}
	}

}
