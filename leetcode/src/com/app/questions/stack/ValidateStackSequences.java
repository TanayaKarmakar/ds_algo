package com.app.questions.stack;

import java.util.Stack;

public class ValidateStackSequences {
	private static boolean validateStackSequences(int[] pushed, int[] popped) {
		Stack<Integer> stack = new Stack<>();
		int n = pushed.length;

		int j = 0;
		for (int i = 0; i < n; i++) {
			stack.push(pushed[i]);

			while (!stack.isEmpty() && j < n && stack.peek() == popped[j]) {
				stack.pop();
				j++;
			}
		}
		return j == n;
	}

	public static void main(String[] args) {
		int[] pushed = { 1, 2, 3, 4, 5 };
		int[] popped = { 4, 5, 3, 2, 1 };
		
		boolean hasCorrectSequence = validateStackSequences(pushed, popped);
		
		System.out.println(hasCorrectSequence);
	}

}
