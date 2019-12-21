package com.app.string.classroom;

import java.util.Arrays;

public class LeftMostOccurenceOfRepeatingChar {
	//TBD
	private static int leftMostOccuringIndexEfficient(String str) {
		int[] freqArr = new int[256];

		int n = str.length();
		int res = Integer.MAX_VALUE;
		Arrays.fill(freqArr, -1);
		for (int i = n - 1; i >= 0; i--) {
			if (freqArr[str.charAt(i)] == -1)
				freqArr[str.charAt(i)] = i;
			else
				res = i;
		}
		return (res == Integer.MAX_VALUE) ? -1 : res;
	}

	private static int leftMostOccuringIndex(String str) {
		int[] freqArr = new int[256];

		int n = str.length();
		int res = Integer.MAX_VALUE;
		Arrays.fill(freqArr, -1);
		for (int i = 0; i < n; i++) {
			if (freqArr[str.charAt(i)] == -1) {
				freqArr[str.charAt(i)] = i;
			} else {
				res = Integer.min(res, freqArr[str.charAt(i)]);
			}
		}

		return (res == Integer.MAX_VALUE) ? -1 : res;
	}

	public static void main(String[] args) {
		System.out.println(
				"Leftmost Occurence of " + "First Repeating character - " + leftMostOccuringIndex("geeksforgeeks"));

		System.out.println("Leftmost Occurence of " + "First Repeating character Efficient - "
				+ leftMostOccuringIndexEfficient("geeksforgeeks"));

		System.out.println("Leftmost Occurence of " + "First Repeating character - "
				+ leftMostOccuringIndex("fullstack developement"));

		System.out.println("Leftmost Occurence of " + "First Repeating character Efficient - "
				+ leftMostOccuringIndexEfficient("fullstack development"));
		
		System.out.println("Leftmost Occurence of " + "First Repeating character - "
				+ leftMostOccuringIndex("oitikaka"));
		
		System.out.println("Leftmost Occurence of " + "First Repeating character Efficient - "
				+ leftMostOccuringIndexEfficient("oitikaka"));
	}

}
