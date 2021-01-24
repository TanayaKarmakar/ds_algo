package com.app.dynamicprogramming;

public class EggDroppingProblem {
	private static int minAttempt(int nE, int nF) {
		int[][] dp = new int[nE + 1][nF + 1];

		for (int i = 1; i <= nE; i++) {
			for (int j = 1; j <= nF; j++) {
				if (i == 1) {
					dp[i][j] = j;
				} else if (j == 1) {
					dp[i][j] = 1;
				} else {
					int min = Integer.MAX_VALUE;
					for (int j1 = j - 1, j2 = 0; j1 >= 0; j1--, j2++) {
						int val1 = dp[i][j1]; //egg survives
						int val2 = dp[i - 1][j2]; //egg breaks
						min = Integer.min(min, Integer.max(val1, val2));
					}
					dp[i][j] = min + 1;
				}
			}
		}
		
		return dp[nE][nF];
	}

	public static void main(String[] args) {
		int nE = 3;
		int nF = 7;
		
		int ans = minAttempt(nE, nF);
		
		System.out.println(ans);
	}

}
