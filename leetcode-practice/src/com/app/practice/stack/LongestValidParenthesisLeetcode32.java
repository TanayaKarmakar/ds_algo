package com.app.practice.stack;

import java.util.Stack;

public class LongestValidParenthesisLeetcode32 {
	private static int longestValidParenthesis(String s) {
		int n = s.length();

		Stack<Integer> stack = new Stack<>();
		stack.push(-1);
		
		int maxLen = 0;

		for(int i = 0; i < n; i++) {
			if(s.charAt(i) == ')') {
				stack.pop();
				if(stack.isEmpty()) {
					stack.push(i);
				} else {
					maxLen = Integer.max(maxLen, (i - stack.peek()));
				}
			} else {
				stack.push(i);
			}
		}
		
		return maxLen;
	}

	public static void main(String[] args) {
		String str = "(()";
		
		int maxLen = longestValidParenthesis(str);
		
		System.out.println(maxLen);
		
		str = ")()())";
		
		maxLen = longestValidParenthesis(str);
		
		System.out.println(maxLen);
	}

}
