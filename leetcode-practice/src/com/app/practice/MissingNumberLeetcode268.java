package com.app.practice;

public class MissingNumberLeetcode268 {
	private static int missingNumber(int[] nums) {
		int sum = 0;
		int n = nums.length;
		for(int i = 0; i <= n; i++) {
			sum += i;
		}
		
		for(int i = 0; i < n; i++) {
			sum -= nums[i];
		}
		return sum;
	}

	public static void main(String[] args) {
		int[] nums = { 3, 0, 1 };

		System.out.println(missingNumber(nums));

		nums = new int[] { 9, 6, 4, 2, 3, 5, 7, 0, 1 };
		
		System.out.println(missingNumber(nums));

	}

}
