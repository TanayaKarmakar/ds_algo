package com.app.questions;

import java.util.Stack;

public class ValidParenthesis {
	private static final char OPENING_PARENTHESIS = '(';
	private static final char CLOSING_PARENTHESIS = ')';
	private static final char OPENING_CURLY_BRACES = '{';
	private static final char CLOSING_CURLY_BRACES = '}';
	private static final char OPENING_SQUARE_BRACKETS = '[';
	private static final char CLOSING_SQUARE_BRACKETS = ']';

	private static boolean matching(char currentChar, char topChar) {
		return (currentChar == CLOSING_PARENTHESIS && topChar == OPENING_PARENTHESIS)
				|| (currentChar == CLOSING_CURLY_BRACES && topChar == OPENING_CURLY_BRACES)
				|| (currentChar == CLOSING_SQUARE_BRACKETS && topChar == OPENING_SQUARE_BRACKETS);
	}

	private static boolean isValid(String str) {
		Stack<Character> charStack = new Stack<>();
		int n = str.length();

		for (int i = 0; i < n; i++) {
			char currentChar = str.charAt(i);
			if (currentChar == CLOSING_PARENTHESIS || currentChar == CLOSING_CURLY_BRACES
					|| currentChar == CLOSING_SQUARE_BRACKETS) {
				if (charStack.isEmpty())
					return false;
				else if (!matching(currentChar, charStack.pop()))
					return false;
			} else {
				charStack.push(currentChar);
			}

		}

		return charStack.isEmpty();
	}

	public static void main(String[] args) {
		String str = "()";
		
		System.out.println(isValid(str));
		
		str = "([)]";
		
		System.out.println(isValid(str));
	}

}
