package com.app.questions;

import java.util.PriorityQueue;

public class KthLargestElement {
	private static int kThLargestElement(int[] nums, int k) {
		PriorityQueue<Integer> pQ = new PriorityQueue<>();
		for (int i = 0; i < k; i++) {
			pQ.add(nums[i]);
		}

		int n = nums.length;
		for (int i = k; i < n; i++) {
			if (nums[i] > pQ.peek()) {
				pQ.poll();
				pQ.add(nums[i]);
			}
		}
		
		//System.out.println(pQ);

		return pQ.peek();
	}

	public static void main(String[] args) {
		int[] nums = { 3, 2, 1, 6, 5, 4 };

		System.out.println(kThLargestElement(nums, 3));

	}

}
