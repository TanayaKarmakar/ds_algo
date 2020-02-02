package com.app.heap.practice;

import java.util.Iterator;
import java.util.PriorityQueue;

public class KLargestElement {
	private static void kLargestElement(int[] nums, int k) {
		PriorityQueue<Integer> pQ = new PriorityQueue<>();
		for (int i = 0; i < k; i++) {
			pQ.add(nums[i]);
		}

		for (int i = k; i < nums.length; i++) {
			if (nums[i] > pQ.peek()) {
				pQ.poll();
				pQ.add(nums[i]);
			}
		}

		//Iterator<Integer> qItr = pQ.iterator();
		String str = "";

		while (!pQ.isEmpty()) {
			str = pQ.poll() + " " + str;
		}
		System.out.println(str);
	}

	public static void main(String[] args) {
		int[] nums = {12, 5, 787, 1, 23};
		
		kLargestElement(nums, 2);

	}

}
