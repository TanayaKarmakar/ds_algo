package com.app.questions;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumLeetcode39 {
	private static void getCombinationsHelper(List<List<Integer>> res, int[] candidates, int sum,
			int target, int startIndx, List<Integer> item) {
		if(sum > target)
			return;
		if(sum == target) {
			res.add(new ArrayList<>(item));
			return;
		}
		for(int i = startIndx; i < candidates.length; i++) {
			item.add(candidates[i]);
			getCombinationsHelper(res, candidates, sum + candidates[i], target, i, item);
			item.remove(item.size() - 1);
		}
	}

	private static List<List<Integer>> getCombinations(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> item = new ArrayList<>();
		getCombinationsHelper(res, candidates, 0, target, 0, item);
		return res;
	}

	public static void main(String[] args) {
		int[] candidates = { 2, 3, 6, 7 };
		int target = 7;

		List<List<Integer>> res = getCombinations(candidates, target);

		System.out.println(res);

	}

}
