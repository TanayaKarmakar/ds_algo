package com.app.dynamicprogramming;

public class BurstBalloon {
	private static long maxPrice(int[] balloons) {
		int[][] dp = new int[balloons.length][balloons.length];

		for (int g = 0; g < dp.length; g++) {
			for (int i = 0, j = g; j < dp.length; i++, j++) {
				int max = Integer.MIN_VALUE;
				for (int k = i; k <= j; k++) {
					int left = (k == i) ? 0 : dp[i][k - 1];
					int right = (k == j) ? 0 : dp[k + 1][j];
					int val = balloons[k];

					if (i > 0) {
						val *= balloons[i - 1];
					}

					if (j != balloons.length - 1) {
						val *= balloons[j + 1];
					}

					int total = left + right + val;
					max = Integer.max(total, max);
				}
				dp[i][j] = max;
			}
		}
		return dp[0][dp.length - 1];
	}

	public static void main(String[] args) {
		int[] balloons = { 2, 3, 1, 5, 6, 4 };
		
		long max = maxPrice(balloons);
		
		System.out.println(max);

	}

}
