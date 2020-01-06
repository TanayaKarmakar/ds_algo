package com.app.stack.classroom;

import java.util.Stack;

public class BalancedParenthesis {
	private static final char OPENING_SQUARE_BRACKET = '[';
	private static final char CLOSING_SQUARE_BRACKET = ']';
	private static final char OPENING_CURLY_BRACES = '{';
	private static final char CLOSING_CURLY_BRACES = '}';
	private static final char OPENING_PARENTHESIS = '(';
	private static final char CLOSING_PARENTHESIS = ')';
	
	private static boolean isMatching(char currentChar, char topChar) {
		return ((currentChar == CLOSING_SQUARE_BRACKET && topChar == OPENING_SQUARE_BRACKET)
				|| (currentChar == CLOSING_CURLY_BRACES && topChar == OPENING_CURLY_BRACES)
				|| (currentChar == CLOSING_PARENTHESIS && topChar == OPENING_PARENTHESIS));
	}

	private static boolean isBalanced(String expr) {
		Stack<Character> exprStack = new Stack<>();
		int n = expr.length();
		for (int i = 0; i < n; i++) {
			char ch = expr.charAt(i);
			if (ch == CLOSING_SQUARE_BRACKET || ch == CLOSING_CURLY_BRACES 
					|| ch == CLOSING_PARENTHESIS) {
				if (exprStack.isEmpty())
					return false;
				else {
					char topChar = exprStack.pop();
					if(!isMatching(ch, topChar))
						return false;
				}
			} else {
				if(ch != ' ') {
					exprStack.push(ch);
				}
			}
		}

		return exprStack.isEmpty();
	}

	public static void main(String[] args) {
		String str = "((()))";
		
		System.out.println("Is Balanced - " + isBalanced(str));
		
		str = "[{]}";
		
		System.out.println("Is Balanced - " + isBalanced(str));
		
		str = "{}[()]";
		
		System.out.println("Is Balanced - " + isBalanced(str));
		
		str = "((())";
		
		System.out.println("Is Balanced - " + isBalanced(str));
	}

}
