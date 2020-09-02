package com.app.practice.stack;

import java.util.Stack;

public class EvaluateReversePolishNotationLeetcode150 {
	private static final String ADDITION = "+";
	private static final String SUBTRACTION = "-";
	private static final String MULTIPLICATION = "*";
	private static final String DIVISION = "/";

	private static boolean isDigit(String val) {
		try {
			int iVal = Integer.parseInt(val);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}

	private static int performOperation(int num1, int num2, String op) {
		if (op.equals(ADDITION))
			return (num1 + num2);
		else if (op.equals(SUBTRACTION))
			return (num1 - num2);
		else if (op.equals(MULTIPLICATION))
			return (num1 * num2);
		else
			return (num1 / num2);
	}

	private static int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<>();
		int n = tokens.length;
		for (int i = 0; i < n; i++) {
			if (isDigit(tokens[i])) {
				stack.push(Integer.parseInt(tokens[i]));
			} else {
				if (!stack.isEmpty()) {
					int num2 = stack.pop();
					int num1 = stack.pop();
					int result = performOperation(num1, num2, tokens[i]);
					stack.push(result);
				}
			}
		}

		return stack.pop();
	}

	public static void main(String[] args) {
		String[] strs = { "2", "1", "+", "3", "*" };
		int val = evalRPN(strs);

		System.out.println(val);

		strs = new String[] { "4", "13", "5", "/", "+" };

		val = evalRPN(strs);

		System.out.println(val);

		strs = new String[] { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" };
	
		val = evalRPN(strs);

		System.out.println(val);
	}

}
