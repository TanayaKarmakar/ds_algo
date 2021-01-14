package com.app.dynamicprogramming;

import java.util.Scanner;

public class NonIntersectingChords {
	private static long numWays(long n) {
		n = n / 2;
		long[] dp = new long[(int)n + 1];
		dp[0] = 1;
		dp[1] = 1;
		
		for(int i = 2; i <= n; i++) {
			for(int j = 0; j < i; j++) {
				dp[i] += (dp[j] * dp[i - j - 1]);
			}
		}
		
		return dp[(int)n];
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long n = scanner.nextLong();
		
		long ans = numWays(n);
		
		System.out.println(ans);
		
		scanner.close();

	}

}
