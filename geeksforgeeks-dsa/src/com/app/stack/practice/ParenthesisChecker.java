package com.app.stack.practice;

import java.util.Stack;

public class ParenthesisChecker {
	private static final char OPEN_PAR = '(';
	private static final char CLOSING_PAR = ')';
	private static final char OPEN_BRACES = '{';
	private static final char CLOSE_BRACES = '}';
	private static final char OPEN_SQ_BRACES = '[';
	private static final char CLOSE_SQ_BRACES = ']';
	
	
	private static boolean isMatching(char currentChar, char topChar) {
		return (currentChar == CLOSING_PAR && topChar == OPEN_PAR)
				|| (currentChar == CLOSE_BRACES && topChar == OPEN_BRACES)
				|| (currentChar == CLOSE_SQ_BRACES && topChar == OPEN_SQ_BRACES);
	}
	private static boolean isPar(String str) {
		Stack<Character> charStack = new Stack<>();
		int n = str.length();

		for (int i = 0; i < n; i++) {
			if(str.charAt(i) == CLOSING_PAR || str.charAt(i) == CLOSE_BRACES 
					|| str.charAt(i) == CLOSE_SQ_BRACES) {
				if(charStack.isEmpty())
					return false;
				if(!isMatching(str.charAt(i), charStack.pop()))
					return false;
			} else {
				charStack.push(str.charAt(i));
			}
		}
		
		return charStack.isEmpty();
	}

	public static void main(String[] args) {
		String str = "{([])}";
		
		System.out.println("Balanced - " + isPar(str));
		
		str = "()";
		
		System.out.println("Balanced - " + isPar(str));
		
		str = "({}";
		
		System.out.println("Balanced - " + isPar(str));

	}

}
