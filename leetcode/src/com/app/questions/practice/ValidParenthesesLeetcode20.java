package com.app.questions.practice;

import java.util.Stack;

public class ValidParenthesesLeetcode20 {
	private static final char OPEN_PARENTHESIS = '(';
	private static final char CLOSE_PARENTHESIS = ')';
	private static final char OPEN_CURLY_BRACES = '{';
	private static final char CLOSE_CURLY_BRACES = '}';
	private static final char OPEN_SQUARE_BRACKETS = '[';
	private static final char CLOSE_SQUARE_BRACKETS = ']';

	private static boolean isValidMatch(char currentChar, char topChar) {
		return (currentChar == CLOSE_PARENTHESIS && topChar == OPEN_PARENTHESIS)
				|| (currentChar == CLOSE_CURLY_BRACES && topChar == OPEN_CURLY_BRACES)
				|| (currentChar == CLOSE_SQUARE_BRACKETS && topChar == OPEN_SQUARE_BRACKETS);
	}

	private static boolean isValidParentheses(String str) {
		Stack<Character> stack = new Stack<>();
		int n = str.length();

		for (int i = 0; i < n; i++) {
			char ch = str.charAt(i);
			if (ch == OPEN_PARENTHESIS || ch == OPEN_CURLY_BRACES || ch == OPEN_SQUARE_BRACKETS) {
				stack.push(ch);
			} else {
				if(stack.isEmpty())
					return false;
				if (isValidMatch(ch, stack.peek())) {
					stack.pop();
				} else {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		
		System.out.println(isValidParentheses("()"));
		System.out.println(isValidParentheses("(){}[]"));
		System.out.println(isValidParentheses("(]"));
		System.out.println(isValidParentheses("([)]"));
		System.out.println(isValidParentheses("{[]}"));
	}

}
