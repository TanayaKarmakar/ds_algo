package com.app.stack.practice;

import java.util.Stack;

public class NextGreaterElement {
	private static void nextGreaterElement(int[] arr) {
		Stack<Integer> stack = new Stack<>();
		int n = arr.length;
		stack.push(arr[n - 1]);

		String str = "-1";

		for (int i = n - 2; i >= 0; i--) {
			while(!stack.isEmpty() && arr[i] > stack.peek()) {
				stack.pop();
			}
			int nextGreaterElement = stack.isEmpty() ? -1:stack.peek();
			str = nextGreaterElement + " " + str;
			stack.push(arr[i]);
		}
		
		System.out.println(str);
	}

	public static void main(String[] args) {
		int[] arr = { 1, 3, 2, 4 };

		nextGreaterElement(arr);

		arr = new int[] { 6, 8, 0, 1, 3 };

		nextGreaterElement(arr);
	}

}
