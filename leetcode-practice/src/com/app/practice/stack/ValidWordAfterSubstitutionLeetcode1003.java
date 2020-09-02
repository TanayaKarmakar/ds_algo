package com.app.practice.stack;

import java.util.Scanner;
import java.util.Stack;

public class ValidWordAfterSubstitutionLeetcode1003 {
	private static boolean isValid(String s) {
		if(s.length() < 3)
			return false;
		int n = s.length();
		Stack<Character> stack = new Stack<>();
		
		for(int i = 0; i < n; i++) {
			char ch = s.charAt(i);
			if(ch == 'c') {
				if(stack.isEmpty() || stack.size() < 2)
					return false;
				char ch2 = stack.pop();
				char ch1 = stack.pop();
				if(ch1 != 'a' || ch2 != 'b')
					return false;
			} else {
				stack.push(ch);
			}
		}
		
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String text = scanner.next();
		
		System.out.println(isValid(text));
		
		scanner.close();

	}

}
