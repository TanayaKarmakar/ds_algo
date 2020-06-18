package com.app.problems.gfg.dp;

import java.util.Scanner;

public class CountNumberOfHops {
	private static int countNumberOfHops(int n) {
		if(n == 1)
			return 1;
		if(n == 2)
			return 2;
		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;
		
		for(int i = 3; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
		}
		return dp[n];
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nTestCases = scanner.nextInt();
		
		while(nTestCases-- > 0) {
			int n = scanner.nextInt();
			int totalWays = countNumberOfHops(n);
			
			System.out.println(totalWays);
		}
		
		scanner.close();

	}

}
