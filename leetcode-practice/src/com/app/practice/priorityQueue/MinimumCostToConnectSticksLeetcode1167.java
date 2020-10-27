package com.app.practice.priorityQueue;

import java.util.PriorityQueue;

public class MinimumCostToConnectSticksLeetcode1167 {
	private static int connectSticks(int[] sticks) {
		int n = sticks.length;
		PriorityQueue<Integer> pQ = new PriorityQueue<>();

		for (int i = 0; i < n; i++) {
			pQ.add(sticks[i]);
		}

		int sum = 0;
		while (pQ.size() > 1) {
			int n1 = pQ.poll();
			int n2 = pQ.poll();

			int total = (n1 + n2);
			sum += total;
			pQ.add(total);
		}

		return sum;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 4, 3 };
		int ans = connectSticks(nums);
		
		System.out.println(ans);
	}

}
