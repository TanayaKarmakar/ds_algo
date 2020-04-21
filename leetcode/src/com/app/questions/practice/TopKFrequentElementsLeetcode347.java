package com.app.questions.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class Item implements Comparable<Item> {
	int val;
	int freq;

	@Override
	public int compareTo(Item o) {
		if (this.freq < o.freq)
			return 1;
		else if (this.freq > o.freq)
			return -1;
		return 0;
	}
}

public class TopKFrequentElementsLeetcode347 {
	private static List<Integer> topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int el : nums) {
			map.put(el, map.getOrDefault(el, 0) + 1);
		}

		PriorityQueue<Item> pQ = new PriorityQueue<>();
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			Item item = new Item();
			item.val = entry.getKey();
			item.freq = entry.getValue();
			pQ.add(item);
		}

		List<Integer> res = new ArrayList<>();
		while (k > 0 && !pQ.isEmpty()) {
			Item item = pQ.poll();
			res.add(item.val);
			k--;
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 1, 1, 2, 2, 3 };
		System.out.println(topKFrequent(nums, 2));
	}

}
