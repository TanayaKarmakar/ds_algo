package com.app.questions.read;

import java.util.Stack;

public class LargestHistogramRectangleLeetcode84 {
	private static int largestArea(int[] nums) {
		int n = nums.length;
		Stack<Integer> stack = new Stack<>();

		int i = 0;
		int res = 0;
		int maxRes = 0;
		for (; i < n;) {
			if (stack.isEmpty() || nums[stack.peek()] <= nums[i]) {
				stack.push(i++);
			} else {
				int top = stack.pop();
				if (stack.isEmpty()) {
					res = i * nums[top];
				} else {
					res = nums[top] * (i - stack.peek() - 1);
				}
			}
			maxRes = Integer.max(res, maxRes);
		}
		return maxRes;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 1, 5, 6, 2, 3 };
		
		int maxRes = largestArea(nums);
		
		System.out.println(maxRes);
	}

}
