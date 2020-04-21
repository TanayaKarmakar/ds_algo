package com.app.questions.practice;

import java.util.Arrays;

public class ReverseStringLeetcode344 {
	private static void reverseString(char[] s) {
		int start = 0;
		int end = s.length - 1;

		while (start <= end) {
			char tmp = s[start];
			s[start] = s[end];
			s[end] = tmp;
			start++;
			end--;
		}
	}

	public static void main(String[] args) {
		char[] input = { 'h', 'e', 'l', 'l', 'o' };
		
		reverseString(input);
		
		System.out.println(Arrays.toString(input));

	}

}
