package com.app.questions.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSumLeetcode15 {
	private static List<List<Integer>> getThreeSum(int[] nums) {
		if (nums.length == 0)
			return new ArrayList<>();
		int n = nums.length;
		Arrays.sort(nums);
		Set<List<Integer>> res = new HashSet<>();
		for (int i = 0; i < n - 1; i++) {
			twoSum(nums[i], nums, i + 1, n, res);
		}

		return new ArrayList<>(res);
	}

	private static void twoSum(int num, int[] nums, int startIndx, int len, Set<List<Integer>> res) {
		int endIndx = len - 1;
		while (startIndx < endIndx) {
			if (num + nums[startIndx] + nums[endIndx] == 0) {
				List<Integer> item = new ArrayList<>();
				item.add(num);
				item.add(nums[startIndx]);
				item.add(nums[endIndx]);
				res.add(item);
				startIndx++;
				endIndx--;
			} else if (num + nums[startIndx] + nums[endIndx] < 0) {
				startIndx++;
			} else {
				endIndx--;
			}
		}

	}

	public static void main(String[] args) {
		int[] nums = { -1, 0, 1, 2, -1, -4 };
		List<List<Integer>> res = getThreeSum(nums);
		
		System.out.println(res);

	}

}
