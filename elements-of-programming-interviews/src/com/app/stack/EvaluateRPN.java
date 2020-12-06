package com.app.stack;

import java.util.Stack;

public class EvaluateRPN {
	private static boolean isDigit(String el) {
		try {
			int num = Integer.parseInt(el);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}

	private static int performOperation(int n1, int n2, String op) {
		switch (op) {
		case "+":
			return n1 + n2;
		case "-":
			return n1 - n2;
		case "x":
			return n1 * n2;
		case "/":
			return n1 / n2;
		}
		return 0;
	}

	private static int evalRPN(String rpnExpr) {
		String[] exprs = rpnExpr.split(",");

		Stack<Integer> stack = new Stack<>();
		int n = exprs.length;

		for (int i = 0; i < n; i++) {
			if (isDigit(exprs[i])) {
				stack.push(Integer.parseInt(exprs[i]));
			} else {
				int n2 = stack.pop();
				int n1 = stack.pop();
				int result = performOperation(n1, n2, exprs[i]);
				stack.push(result);
			}
		}

		return stack.pop();
	}

	public static void main(String[] args) {
		String rpnExpr = "3,4,+,2,x,1,+";

		int ans = evalRPN(rpnExpr);
		
		System.out.println(ans);

	}

}
