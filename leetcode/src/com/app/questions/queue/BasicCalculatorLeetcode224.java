package com.app.questions.queue;

import java.util.LinkedList;
import java.util.Queue;

public class BasicCalculatorLeetcode224 {
	private static int calculate(String str) {
		int n = str.length();
		Queue<Character> q = new LinkedList<>();
		
		for(int i = 0; i < n; i++) {
			if(str.charAt(i) != ' ')
				q.add(str.charAt(i));
		}
		q.add(' ');
		return helper(q);
	}
	
	private static int helper(Queue<Character> q) {
		int sum = 0;
		int num = 0;
		int prev = 0;
		char prevOp = '+';
		
		while(!q.isEmpty()) {
			char c = q.poll();
			
			if(c == '(') 
				num = helper(q);
			else if(Character.isDigit(c)) {
				num = num * 10 + (c - '0');
			} else {
				switch(prevOp) {
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
				if(c == ')')
					break;
				prevOp = c;
				num = 0;
			}
		}
		return sum + prev;
	}

	public static void main(String[] args) {
		String expr = "1 + 1";
		
		System.out.println(calculate(expr));
		
		expr = " 2-1 + 2 ";
		
		System.out.println(calculate(expr));
		
		expr = "(1+(4+5+2)-3)+(6+8)";
		
		System.out.println(calculate(expr));

	}

}
