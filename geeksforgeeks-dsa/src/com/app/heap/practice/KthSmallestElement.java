package com.app.heap.practice;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestElement {
	private static int kThSmallest(int[] nums, int k) {
		PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < k; i++) {
			pQ.add(nums[i]);
		}

		for (int i = k; i < nums.length; i++) {
			if (nums[i] < pQ.peek()) {
				pQ.poll();
				pQ.add(nums[i]);
			}
		}

		return pQ.peek();
	}

	public static void main(String[] args) {
		int[] nums = { 3, 5, 4, 2, 9 };

		System.out.println(kThSmallest(nums, 3));

		nums = new int[] { 4, 3, 7, 6, 5 };
		
		System.out.println(kThSmallest(nums, 5));
	}

}
