package com.app.questions.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets2Leetcode90 {
	private static void subsetsWithDup(List<List<Integer>> res, List<Integer> item, int[] nums, int start) {
		res.add(new ArrayList<>(item));

		for (int i = start; i < nums.length; i++) {
			if (i > start && nums[i - 1] == nums[i])
				continue;
			item.add(nums[i]);
			subsetsWithDup(res, item, nums, i + 1);
			item.remove(item.size() - 1);
		}
	}

	private static List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> item = new ArrayList<>();
		subsetsWithDup(res, item, nums, 0);
		return res;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 2 };
		List<List<Integer>> res = subsetsWithDup(nums);
		
		System.out.println(res);
	}

}
