package com.app.practice.recursionbacktracking;

import java.util.ArrayList;
import java.util.List;

public class SubsetsLeetcode78 {
	private static List<List<Integer>> subsets(List<List<Integer>> res, int[] nums, int indx) {
		if (indx >= nums.length) {
			res.add(new ArrayList<>());
			return res;
		}
		res = subsets(res, nums, indx + 1);
		List<List<Integer>> newRes = new ArrayList<>();
 		for (List<Integer> item : res) {
			List<Integer> newList = new ArrayList<>();
			newList.add(nums[indx]);
			newList.addAll(item);
			newRes.add(item);
			newRes.add(newList);
		}

		return newRes;
	}

	private static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		return subsets(res, nums, 0);
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };
		List<List<Integer>> res = subsets(nums);
		
		System.out.println(res);
	}

}
