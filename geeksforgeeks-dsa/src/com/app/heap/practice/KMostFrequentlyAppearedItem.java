package com.app.heap.practice;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class KMostFrequentlyAppearedItem {
	private static int kMostFreq(int[] nums, int k) {
		Map<Integer, Integer> numMap = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (!numMap.containsKey(nums[i])) {
				numMap.put(nums[i], 1);
			} else {
				int tmp = numMap.get(nums[i]);
				numMap.put(nums[i], ++tmp);
			}
		}

		PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
		for (Map.Entry<Integer, Integer> entry : numMap.entrySet()) {
			pQ.add(entry.getValue());
		}

		int i = k - 1;
		int sum = 0;
		while (i >= 0) {
			sum += pQ.poll();
			i--;
		}

		return sum;
	}

	public static void main(String[] args) {

		int[] nums = { 3, 1, 4, 4, 5, 2, 6, 1 };
		System.out.println(kMostFreq(nums, 2));
	}

}
