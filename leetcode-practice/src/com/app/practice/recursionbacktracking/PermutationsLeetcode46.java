package com.app.practice.recursionbacktracking;

import java.util.ArrayList;
import java.util.List;

public class PermutationsLeetcode46 {
	private static void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

	private static void permute(List<List<Integer>> res, int[] nums, int l, int r) {
		if (l == r) {
			List<Integer> item = new ArrayList<>();
			for (int num : nums) {
				item.add(num);
			}
			res.add(item);
			return;
		}

		for (int i = l; i <= r; i++) {
			swap(nums, l, i);
			permute(res, nums, l + 1, r);
			swap(nums, l, i);
		}
	}

	private static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> permutations = new ArrayList<>();
		permute(permutations, nums, 0, nums.length - 1);
		return permutations;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };
		List<List<Integer>> res = permute(nums);
		
		System.out.println(res);
	}

}
