package com.app.practice.queue;

import java.util.Deque;
import java.util.LinkedList;

public class LongestContinuousArrayDiffLessOrEqualToLimitLeetcode1438 {
	private static int longestSubarray(int[] nums, int limit) {
		int n = nums.length;

		Deque<Integer> maxD = new LinkedList<>();
		Deque<Integer> minD = new LinkedList<>();

		int j = 0;
		int i = 0;

		for (i = 0; i < n; i++) {
			while (!maxD.isEmpty() && maxD.peekLast() < nums[i])
				maxD.pollLast();
			

			while (!minD.isEmpty() && minD.peekLast() > nums[i])
				minD.pollLast();
			maxD.addLast(nums[i]);
			minD.addLast(nums[i]);

			int diff = Math.abs(maxD.peek() - minD.peek());
			if(diff > limit) {
				if(nums[j] == maxD.peek())
					maxD.poll();
				if(nums[j] == minD.peek())
					minD.poll();
				j++;
			}
		}
		return (i - j);
	}

	public static void main(String[] args) {
		int[] nums = { 8, 2, 4, 7 };
		int limit = 4;

		int ans = longestSubarray(nums, limit);
		System.out.println(ans);
	}

}
