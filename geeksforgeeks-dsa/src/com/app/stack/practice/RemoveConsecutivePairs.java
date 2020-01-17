package com.app.stack.practice;

import java.util.Stack;

public class RemoveConsecutivePairs {
	private static String removeDuplicatePairs(String str) {
		Stack<Character> charStack = new Stack<>();

		int n = str.length();

		for(int i = 0;i<n;i++) {
			if(charStack.isEmpty()) {
				charStack.push(str.charAt(i));
			} else {
				if(str.charAt(i) != charStack.peek()) {
					charStack.push(str.charAt(i));
				} else {
					charStack.pop();
				}
			}
		}

		if (charStack.isEmpty())
			return "Empty String";
		StringBuilder sb = new StringBuilder();
		while (!charStack.isEmpty()) {
			sb.append(charStack.pop());
		}

		return sb.reverse().toString();
	}

	public static void main(String[] args) {
		String str = "aaabbaaccd";
		System.out.println(removeDuplicatePairs(str));

		str = "aaaa";
		System.out.println(removeDuplicatePairs(str));
	}

}
