package com.app.questions.greedy;

import java.util.PriorityQueue;

public class MinimumCostToConnectSticksLeetcode1167 {
	private static int connectSticks(int[] sticks) {
		if (sticks.length < 2)
			return 0;
		int n = sticks.length;

		PriorityQueue<Integer> pQ = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			pQ.add(sticks[i]);
		}

		int totalCost = 0;
		while (pQ.size() > 1) {
			int n1 = pQ.poll();
			int n2 = pQ.poll();

			int sum = (n1 + n2);
			totalCost += sum;
			pQ.add(sum);
		}

		return totalCost;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 4, 3 };
		int ans = connectSticks(nums);

		System.out.println(ans);
	}

}
