package com.app.practice;

import java.util.Deque;
import java.util.LinkedList;

public class ContiguousSubarrayDiffLessOrEqualLimitLeetcode1438 {
	private static int longestSubarray(int[] nums, int limit) {
		Deque<Integer> maxD = new LinkedList<>();
		Deque<Integer> minD = new LinkedList<>();

		int i = 0;
		int j = 0;
		for (j = 0; j < nums.length; j++) {
			while (!maxD.isEmpty() && maxD.peekLast() < nums[j]) {
				maxD.pollLast();
			}

			while (!minD.isEmpty() && minD.peekLast() > nums[j]) {
				minD.pollLast();
			}

			maxD.add(nums[j]);
			minD.add(nums[j]);

			if ((int) Math.abs(maxD.peek() - minD.peek()) > limit) {
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
		
		int len = longestSubarray(nums, 4);
		
		System.out.println(len);
	}

}
