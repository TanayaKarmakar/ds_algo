package com.app.practice.recursionbacktracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumLeetcode39 {
	private static void combinationSum(List<List<Integer>> set, List<Integer> item, 
			int[] nums, int target, int indx) {
		if (target == 0) {
			List<Integer> newList = new ArrayList<>();
			newList.addAll(item);
			set.add(newList);
			return;
		}
		if (target < 0)
			return;
		for (int i = indx; i < nums.length; i++) {
			item.add(nums[i]);
			combinationSum(set, item, nums, target - nums[i], i);
			item.remove(item.size() - 1);
		}
	}

	private static List<List<Integer>> combinationSum(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> item = new ArrayList<>();
		combinationSum(res, item, nums, target, 0);
		return res;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 3, 6, 7 };
		int target = 7;
		
		List<List<Integer>> res = combinationSum(nums, target);
		
		System.out.println(res);

	}

}
