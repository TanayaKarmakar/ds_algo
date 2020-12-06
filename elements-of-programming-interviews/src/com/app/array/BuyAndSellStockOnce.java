package com.app.array;

public class BuyAndSellStockOnce {
	private static int maxProfit(int[] nums) {
		int minPrice = Integer.MAX_VALUE;
		int maxProfit = Integer.MIN_VALUE;

		int n = nums.length;
		for (int i = 0; i < n; i++) {
			minPrice = Integer.min(minPrice, nums[i]);
			maxProfit = Integer.max(maxProfit, (nums[i] - minPrice));
		}

		return maxProfit == Integer.MIN_VALUE ? 0 : maxProfit;
	}

	public static void main(String[] args) {
		int[] nums = { 310, 315, 275, 295, 260, 270, 290, 230, 255, 250 };
		
		int maxProfit = maxProfit(nums);
		
		System.out.println(maxProfit);
	}

}
