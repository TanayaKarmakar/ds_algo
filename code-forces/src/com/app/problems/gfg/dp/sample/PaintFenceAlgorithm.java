package com.app.problems.gfg.dp.sample;

import java.util.Scanner;

public class PaintFenceAlgorithm {
	private static final int MOD = 1000000007;
	
	private static int totalWays(int n, int k) {
		int[] dp = new int[n + 1];
		
		dp[0] = 0;
		dp[1] = k;
		dp[2] = k*k;
		
		for(int i = 3; i <= n; i++) {
			dp[i] = ((k - 1) * ((dp[i - 1] % MOD) + (dp[i - 2] % MOD)) % MOD) % MOD;
		}
		
		return dp[n];
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		
		int totalWays = totalWays(n, k);
		
		System.out.println(totalWays);
		
		scanner.close();
	}

}
