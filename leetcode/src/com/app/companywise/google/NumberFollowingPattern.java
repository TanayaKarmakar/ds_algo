package com.app.companywise.google;

import java.util.Stack;

public class NumberFollowingPattern {
	private static void pattern(String s) {
		Stack<String> stack = new Stack<>();
		int n = s.length();
		for (int i = 0; i <= n; i++) {
			stack.push("" + (i + 1));
			if (i == n || s.charAt(i) == 'I') {
				while (!stack.isEmpty()) {
					System.out.print(stack.pop());
				}
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		pattern("D");
		pattern("I");
		pattern("IIDDD");
	}

}
