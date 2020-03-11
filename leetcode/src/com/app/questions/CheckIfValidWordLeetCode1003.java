package com.app.questions;

import java.util.Stack;

public class CheckIfValidWordLeetCode1003 {
	private static boolean checkIfValid(String str) {
		Stack<Character> stack = new Stack<>();
		char[] charArr = str.toCharArray();
		int n = charArr.length;

		for (int i = 0; i < n; i++) {
			if(charArr[i] == 'c') {
				if(stack.size() < 2)
					return false;
				char ch2 = stack.pop();
				char ch1 = stack.pop();
				if(ch1 != 'a' || ch2  != 'b')
					return false;
			} else {
				stack.push(charArr[i]);
			}
		}
		return stack.isEmpty() ? true : false;
	}

	public static void main(String[] args) {
		String str1 = "ababcc";
		
		System.out.println(checkIfValid(str1));
		
		str1 = "abcabcabc";
		
		System.out.println(checkIfValid(str1));
		
		str1 = "cababc";
		
		System.out.println(checkIfValid(str1));
	}

}
