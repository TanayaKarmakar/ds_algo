package com.app.questions.stack;

import java.util.Stack;

public class BaseballGameLeetcode682 {

	private static boolean isDigit(String str) {
		try {
			int el = Integer.parseInt(str);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}

	private static int calPoints(String[] ops) {
		int n = ops.length;
		Stack<Integer> stack = new Stack<>();
		int sum = 0;

		for (int i = 0; i < n; i++) {
			if (isDigit(ops[i])) {
				int num = Integer.parseInt(ops[i]);
				stack.push(num);
				sum += num;
			} else if (ops[i].equals("C")) {
				int el = stack.pop();
				sum -= el;
			} else if (ops[i].equals("D")) {
				int item = stack.peek() * 2;
				sum += item;
				stack.push(item);
			} else if (ops[i].equals("+")) {
				int n2 = stack.pop();
				int n1 = stack.pop();
				int total = n1 + n2;
				stack.push(n1);
				stack.push(n2);
				stack.push(total);
				sum += total;
			}
		}

		return sum;
	}

	public static void main(String[] args) {
		String[] ops = { "5", "2", "C", "D", "+" };

		int sum = calPoints(ops);

		System.out.println(sum);

	}

}
