package com.app.questions.practice;

import java.util.Stack;

public class ValidSubstitutionLeetcode1003 {
	private static boolean isValid(String S) {
		Stack<Character> stack = new Stack<>();
		int n = S.length();
		
		for(int i = 0; i < n; i++) {
			char ch = S.charAt(i);
			if(ch == 'c') {
				if(stack.isEmpty())
					return false;
				else  {
					if(stack.peek() == 'b') {
						stack.pop();
						if(stack.isEmpty())
							return false;
						else {
							if(stack.peek() == 'a')
								stack.pop();
							else
								return false;
						}
					} else {
						return false;
					}
				}
			} else {
				stack.push(ch);
			}
		}
		
		if(stack.isEmpty())
			return true;
		return false;
	}

	public static void main(String[] args) {
		System.out.println(isValid("aabcbc"));
		System.out.println(isValid("abcabcababcc"));
		System.out.println(isValid("abccba"));
		System.out.println(isValid("cababc"));

	}

}
