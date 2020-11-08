package com.app.practice.stack;

import java.util.Stack;

public class WordIsValidAfterSubstitutionLeetcode1003 {
	private static boolean isValid(String s) {
		if(s.length() == 0)
			return true;
		if(s.length() < 3)
			return false;
		Stack<Character> stack = new Stack<>();
		int n = s.length();
		
		for(int i = 0; i < n; i++) {
			if(s.charAt(i) == 'c') {
				if(stack.isEmpty() || stack.size() < 2)
					return false;
				else {
					char ch2 = stack.pop();
					char ch1 = stack.pop();
					if(ch1 != 'a' || ch2 != 'b')
						return false;
				}
			} else {
				stack.push(s.charAt(i));
			}
		}
		
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
