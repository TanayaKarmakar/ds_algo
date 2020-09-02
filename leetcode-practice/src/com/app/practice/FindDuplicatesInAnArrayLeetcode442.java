package com.app.practice;

import java.util.ArrayList;
import java.util.List;

public class FindDuplicatesInAnArrayLeetcode442 {
	private static List<Integer> findDuplicates(int[] nums) {
		int n = nums.length;

		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int indx = Math.abs(nums[i]);
			if (nums[indx - 1] > 0) {
				nums[indx - 1] = -nums[indx - 1];
			} else {
				res.add(indx);
			}
		}

		return res;
	}

	public static void main(String[] args) {
		int[] nums = { 4, 3, 2, 7, 8, 2, 3, 1 };

		System.out.println(findDuplicates(nums));

	}

}
