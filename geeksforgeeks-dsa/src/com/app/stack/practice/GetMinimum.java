package com.app.stack.practice;

import java.util.Stack;

public class GetMinimum {
	private static Stack<Integer> minStack = new Stack<>();

	public static Stack<Integer> push(int[] arr, int n) {
		// minStack.clear();
		Stack<Integer> numStack = new Stack<>();

		numStack.push(arr[0]);
		minStack.push(arr[0]);

		for (int i = 1; i < n; i++) {
			if (minStack.peek() >= arr[i]) {
				minStack.push(arr[i]);
			}
			numStack.push(arr[i]);
		}

		return numStack;
	}

	public static void getMinAtPop(Stack<Integer> stack) {
		while (!stack.isEmpty()) {
			int topEl = stack.peek();
			int minEl = minStack.peek();
			System.out.print(minEl + " ");
			if (minEl == topEl) {
				minStack.pop();
			}
			stack.pop();
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6 };
		Stack<Integer> stack = push(arr, arr.length);
		getMinAtPop(stack);
		
		arr = new int[] {1, 6, 43, 1, 2, 0, 5};
		stack = push(arr, arr.length);
		getMinAtPop(stack);
	}

}
