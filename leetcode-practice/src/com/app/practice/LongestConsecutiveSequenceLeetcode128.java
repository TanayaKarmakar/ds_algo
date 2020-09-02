package com.app.practice;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequenceLeetcode128 {
	private static int longestConsecutive(int[] nums) {
		if(nums.length == 0)
			return 0;
		Map<Integer, Boolean> map = new HashMap<>();
		for (int num : nums) {
			map.put(num, true);
		}

		int maxLen = 1;
		int n = nums.length;

		for (int i = 0; i < n; i++) {
			int k = nums[i];
			int len = 0;

			while (map.containsKey(k) && map.get(k) == true) {
				map.put(k, false);
				k--;
				len++;
			}

			k = nums[i] + 1;
			while (map.containsKey(k) && map.get(k) == true) {
				map.put(k, false);
				k++;
				len++;
			}

			maxLen = Integer.max(maxLen, len);
		}
		return maxLen;

	}

	public static void main(String[] args) {
		int[] nums = { 100, 4, 200, 1, 3, 2 };
		int maxLen = longestConsecutive(nums);
		
		System.out.println(maxLen);
		
		nums = new int[] {10};
		maxLen = longestConsecutive(nums);
		
		System.out.println(maxLen);
	}

}
