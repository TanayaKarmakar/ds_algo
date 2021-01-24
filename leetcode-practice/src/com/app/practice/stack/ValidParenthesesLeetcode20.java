package com.app.practice.stack;

import java.util.Stack;

public class ValidParenthesesLeetcode20 {
	private static final char OPEN_PAREN = '(';
	private static final char CLOSED_PAREN = ')';
	private static final char OPEN_BRACE = '{';
	private static final char CLOSED_BRACE = '}';
	private static final char OPEN_SQUARE = '[';
	private static final char CLOSED_SQUARE = ']';

	private static boolean isValid(char topChar, char currentChar) {
		return (currentChar == CLOSED_PAREN && topChar == OPEN_PAREN)
				|| (currentChar == CLOSED_BRACE && topChar == OPEN_BRACE)
				|| (currentChar == CLOSED_SQUARE && topChar == OPEN_SQUARE);
	}

	private static boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == CLOSED_PAREN || s.charAt(i) == CLOSED_BRACE || s.charAt(i) == CLOSED_SQUARE) {
				if (stack.isEmpty() || !isValid(stack.peek(), s.charAt(i)))
					return false;
				stack.pop();
			} else {
				stack.push(s.charAt(i));
			}
		}

		return stack.isEmpty();
	}

	public static void main(String[] args) {
		System.out.println(isValid("()"));
		System.out.println(isValid("(){}[]"));
		System.out.println(isValid("(]"));
	}

}
