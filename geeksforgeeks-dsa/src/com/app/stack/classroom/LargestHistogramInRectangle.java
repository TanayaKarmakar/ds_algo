package com.app.stack.classroom;

import java.util.Stack;

public class LargestHistogramInRectangle {
	private static int largestHistogram(int[] arr) {
		int n = arr.length;
		Stack<Integer> stack = new Stack<>();

		int res = 0;
		int maxRes = 0;

		int i = 0;
		for (i = 0; i < n;) {
			if (stack.isEmpty() || arr[stack.peek()] <= arr[i]) {
				stack.push(i++);
			} else {
				int top = stack.pop();
				if (stack.isEmpty()) {
					res = arr[top] * i;
				} else {
					res = arr[top] * (i - stack.peek() - 1);
				}
				maxRes = Integer.max(res, maxRes);
			}
		}

		while (!stack.isEmpty()) {
			int top = stack.pop();
			if (stack.isEmpty()) {
				res = arr[top] * i;
			} else {
				res = arr[top] * (i - stack.peek() - 1);
			}
			maxRes = Integer.max(res, maxRes);
		}

		return maxRes;
	}

	public static void main(String[] args) {
		int[] arr = { 6, 2, 5, 4, 5, 1, 6 };

		System.out.println("MaxArea - " + largestHistogram(arr));

	}

}
