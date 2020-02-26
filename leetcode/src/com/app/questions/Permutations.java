package com.app.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations {
	private static void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

	private static void permuteRec(int[] nums, int l, int r, List<List<Integer>> res) {
		if (l == r) {
			List<Integer> numsList = Arrays.stream(nums).mapToObj(el -> el).collect(Collectors.toList());
			res.add(numsList);
		} else {
			for (int i = l; i <= r; i++) {
				swap(nums, l, i);
				permuteRec(nums, l + 1, r, res);
				swap(nums, l, i);
			}
		}
	}

	private static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		permuteRec(nums, 0, nums.length - 1, res);

		return res;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };

		List<List<Integer>> res = permute(nums);
		System.out.println(res);

	}

}
