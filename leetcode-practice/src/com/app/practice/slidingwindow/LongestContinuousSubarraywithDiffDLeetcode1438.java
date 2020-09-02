package com.app.practice.slidingwindow;

import java.util.ArrayDeque;
import java.util.Deque;

public class LongestContinuousSubarraywithDiffDLeetcode1438 {
	private static int maxLength(int[] nums, int limit) {
		Deque<Integer> maxD = new ArrayDeque<>();
		Deque<Integer> minD = new ArrayDeque<>();

		int n = nums.length;
		int i = 0;
		int j = 0;
		for (j = 0; j < n; j++) {
			while (!maxD.isEmpty() && maxD.peekLast() < nums[j])
				maxD.pollLast();
			maxD.add(nums[j]);

			while (!minD.isEmpty() && minD.peekLast() > nums[j])
				minD.pollLast();
			minD.add(nums[j]);

			if (maxD.peek() - minD.peek() > limit) {
				if (nums[i] == maxD.peek())
					maxD.poll();
				if (nums[i] == minD.peek())
					minD.poll();
				i++;
			}
		}

		return (j - i);
	}

	public static void main(String[] args) {
		int[] nums = { 8, 2, 4, 7 };
		int limit = 4;
		
		int maxLen = maxLength(nums, limit);
		
		System.out.println(maxLen);
		
		

	}

}
