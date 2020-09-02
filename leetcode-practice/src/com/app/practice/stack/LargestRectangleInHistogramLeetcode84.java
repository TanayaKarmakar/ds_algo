package com.app.practice.stack;

import java.util.Stack;

public class LargestRectangleInHistogramLeetcode84 {
	private static int largestRectangleInHistogram(int[] heights) {
		Stack<Integer> stack = new Stack<>();
		int n = heights.length;
		int maxArea = 0;

		int i = 0;
		for (i = 0; i < n;) {
			if (stack.isEmpty() || heights[stack.peek()] <= heights[i]) {
				stack.push(i++);
			} else {
				int top = stack.pop();
				if (stack.isEmpty()) {
					maxArea = Integer.max(maxArea, i * heights[top]);
				} else {
					maxArea = Integer.max(maxArea, heights[top] * (i - stack.peek() - 1));
				}
			}
		}

		while (!stack.isEmpty()) {
			int top = stack.pop();
			if (stack.isEmpty()) {
				maxArea = Integer.max(maxArea, i * heights[top]);
			} else {
				maxArea = Integer.max(maxArea, heights[top] * (i - stack.peek() - 1));
			}
		}

		return maxArea;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 1, 5, 6, 2, 3 };
		int maxArea = largestRectangleInHistogram(nums);
		
		System.out.println(maxArea);
	}

}
