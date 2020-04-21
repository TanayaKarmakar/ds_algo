package com.app.questions.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class FourSumLeetcode18 {
	private static List<List<Integer>> fourSum(int[] nums, int target) {
		if(nums.length <= 3)
			return new ArrayList<>();
		Arrays.sort(nums);

		int n = nums.length;

		Set<List<Integer>> res = new LinkedHashSet<>();
		for (int i = 0; i < n - 2; i++) {
			for (int j = i + 1; j < n - 1; j++) {
				pairSum(nums[i], nums[j], j + 1, nums, target, res);
			}
		}

		return new ArrayList<>(res);
	}

	private static void pairSum(int num1, int num2, int start, int[] nums, int target, Set<List<Integer>> res) {
		int n = nums.length;
		int end = n - 1;
		while (start < end) {
			int sum = num1 + num2 + nums[start] + nums[end];
			if (sum == target) {
				List<Integer> items = new ArrayList<>();
				items.add(num1);
				items.add(num2);
				items.add(nums[start]);
				items.add(nums[end]);

				res.add(items);
				start++;
				end--;
			} else if (sum < target) {
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
