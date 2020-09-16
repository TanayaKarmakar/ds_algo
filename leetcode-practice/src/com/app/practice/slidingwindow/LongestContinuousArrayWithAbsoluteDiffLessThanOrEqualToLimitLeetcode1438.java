package com.app.practice.slidingwindow;

import java.util.ArrayDeque;
import java.util.Deque;

public class LongestContinuousArrayWithAbsoluteDiffLessThanOrEqualToLimitLeetcode1438 {
	private static int longestSubarray(int[] nums, int limit) {
		Deque<Integer> maxD = new ArrayDeque<>();
		Deque<Integer> minD = new ArrayDeque<>();

		int n = nums.length;
		int i = 0;
		int j = 0;
		for (j = 0; j < n; j++) {
			while (!maxD.isEmpty() && maxD.peekLast() < nums[j])
				maxD.pollLast();
			while (!minD.isEmpty() && minD.peekLast() > nums[j])
				minD.pollLast();
			maxD.add(nums[j]);
			minD.add(nums[j]);

			if ((int)Math.abs(maxD.peek() - minD.peek()) > limit) {
				if (maxD.peek() == nums[i])
					maxD.poll();
				if (minD.peek() == nums[i])
					minD.poll();
				i++;
			}
		}

		return (j - i);
	}

	public static void main(String[] args) {
		int[] nums = { 8, 2, 4, 7 };
		int limit = 4;
		
		int len = longestSubarray(nums, limit);
		
		System.out.println(len);
	}

}
