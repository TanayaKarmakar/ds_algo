package com.app.practice.priorityQueue;

import java.util.PriorityQueue;

public class KThLargestElementInAnArrayLeetcode215 {
	private static int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> pQ = new PriorityQueue<>();
		for (int i = 0; i < k; i++) {
			pQ.add(nums[i]);
		}

		int n = nums.length;
		for (int i = k; i < n; i++) {
			if (pQ.peek() < nums[i]) {
				pQ.poll();
				pQ.add(nums[i]);
			}
		}

		return pQ.peek();
	}

	public static void main(String[] args) {
		int[] nums = { 3, 2, 1, 5, 6, 4 };

		int ans = findKthLargest(nums, 2);

		System.out.println(ans);

	}

}
