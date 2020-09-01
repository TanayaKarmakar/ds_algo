package com.app.augustchallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PancakeSorting {
	private static int getIndx(int[] nums, int target) {
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			if (nums[i] == target) {
				return ++i;
			}
		}

		return -1;
	}

	private static void reverse(int[] nums, int len) {
		int start = 0;
		int end = len - 1;

		while (start < end) {
			int tmp = nums[start];
			nums[start] = nums[end];
			nums[end] = tmp;
			start++;
			end--;
		}
	}

	private static List<Integer> pancakeSort(int[] nums) {
		int n = nums.length;
		List<Integer> flips = new ArrayList<>();
		for (int target = n; target > 0; target--) {
			int indx = getIndx(nums, target);
			if (target == indx)
				continue;
			else if (indx >= 1) {
				flips.add(indx);
				reverse(nums, indx);
			}
			flips.add(target);
			reverse(nums, target);
		}

		return flips;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };

		List<Integer> flips = pancakeSort(nums);

		System.out.println(flips);

		System.out.println(Arrays.toString(nums));

	}

}
