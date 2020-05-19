package com.app.questions.slidingwindow;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SlidingWindowMaximumLeetcode239 {
	private static List<Integer> slidingWindowMaximum(int[] nums, int k) {
		if (k > nums.length) {
			int max = Integer.MIN_VALUE;
			for (int num : nums) {
				max = Integer.max(num, max);
			}
			List<Integer> res = new ArrayList<>();
			res.add(max);
			return res;
		}
		int n = nums.length;
		int i = 0;
		Deque<Integer> maxD = new LinkedList<>();
		while (i < k) {
			while (!maxD.isEmpty() && nums[maxD.peekLast()] < nums[i])
				maxD.pollLast();
			maxD.add(i);
			i++;
		}
		List<Integer> res = new ArrayList<>();
		res.add(maxD.peek());

		while (i < n) {
			while (!maxD.isEmpty() && nums[maxD.peekLast()] < nums[i])
				maxD.pollLast();
			maxD.add(i);

			while (maxD.peek() < (i - k + 1)) {
				maxD.poll();
			}
			res.add(maxD.peek());
			i++;
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums = { 10, 2, 5, 12, 8, 13, 9, 7, 1, 3, 8 };
		List<Integer> res = slidingWindowMaximum(nums, 3);
		
		for(Integer el: res) {
			System.out.print(nums[el] + " ");
		}
		System.out.println();
	}

}
