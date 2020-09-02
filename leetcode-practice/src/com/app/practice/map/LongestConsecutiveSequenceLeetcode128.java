package com.app.practice.map;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequenceLeetcode128 {
	private static int longestConsecutiveSequnece(int[] nums) {
		if(nums.length == 0)
			return 0;
		Map<Integer, Boolean> map = new HashMap<>();
		int n = nums.length;

		for (int i = 0; i < n; i++) {
			map.put(nums[i], true);
		}

		int maxlen = 1;

		for (int i = 0; i < n; i++) {
			int k = nums[i];
			int count = 0;

			while (map.containsKey(k) && map.get(k) == true) {
				map.put(k, false);
				k++;
				count++;
			}

			k = nums[i] - 1;
			while (map.containsKey(k) && map.get(k) == true) {
				map.put(k, true);
				k--;
				count++;
			}

			maxlen = Integer.max(maxlen, count);
		}
		return maxlen;
	}

	public static void main(String[] args) {
		int[] nums = { 100, 4, 200, 1, 3, 2 };
		int len = longestConsecutiveSequnece(nums);
		
		System.out.println(len);
	}

}
