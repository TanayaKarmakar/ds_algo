package com.app.stack.practice;

import java.util.Stack;

public class RemoveConsecutiveDuplicates {
	private static String removeDuplicates(String str) {
		Stack<Character> charStack = new Stack<>();

		int n = str.length();
		for (int i = 0; i < n; i++) {
			if (charStack.isEmpty() || charStack.peek() != str.charAt(i)) {
				charStack.push(str.charAt(i));
			}
		}

		StringBuilder sb = new StringBuilder();
		while (!charStack.isEmpty()) {
			sb.append(charStack.pop());
		}

		return sb.reverse().toString();
	}

	public static void main(String[] args) {
		String str = "aabbbcccc";

		System.out.println(removeDuplicates(str));
	}

}
