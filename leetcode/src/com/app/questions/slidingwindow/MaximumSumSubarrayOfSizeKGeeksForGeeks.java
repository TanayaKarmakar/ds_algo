package com.app.questions.slidingwindow;

public class MaximumSumSubarrayOfSizeKGeeksForGeeks {
	private static int maxSum(int[] nums, int k) {
		int n = nums.length;
		int sum = 0;
		int l = 0;
		int r = 0;
		while (r < k) {
			sum += nums[r];
			r++;
		}

		int maxSum = sum;
		while (r < n) {
			sum += nums[r] - nums[l];
			r++;
			l++;
			maxSum = Integer.max(maxSum, sum);
		}
		return maxSum;
	}

	public static void main(String[] args) {
		int[] nums = { 100, 200, 300, 400 };
		int maxSum = maxSum(nums, 2);
		
		System.out.println(maxSum);
	}

}
