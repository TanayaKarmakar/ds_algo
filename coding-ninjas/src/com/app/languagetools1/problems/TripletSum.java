package com.app.languagetools1.problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TripletSum {
	private static void tripletSumInefficient(int[] nums, int sum) {
		Arrays.sort(nums);
		int n = nums.length;
		for (int i = 0; i < n - 1; i++) {
			int val1 = nums[i];
			for (int j = i + 1; j < n; j++) {
				int val2 = nums[j];
				for (int k = j + 1; k < n; k++) {
					if (val1 + val2 + nums[k] == sum) {
						System.out.println(i + " " + j + " " + k);
					}
				}
			}
		}
	}

	private static void twoSumProperty(int[] nums, int startIndx, int sum, int k, int n) {
		Set<Integer> set = new HashSet<>();
		sum = sum - k;
		for (int i = startIndx; i < n; i++) {
			if (set.contains(sum - nums[i])) {
				System.out.println(
						k + " " + Integer.min(nums[i], sum - nums[i]) + " " + Integer.max(nums[i], sum - nums[i]));
			} else {
				set.add(nums[i]);
			}
		}
	}

	private static void tripletSum(int[] nums, int sum) {
		Arrays.sort(nums);
		int n = nums.length;

		for (int i = 0; i < n - 1; i++) {
			int k = nums[i];
			twoSumProperty(nums, i + 1, sum, k, n);
		}
//		Arrays.sort(nums);
//		int n = nums.length;
//		for (int i = 0; i < n; i++) {
//			int left = i + 1;
//			int right = n - 1;
//			int item = nums[i];
//			while (left < right) {
//				if (item + nums[left] + nums[right] == sum) {
//					System.out.println(item + " " + nums[left] + " " + nums[right]);
//					left++;
//					right--;
//				} else if (item + nums[left] + nums[right] < sum) {
//					left++;
//				} else {
//					right--;
//				}
//			}
//		}
	}

	public static void main(String[] args) {
//		int val = 12;
//		int[] nums = { 1, 2, 3, 4, 5, 6, 7 };

		int val = 6;
		int[] nums = { 1, 2, 2, 3, 3 };
		tripletSumInefficient(nums, val);
	}

}
