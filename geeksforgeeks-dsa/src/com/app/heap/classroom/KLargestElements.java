package com.app.heap.classroom;

import java.util.Iterator;
import java.util.PriorityQueue;

public class KLargestElements {
	private static void printKLargestElements(int[] nums, int k) {
		int n = nums.length;
		PriorityQueue<Integer> pQ = new PriorityQueue<>();
		for (int i = 0; i < k; i++) {
			pQ.add(nums[i]);
		}
		for (int i = k; i < n; i++) {
			if (nums[i] > pQ.peek()) {
				pQ.poll();
				pQ.add(nums[i]);
			}
		}

		Iterator<Integer> qItr = pQ.iterator();
		while (qItr.hasNext()) {
			System.out.print(qItr.next() + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr = { 5, 10, 15, 20, 8, 18, 25 };
		printKLargestElements(arr, 3);
	}

}
