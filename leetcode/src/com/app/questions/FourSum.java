package com.app.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class FourSum {
	private static List<List<Integer>> fourSum(int[] nums, int target) {
		Arrays.sort(nums);
		Set<List<Integer>> numSet = new LinkedHashSet<>();
		int n = nums.length;

		for (int i = 0; i < (n - 2); i++) {
			for (int j = i + 1; j < n - 1; j++) {
				pairSum(nums, j + 1, nums[i], nums[j], target, numSet);
			}
		}

		return new ArrayList<>(numSet);
	}

	private static void pairSum(int[] nums, int start, int n1, int n2, int n3, Set<List<Integer>> numSet) {
		int end = nums.length - 1;
		int sum = n3 - (n1 + n2);

		while (start < end) {
			int currSum = nums[start] + nums[end];
			if (currSum == sum) {
				List<Integer> res = new ArrayList<>();
				res.add(n1);
				res.add(n2);
				res.add(nums[start]);
				res.add(nums[end]);
				numSet.add(res);
				start++;
				end--;
			} else if (currSum < sum) {
				start++;
			} else {
				end--;
			}
		}
	}

	public static void main(String[] args) {
		int[] nums = { 1, 0, -1, 0, -2, 2 };
		List<List<Integer>> res = fourSum(nums, 0);
		System.out.println(res);
	}

}
