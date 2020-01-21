package com.app.stack.practice;

import java.util.Stack;

public class StockSpanProblem {
	private static void calculateSpan(int[] arr) {
		int n = arr.length;
		Stack<Integer> stack = new Stack<>();

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
		int[] arr = {100, 80, 60, 70, 60, 75, 85};
		calculateSpan(arr);
	}

}
