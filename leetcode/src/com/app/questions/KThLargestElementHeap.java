package com.app.questions;

import java.util.PriorityQueue;

public class KThLargestElementHeap {
	PriorityQueue<Integer> pQ = new PriorityQueue<>();
	int k;

	public KThLargestElementHeap(int k, int[] nums) {
		this.k = k;
		int len = Math.min(nums.length, k);
		for (int i = 0; i < len; i++) {

			pQ.add(nums[i]);
		}

		for (int i = len; i < nums.length; i++) {

			if (nums[i] > pQ.peek()) {

				pQ.poll();
				pQ.add(nums[i]);
			}
		}
	}

	private int add(int num) {
		if (pQ.isEmpty() || pQ.size() < k) {

			pQ.add(num);
		} else if (num > pQ.peek()) {

			pQ.poll();
			pQ.add(num);
		}

		return pQ.peek();
	}

	public static void main(String[] args) {
		KThLargestElementHeap obj = new KThLargestElementHeap(3, new int[] { 4, 5, 8, 2 });

		System.out.println(obj.add(3));
		System.out.println(obj.add(5));
		System.out.println(obj.add(10));
		System.out.println(obj.add(9));
		System.out.println(obj.add(4));

		obj = new KThLargestElementHeap(3, new int[] {});
		System.out.println(obj.add(-3));
		System.out.println(obj.add(-2));
		System.out.println(obj.add(-4));
		System.out.println(obj.add(0));
		System.out.println(obj.add(4));

		obj = new KThLargestElementHeap(1, new int[] { -2 });
		System.out.println(obj.add(-3));
		System.out.println(obj.add(0));

	}

}
