package com.app.questions;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicates {
	private static List<Integer> findDuplicates(int[] nums) {
		List<Integer> res = new ArrayList<>();
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			int k = Math.abs(nums[i]);
			if (k - 1 >= 0 && k - 1 < n) {
				if (nums[k - 1] > 0) {
					nums[k - 1] = -nums[k - 1];
				} else {
					res.add(k);
				}
			}
		}

		return res;
	}

	public static void main(String[] args) {
		int[] nums = { 4, 3, 2, 7, 8, 2, 3, 1 };
		System.out.println(findDuplicates(nums));

		nums = new int[] { 2, 2 };
		System.out.println(findDuplicates(nums));
	}

}
