package com.app.practice.priorityQueue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class TopKFrequentElementsLeetcode347 {
	private static int[] topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		PriorityQueue<Integer> pQ = new PriorityQueue<>((n1, n2) -> map.get(n1) - map.get(n2));

		Set<Integer> keys = map.keySet();
		int i = 0;
		for (Integer key : keys) {
			pQ.add(key);

			if (pQ.size() > k)
				pQ.remove();
		}

		int[] items = new int[k];
		i = 0;
		while (!pQ.isEmpty()) {
			items[i++] = pQ.poll();
		}

		return items;

	}

	public static void main(String[] args) {
		int[] nums = { 1, 1, 1, 2, 2, 3 };
		int k = 2;
		
		int[] res = topKFrequent(nums, k);
		
		System.out.println(Arrays.toString(res));

	}

}
