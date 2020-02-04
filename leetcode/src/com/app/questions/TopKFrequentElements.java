package com.app.questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class Frequency implements Comparable<Frequency> {
	int data;
	int freq;

	public Frequency(int data, int freq) {
		this.data = data;
		this.freq = freq;
	}

	@Override
	public int compareTo(Frequency o) {
		if (this.freq == o.freq)
			return 0;
		else if (this.freq < o.freq)
			return -1;
		else
			return 1;
	}
}

public class TopKFrequentElements {
	private static List<Integer> topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> numMap = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (!numMap.containsKey(nums[i])) {
				numMap.put(nums[i], 1);
			} else {
				int tmp = numMap.get(nums[i]);
				numMap.put(nums[i], ++tmp);
			}
		}

		PriorityQueue<Frequency> pQ = new PriorityQueue<>(Collections.reverseOrder());
		for (Map.Entry<Integer, Integer> entry : numMap.entrySet()) {
			pQ.add(new Frequency(entry.getKey(), entry.getValue()));
		}

		List<Integer> res = new ArrayList<>();
		while (k > 0 && !pQ.isEmpty()) {
			res.add(pQ.poll().data);
			k--;
		}

		return res;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 1, 1, 2, 2, 3 };
		List<Integer> res = topKFrequent(nums, 2);
		System.out.println(res);
	}

}
