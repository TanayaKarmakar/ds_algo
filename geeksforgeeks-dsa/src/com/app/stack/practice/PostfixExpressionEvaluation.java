package com.app.stack.practice;

import java.util.Stack;

public class PostfixExpressionEvaluation {
	private static int performOperation(int num1, int num2, char operator) {
		if (operator == '+')
			return num1 + num2;
		else if (operator == '-')
			return num1 - num2;
		else if (operator == '*')
			return num1 * num2;
		else
			return num1 / num2;
	}

	private static int evaluatePostfixExpression(String postfixExpr) {
		int n = postfixExpr.length();
		Stack<Integer> operandStack = new Stack<>();

		for (int i = 0; i < n; i++) {
			char currentChar = postfixExpr.charAt(i);
			if (Character.isDigit(currentChar)) {
				operandStack.push(Integer.parseInt(String.valueOf(currentChar)));
			} else {
				int secondOperand = operandStack.pop();
				int firstOperand = operandStack.pop();
				operandStack.push(performOperation(firstOperand, secondOperand, currentChar));
			}
		}

		return operandStack.pop();
	}

	public static void main(String[] args) {
		String str = "231*+9-";
		
		System.out.println("Result = " + evaluatePostfixExpression(str));

		str = "123+*8-";
		
		System.out.println("Result = " + evaluatePostfixExpression(str));
	}

}
