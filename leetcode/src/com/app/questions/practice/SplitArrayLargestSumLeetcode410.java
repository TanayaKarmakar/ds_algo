package com.app.questions.practice;

public class SplitArrayLargestSumLeetcode410 {
	private static boolean isPossible(int[] nums, int mid, int m) {
		int nSplits = 1;
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			if (sum + nums[i] <= mid)
				sum += nums[i];
			else {
				sum = nums[i];
				nSplits++;
				if (nSplits > m)
					return false;
			}
		}
		return true;
	}

	private static int splitArray(int[] nums, int m) {
		int start = 0;
		int end = 0;
		for (int n : nums) {
			start = Integer.max(start, n);
			end += n;
		}

		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (isPossible(nums, mid, m))
				end = mid - 1;
			else
				start = mid + 1;
		}
		return start;
	}

	public static void main(String[] args) {
		int[] nums = { 7, 2, 5, 10, 8 };
		int m = 2;
		
		int val = splitArray(nums, m);
		
		System.out.println(val);

	}

}
