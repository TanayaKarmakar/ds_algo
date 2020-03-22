package com.app.questions;

import java.util.Stack;

public class BasicCalculator2Leetcode227 {
	private static int calculate(String s) {
		int n = s.length();
		int start = 0;
		char sign = '+';
		Stack<Integer> stack = new Stack<>();
		int sum = 0;
		
		while(start < n) {
			char ch = s.charAt(start);
			if(Character.isDigit(ch)) {
				sum = sum * 10;
				sum = sum + (ch - '0');
			} 
			if(!Character.isDigit(ch) && ch != ' ' || start == n - 1) {
				if(sign == '+') {
					stack.push(sum);
				} else if(sign == '-') {
					stack.push(-sum);
				} else if(sign == '*') {
					stack.push(stack.pop() * sum);
				} else if(sign == '/') {
					stack.push(stack.pop() / sum);
				}
				sum = 0;
				sign = s.charAt(start);
			}
			start++;
		}
		
		int res = 0;
		for(Integer el: stack) {
			res += el;
		}
		
		return res;
	}
	public static void main(String[] args) {
//		System.out.println(calculate("3+2*2"));
//		System.out.println(calculate("3/2 "));
//		System.out.println(calculate(" 3+5 / 2 "));
//		System.out.println(calculate("42"));
		//System.out.println(calculate("0-2147483647"));
		//System.out.println(calculate("1+1-1"));
		System.out.println(calculate("1*2-3/4+5*6-7*8+9/10"));

	}

}
