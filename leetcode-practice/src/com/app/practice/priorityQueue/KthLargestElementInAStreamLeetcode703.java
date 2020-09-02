package com.app.practice.priorityQueue;

import java.util.PriorityQueue;

class KthLargest {
	private PriorityQueue<Integer> pQ;
	int k;

	public KthLargest(int k, int[] nums) {
		pQ = new PriorityQueue<>();
		this.k = k;

		int n = nums.length;
		int len = Integer.min(k, n);

		for (int i = 0; i < len; i++) {
			pQ.add(nums[i]);
		}

		for (int i = len; i < n; i++) {
			if (pQ.peek() < nums[i]) {
				pQ.poll();
				pQ.add(nums[i]);
			}
		}

	}

	public int add(int val) {
		if (pQ.isEmpty() || pQ.size() < k)
			pQ.add(val);
		else if (pQ.peek() < val) {
			pQ.poll();
			pQ.add(val);
		}

		return pQ.peek();
	}
}

public class KthLargestElementInAStreamLeetcode703 {

	public static void main(String[] args) {
		KthLargest obj = new KthLargest(3, new int[] { 4, 5, 8, 2 });

		System.out.println(obj.add(3));
		System.out.println(obj.add(5));
		System.out.println(obj.add(10));
		System.out.println(obj.add(9));
		System.out.println(obj.add(4));
	}

}
