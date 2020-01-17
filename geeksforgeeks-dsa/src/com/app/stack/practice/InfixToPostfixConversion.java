package com.app.stack.practice;

import java.util.Stack;

public class InfixToPostfixConversion {
	private static final int PREC_1 = 1;
	private static final int PREC_2 = 2;
	private static final int PREC_3 = 3;
	private static final char OPENING_PARENTHESIS = '(';
	private static final char CLOSING_PARENTHESIS = ')';

	private static int getPrecedence(char op) {
		if (op == '+' || op == '-')
			return PREC_1;
		else if (op == '*' || op == '/')
			return PREC_2;
		else if (op == '^')
			return PREC_3;
		else
			return -1;
	}

	private static boolean isAlpha(char ch) {
		return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
	}

	private static String convertToPostfix(String infixExpr) {
		Stack<Character> operatorStack = new Stack<>();

		int n = infixExpr.length();

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n; i++) {
			char currentChar = infixExpr.charAt(i);
			if (isAlpha(currentChar)) {
				sb.append(currentChar);
			} else {
				if (currentChar == OPENING_PARENTHESIS) {
					operatorStack.push(OPENING_PARENTHESIS);
				} else if (currentChar == CLOSING_PARENTHESIS) {
					while (operatorStack.peek() != OPENING_PARENTHESIS) {
						sb.append(operatorStack.pop());
					}
					operatorStack.pop();
				} else {
					if (operatorStack.isEmpty()) {
						operatorStack.push(currentChar);
					} else {
						int currentCharPrec = getPrecedence(currentChar);
						while (!operatorStack.isEmpty() && getPrecedence(operatorStack.peek()) >= currentCharPrec) {
							sb.append(operatorStack.pop());
						}
						operatorStack.push(currentChar);
					}
				}
			}
		}

		while (!operatorStack.isEmpty()) {
			sb.append(operatorStack.pop());
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String str = "a+b*(c^d-e)^(f+g*h)-i";

		System.out.println("Infix to Postfix - " + convertToPostfix(str));

		str = "A*(B+C)/D";

		System.out.println("Infix to Postfix - " + convertToPostfix(str));
	}

}
