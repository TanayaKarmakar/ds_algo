package com.app.practice.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSumProblemLeetcode3 {
	private static List<List<Integer>> getZeroSum(int[] nums) {
		int n = nums.length;
		Arrays.sort(nums);

		Set<List<Integer>> res = new HashSet<>();
		for (int i = 0; i < n - 2; i++) {
			twoSum(nums, nums[i], i + 1, res);
		}

		return new ArrayList<>(res);
	}

	private static void twoSum(int[] nums, int num, int start, Set<List<Integer>> res) {
		int end = nums.length - 1;
		while (start < end) {
			if (num + nums[start] + nums[end] == 0) {
				List<Integer> item = new ArrayList<>();
				item.add(num);
				item.add(nums[start]);
				item.add(nums[end]);
				res.add(item);
				start++;
				end--;
			} else if (num + nums[start] + nums[end] > 0)
				end--;
			else
				start++;
		}
	}

	public static void main(String[] args) {
		int[] nums = { -1, 0, 1, 2, -1, -4 };
		
		List<List<Integer>> res = getZeroSum(nums);
		
		System.out.println(res);

	}

}
