package com.app.practice.queue;

import java.util.LinkedList;
import java.util.Queue;

public class BasicCalculatorIILeetcode227 {
	private static int calculate(String s) {
		Queue<Character> q = new LinkedList<>();
		int n = s.length();
		
		for(int i = 0; i < n; i++) {
			if(s.charAt(i) != ' ')
				q.add(s.charAt(i));
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
						prev *= num;
						break;
					case '/':
						prev /= num;
						break;
				}
				if(ch == ')')
					break;
				prevOp = ch;
				num = 0;
			}
		}
		return (sum + prev);
	}

	public static void main(String[] args) {
		String str = "3+2*2";
		
		int ans = calculate(str);
		
		System.out.println(ans);

	}

}
