package com.app.questions;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequenceLeetcode128 {
	private static int longestConsecutive(int[] nums) {
		if (nums.length <= 1)
			return nums.length;
		Map<Integer, Boolean> numMap = new HashMap<>();
		for (int num : nums) {
			numMap.put(num, true);
		}

		int len = 0;
		int maxLen = Integer.MIN_VALUE;

		int n = nums.length;
		int i = 0;

		while (i < n) {
			int k = nums[i];
			while (numMap.containsKey(k) && numMap.get(k) == true) {
				numMap.put(k, false);
				len++;
				k++;
			}

			k = nums[i] - 1;
			while (numMap.containsKey(k) && numMap.get(k) == true) {
				numMap.put(k, false);
				len++;
				k--;
			}

			maxLen = Integer.max(maxLen, len);
			len = 0;
			i++;
		}
		return maxLen;
	}

	public static void main(String[] args) {
		int[] nums = { 100, 4, 200, 1, 3, 2 };
		int maxLen = longestConsecutive(nums);

		System.out.println(maxLen);

		nums = new int[] { 1, 2, 3, 4, 7, 8, 9, 11, 12 };

		maxLen = longestConsecutive(nums);

		System.out.println(maxLen);

		nums = new int[] { 20, 30, 40 };

		maxLen = longestConsecutive(nums);

		System.out.println(maxLen);

	}

}
