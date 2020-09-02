package com.app.practice.slidingwindow;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximumLeetcode239 {
	private static int[] maxSlidingWindow(int[] nums, int k) {
		int n = nums.length;
		int[] res = new int[n - k + 1];

		int i = 0;
		Deque<Integer> maxD = new LinkedList<>();

		for (i = 0; i < k; i++) {
			while (!maxD.isEmpty() && nums[maxD.peekLast()] < nums[i])
				maxD.pollLast();
			maxD.add(i);
		}

		int j = 0;
		for (i = k; i < n; i++) {
			res[j++] = nums[maxD.peek()];

			while (!maxD.isEmpty() && maxD.peek() < (i - k + 1))
				maxD.poll();

			while (!maxD.isEmpty() && nums[maxD.peekLast()] < nums[i])
				maxD.pollLast();

			maxD.add(i);
		}
		
		res[j] = nums[maxD.peek()];

		return res;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
		int k = 3;
		int[] res = maxSlidingWindow(nums, k);
		
		System.out.println(Arrays.toString(res));
	}

}
