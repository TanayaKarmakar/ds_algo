package com.app.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {
	private static List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);

		int n = nums.length;
		Set<List<Integer>> res = new LinkedHashSet<>();
		for (int i = 0; i < n - 1; i++) {
			getTwoSum(nums, i + 1, nums[i], res);
		}

		return new ArrayList<>(res);
	}

	private static void getTwoSum(int[] nums, int start, int sum, Set<List<Integer>> res) {
		int end = nums.length - 1;

		while (start < end) {
			int currSum = nums[start] + nums[end];
			if (currSum == -sum) {
				List<Integer> curr = new ArrayList<>();
				curr.add(sum);
				curr.add(nums[start]);
				curr.add(nums[end]);
				res.add(curr);
				start++;
				end--;
			} else if (currSum > Math.abs(sum)) {
				end--;
			} else {
				start++;
			}
		}
	}

	public static void main(String[] args) {
		int[] nums = { -1, 0, 1, 2, -1, -4 };
		List<List<Integer>> res = threeSum(nums);
		System.out.println(res);

		nums = new int[] { 0, 0, 0, 0 };
		res = threeSum(nums);

		System.out.println(res);

		nums = new int[] { -2, 0, 1, 1, 2 };

		res = threeSum(nums);

		System.out.println(res);

		nums = new int[] { -4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6 };
		
		res = threeSum(nums);
		
		System.out.println(res);
	}

}
