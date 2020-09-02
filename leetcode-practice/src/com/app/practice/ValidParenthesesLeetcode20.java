package com.app.practice;

import java.util.Stack;

public class ValidParenthesesLeetcode20 {
	private static boolean isValidChar(char topChar, char inputChar) {
		return ((topChar == '(' && inputChar == ')') || (topChar == '{' && inputChar == '}')
				|| (topChar == '[' && inputChar == ']'));
	}
	
	private static boolean isValid(String s) {
		if(s.isEmpty())
			return true;
		Stack<Character> stack = new Stack<>();
		int n = s.length();
		
		
		for(int i = 0; i < n; i++) {
			if(s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']') {
				if(stack.isEmpty() || !isValidChar(stack.peek(), s.charAt(i))) {
					return false;
				} else {
					stack.pop();
				}
			} else {
				stack.push(s.charAt(i));
			}
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		String str = "()";
		
		System.out.println(isValid(str));
		
		str = "()[]{}";
		
		System.out.println(isValid(str));
		
		str = "(]";
		
		System.out.println(isValid(str));
		
		str = "{[]}";
		
		System.out.println(isValid(str));
	}

}
