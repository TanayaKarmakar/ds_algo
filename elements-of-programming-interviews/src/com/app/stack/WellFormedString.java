package com.app.stack;

import java.util.Stack;

public class WellFormedString {
	private static final Character OPEN_PAR1 = '(';
	private static final Character CLOSE_PAR1 = ')';
	private static final Character OPEN_PAR2 = '{';
	private static final Character CLOSE_PAR2 = '}';
	private static final Character OPEN_PAR3 = '[';
	private static final Character CLOSE_PAR3 = ']';

	private static boolean isValid(char topChar, char currentChar) {
		return (topChar == OPEN_PAR1 && currentChar == CLOSE_PAR1)
				|| (topChar == OPEN_PAR2 && currentChar == CLOSE_PAR2)
				|| (topChar == OPEN_PAR3 && currentChar == CLOSE_PAR3);
	}

	private static boolean wellFormed(String exprStr) {
		int n = exprStr.length();

		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < n; i++) {
			char ch = exprStr.charAt(i);
			if (ch == CLOSE_PAR1 || ch == CLOSE_PAR2 || ch == CLOSE_PAR3) {
				if (stack.isEmpty())
					return false;
				char topCh = stack.pop();
				if (!isValid(topCh, ch))
					return false;
			} else {
				stack.push(ch);
			}
		}

		return true;
	}

	public static void main(String[] args) {
		String inputStr = "[()[]{()()}]";
		
		boolean ans = wellFormed(inputStr);
		
		System.out.println(ans);
	}

}
