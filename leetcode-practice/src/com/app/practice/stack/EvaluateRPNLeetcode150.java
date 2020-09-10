package com.app.practice.stack;

import java.util.Stack;

public class EvaluateRPNLeetcode150 {
	private static boolean isDigit(String str) {
		try {
			int num = Integer.parseInt(str);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}

	private static int performOperation(int num1, int num2, String op) {
		int result = 0;
		switch (op) {
		case "+":
			result = num1 + num2;
			break;
		case "-":
			result = num1 - num2;
			break;
		case "*":
			result = num1 * num2;
			break;
		case "/":
			result = num1 / num2;
			break;
		}
		return result;
	}

	private static int evalRPN(String[] tokens) {
		if (tokens.length == 0)
			return 0;
		if (tokens.length == 1) {
			int num = Integer.parseInt(tokens[0].trim());
			return num;
		}
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < tokens.length; i++) {
			if (isDigit(tokens[i])) {
				stack.push(Integer.parseInt(tokens[i].trim()));
			} else {
				if (stack.isEmpty())
					return 0;
				int num2 = stack.pop();
				int num1 = stack.pop();
				int result = performOperation(num1, num2, tokens[i]);
				stack.push(result);
			}
		}

		return stack.peek();
	}

	public static void main(String[] args) {
		String[] strs = { "2", "1", "+", "3", "*" };
		int ans = evalRPN(strs);

		System.out.println(ans);
	}

}
