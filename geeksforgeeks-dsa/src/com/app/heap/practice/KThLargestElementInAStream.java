package com.app.heap.practice;

import java.util.PriorityQueue;

public class KThLargestElementInAStream {
	private static void kThLargestInStream(int[] nums, int k) {
		PriorityQueue<Integer> pQ = new PriorityQueue<>();
		int cnt = 0;
		for (int i = 0; i < k; i++) {
			pQ.add(nums[i]);
			cnt++;
			if (cnt < k) {
				System.out.print("-1 ");
			}
			if (cnt == k) {
				System.out.print(pQ.peek() + " ");
			}
		}

		int n = nums.length;
		for (int i = k; i < n; i++) {
			if(pQ.peek() < nums[i]) {
				pQ.poll();
				pQ.add(nums[i]);
			}
			System.out.print(pQ.peek() + " ");
		}
//		pQ.poll();
//		System.out.print(pQ.peek() + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4, 5, 6};
		
		kThLargestInStream(nums, 4);
	}

}
