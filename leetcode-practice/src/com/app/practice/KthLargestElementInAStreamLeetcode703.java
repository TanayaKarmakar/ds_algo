package com.app.practice;

import java.util.PriorityQueue;

class KthLargest {
	int k;
	PriorityQueue<Integer> pQ = new PriorityQueue<>();

	public KthLargest(int k, int[] nums) {
		int n = nums.length;
		this.k = k;
		for (int i = 0; i < k; i++) {
			pQ.add(nums[i]);
		}

		for (int i = k + 1; i < n; i++) {
			if (pQ.peek() < nums[i]) {
				pQ.poll();
				pQ.add(nums[i]);
			}
		}
	}

	public int add(int num) {
		if (pQ.isEmpty() || pQ.size() < k) {
			pQ.add(num);
		} else {
			if (pQ.peek() < num) {
				pQ.poll();
				pQ.add(num);
			}
		}
		return pQ.peek();
	}
}

public class KthLargestElementInAStreamLeetcode703 {

	public static void main(String[] args) {
		int k = 3;
		int[] nums = { 4, 5, 8, 2 };
		KthLargest kThLargest = new KthLargest(k, nums);

		System.out.println(kThLargest.add(3));
		System.out.println(kThLargest.add(5));
		System.out.println(kThLargest.add(10));
		System.out.println(kThLargest.add(9));
		System.out.println(kThLargest.add(4));
		
	}

}
