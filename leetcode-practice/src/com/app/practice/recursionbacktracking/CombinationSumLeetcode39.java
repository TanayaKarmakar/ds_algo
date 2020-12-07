package com.app.practice.recursionbacktracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumLeetcode39 {
	private static void combinationSum(int[] candidates, int target, int sum, List<List<Integer>> result,
			List<Integer> item, int indx) {
		if (sum == target) {
			List<Integer> newList = new ArrayList<>(item);
			result.add(newList);
			return;
		}

		if (sum > target)
			return;

		for (int i = indx; i < candidates.length; i++) {
			item.add(candidates[i]);
			combinationSum(candidates, target, sum + candidates[i], result, item, i);
			item.remove(item.size() - 1);
		}
	}

	private static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> item = new ArrayList<>();

		combinationSum(candidates, target, 0, result, item, 0);
		return result;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 3, 6, 7 };
		int target = 7;
		
		List<List<Integer>> result = combinationSum(nums, target);
		
		System.out.println(result);

	}

}
