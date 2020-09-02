package com.app.practice.queue;

import java.util.LinkedList;
import java.util.Queue;

public class BasicCalculatorLeetcode224 {
	private static int calculate(String s) {
		int n = s.length();
		
		Queue<Character> q = new LinkedList<>();
		for(int i = 0; i < n; i++) {
			if(s.charAt(i) != ' ')
				q.add(s.charAt(i));
		}
		q.add(' ');
		
		return helper(q);
	}
	
	private static int helper(Queue<Character> q) {
		int num = 0;
		int prev = 0;
		char prevOp = '+';
		int sum = 0;
		
		while(!q.isEmpty()) {
			char ch = q.poll();
			if(ch == '(')
				num = helper(q);
			else if(Character.isDigit(ch))
				num = num * 10 + (ch - '0');
			else {
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
						prev = prev * num;
						break;
					case '/':
						prev = prev / num;
						break;
				}
				
				if(ch == ')')
					break;
				prevOp = ch;
				num = 0;
			}
		}
		return sum + prev;
	}

	public static void main(String[] args) {
		String str = "(1+(4+5+2)-3)+(6+8)";
		
		int res = calculate(str);
		
		System.out.println(res);

	}

}
