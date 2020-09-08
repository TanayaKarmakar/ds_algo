package com.app.practice.recursionbacktracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumLeetcode39 {
	private static void combinationSum(List<List<Integer>> res, List<Integer> item, int[] candidates, int target,
			int indx) {
		if (target == 0) {
			res.add(new ArrayList<>(item));
			return;
		}
		if (target < 0 || indx >= candidates.length)
			return;

		for (int i = indx; i < candidates.length; i++) {
			item.add(candidates[i]);
			combinationSum(res, item, candidates, target - candidates[i], i);
			item.remove(item.size() - 1);
		}
	}

	private static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> item = new ArrayList<>();

		combinationSum(res, item, candidates, target, 0);
		return res;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 3, 6, 7 };
		int target = 7;
		
		List<List<Integer>> res = combinationSum(nums, target);
		
		System.out.println(res);
	}

}
