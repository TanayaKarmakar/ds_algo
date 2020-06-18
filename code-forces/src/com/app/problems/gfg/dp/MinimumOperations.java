package com.app.problems.gfg.dp;

import java.util.Scanner;

public class MinimumOperations {
	private static int minOps(int n) {
		int[] dp = new int[n + 1];
		dp[0] = 0;
		for(int i = 1; i <= n; i++) {
			int option1 = Integer.MAX_VALUE;
			if(i % 2 == 0) {
				option1 = dp[i / 2];
			}
			int option2 = dp[i - 1];
			dp[i] = 1 + Integer.min(option1, option2);
		}
		return dp[n];
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int nTestCases = scanner.nextInt();
		while(nTestCases-- > 0) {
			int n = scanner.nextInt();
			int minOps = minOps(n);
			
			System.out.println(minOps);
		}

		scanner.close();
	}

}
