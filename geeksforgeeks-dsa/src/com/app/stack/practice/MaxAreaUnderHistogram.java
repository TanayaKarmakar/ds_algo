package com.app.stack.practice;

import java.util.Stack;

public class MaxAreaUnderHistogram {
	private static int maxAreaUnderHistogram(int[] arr) {
		int n = arr.length;
		Stack<Integer> stack = new Stack<>();

		int currentArea = 0;
		int maxArea = Integer.MIN_VALUE;

		int i = 0;
		for (i = 0; i < n;) {
			if (stack.isEmpty() || arr[stack.peek()] <= arr[i]) {
				stack.push(i++);
			} else {
				int top = stack.pop();
				if (stack.isEmpty()) {
					currentArea = arr[top] * i;
				} else {
					currentArea = arr[top] * (i - stack.peek() - 1);
				}
				maxArea = Integer.max(maxArea, currentArea);
			}
		}
		
		
		while(!stack.isEmpty()) {
			int top = stack.pop();
			if(stack.isEmpty()) {
				currentArea = arr[top] * i;
			} else {
				currentArea = arr[top] * (i - stack.peek() - 1);
			}
			maxArea = Integer.max(maxArea, currentArea);
		}
		
		return maxArea;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
