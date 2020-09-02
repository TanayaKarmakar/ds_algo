package com.app.practice;

import java.util.ArrayList;
import java.util.List;

public class SubsetsLeetcode78 {
	private static void subsets(List<List<Integer>> res, List<Integer> item, int[] nums, int start) {
		res.add(new ArrayList<>(item));

		for (int i = start; i < nums.length; i++) {
			item.add(nums[i]);
			subsets(res, item, nums, i + 1);
			item.remove(item.size() - 1);
		}
	}

	private static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> item = new ArrayList<>();

		subsets(res, item, nums, 0);

		return res;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };
		List<List<Integer>> res = subsets(nums);
		
		System.out.println(res);

	}

}
