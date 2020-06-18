package com.app.problems.hackerearth.dp;

import java.util.Arrays;
import java.util.Scanner;

public class WackyWorkout {
	private static final int MOD = 1000000007;
	
	private static int totalWays(int []dp, int n) {
		dp[0] = 1;
		dp[1] = 1;
		for(int i = 2; i <= n; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
		}
		return dp[n];
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nTestCases = scanner.nextInt();
		while(nTestCases-- > 0) {
			int n = (int)((scanner.nextLong()) % MOD);
			int[] dp = new int[(n + 1)%MOD];
			Arrays.fill(dp, -1);
			int totalWays = totalWays(dp, n);
			System.out.println(totalWays + 1);
		}
		scanner.close();
	}

}
