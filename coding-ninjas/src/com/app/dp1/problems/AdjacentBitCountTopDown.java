package com.app.dp1.problems;

import java.util.Arrays;
import java.util.Scanner;

public class AdjacentBitCountTopDown {
	private static final int MAX = 101;
	private static final int MOD = 1000000007;
	
	private static int totalWays(int[][][] dp, int n, int k, int firstBit) {
		if(n == 1) {
			if(k == 0) {
				return 1;
			} else
				return 0;
		}
		if(k < 0)
			return 0;
		
		if(dp[n][k][firstBit] != -1)
			return dp[n][k][firstBit];
		
		int totalWays = 0;
		if(firstBit == 1) {
			totalWays = ((totalWays(dp, n - 1, k - 1, 1) % MOD) + (totalWays(dp, n - 1, k, 0) % MOD)) % MOD;
		}
		if(firstBit == 0) {
			totalWays = ((totalWays(dp, n - 1, k, 1) % MOD) + (totalWays(dp, n - 1, k, 0) % MOD)) % MOD;
		}
		//System.out.println("TotalWays - " + totalWays);
		dp[n][k][firstBit] = totalWays;
		return totalWays;
	}
	
	private static int totalWays(int n, int k) {
		int[][][] dp = new int[MAX][MAX][2];
		for(int i = 0; i < MAX; i++) {
			for(int j = 0; j < MAX; j++) {
				for(int l = 0; l < 2; l++) {
					dp[i][j][l] = -1;
				}
			}
		}
		
		int ans = (totalWays(dp, n, k, 0) % MOD + totalWays(dp, n, k, 1) % MOD) % MOD;
		
		//System.out.println(dp[n][k][1]);
		
		return ans;
	}

	public static void main(String[] args) {
//		int ans = totalWays(5, 2);
//		
//		System.out.println(ans);
		
		Scanner scanner = new Scanner(System.in);
		int nTestCases = scanner.nextInt();
		while(nTestCases > 0) {
			int setNumber = scanner.nextInt();
			int n = scanner.nextInt();
			int k = scanner.nextInt();
			int ans = totalWays(n, k);
			System.out.println(setNumber + " " + ans);
			nTestCases--;
		}
		scanner.close();
	}

}
