package com.app.questions.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumLeetcode39 {
	private static void combinationSum(List<List<Integer>> res, List<Integer> item, int[] candidates, int start, 
			int target) {
		if (target < 0)
			return;
		if (target == 0) {
			List<Integer> newItem = new ArrayList<>(item);
			res.add(newItem);
			return;
		}
		for (int i = start; i < candidates.length; i++) {
			item.add(candidates[i]);
			combinationSum(res, item, candidates, i, target - candidates[i]);
			item.remove(item.size() - 1);
		}

	}

	private static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> item = new ArrayList<>();

		combinationSum(res, item, candidates, 0, target);
		return res;
	}

	public static void main(String[] args) {
		int[] candidates = { 2, 3, 6, 7 };
		int target = 7;
		List<List<Integer>> res = combinationSum(candidates, target);
		
		System.out.println(res);

	}

}
