package com.app.dp2.problems;

public class Knapsack01BottomUp {
	private static int knapSackSpaceOptimized(int[] weight, int[] value, int maxWeight) {
		int[] dp = new int[maxWeight + 1];
		int n = weight.length;
		
		for(int i = 0; i <= maxWeight; i++) {
			if(i >= weight[0]) {
				dp[i] = value[0];
			}
		}
		
		for(int i = 1; i < n; i++) {
			for(int j = maxWeight; j >= 0; j--) {
				int option1 = 0;
				if(j >= weight[i]) {
					option1 = value[i] + dp[j - weight[i]];
				} 
				int option2 = dp[j];
				dp[j] = Integer.max(option1, option2);
			}
		}
		
		return dp[maxWeight];
	}
	
	private static int knapSack(int[] weight, int[] value, int maxWeight) {
		int n = weight.length;
		int[][] dp = new int[n][maxWeight + 1];

		for (int i = 1; i <= maxWeight; i++) {
			if (i >= weight[0]) {
				dp[0][i] = value[0];
			}
		}

		for (int i = 1; i < n; i++) {
			for (int j = 1; j <= maxWeight; j++) {
				if (j >= weight[i]) {
					int option1 = dp[i - 1][j];
					int option2 = value[i] + dp[i - 1][j - weight[i]];
					dp[i][j] = Integer.max(option1, option2);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[n - 1][maxWeight];
	}

	public static void main(String[] args) {
		int[] weight = { 1, 2, 4, 5 };
		int[] value = { 5, 4, 8, 6 };
		int maxWt = 5;
		
		int ans = knapSack(weight, value, maxWt);
		
		int ans1 = knapSackSpaceOptimized(weight, value, maxWt);
		
		System.out.println(ans);
		
		System.out.println(ans1);

	}

}
