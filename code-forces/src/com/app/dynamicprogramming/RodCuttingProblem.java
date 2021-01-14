package com.app.dynamicprogramming;

public class RodCuttingProblem {
	private static int maxPrice(int[] prices) {
		int n = prices.length;
		int[] dp = new int[n + 1];

		dp[1] = prices[0];

		for (int i = 2; i <= n; i++) {
			dp[i] = prices[i - 1];
			int left = 1;
			int right = i - 1;

			while (left <= right) {
				dp[i] = Integer.max(dp[i], dp[left] + dp[right]);
				left++;
				right--;
			}
		}

		return dp[n];
	}

	public static void main(String[] args) {
		int[] prices = { 1, 5, 8, 9, 10, 17, 17, 20 };
		
		int maxPrice = maxPrice(prices);
		
		System.out.println(maxPrice);

	}

}
