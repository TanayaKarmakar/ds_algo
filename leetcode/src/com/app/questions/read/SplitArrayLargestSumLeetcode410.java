package com.app.questions.read;

public class SplitArrayLargestSumLeetcode410 {
	private static boolean isPossible(int[] nums, int m, long mid) {
		int sum = 0;
		int nSplits = 1;
		for (int i = 0; i < nums.length; i++) {
			if (sum + nums[i] <= mid) {
				sum = sum + nums[i];
			} else {
				sum = nums[i];
				nSplits++;
				if (nSplits > m)
					return false;
			}
		}
		return true;
	}

	public static int splitArray(int[] nums, int m) {
		//Arrays.sort(nums);
		int totalSum = 0;
		long start = 0;
		for (int el : nums) {
			totalSum += el;
			start = Long.max(start, el);
		}

		
		long end = totalSum;
		while (start <= end) {
			long mid = start + (end - start) / 2;
			if (isPossible(nums, m, mid)) { 
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return (int)start;
	}

	public static void main(String[] args) {
		int[] nums = { 7, 2, 5, 10, 8 };
		int m = 2;

		System.out.println(splitArray(nums, m));
	}

}
