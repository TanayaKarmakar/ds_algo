package com.app.questions.practice;

import java.util.Stack;

public class EvaluateReversePolishNotationLeetCode150 {
	private static final String PLUS = "+";
	private static final String MINUS = "-";
	private static final String MUL = "*";
	private static final String DIV = "/";

	private static boolean isDigit(String token) {
		try {
			int el = Integer.parseInt(token);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}

	private static int performOperation(int el1, int el2, String op) {
		if (op.equals(PLUS))
			return el1 + el2;
		else if (op.equals(MINUS))
			return el1 - el2;
		else if (op.equals(MUL))
			return el1 * el2;
		else
			return el1 / el2;
	}

	private static int evaluateRPN(String[] tokens) {
		if (tokens.length == 0)
			return 0;
		Stack<Integer> stack = new Stack<Integer>();
		int n = tokens.length;
		int i = 0;
		while (i < n) {
			if (isDigit(tokens[i])) {
				stack.push(Integer.parseInt(tokens[i]));
			} else {
				int el2 = stack.pop();
				int el1 = stack.pop();
				stack.push(performOperation(el1, el2, tokens[i]));
			}
			i++;
		}

		return stack.pop();
	}

	public static void main(String[] args) {
		System.out.println(evaluateRPN(new String[] { "2", "1", "+", "3", "*" }));
		System.out.println(evaluateRPN(new String[] { "4", "13", "5", "/", "+" }));
		System.out.println(
				evaluateRPN(new String[] { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" }));
	}

}
