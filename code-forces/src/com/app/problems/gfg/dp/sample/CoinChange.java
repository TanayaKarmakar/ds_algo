package com.app.problems.gfg.dp.sample;

import java.util.Scanner;

public class CoinChange {
	private static int totalWays(int[] denom, int n) {
		int[][] dp = new int[denom.length][n + 1];
		
		for(int i = 0; i < denom.length; i++) {
			dp[i][0] = 1;
		}
		
		for(int i = 0; i < denom.length; i++) {
			for(int j = 1; j <= n; j++) {
				if(i - 1 >= 0) {
					dp[i][j] = dp[i - 1][j];
				}
				if(j >= denom[i]) {
					dp[i][j] += dp[i][j - denom[i]];
				}
			}
		}
		
		return dp[denom.length - 1][n];
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int nD = scanner.nextInt();
		
		int[] denom = new int[nD];
		
		for(int i = 0; i < nD; i++) {
			denom[i] = scanner.nextInt();
		}
		
		int n = scanner.nextInt();
		int totalWays = totalWays(denom, n);
		
		System.out.println(totalWays);
		
		scanner.close();

	}

}
