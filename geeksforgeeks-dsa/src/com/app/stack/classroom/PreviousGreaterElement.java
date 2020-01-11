package com.app.stack.classroom;

import java.util.Stack;

public class PreviousGreaterElement {
	private static void previousGreaterElement(int[] arr) {
		int n = arr.length;
		Stack<Integer> stack = new Stack<>();
		stack.push(arr[0]);
		System.out.print(-1 + " ");

		for (int i = 1; i < n; i++) {

			while (!stack.isEmpty() && arr[i] > stack.peek()) {
				stack.pop();
			}
			int prevGreater = stack.isEmpty() ? -1 : stack.peek();
			stack.push(arr[i]);

			System.out.print(prevGreater + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr = { 15, 10, 18, 12, 4, 6, 2, 8 };
		previousGreaterElement(arr);

		arr = new int[] { 8, 10, 12 };
		previousGreaterElement(arr);

		arr = new int[] { 12, 10, 8 };
		previousGreaterElement(arr);

	}

}
