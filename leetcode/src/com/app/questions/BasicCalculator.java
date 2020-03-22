package com.app.questions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BasicCalculator {
	private static final char PLUS = '+';
	private static final char MINUS = '-';
	private static final char OPENING_PAR = '(';
	private static final char CLOSING_PAR = ')';

	
	public static int calculate(String str) {
		List<String> tokens = convertToTokens(str);
		if(tokens.size() == 1)
			return Integer.valueOf(tokens.get(0));
		else
			return evaluatePostfix(convertPostfix(tokens));
	}
	
	private static List<String> convertToTokens(String str) {
		int n = str.length();
		List<String> tokens = new ArrayList<>();
		for(int i = 0;i<n;i++) {
			char currentChar = str.charAt(i);
			if(currentChar == OPENING_PAR || currentChar == CLOSING_PAR || currentChar == PLUS
					|| currentChar == MINUS) {
				tokens.add(currentChar + "");
			} else {
				//if condition means current char is digit but previous one plus, minus, or parentheses
				if(tokens.size() == 0 || tokens.get(tokens.size() - 1).equals(OPENING_PAR + "") || tokens.get(tokens.size() - 1).equals(CLOSING_PAR + "")
						|| tokens.get(tokens.size() - 1).equals(PLUS + "") || tokens.get(tokens.size() - 1).equals(MINUS + "")) {
					tokens.add(currentChar + "");
				} else {
					//this means previous character was digit
					String prevToken = tokens.get(tokens.size() - 1);
					tokens.remove(tokens.size() - 1);
					tokens.add(prevToken + currentChar);
				}
			}
		}
		return tokens;
	}
	
	private static boolean isDigit(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch(NumberFormatException ex) {
			return false;
		}
	}

	private static List<String> convertPostfix(List<String> infixExpr) {
		int n = infixExpr.size();
		Stack<String> operatorStack = new Stack<>();
		List<String> res = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			String currentChar = infixExpr.get(i).trim();
			if (isDigit(currentChar)) {
				res.add(currentChar);
			} else if (currentChar.equals(PLUS + "") || currentChar.equals(MINUS + "")) {
				if (operatorStack.isEmpty() || operatorStack.peek().equals(OPENING_PAR + "")) {
					operatorStack.push(currentChar);
				} else if (operatorStack.peek().equals(PLUS + "") || operatorStack.peek().equals(MINUS + "")) {
					res.add(operatorStack.pop());
					operatorStack.push(currentChar);
				}
			} else if (currentChar.equals(CLOSING_PAR + "")) {
				while (!operatorStack.isEmpty() && !operatorStack.peek().equals(OPENING_PAR + "")) {
					res.add(operatorStack.pop());
				}
				operatorStack.pop();
			} else if (currentChar.equals(OPENING_PAR + "")) {
				operatorStack.push(OPENING_PAR + "");
			}

		}
		while (!operatorStack.isEmpty()) {
			res.add(operatorStack.pop());
		}
		return res;
	}

	private static int performOperation(int op1, int op2, String operator) {
		if (operator.equals(PLUS + ""))
			return op1 + op2;
		else
			return op1 - op2;
	}

	private static int evaluatePostfix(List<String> postFixExpr) {
		int n = postFixExpr.size();
		Stack<Integer> operandStack = new Stack<>();

		int res = 0;

		for (int i = 0; i < n; i++) {
			String currentChar = postFixExpr.get(i);
			if (isDigit(currentChar)) {
				operandStack.push(Integer.valueOf(currentChar));
			} else {
				int secondOp = operandStack.pop();
				int firstOp = operandStack.pop();
				operandStack.push(performOperation(firstOp, secondOp, currentChar));
			}
		}

		return operandStack.peek();
	}

	public static void main(String[] args) {
		String str = "(1+(4+5+2)-3)+(6+8)";

		System.out.println(calculate(str));
		
		str = "2-1 + 2 ";
		
		System.out.println(calculate(str));
		
		str = "2147483647";
		
		System.out.println(calculate(str));
		
		str = "1-11";
		
		System.out.println(calculate(str));

	}

}
