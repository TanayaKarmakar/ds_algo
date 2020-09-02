package com.app.practice;

public class BuyAndSellStockLeetcode121 {
	private static int maxProfit(int[] nums) {
		int n = nums.length;

		int minPrice = Integer.MAX_VALUE;
		int maxProfit = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			minPrice = Integer.min(minPrice, nums[i]);
			maxProfit = Integer.max(maxProfit, (nums[i] - minPrice));
		}

		return maxProfit;
	}

	public static void main(String[] args) {
		int[] nums = { 7, 1, 5, 3, 6, 4 };

		int maxProfit = maxProfit(nums);

		System.out.println(maxProfit);

		nums = new int[] { 7, 6, 4, 3, 1 };
		
		maxProfit = maxProfit(nums);

		System.out.println(maxProfit);

	}

}
