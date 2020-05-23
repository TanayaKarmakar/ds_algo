package com.app.questions.dp;

import java.util.Stack;

public class LongestValidParenthesesLeetcode32 {
	
	private static int longestValidParentheses(String s) {
		Stack<Integer> stack = new Stack<>();
		int n = s.length();
		
		int maxLen = 0;
		
		stack.push(-1);
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
		System.out.println(longestValidParentheses("(()"));
		System.out.println(longestValidParentheses("()()(())"));
	}

}
