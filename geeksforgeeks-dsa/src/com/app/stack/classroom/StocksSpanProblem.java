package com.app.stack.classroom;

import java.util.Stack;

public class StocksSpanProblem {
	private static void stockSpanProblem(int[] arr) {
		Stack<Integer> stack = new Stack<>();
		int n = arr.length;

		for (int i = 0; i < n; i++) {
			int span = 1;
			while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
				stack.pop();
			}
			span = stack.isEmpty() ? (i + 1) : i - stack.peek();
			System.out.print(span + " ");
			stack.push(i);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr = { 15, 13, 12, 14, 16, 8, 6, 30 };
		stockSpanProblem(arr);
	}

}
