package com.app.practice;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximumLeetcode239 {
	private static int[] slidingWindow(int[] nums, int k) {
		Deque<Integer> maxD = new LinkedList<>();
		int n = nums.length;
		int[] res = new int[n - k + 1];

		int r = 0;
		int l = 0;

		while (r < k) {
			while (!maxD.isEmpty() && nums[maxD.peekLast()] < nums[r])
				maxD.pollLast();
			maxD.addLast(r);
			r++;
		}

		int i = 0;
		while (r < n) {
			res[i++] = nums[maxD.peek()];
			while (!maxD.isEmpty() && nums[maxD.peekLast()] < nums[r])
				maxD.pollLast();

			while (!maxD.isEmpty() && maxD.peek() < r - k + 1)
				maxD.poll();
			maxD.addLast(r);
			r++;
		}
		
		res[i] = nums[maxD.peek()];

		return res;
	}

	public static void main(String[] args) {
		int[] nums = {7, 2, 4};
		int[] res = slidingWindow(nums, 2);
		
		System.out.println(Arrays.toString(res));

	}

}
