package com.app.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FourSumLeetcode18 {
	private static List<List<Integer>> fourSum(int[] nums, int target) {
		Arrays.sort(nums);

		Set<List<Integer>> res = new HashSet<>();

		int n = nums.length;
		for (int i = 0; i < n - 2; i++) {
			int num1 = nums[i];
			for (int j = i + 1; j < n - 1; j++) {
				int num2 = nums[j];
				findSum(res, num1, num2, nums, j + 1, target, n);
			}
		}

		return new ArrayList<>(res);
	}

	private static void findSum(Set<List<Integer>> res, int num1, int num2, int[] nums, int start, int target, int n) {
		int l = start;
		int r = n - 1;
		while (l < r) {
			int sum = num1 + num2 + nums[l] + nums[r];
			if (sum == target) {
				List<Integer> item = new ArrayList<>();
				item.add(num1);
				item.add(num2);
				item.add(nums[l]);
				item.add(nums[r]);
				res.add(item);
				l++;
				r--;
			} else if (sum < target)
				l++;
			else
				r--;
		}
	}

	public static void main(String[] args) {
		int[] nums = { 1, 0, -1, 0, -2, 2 };
		List<List<Integer>> res = fourSum(nums, 0);
		
		System.out.println(res);

	}

}
