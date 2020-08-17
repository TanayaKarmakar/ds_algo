package com.app.augustchallenge;

public class BuyAndSellStockIIISpaceOptimized {
	private static int maxProfit(int[] prices) {
		if(prices.length == 0)
			return 0;
		int n = prices.length;
		int[] oddProfits = new int[n];
		int[] evenProfits = new int[n];
		
		int k = 2;
		
		for(int t = 1; t <= k; t++) {
			int[] currentProfits;
			int[] previousProfits;
			
			int maxProfit = Integer.MIN_VALUE;
			
			if(k % 2 != 0) {
				currentProfits = oddProfits;
				previousProfits = evenProfits;
			} else {
				currentProfits = evenProfits;
				previousProfits = oddProfits;
			}
			
			for(int d = 1; d < n; d++) {
				int currentProfit = previousProfits[d - 1] - prices[d - 1];
				maxProfit = Integer.max(maxProfit, currentProfit);
				
				int option1 = currentProfits[d - 1];
				int option2 = prices[d] + maxProfit;
				
				currentProfits[d] = Integer.max(option1, option2);
			}
		}
		
		if(k % 2 != 0)
			return oddProfits[n - 1];
		else
			return evenProfits[n - 1];
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
