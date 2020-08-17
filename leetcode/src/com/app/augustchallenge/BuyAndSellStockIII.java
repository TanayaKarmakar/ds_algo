package com.app.augustchallenge;

public class BuyAndSellStockIII {
	private static int maxProfit(int[] prices) {
		if(prices.length == 0)
			return 0;
		int n = prices.length;
		int k = 2;

		int[][] profit = new int[k + 1][n];

		for (int t = 1; t <= k; t++) {
			int maxProfit = Integer.MIN_VALUE;
			for (int d = 1; d < n; d++) {
				int currentProfit = profit[t - 1][d - 1] - prices[d - 1];
				maxProfit = Integer.max(currentProfit, maxProfit);

				int option1 = profit[t][d - 1];
				int option2 = prices[d] + maxProfit;
				profit[t][d] = Integer.max(option1, option2);
			}
		}

		return profit[k][n - 1];
	}

	public static void main(String[] args) {
		int[] nums = { 3, 3, 5, 0, 0, 3, 1, 4 };
		int maxProfit = maxProfit(nums);

		System.out.println(maxProfit);

		nums = new int[] { 1, 2, 3, 4, 5 };

		maxProfit = maxProfit(nums);

		System.out.println(maxProfit);

		nums = new int[] { 7, 6, 4, 3, 1 };

		maxProfit = maxProfit(nums);

		System.out.println(maxProfit);
	}

}
