package com.app.practice.stack;

import java.util.Scanner;
import java.util.Stack;

public class ValidAfterSubstitutionLeetcode1003 {
	private static boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		int n = s.length();

		for (int i = 0; i < n; i++) {
			if (s.charAt(i) == 'c') {
				if (stack.isEmpty() || stack.size() < 2)
					return false;
				else {
					char char2 = stack.pop();
					char char1 = stack.pop();
					if (char1 != 'a' || char2 != 'b')
						return false;
				}
			} else {
				stack.push(s.charAt(i));
			}
		}

		if (!stack.isEmpty())
			return false;

		return true;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String str = scanner.next();

		System.out.println(isValid(str));

		scanner.close();

	}

}
