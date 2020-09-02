package com.app.practice.stack;

import java.util.LinkedList;
import java.util.Queue;

public class BasicCalculatorLeetcode224 {
	private static int calculate(String str) {
		Queue<Character> q = new LinkedList<>();

		int n = str.length();
		int i = 0;
		while (i < n) {
			if (str.charAt(i) != ' ') {
				q.add(str.charAt(i));
			}
			i++;
		}
		q.add(' ');
		return helper(q);
	}

	private static int helper(Queue<Character> q) {
		int num = 0;
		int prev = 0;
		int sum = 0;
		char prevOp = '+';
		while (!q.isEmpty()) {
			char ch = q.poll();
			if (ch == '(')
				num = helper(q);
			else if (Character.isDigit(ch)) {
				num = num * 10 + (ch - '0');
			} else {
				switch (prevOp) {
				case '+':
					sum += prev;
					prev = num;
					break;
				case '-':
					sum += prev;
					prev = -num;
					break;
				case '*':
					prev *= num;
					break;
				case '/':
					prev /= num;
					break;
				}
				if (ch == ')')
					break;
				prevOp = ch;
				num = 0;
			}
		}
		return sum + prev;
	}

	public static void main(String[] args) {
		String str = "(1+(4+5+2)-3)+(6+8)";
		
		int result = calculate(str);
		
		System.out.println(result);
		
		str = " 2-1 + 2 ";
		
		result = calculate(str);
		
		System.out.println(result);

	}

}
