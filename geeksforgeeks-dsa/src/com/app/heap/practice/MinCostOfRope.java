package com.app.heap.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MinCostOfRope {
	private static int findMinCost(int[] costs) {
		int n = costs.length;
		PriorityQueue<Integer> pQ = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			pQ.add(costs[i]);
		}

		int total = 0;
		while (pQ.size() > 1) {
			int item1 = pQ.poll();
			int item2 = pQ.poll();

			int sum = item1 + item2;
			pQ.add(sum);
			total += sum;
		}

		return total;
	}

	public static void main(String[] args) {
		int[] costs = { 4, 3, 2, 6 };
		System.out.println("Min Cost - " + findMinCost(costs));

		costs = new int[] { 4, 2, 7, 6, 9 };
		System.out.println("Min Cost - " + findMinCost(costs));
	}

}
