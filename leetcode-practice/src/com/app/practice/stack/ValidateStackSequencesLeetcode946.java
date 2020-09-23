package com.app.practice.stack;

import java.util.Stack;

public class ValidateStackSequencesLeetcode946 {
	private static boolean validateStackSequences(int[] pushed, int[] popped) {
		int n = pushed.length;

		Stack<Integer> stack = new Stack<>();
		int j = 0;
		for (int i = 0; i < n; i++) {
			stack.push(pushed[i]);

			while (!stack.isEmpty() && (stack.peek() == popped[j] || i == n)) {
				stack.pop();
				j++;
			}
		}

		return (j == n);
	}

	public static void main(String[] args) {
		int[] pushed = { 1, 2, 3, 4, 5 };
		int[] popped = { 4, 5, 3, 2, 1 };
		
		boolean isValid = validateStackSequences(pushed, popped);
		
		System.out.println(isValid);

	}

}
