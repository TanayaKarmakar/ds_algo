package com.app.practice.stack;

import java.util.Scanner;
import java.util.Stack;

public class ValidParenthesisLeetcode20 {
	private static boolean isValid(char inputChar, char topChar) {
		return (topChar == '(' && inputChar == ')') || (topChar == '{' && inputChar == '}')
				|| (topChar == '[' && inputChar == ']');
	}
	
	private static boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		
		int n = s.length();
		
		for(int i = 0; i < n; i++) {
			char ch = s.charAt(i);
			if(ch == ')' || ch == '}' || ch == ']') {
				if(stack.isEmpty() || !isValid(ch, stack.peek()))
					return false;
				else
					stack.pop();
			} else {
				stack.push(ch);
			}
		}
		
		if(stack.isEmpty())
			return true;
		return false;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String txt = scanner.next();
		
		boolean isValid = isValid(txt);
		
		System.out.println(isValid);
		
		scanner.close();

	}

}
