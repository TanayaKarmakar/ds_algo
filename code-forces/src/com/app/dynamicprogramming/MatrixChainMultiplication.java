package com.app.dynamicprogramming;

public class MatrixChainMultiplication {
	private static int minMCM(int[] arr) {
		int[][] dp = new int[arr.length - 1][arr.length - 1];

		for (int g = 0; g < dp.length; g++) {
			for (int i = 0, j = g; j < dp.length; i++, j++) {
				if (g == 0) {
					dp[i][j] = 0;
				} else if (g == 1) {
					dp[i][j] = arr[i] * arr[j] * arr[j + 1];
				} else {
					int min = Integer.MAX_VALUE;
					for (int k = i; k < j; k++) {
						int lc = dp[i][k];
						int rc = dp[k + 1][j];
						int mc = arr[i] * arr[k + 1] * arr[j + 1];
						int tc = lc + rc + mc;
						min = Integer.min(tc, min);
					}
					dp[i][j] = min;
				}
			}
		}
		return dp[0][dp.length - 1];
	}

	public static void main(String[] args) {
		int[] nums = { 10, 20, 30, 40, 50, 60 };
		int minCost = minMCM(nums);
		
		System.out.println(minCost);

	}

}
