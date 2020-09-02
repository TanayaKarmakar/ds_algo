package com.app.practice;

public class SplitArrayLargestSumLeetcode410 {
	private static boolean isConfigPossible(int[] nums, int mid, int m) {
		int count = 1;
		int sum = 0;
		for (int num : nums) {
			if (sum + num <= mid) {
				sum += num;
			} else {
				sum = num;
				count++;
				if (count > m)
					return false;
			}
		}
		return true;
	}

	private static int splitArray(int[] nums, int m) {
		int start = 0;
		int end = 0;
		for (int num : nums) {
			start = Integer.max(start, num);
			end += num;
		}

		while (start <= end) {
			int mid = (start + end) >> 1;
			if (isConfigPossible(nums, mid, m)) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return start;
	}

	public static void main(String[] args) {
		int[] nums = { 7, 2, 5, 10, 8 };
		int m = 2;
		
		System.out.println(splitArray(nums, m));
	}

}
