package com.app.questions;

import java.util.Stack;

public class EvaluateReversePolishNotationLeetcode150 {
	private static final String ADDITION = "+";
	private static final String SUBTRACTION = "-";
	private static final String MULTIPLICATION = "*";
	private static final String DIVISION = "/";

	private static int performOperation(int operand1, int operand2, String operator) {
		int result = Integer.MAX_VALUE;
		switch (operator) {
		case ADDITION:
			result = operand1 + operand2;
			break;
		case SUBTRACTION:
			result = operand1 - operand2;
			break;
		case MULTIPLICATION:
			result = operand1 * operand2;
			break;
		case DIVISION:
			result = operand1 / operand2;
			break;
		}
		return result;
	}

	private static boolean isDigit(String token) {
		try {
			int val = Integer.parseInt(token);
			return true;
		} catch (NumberFormatException ex) {
			return false;
		}
	}

	private static int evalRPN(String[] tokens) {
		if (tokens.length == 1) {
			return Integer.parseInt(tokens[0]);
		}
		Stack<Integer> stack = new Stack<>();
		for (String token : tokens) {
			if (isDigit(token)) {
				stack.push(Integer.parseInt(token));
			} else {
				int op2 = stack.pop();
				int op1 = stack.pop();
				stack.push(performOperation(op1, op2, token));
			}
		}
		return stack.pop();
	}

	public static void main(String[] args) {
		System.out.println("Result - " + evalRPN(new String[] {"2", "1", "+", "3", "*"}));

	}

}
