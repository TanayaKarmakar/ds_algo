package com.app.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PermutationOfAnArray {
	private static void permuteRec(List<List<Integer>> res, List<Integer> nums, int l, int r) {
		if (l == r) {
			List<Integer> items = new ArrayList<>();
			for (Integer el : nums) {
				items.add(el);
			}
			res.add(items);
			return;
		}

		for (int i = l; i <= r; i++) {
			Collections.swap(nums, i, l);
			permuteRec(res, nums, l + 1, r);
			Collections.swap(nums, i, l);
		}
	}

	private static List<List<Integer>> permute(List<Integer> nums) {
		List<List<Integer>> res = new ArrayList<>();
		permuteRec(res, nums, 0, nums.size() - 1);
		return res;
	}

	public static void main(String[] args) {
		List<Integer> nums = new ArrayList<>();
		nums.add(1);
		nums.add(2);
		nums.add(3);

		List<List<Integer>> res = permute(nums);

		System.out.println(res);
	}

}
