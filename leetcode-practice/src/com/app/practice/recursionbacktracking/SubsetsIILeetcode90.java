package com.app.practice.recursionbacktracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsIILeetcode90 {
	private static void subsetsWithDup(int[] nums, List<Integer> subset, List<List<Integer>> subsets, int start) {
		List<Integer> newList = new ArrayList<>(subset);
		subsets.add(newList);
		for (int i = start; i < nums.length; i++) {
			if (i > start && nums[i - 1] == nums[i]) 
				continue;
			subset.add(nums[i]);
			subsetsWithDup(nums, subset, subsets, i + 1);
			subset.remove(subset.size() - 1);	
		}
	}

	private static List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
		List<Integer> subset = new ArrayList<>();
		List<List<Integer>> subsets = new ArrayList<>();

		subsetsWithDup(nums, subset, subsets, 0);

		return subsets;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 2 };
		List<List<Integer>> res = subsetsWithDup(nums);
		
		System.out.println(res);

	}

}
