package com.app.practice;

import java.util.Stack;

public class EvaluateReversePolishNotationLeetcode150 {
	private static boolean isDigit(String str) {
		try {
			int val = Integer.parseInt(str);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}

	private static int performOperation(int num1, int num2, String op) {
		if (op.equals("+"))
			return num1 + num2;
		else if (op.equals("-"))
			return num1 - num2;
		else if (op.equals("*"))
			return num1 * num2;
		else
			return num1 / num2;
	}

	private static int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<>();

		int n = tokens.length;
		for (int i = 0; i < n; i++) {
			if (isDigit(tokens[i])) {
				stack.push(Integer.parseInt(tokens[i]));
			} else {
				int num2 = stack.pop();
				int num1 = stack.pop();
				stack.push(performOperation(num1, num2, tokens[i]));
			}
		}
		return stack.pop();
	}

	public static void main(String[] args) {
		String[] tokens = { "2", "1", "+", "3", "*" };
		
		System.out.println(evalRPN(tokens));
		
		tokens = new String[] {"4", "13", "5", "/", "+"};
		
		System.out.println(evalRPN(tokens));
		
		tokens = new String[] {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
		
		System.out.println(evalRPN(tokens));
	}

}
