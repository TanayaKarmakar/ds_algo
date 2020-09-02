package com.app.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationsSum2Leetcode40 {
	private static void combinationSum2(List<List<Integer>> res, List<Integer> item, int[] candidates, int indx,
			int target) {
		if (target == 0) {
			res.add(new ArrayList<>(item));
			return;
		}
		if (target < 0)
			return;
		for (int i = indx; i < candidates.length; i++) {
			if (i > indx && candidates[i] == candidates[i - 1])
				continue;
			item.add(candidates[i]);
			combinationSum2(res, item, candidates, i + 1, target - candidates[i]);
			item.remove(item.size() - 1);
		}
	}

	private static List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> item = new ArrayList<>();
		combinationSum2(res, item, candidates, 0, target);
		return res;
	}

	public static void main(String[] args) {
		int[] candidates = { 10, 1, 2, 7, 6, 1, 5 };
		int target = 8;
		
		List<List<Integer>> res = combinationSum2(candidates, target);
		
		System.out.println(res);

	}

}
