package com.app.practice.stack;

import java.util.Stack;

public class ValidateStackSequencesLeetcode946 {
	private static boolean validateStackSequences(int[] pushed, int[] popped) {
		if (pushed.length != popped.length)
			return false;
		Stack<Integer> stack = new Stack<>();
		int n = pushed.length;

		int j = 0;
		for (int i = 0; i < n; i++) {
			stack.push(pushed[i]);
			while (!stack.isEmpty() && stack.peek() == popped[j]) {
				stack.pop();
				j++;
			}
		}

		return j == n;
	}

	public static void main(String[] args) {
		int[] pushed = { 1, 2, 3, 4, 5 };
		int[] popped = { 4, 5, 3, 2, 1 };

		System.out.println(validateStackSequences(pushed, popped));

		pushed = new int[] { 1, 2, 3, 4, 5 };
		popped = new int[] { 4, 3, 5, 1, 2 };
		
		System.out.println(validateStackSequences(pushed, popped));
	}

}
