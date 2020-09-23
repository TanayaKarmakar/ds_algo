package com.app.practice.recursionbacktracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumIILeetcode40 {
	private static void combinationSum2(List<List<Integer>> res, List<Integer> item, int[] candidates, int target,
			int start) {
		if (target == 0) {
			List<Integer> item1 = new ArrayList<>();
			for (Integer el : item) {
				item1.add(el);
			}
			res.add(item1);
			return;
		}
		if (target < 0 || start >= candidates.length)
			return;
		for (int i = start; i < candidates.length; i++) {
			if(i != start && candidates[i - 1] == candidates[i])
				continue;
			item.add(candidates[i]);
			combinationSum2(res, item, candidates, target - candidates[i], i + 1);
			item.remove(item.size() - 1);
		}
	}

	private static List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> item = new ArrayList<>();
		combinationSum2(res, item, candidates, target, 0);
		return res;
	}

	public static void main(String[] args) {
		int[] candidates = { 10, 1, 2, 7, 6, 1, 5 };
		int target = 8;
		List<List<Integer>> res = combinationSum2(candidates, target);

		System.out.println(res);
	}

}
