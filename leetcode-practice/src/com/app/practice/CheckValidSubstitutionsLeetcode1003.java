package com.app.practice;

import java.util.Stack;

public class CheckValidSubstitutionsLeetcode1003 {
	private static boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		int n = s.length();
		
		for(int i = 0; i < n; i++) {
			if(s.charAt(i) == 'c') {
				if(stack.isEmpty())
					return false;
				else if(stack.size() < 2)
					return false;
				else {
					char ch2 = stack.pop();
					char ch1 = stack.pop();
					if(ch2 != 'b' || ch1 != 'a')
						return false;
				}
			} else {
				stack.push(s.charAt(i));
			}
		}
		if(!stack.isEmpty())
			return false;
		return true;
	}

	public static void main(String[] args) {
		String str = "aabcbc";
		
		System.out.println(isValid(str));
		
		str = "abcabcababcc";
		
		System.out.println(isValid(str));
		
		str = "abccba";
		
		System.out.println(isValid(str));
		
		str = "cababc";
		
		System.out.println(isValid(str));
	}

}
