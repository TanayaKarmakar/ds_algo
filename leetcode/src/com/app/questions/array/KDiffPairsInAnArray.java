package com.app.questions.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class KDiffPairsInAnArray {
	private static int findPairsEfficient(int[] nums, int k) {
		int ans = 0;

		if (k == 0) {
			Map<Integer, Integer> map = new HashMap<>();
			for (int n : nums) {
				map.put(n, map.getOrDefault(n, 0) + 1);
				if (map.get(n) == 2)
					ans++;
			}

			return ans;
		}

		Set<Integer> set = new HashSet<>();
		for (int n : nums) {
			if (!set.contains(n)) {
				if (set.contains(n - k))
					ans++;
				if (set.contains(n + k))
					ans++;
				set.add(n);
			}
		}

		return ans;
	}

	private static int findPairs(int[] nums, int k) {
		if (nums.length < 2)
			return 0;

		int n = nums.length;

		Set<String> pairs = new HashSet<>();

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				int diff = Math.abs(nums[i] - nums[j]);

				if (diff == k) {
					int min = Integer.min(nums[i], nums[j]);
					int max = Integer.max(nums[i], nums[j]);
					pairs.add(min + "-" + max);
				}
			}
		}

		return pairs.size();
	}

	public static void main(String[] args) {
		int[] nums = { 3, 1, 4, 1, 5 };
		int k = 2;

		int ans = findPairsEfficient(nums, k);

		System.out.println(ans);

	}

}
