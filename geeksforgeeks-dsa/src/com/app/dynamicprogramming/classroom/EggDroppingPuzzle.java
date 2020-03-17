package com.app.dynamicprogramming.classroom;

public class EggDroppingPuzzle {
	private static int getMinTries(int n, int k) {
		int[][] dp = new int[n + 1][k + 1];

		for (int i = 1; i <= k; i++) {
			dp[1][i] = 1;
		}

		for (int i = 1; i <= n; i++) {
			dp[i][1] = i;
		}

		for (int i = 2; i <= n; i++) {
			for (int j = 2; j <= k; j++) {
				dp[i][j] = Integer.MAX_VALUE;
				for (int x = 1; x < i; x++) {
					int eggBroke = dp[x - 1][j - 1];
					int eggDidNotBreak = dp[i - x][j];
					int temp = Integer.max(eggBroke, eggDidNotBreak) + 1;
					if (dp[i][j] > temp) {
						dp[i][j] = temp;
					}
				}
			}
		}
		return dp[n][k];
	}

	public static void main(String[] args) {
		int minimumTries = getMinTries(8, 4);

		System.out.println("Minimum Tries - " + minimumTries);

	}

}
