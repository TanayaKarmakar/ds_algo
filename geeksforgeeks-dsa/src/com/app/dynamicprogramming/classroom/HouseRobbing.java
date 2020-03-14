package com.app.dynamicprogramming.classroom;

public class HouseRobbing {

	// application of maximum subarray sum with constraint 1
	private static int getMaximumMoney(int[] nums) {
		int n = nums.length;
		int[] maxMoney = new int[n];

		maxMoney[0] = nums[0];
		maxMoney[1] = Integer.max(nums[0], nums[1]);
		for (int i = 2; i < n; i++) {
			maxMoney[i] = Integer.max(maxMoney[i - 1], nums[i] + maxMoney[i - 2]);
		}
		return maxMoney[n - 1];
	}

	public static void main(String[] args) {
		int[] nums = { 2, 3, 16, 100, 4, 5 };
		
		int maxMoney = getMaximumMoney(nums);
		
		System.out.println("MaxMoney - " + maxMoney);

	}

}
