package com.app.questions.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSum2Leetcode40 {
	private static void combinationSum2(Set<List<Integer>> res, List<Integer> item, int[] candidates, int target,
			int indx) {
		if (target < 0)
			return;
		if (target == 0) {
			res.add(new ArrayList<>(item));
			return;
		}
		for (int i = indx; i < candidates.length; i++) {
			if(i > indx && candidates[i - 1] == candidates[i]) continue;
			item.add(candidates[i]);
			combinationSum2(res, item, candidates, target - candidates[i], i + 1);
			item.remove(item.size() - 1);
		}
	}

	private static List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		Set<List<Integer>> res = new HashSet<>();
		List<Integer> item = new ArrayList<>();
		combinationSum2(res, item, candidates, target, 0);
		return new ArrayList<>(res);
	}

	public static void main(String[] args) {
		int[] candidates = { 10, 1, 2, 7, 6, 1, 5 };
		int target = 8;

		List<List<Integer>> res = combinationSum2(candidates, target);

		System.out.println(res);

		candidates = new int[] { 2, 5, 2, 1, 2 };
		target = 5;
		
		res = combinationSum2(candidates, target);

		System.out.println(res);

	}

}
