package com.app.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSumLeetcode15 {
	private static void isTwoSum(int num, int[] nums, int start, int n, Set<List<Integer>> items) {
		int end = n - 1;
		while (start < end) {
			if (num + nums[start] + nums[end] == 0) {
				List<Integer> item = new ArrayList<>();
				item.add(num);
				item.add(nums[start]);
				item.add(nums[end]);
				items.add(item);
				start++;
				end--;
			} else if (num + nums[start] + nums[end] > 0) {
				end--;
			} else {
				start++;
			}
		}
	}

	private static List<List<Integer>> threeSum(int[] nums) {
		if (nums.length < 3) {
			return new ArrayList<>();
		}
		Set<List<Integer>> res = new HashSet<>();

		int n = nums.length;

		Arrays.sort(nums);

		for (int i = 0; i < n; i++) {
			isTwoSum(nums[i], nums, i + 1, n, res);
		}
		return new ArrayList<>(res);
	}

	public static void main(String[] args) {
		int[] nums = { -1, 0, 1, 2, -1, -4 };
		List<List<Integer>> res = threeSum(nums);
		
		System.out.println(res);

	}

}
