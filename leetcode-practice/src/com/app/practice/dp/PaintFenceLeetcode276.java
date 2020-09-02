package com.app.practice.dp;

import java.util.Scanner;

public class PaintFenceLeetcode276 {
	private static int numWays(int n, int k) {
		if(n == 0)
			return 0;
		if(n == 1)
			return k;
		if(n == 2)
			return (k * k);
		
		int[] dp = new int[n + 1];
		dp[0] = 0;
		dp[1] = k;
		dp[2] = (k * k);
		
		for(int i = 3; i <= n; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2]) * (k - 1);
		}
		
		return dp[n];
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		
		int ans = numWays(n, k);
		
		System.out.println(ans);
		
		scanner.close();

	}

}
