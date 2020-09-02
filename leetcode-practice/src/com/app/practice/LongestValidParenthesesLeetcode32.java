package com.app.practice;

import java.util.Stack;

public class LongestValidParenthesesLeetcode32 {
	private static int longestValidParenthesis(String s) {
		Stack<Integer> stack = new Stack<>();
		stack.push(-1);
		
		int maxLen = 0;
		int n = s.length();
		for(int i = 0; i < n; i++) {
			if(s.charAt(i) == ')') {
				stack.pop();
				if(stack.isEmpty()) {
					stack.push(i);
				} else {
					maxLen = Integer.max(maxLen, i - stack.peek());
				}
			} else {
				stack.push(i);
			}
		}
		return maxLen;
	}

	public static void main(String[] args) {
		String str = "(()";
		
		System.out.println(longestValidParenthesis(str));
		
		str = ")()())";
		
		System.out.println(longestValidParenthesis(str));

	}

}
